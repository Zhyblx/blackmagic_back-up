package Institutes.changefilename.Kernel;

import java.util.ArrayList;
import java.util.List;
import java.io.File;

/**
 * 类：AllFilesCatalog
 * 作用：获取所有目录路径(即，扫描目录)
 */
public class AllFilesCatalog {
    private static List<String> list = new ArrayList<String>();

    public static List<String> getAllFiles(File dir) {
        File[] files = dir.listFiles();
        for (int i = 0; i < files.length; i++) {
            if (files[i].isDirectory()) {
                //这里面用了递归的算法
                getAllFiles(files[i]);

            }
        }
        list.add(dir.getPath());
        return list;

    }
}
