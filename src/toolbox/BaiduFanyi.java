package toolbox;

/**
 * 类:BaiduFanyi
 * 作用：翻译
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import repositories.BrowserEnum;

import java.lang.Math;

public class BaiduFanyi {

    private static Connection connection = null;
    private static Document document = null;
    private static final String appid = "20181101000228805";
    private static final String key = "cKDUdVtrFTDSBCSRJnxl";

    public static String getBaiduFanyi(String text) {

        int intMath = 0;
        String md5 = "";
        String returnData = "";

        try {
            intMath = (int) (Math.random() * 100);
            md5 = MD5Util.setMD5(appid + text + String.valueOf(intMath) + key);

            connection = Jsoup.connect("http://api.fanyi.baidu.com/api/trans/vip/translate");
            connection.header("Content-Type" , "application/json");
            connection.header("Content-Type" , "application/x-www-form-urlencoded; charset=UTF-8");
            connection.data("q" , text);
            connection.data("from" , "auto");
            connection.data("to" , "auto");
            connection.data("appid" , appid);
            connection.data("salt" , String.valueOf(intMath));
            connection.data("sign" , md5);
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(5000);

            document = connection.post();
            String strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONArray jsonArray = jsonObject.getJSONArray("trans_result");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                returnData = jsonObject1.getString("dst");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnData;

    }

    public static void main(String[] args) throws Exception {

        System.out.println(BaiduFanyi.getBaiduFanyi("You aren't following anybody.\n" +
                "earn more about being social on GitHub"));
//        System.out.println(BaiduFanyi.getBaiduFanyi("can be downloadable"));
    }


}
