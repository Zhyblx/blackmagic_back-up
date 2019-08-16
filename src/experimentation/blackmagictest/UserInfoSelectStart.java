package experimentation.blackmagictest;

/**
 * 类：UserInfoSelectStart
 * 获取用户信息
 */

import businessunit.blackmagicproject.userinfo.UserInfo;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class UserInfoSelectStart {

    private static File fileInput = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    private static File fileOutput = null;
    private static OutputStream outputStream = null;
    private static OutputStreamWriter outputStreamWriter = null;
    private static BufferedWriter bufferedWriter = null;

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {
                System.out.println("开始获取数据……");
                fileInput = new File("/Users/zhangyibin/Downloads/用户ID.txt");
                inputStream = new FileInputStream(fileInput);
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String strInput = "";
                while ((strInput = bufferedReader.readLine()) != null) {
//                    System.out.println(strInput);
                    fileOutput = new File("/Users/zhangyibin/Downloads/用户info.txt");
                    outputStream = new FileOutputStream(fileOutput, true);
                    outputStreamWriter = new OutputStreamWriter(outputStream);
                    bufferedWriter = new BufferedWriter(outputStreamWriter);
                    bufferedWriter.write(UserInfo.getUserLocation(strInput, "E79076F5B452CE57C7C1DAD4731FD8C5") + "\r\n");
                    bufferedWriter.close();
                    outputStreamWriter.close();
                    outputStream.close();

                }

                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                System.out.println("数据获取结束……");

            } catch (Exception e) {
                System.out.println("获取出错……");

            }
        }
    };

    public static void main(String[] args) throws Exception {
        //跑剩下的log文件即可
        new Thread(runnable).start();

    }

}
