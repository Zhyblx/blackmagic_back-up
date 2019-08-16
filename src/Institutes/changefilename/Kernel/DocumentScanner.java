package Institutes.changefilename.Kernel;

import java.io.File;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 类：DocumentScanner
 * 作用：文件扫描器；可扫描一个目录(包括子目录)下的所以文件
 */

public class DocumentScanner {

    private static List<String> listCatalog = new ArrayList<>();//存储目录
    private static List<String> listFile = new ArrayList<>();//存储文件
    private static Iterator<String> iterator = null;
    private static File file1=null;

    public static List<String> getDocumentScanner(File file) {
        try {
            listCatalog.addAll(AllFilesCatalog.getAllFiles(file));
            iterator = listCatalog.iterator();
            while (iterator.hasNext()) {
                String filePath = iterator.next();
//                System.out.println(filePath);
                file1=new File(filePath);
                String fileName=DiskScan.getFileName(file1);
                listFile.add(fileName);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return listFile;

    }

}
