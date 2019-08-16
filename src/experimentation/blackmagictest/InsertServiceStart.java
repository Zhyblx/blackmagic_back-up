package experimentation.blackmagictest;

import toolbox.databaseservice.InsertService;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class InsertServiceStart {

    private static File file = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    public static void main(String[] args) {
        try {
            file = new File("/Users/zhangyibin/Downloads/update_sql.txt");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String strTxt = "";

            while ((strTxt = bufferedReader.readLine()) != null) {
//                System.out.println(strTxt);
                InsertService.getInsertService(strTxt);
//                Thread.sleep(500);
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

}
