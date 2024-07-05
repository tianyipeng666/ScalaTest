package obs

import com.obs.services.exception.ObsException
import com.obs.services.model.{AccessControlList, CreateBucketRequest, ObjectMetadata, PutObjectRequest}
import com.obs.services.{ObsClient, ObsConfiguration}
import conf.Constant
import log.LazyLogging
import org.json4s.DefaultFormats

import java.io.InputStream
import scala.collection.mutable.ListBuffer
import scala.jdk.CollectionConverters.IterableHasAsScala

object ObsUtils extends LazyLogging {

  private val client = {
    val config = new ObsConfiguration()
    config.setSocketTimeout(60000)
    config.setConnectionTimeout(60000)
    config.setEndPoint(Constant.s3Endpoint)
    config.setMaxConnections(Constant.s3MaxConn)
    new ObsClient(Constant.s3AccessKeyId, Constant.s3SecretAccessKey, config)
  }

  def removeBucket(bucketName: String = Constant.s3BucketName, forceDelete: Boolean = false): Boolean
  = baseRetry { client =>
    if (client.headBucket(bucketName)) {
      val bucketAllObject = client.listObjects(bucketName).getObjects()
      if (bucketAllObject.size > 0) {
        if (forceDelete) {
          batchRemoveObject(bucketAllObject.asScala.map(_.getObjectKey), bucketName)
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
          case obsE: ObsException =>
            if (retryRemove) {
              logger.info(s"[obs services] delete bucket: ${bucketName}, delete object ${obj} failed," +
                s" code: ${obsE.getErrorCode}, msg: ${obsE.getErrorMessage}")
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
    if (!client.headBucket(bucketName)) {
      client.createBucket(new CreateBucketRequest(bucketName))
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
    val request = new PutObjectRequest(bucketName, path, streamObject)
    val metadata = new ObjectMetadata()
    metadata.setContentLength(streamObject.available())
    metadata.setContentType(contentType)
    request.setAcl(client.getBucketAcl(bucketName))
    request.setMetadata(metadata)
    client.putObject(request)
    s"/$bucketName$path"
  }


  def listObjects(tbName: String, bucketName: String = Constant.s3BucketName): Iterable[String]
  = baseRetry { client =>
//    val objects = client.listObjects(bucketName).getObjects()
//    println(objects.size())
//    objects.asScala.map(_.getObjectKey)
    client.listObjects(bucketName).getObjects().asScala.map(_.getObjectKey).filter(_.startsWith("/" + tbName))
  }

  def baseRetry[U](checkClient: ObsClient => U): U = {
    implicit val formats = DefaultFormats
    try {
      checkClient(client)
    } catch {
      case e: ObsException =>
        logger.info(s"[obs services] internet error, msg: ${e.printStackTrace()}")
        Thread.sleep(10 * 1000)
        checkClient(client)
      case e: Throwable =>
        Thread.sleep(10 * 1000)
        throw e
    }
  }

  def init(bucketName: String = Constant.s3BucketName): Unit = baseRetry { client =>
    // 环境未给访问其他bucket权限，无法判断bucket是否存在
    makeBucket(bucketName)
  }

  def getBucketPolicy(bucketName: String): AccessControlList = baseRetry { client =>
    client.getBucketAcl(bucketName)
  }

  def setBucketPolicy(bucketName: String, policy: AccessControlList): Unit = baseRetry { client =>
    client.setBucketAcl(bucketName, policy)
  }

}


