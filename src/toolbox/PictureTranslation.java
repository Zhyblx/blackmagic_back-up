package toolbox;

/**
 * 类： PictureTranslation
 * 作用：对图片中的字符进行翻译
 */

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

public class PictureTranslation {

    public static String getPictureTranslation(String imagePath) {
        List<String> list = new ArrayList<String>();

        String strTxt = "";
        String returnData = "";

        try {
            strTxt = Ocr.getOcrRun(imagePath);
            String strData[] = strTxt.split("\r\n");
            for (String str : strData) {
                list.add(str);

            }

            Iterator<String> iterator=list.iterator();
            while (iterator.hasNext()){
                String str=iterator.next();
                returnData =returnData+str+"\r\n"+ BaiduFanyi.getBaiduFanyi(str)+"\r\n";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnData;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(PictureTranslation.getPictureTranslation("/Users/zhangyibin/Downloads/1.png"));
    }

}
