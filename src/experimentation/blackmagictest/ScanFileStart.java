package experimentation.blackmagictest;


import Institutes.changefilename.Kernel.DocumentScanner;

import java.io.File;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 类：ScanFile
 * 作用：扫描文件启动程序
 */
public class ScanFileStart {

    private static File file = new File("/Users/zhangyibin/Downloads/未命名文件夹/");

    private static List<String> list = new ArrayList<String>();
    private static Iterator<String> iterator = null;
    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
//                System.out.println(DiskScan.getFileName(file));
//                System.out.println(AllFilesCatalog.getAllFiles(file,0));

                list.addAll(DocumentScanner.getDocumentScanner(file));
                iterator = list.iterator();
                while (iterator.hasNext()) {
                    System.out.println(iterator.next());
                }

//                DocumentScanner.getDocumentScanner(file);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) {
        new Thread(runnable).start();

    }


}
