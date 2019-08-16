package edges.statistics;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 类：PinyinTaggingStart
 * 作用：对读取的文件内容进行拼音标注
 */

public class PinyinTaggingStart {

    private static File file = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                file = new File("/Users/zhangyibin/Documents/环球黑卡工作台/产品项目/基础业务/搜索项目/搜索项目二期/Top2000的词汇对比/7");
                inputStream = new FileInputStream(file);
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String strTxt = "";
                while ((strTxt = bufferedReader.readLine()) != null) {
                    String strQP = PinyinTagging.getTaggingQuanPin(strTxt);
                    String strSL = PinyinTagging.getTaggingSuolue(strTxt);
                    System.out.println(strTxt + "---->" + strQP + "---->"+strSL);

                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

            } catch (Exception e) {
//                e.printStackTrace();

            }
        }
    };

    public static void main(String[] args) throws Exception {
        new Thread(runnable).start();

    }
}
