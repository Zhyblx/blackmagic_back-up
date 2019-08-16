package experimentation.blackmagictest;

import businessunit.blackmagicproject.SelectInfo;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * 类：SelectShopCommodityStatr
 * 作用：查询供应商的商品列表
 */

public class SelectShopCommodityStatr {

    private static File file = null;
    private static OutputStream outputStream = null;
    private static OutputStreamWriter outputStreamWriter = null;
    private static BufferedWriter bufferedWriter = null;

    public static void main(String[] args) throws Exception {
        try {
//            System.out.println(SelectInfo.getCommodityData("1",1,"084602FC557E1825781A8AB467526637"));
//
            file = new File("/Users/zhangyibin/Downloads/shop.txt");
            outputStream = new FileOutputStream(file, true);
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

//            231
            for (int i = 1; i <= 819; i++) {
                Thread.sleep(200);
                String strTxt = SelectInfo.getCommodityData("","", i, "084602FC557E1825781A8AB467526637");
                System.out.println(strTxt);
                bufferedWriter.write(strTxt);

            }

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
