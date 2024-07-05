package s3

import java.io.InputStream
import scala.collection.mutable.ListBuffer
import com.amazonaws.{ClientConfiguration, SdkClientException}
import com.amazonaws.auth.{AWSStaticCredentialsProvider, BasicAWSCredentials}
import com.amazonaws.client.builder.AwsClientBuilder
import com.amazonaws.services.s3.AmazonS3
import com.amazonaws.services.s3.AmazonS3ClientBuilder
import com.amazonaws.services.s3.model.{AccessControlList, ObjectMetadata}
import conf.Constant
import log.LazyLogging
import org.json4s.DefaultFormats
import sun.misc.BASE64Encoder

import java.security.MessageDigest
import scala.collection.JavaConverters.iterableAsScalaIterableConverter


object S3Utils extends LazyLogging {

  val sep = "\n"
  val Method = "PUT"
  val Content_MD5 = ""
  val Content_Type = "application/octet-stream"
  val Date = ""
  val CanonicalizedHeaders = ""
  val CanonicalizedResource = ""


  private val client = {
    AmazonS3ClientBuilder.standard()
      .withCredentials(new AWSStaticCredentialsProvider(
        new BasicAWSCredentials(Constant.s3AccessKeyId, Constant.s3SecretAccessKey))
      )
      .withEndpointConfiguration(new AwsClientBuilder.EndpointConfiguration(
        Constant.s3Endpoint,
        Constant.s3Region))
      .withPathStyleAccessEnabled(Constant.s3PathStyle)
      .withChunkedEncodingDisabled(true)
      .withClientConfiguration(new ClientConfiguration()
        .withMaxConnections(Constant.s3MaxConn)
        .withMaxErrorRetry(3))
      .build()
  }

  def removeBucket(bucketName: String = Constant.s3BucketName, forceDelete: Boolean = false): Boolean
  = baseRetry { client =>
    if (client.doesBucketExistV2(bucketName)) {
      val bucketAllObject = client.listObjects(bucketName).getObjectSummaries()
      if (bucketAllObject.size > 0) {
        if (forceDelete) {
          batchRemoveObject(bucketAllObject.asScala.map(_.getKey), bucketName)
        } else {
          throw new Exception(s"bucket: ${bucketName} is not empty, forbidden delete bucket")
        }
      }
      client.deleteBucket(bucketName)
    }
    true
  }

  def removeObjectById(objectName: String, bucketName: String = Constant.s3BucketName): Unit
  = baseRetry { client =>
    client.deleteObject(bucketName, objectName)
  }

  def removeObjectByTBId(tbName: String, bucketName: String = Constant.s3BucketName): Boolean = {
    batchRemoveObject(listObjects(tbName, bucketName), bucketName)
  }

  def batchRemoveObject(objectName: Iterable[String], bucketName: String = Constant.s3BucketName,
                        retryRemove: Boolean = false): Boolean = baseRetry { client =>
    val list = objectName.toList
    val errList = ListBuffer[String]()
    logger.info(s"batchRemoveObject objectName: ${list.mkString(",")}, " +
      s"objectCount: ${list.size}, bucketName: $bucketName")
    if (objectName.size > 0) {
      objectName.foreach(obj => {
        try {
          client.deleteObject(bucketName, obj)
        } catch {
          case s3E: SdkClientException =>
            if (retryRemove) {
              logger.info(s"[s3 services] delete bucket: ${bucketName}, delete object ${obj} failed," +
                s" ==> ${s3E.printStackTrace}")
            } else {
              errList += obj
            }
        }
      })
    }
    if (errList.size > 0) {
      if (retryRemove) {
        return false
      } else {
        batchRemoveObject(errList, bucketName, true)
      }
    } else {
      return true
    }
  }

  def makeBucket(bucketName: String = Constant.s3BucketName): Unit = baseRetry { client =>
    if (!client.doesBucketExistV2(bucketName)) {
      client.createBucket(bucketName)
    }
  }

  def putObject(tbName: String, streamObject: InputStream, bucketName: String = Constant.s3BucketName,
                contentType: String = "application/octet-stream", suffix: String = ""): String = baseRetry { client =>
    if (streamObject == null) {
      return null
    }
    val path = if (suffix == "" || suffix == null) {
      s"/${tbName}/${System.currentTimeMillis()}"
    } else {
      s"/${tbName}/${System.currentTimeMillis()}.${suffix}"
    }
    val metadata = new ObjectMetadata()
    metadata.setContentLength(streamObject.available())
    // metadata.setHeader("x-obs-date", )
    // metadata.setHeader("Authorization", "")
    metadata.setContentType(contentType)
    client.putObject(bucketName, path, streamObject, metadata)
    s"/$bucketName$path"
  }

  def listObjects(tbName: String, bucketName: String = Constant.s3BucketName): Iterable[String]
  = baseRetry { client =>
    client.listObjects(bucketName, tbName).getObjectSummaries().asScala.map(_.getKey)
  }

  def baseRetry[U](checkConnect: AmazonS3 => U): U = {
    implicit val formats = DefaultFormats
    try {
      checkConnect(client)
    } catch {
      case e: SdkClientException =>
        logger.info(s"[s3 services] internet error, msg: ${e.printStackTrace()}")
        Thread.sleep(10 * 1000)
        checkConnect(client)
      case e: Throwable =>
        Thread.sleep(10 * 1000)
        throw e
    }
  }

  def init(bucketName: String = Constant.s3BucketName): Unit = baseRetry { client =>
    makeBucket(bucketName)
  }

  def getBucketPolicy(bucketName: String): AccessControlList = baseRetry { client =>
    client.getBucketAcl(bucketName)
  }

  def setBucketPolicy(bucketName: String, policy: AccessControlList): Unit = baseRetry { client =>
    client.setBucketAcl(bucketName, policy)
  }

  def calculateSignature():String = {
    Method + sep + Content_MD5 + sep + Content_Type + sep + Date + sep + CanonicalizedHeaders + sep + CanonicalizedResource
  }

  def getContentMD5(content: String):String = {
    val messageDigest = MessageDigest.getInstance("MD5");
    val encoder = new BASE64Encoder();
    encoder.encode(messageDigest.digest(content.getBytes("utf-8")))
  }

}


