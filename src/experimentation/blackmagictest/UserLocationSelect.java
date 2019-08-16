package experimentation.blackmagictest;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 类：UserLocationSelect
 * 作用：处理文档中的空格行
 */

public class UserLocationSelect {

    private static File file = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                file = new File("/Users/zhangyibin/Downloads/Untitled-1.txt");
                inputStream = new FileInputStream(file);
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String strTxt = "";
                while ((strTxt = bufferedReader.readLine()) != null) {
                    if (strTxt.length() > 30) {
                        System.out.println(strTxt);
                    }

                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws Exception {
        new Thread(runnable).start();
    }

}
