package edges.userexperience;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 类：UserFeedback
 * 作用：用户反馈内容的关键词检索
 *
 */
public class UserFeedback {

    private static File file = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) throws Exception {
        try {
            file = new File("/Users/zhangyibin/Documents/环球黑卡工作台/业务分析/20181203报告/原始数据/用户反馈内容.txt");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String str = "";
            while ((str = bufferedReader.readLine()) != null) {
                String query="搜索";
                if(str.indexOf(query)!=-1){
                    System.out.println(str);
                }
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
