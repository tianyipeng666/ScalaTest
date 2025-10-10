import com.haizhi.tools.util.UsingUtils
import com.travelsky.alid.Sm4DecryptApp
import com.travelsky.alid.util.Filesdecrypt

object ScalaMain {
  def main(args: Array[String]): Unit = {
    val hdfsEnPath = "/bdp/tmp/d018d86c9f34401385f47e8f838204fa"
    // val hdfsDenPath = "/typ/d018d86c9f34401385f47e8f838204faDEN1"
    UsingUtils.withResources(Filesdecrypt.openInputStream(hdfsEnPath)) { int =>
      UsingUtils.withResources(Filesdecrypt.openOutputStreamByUDF(hdfsEnPath + ".xml", true)) { out =>
        Sm4DecryptApp.Sm4Decrypt(int, out)
      }
    }
  }
}
