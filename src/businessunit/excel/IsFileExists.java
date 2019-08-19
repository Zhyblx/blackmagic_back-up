package businessunit.excel;

/**
 * 类：IsFileExists
 * 作用：判断文件是否存在
 *
 */

import java.io.File;

public class IsFileExists {

    private static boolean order=false;
    public static boolean setIsFileExists(File file){
        File isFile=file;
        if(isFile.exists()){
            isFile.delete();
            order=true;
        }

        return order;
    }

    public static final void main(String[] args) throws Exception {
        File file=new File("/Users/zhangyibin/Downloads/2019-08-17至2019-08-17的订单.xlsx");
        System.out.println(IsFileExists.setIsFileExists(file));

    }
}
