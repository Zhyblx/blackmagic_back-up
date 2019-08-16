package toolbox;

import java.io.File;
import java.io.FileOutputStream;

import de.innosystec.unrar.Archive;
import de.innosystec.unrar.rarfile.FileHeader;

/**
 * 类：UntieRARFile
 * 作用：解压RAR文件
 */

public final class UntieRARFile {

    private static File file = null;
    private static FileOutputStream fileOutputStream = null;

    private static Archive archive = null;
    private static FileHeader fileHeader = null;

    private static String compressFileName = "";

    public static void getUntieRARFile(File sourceRar , File destDir) {
        try {

            archive = new Archive(sourceRar);
            fileHeader = archive.nextFileHeader();

            System.out.println("开始解压...");

            while (fileHeader != null) {
                // 获得文件名称
                compressFileName = "";
//                compressFileName = fileHeader.getFileNameString().trim();
                // 解决中文乱码问题
                if (fileHeader.isUnicode()) {
                    // 方法getFileNameW(),返回指定路径中最后的文件夹或文件,可解决中文乱码问题
                    compressFileName = fileHeader.getFileNameW().trim();
                } else {
                    // 方法getFileNameString(),返回指定路径中最后的文件夹或文件
                    compressFileName = fileHeader.getFileNameString().trim();
                }
                // 正则表达式
                compressFileName = compressFileName.replaceAll("\\\\" , "/");


                // rar文件解压到的目标路径
                file = new File(destDir.getAbsoluteFile() + "/" + compressFileName);
                // 输出完成解压的文件和文件夹
                System.out.println(String.valueOf(file.getAbsoluteFile()));

                if (fileHeader.isDirectory()) {
                    if (!file.exists()) {
                        file.mkdirs();
                    }
                    fileHeader = archive.nextFileHeader();
                    continue;
                }

                if (!file.getParentFile().exists()) {
                    file.getParentFile().mkdirs();
                }

                fileOutputStream = new FileOutputStream(file);
                archive.extractFile(fileHeader , fileOutputStream);
                fileOutputStream.close();
                fileOutputStream = null;
                fileHeader = archive.nextFileHeader();

            }

            archive.close();
            archive = null;
            System.out.println("完成解压 !");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {

        File file1 = new File("/Users/zhangyibin/Downloads/回访表格记录.rar");
        File file2 = new File("/Users/zhangyibin/Downloads/");

        UntieRARFile.getUntieRARFile(file1 , file2);
    }


}
