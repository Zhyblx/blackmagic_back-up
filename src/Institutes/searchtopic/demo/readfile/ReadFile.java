package Institutes.searchtopic.demo.readfile;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

/**
 * 类：ReadFile
 * 作用：文件转数组
 */

public class ReadFile {
    public static String[] getArray(String Path) {
        String[] arrayData=null;
        try {
            List<String> list=new ArrayList<String>();
            File file = new File(Path);
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                list.add(str);

            }
            arrayData=new String[list.size()];
            for(int i=0;i<arrayData.length;i++){
                arrayData[i]=list.get(i);

            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
//
        return arrayData;
    }

    public static void main(String[] args) throws Exception {
        String[] str=ReadFile.getArray("/Users/zhangyibin/Documents/环球黑卡工作台/产品项目/基础业务/搜索项目/搜索项目一期/搜索测试数据/title.txt");
        System.out.println(str[0]);
        System.out.println(str[str.length-1]);
    }

}
