package experimentation.blackmagictest;

import toolbox.UntieRARFile;

import java.io.File;

/**
 * 类：UntieRARFileStart
 * 作用：解压RAR压缩包的应用类
 */

public class UntieRARFileStart {

    private static File file1 = new File("/Users/zhangyibin/Downloads/七夕1.0定制品/七夕定制品图片.rar");
    private static File file2 = new File("/Users/zhangyibin/Downloads/七夕1.0定制品/");

    public static void main(String[] args) throws Exception {
        UntieRARFile.getUntieRARFile(file1 , file2);
    }

}
