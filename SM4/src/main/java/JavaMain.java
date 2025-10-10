

import com.haizhi.tools.util.UsingUtils;
import com.travelsky.alid.Sm4DecryptApp;
import com.travelsky.alid.util.Filesdecrypt;


public class JavaMain {
    public static void main(String[] args) {
        String hdfsEnPath = "/bdp/tmp/d018d86c9f34401385f47e8f838204fa";
        String hdfsDenPath = "/typ/d018d86c9f34401385f47e8f838204faDEN1";
        sm4Dispose(hdfsEnPath, hdfsDenPath);
    }

    public static void sm4Dispose(String ftpPath, String hdfsPath) {
        try {
            Sm4DecryptApp.hdfsSm4ToHdfs(ftpPath, hdfsPath);
        } catch (Exception exception) {
            exception.printStackTrace();
        }
    }

}
