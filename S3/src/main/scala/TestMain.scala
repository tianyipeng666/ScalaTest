import obs.ObsUtils
import org.apache.log4j.PropertyConfigurator
import s3.S3Utils

import java.io.ByteArrayInputStream

object TestMain {


  def main(args: Array[String]): Unit = {
    // System.setProperty("com.amazonaws.services.s3.disableGetObjectMD5Validation", "false")
    // System.setProperty("com.amazonaws.services.s3.disablePutObjectMD5Validation", "false")
    PropertyConfigurator.configure(s"conf/log4j.properties")
    // S3Utils.init()
    dataWriteIn()
    // S3Utils.removeObjectByTBId("s3Test")
    // ObsUtils.init()
    //ObsUtils.removeObjectByTBId("obsTest")
  }

  private def dataWriteIn(): Unit = {
    val decoder = new sun.misc.BASE64Decoder
    val bytes = decoder.decodeBuffer("This is the obs test Second message!")
    val inputStream = new ByteArrayInputStream(bytes)
    val contentType = "application/octet-stream"
    val res = S3Utils.putObject("obsTest", inputStream, contentType = contentType, suffix = "s3FirstCol")
    println(res)
  }
}
