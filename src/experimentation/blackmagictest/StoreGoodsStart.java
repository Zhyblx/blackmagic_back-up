package experimentation.blackmagictest;

/**
 * 类：StoreGoodsStart
 * 作用：存储商品信息到StoreGoods.txt文件中
 */

import businessunit.blackmagicproject.SelectInfo;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

public class StoreGoodsStart implements Runnable {

    private File file = null;
    private OutputStream outputStream = null;
    private OutputStreamWriter outputStreamWriter = null;
    private BufferedWriter bufferedWriter = null;

    @Override
    public void run() {
        try {
            for (int i = 1; i <= 996; i++) {
                Thread.sleep(500);

                file = new File("/Users/zhangyibin/Downloads/StoreGoods.txt");
                outputStream = new FileOutputStream(file, true);
                outputStreamWriter = new OutputStreamWriter(outputStream);
                bufferedWriter = new BufferedWriter(outputStreamWriter);

                bufferedWriter.write(SelectInfo.getCommodityData("","",1,""));

                bufferedWriter.close();
                outputStreamWriter.close();
                outputStream.close();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new StoreGoodsStart()).start();

    }

}
