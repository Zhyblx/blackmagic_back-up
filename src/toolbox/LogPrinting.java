package toolbox;

/**
 * 类：LogPrinting
 * 作用：存储错误日志
 */

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Logger;
import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class LogPrinting {

    private static Logger logger = Logger.getLogger("");
    private static File file = null;
    private static OutputStream outputStream = null;
    private static OutputStreamWriter outputStreamWriter = null;
    private static BufferedWriter bufferedWriter = null;

    public static void getLog(Object msg) {
        String strData = "";
        try {

            strData = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());

            logger.info(String.valueOf(msg));
            file = new File("log.txt");
            outputStream = new FileOutputStream(file , true);
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write("错误："+strData + ";" + String.valueOf(msg)+"\r\n");

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

}
