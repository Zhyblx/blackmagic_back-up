package toolbox;

import repositories.OcrInterface;
import net.sf.json.JSONArray;
import com.baidu.aip.ocr.AipOcr;
import net.sf.json.JSONObject;

import java.util.HashMap;
import java.util.Iterator;

import java.lang.Class;
import java.lang.reflect.Constructor;

/**
 * 类：Ocr
 * 作用：图片识别文字
 */

public final class Ocr implements OcrInterface {

    private static Class myClass = null;
    private static Constructor myConstructor = null;
    private static AipOcr aipOcr = null;
    private static JSONObject jsonObject = null;
    private static JSONArray jsonArray = null;
    private static Iterator<?> iterator = null;
    private static HashMap<String, String> hashMap = new HashMap<String, String>();

    // imagePath 设置图片地址
    public static String getOcrRun(String imagePath) {

        // 计数,作用于结果索引
        int count = 0;

        // 返回值
        String returnData = "";

        try {
            // 反射机制实例化对象
            myClass = Class.forName("com.baidu.aip.ocr.AipOcr");
            // 存在构造方法，并且有三个String类型的参数
            myConstructor = myClass.getConstructor(String.class , String.class , String.class);
            // 构造参数：设置APPID/AK/SK
            aipOcr = (AipOcr) myConstructor.newInstance(OcrInterface.APP_ID , OcrInterface.API_KEY , OcrInterface.SECRET_KEY);
//            System.out.println(aipOcr.basicGeneral(imagePath,null));
            // 百度完成解析后回传Json数据，
            String str_Json = String.valueOf(aipOcr.basicGeneral(imagePath , hashMap));

            // 解析json数据
            jsonObject = JSONObject.fromObject(str_Json);
            jsonArray = jsonObject.getJSONArray("words_result");
//            System.out.println(jsonArray.getString(0));
            iterator = jsonArray.iterator();
            while (iterator.hasNext()) {

                count++;

                Object str = iterator.next();
                jsonObject = JSONObject.fromObject(str);
                returnData = returnData + jsonObject.get("words") + "\r\n";
//                System.out.println(count + ":" + jsonObject.get("words"));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return returnData;

    }

    public static void main(String[] args) throws Exception {

        final String path="/Users/zhangyibin/Downloads/jpg/";

        String[] png={"2.png","3.png","4.png","5.png","6.png","7.png","8.png","9.png","10.png","11.png","12.png","13.png","14.png","15.png","16.png","17.png"};

        for(String str:png){
//            System.out.println(path+str);
//            System.out.println(getOcrRun(path+str));
            String strInfo=getOcrRun(path+str);
//            System.out.println(strInfo);
            if(strInfo.indexOf("d")!=-1){
                System.err.println(strInfo+"::"+str);
            }


        }

//        System.out.println(getOcrRun("/Users/zhangyibin/Downloads/1.png"));



//        getOcrRun("/Users/zhangyibin/Downloads/2.png");
//        getOcrRun("/Users/zhangyibin/Downloads/3.png");
//        getOcrRun("/Users/zhangyibin/Downloads/4.png");
//        getOcrRun("/Users/zhangyibin/Downloads/5.png");
//        getOcrRun("/Users/zhangyibin/Downloads/6.png");

    }

}
