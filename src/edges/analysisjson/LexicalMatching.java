package edges.analysisjson;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.List;
import java.util.ArrayList;

/**
 * 类：LexicalMatching
 * 作用：计算两个文件下相同的词汇
 */

public class LexicalMatching {

    private static File file1 = null;
    private static File file2 = null;

    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) {
        try {
            List<String> list1 = new ArrayList<String>();
            List<String> list2 = new ArrayList<String>();

            file1 = new File("/Users/zhangyibin/Documents/环球黑卡工作台/产品项目/基础业务/搜索项目/搜索项目二期/Top2000的词汇对比/Top2000");
            inputStream = new FileInputStream(file1);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str1 = "";
            while ((str1 = bufferedReader.readLine()) != null) {
                list1.add(str1);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
//            System.out.println(list1);

            file2 = new File("/Users/zhangyibin/Documents/环球黑卡工作台/产品项目/基础业务/搜索项目/搜索项目二期/Top2000的词汇对比/2");
            inputStream = new FileInputStream(file2);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str2 = "";
            while ((str2 = bufferedReader.readLine()) != null) {
                list2.add(str2);
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            for (int i = 0; i < list1.size(); i++) {
                String strList1 = list1.get(i);

                for (int j = 0; j < list2.size(); j++) {
                    String strList2 = list2.get(j);

                    int x = strList1.indexOf(",");
//                    System.out.println(strList1.substring(0,x));
                    if (strList1.substring(0, x).equals(strList2)) {
                        System.out.println(strList1);

                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
