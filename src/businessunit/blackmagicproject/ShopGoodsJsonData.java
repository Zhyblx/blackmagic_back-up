package businessunit.blackmagicproject;

/**
 * 类：GoodsJsonData
 * 作用：收集环球黑卡业务下所有子业务模块的店铺/商品数据信息
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import repositories.BrowserEnum;


public class ShopGoodsJsonData {

    private static Connection connection = null;
    private static Document document = null;

    // 充值中心的商品数据解析

    public static String getUltimaVip(String provinceId , String CookieKey , String CookieValue) {
        String strJson = "";
        String returnTxt = "";

        try {
            connection = Jsoup.connect("http://cos.ultimavip.org/project/remote/recharge/%2F1.0%2Fsold%2Fget/false/form");
            connection.ignoreContentType(true);
            connection.cookie(CookieKey , CookieValue);
            connection.timeout(5000);
            connection.data("busiType" , "1");
            connection.data("provinceId" , provinceId);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());

            document = connection.post();
            strJson = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strJson);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            returnTxt = "充值中心：" + jsonObject1.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnTxt;

    }

    // 查询供应商的商品信息
    public static String getShopCommodity(String supplierId , int pageNum , String strCookie) {

        String strDocJosn = "";
        String returnData = "";
        try {

            connection = Jsoup.connect("http://172.16.10.60:9091/product/listByPage?search=&supplierId=" + supplierId + "&buyerId=&status=&pageNum=" + pageNum + "&categoryId=");
            connection.cookie("JSESSIONID" , strCookie);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding" , "chunked");
            connection.header("Accept" , "*/*");
            connection.header("Accept-Encoding" , "gzip, deflate");
            connection.header("Accept-Language" , "zh-CN,zh;q=0.9");
            connection.header("Connection" , "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(5000);
            connection.ignoreContentType(true);
            document = connection.get();
            strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            returnData = "供应商：" + jsonObject1.toString();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnData;
    }


    // 供应商店铺列表
    public static String getShopsJsonDataList(int pageNum , String strCookie) {
        String strDocJosn = "";
        String returnData = "";
        try {
            connection = Jsoup.connect("http://truechoice.ultimavip.org/supplier/listByPage?name=&pageNum=" + pageNum);
            connection.cookie("JSESSIONID" , strCookie);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding" , "chunked");
            connection.header("Accept" , "*/*");
            connection.header("Accept-Encoding" , "gzip, deflate");
            connection.header("Accept-Language" , "zh-CN,zh;q=0.9");
            connection.header("Connection" , "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(5000);
            connection.ignoreContentType(true);
            document = connection.get();
            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String id = jsonObject2.getString("id");
                String name = jsonObject2.getString("name");
                returnData = returnData + id + "|" + name + "\r\n";

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return returnData;

    }


    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 30; i++) {
            System.out.println(ShopGoodsJsonData.getShopsJsonDataList(i , "5E01E1E1AC53D8FA37A238B48E29AE94"));

        }

    }

}
