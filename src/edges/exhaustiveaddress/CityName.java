package edges.exhaustiveaddress;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * 类：CityName
 * 作用：处理出行订单中的城市名称
 *
 */

public class CityName {

    private String inputPath = "";
    private String outPath = "";

    private CityName(String inputPath, String outPath) {
        this.inputPath = inputPath;
        this.outPath = outPath;

    }

    public void setCityName() throws Exception {

        File outFile = new File(this.outPath);
        OutputStream outputStream = new FileOutputStream(outFile, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        File inputFile = new File(this.inputPath);
        InputStream inputStream = new FileInputStream(inputFile);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String strTxt = "";
        while ((strTxt = bufferedReader.readLine()) != null) {
            //System.out.println(strTxt);

            if (strTxt.length() > 2) {
                String strSubstring = strTxt.substring(strTxt.length() - 1, strTxt.length());//取最后一个字
                if (strSubstring.equals("东") || strSubstring.equals("南") || strSubstring.equals("西") || strSubstring.equals("北")) {
                    System.out.println(strTxt + "--->" + strTxt.substring(0, strTxt.length() - 1));
                    bufferedWriter.write(strTxt + "--->" + strTxt.substring(0, strTxt.length() - 1) + "\r\n");

                } else {
                    System.out.println(strTxt + "--->" + strTxt);
                    bufferedWriter.write(strTxt + "--->" + strTxt + "\r\n");

                }

            } else {
                System.out.println(strTxt + "--->" + strTxt);
                bufferedWriter.write(strTxt + "--->" + strTxt + "\r\n");

            }

//            if (strTxt.length() <= 2) {
//                String strSubstring = strTxt.substring(strTxt.length() - 1, strTxt.length());//取最后一个字
//                if (strSubstring.equals("东") || strSubstring.equals("南") || strSubstring.equals("西") || strSubstring.equals("北")) {
//                    System.out.println(strTxt + "--->" + strTxt);
//
//                }
//            }


        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();

    }

    public static CityName cityName = new CityName("/Users/zhangyibin/Downloads/订单城市B.txt", "/Users/zhangyibin/Downloads/订单城市B处理.txt");

    public static void main(String[] args) throws Exception {
        CityName.cityName.setCityName();

    }

}
