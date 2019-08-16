package Institutes.changefilename.Kernel;

import java.lang.String;
import java.io.File;

/**
 * 类：DiskScan
 * 作用：扫描文件与变更文件名
 */

public class DiskScan {

    /**
     * 递归扫描文件
     */
    public static String getFileName(File file) {
        File[] listFiles = file.listFiles();
        String fileName="";
        try {
            if (listFiles != null && listFiles.length > 0) {
                for (File file2 : listFiles) {
                    if (file2.isDirectory()) {
                        getFileName(new File(file2.getAbsolutePath()));

                    }
                    if (file2.isFile()) {
                        String strFileName=file2.getName();
                        fileName=fileName+strFileName+"\r\n";

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return fileName;
    }

    /** 文件重命名
     * @param path 文件目录
     * @param oldname  原来的文件名
     * @param newname 新文件名
     */
    public static void renameFile(String path,String oldname,String newname){
        if(!oldname.equals(newname)){//新的文件名和以前文件名不同时,才有必要进行重命名
            File oldfile=new File(path+"/"+oldname);
            File newfile=new File(path+"/"+newname);
            if(!oldfile.exists()){
                return;//重命名文件不存在
            }
            if(newfile.exists())//若在该目录下已经有一个文件和新文件名相同，则不允许重命名
                System.out.println(newname+"已经存在！");
            else{
                oldfile.renameTo(newfile);
            }
        }else{
            System.out.println("新文件名和旧文件名相同...");
        }
    }

    public static void main(String[] args) throws Exception {
        System.out.println(DiskScan.getFileName(new File("/Users/zhangyibin/Downloads/news")));
//		DiskScan.renameFile("/Users/zhangyibin/Downloads/","梯田.docx","行政专员-梯田.docx");
    }

}