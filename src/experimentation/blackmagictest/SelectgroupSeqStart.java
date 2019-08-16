package experimentation.blackmagictest;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

import businessunit.blackmagicproject.SelectgroupSeq;

/**
 * 类：SelectgroupSeqStart
 * 作用：子订单号反查组订单号的应用
 */
public class SelectgroupSeqStart implements Runnable {

    private File file = null;
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;

    @Override
    public void run() {
        try {

            file = new File("/Users/zhangyibin/Downloads/子单号.txt");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);

            String str = "";
            while ((str = bufferedReader.readLine()) != null) {

                String strCard = SelectgroupSeq.getSelectgroupSeq(str , "83749433471C134518D372A451A54E08");
                System.out.println(strCard);

                File file1 = new File("/Users/zhangyibin/Downloads/结果.txt");
                OutputStream outputStream1 = new FileOutputStream(file1 , true);
                OutputStreamWriter outputStreamWriter1 = new OutputStreamWriter(outputStream1);
                BufferedWriter bufferedWriter1 = new BufferedWriter(outputStreamWriter1);

                bufferedWriter1.write(strCard + "\r\n");

                bufferedWriter1.close();
                outputStreamWriter1.close();
                outputStream1.close();


            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new SelectgroupSeqStart()).start();
    }

}
