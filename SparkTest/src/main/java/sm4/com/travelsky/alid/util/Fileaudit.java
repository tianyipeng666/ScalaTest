//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package sm4.com.travelsky.alid.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Fileaudit {
    public Fileaudit() {
    }

    public Boolean modeAudit(String mode) {
        String modenew = mode.toUpperCase();
        return !"CBC".equals(modenew) && !"ECB".equals(modenew) && !"CTR".equals(modenew) && !"OFB".equals(modenew) ? false : true;
    }

    public Boolean filesAudit(FileInputStream file, FileOutputStream file2) {
        return file != null && file2 != null ? false : true;
    }
}
