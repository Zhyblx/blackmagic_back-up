package businessunit.blackmagicproject.userinfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import repositories.BrowserEnum;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

/**
 * 类：ShopCommodityUpdateStatus
 * 作用：
 * 1.根据商家ID，查询上/下状态的商品列表。
 * 2.对当前商品的状态进行上/下架变更。
 */

public class ShopCommodityUpdateStatus {

    protected static Connection connection = null;
    protected static Document document = null;

    // 1.查询供应商的上架商品列表
    public static String setShopCommodity(String supplierId, String status, int pageNum, String strCookie) {
        String strDocJosn = "";
        String strId = "";
        String strTitle = "";
        String strTag = "";
        String returnData = "";
        try {
            connection = Jsoup.connect(
                    "http://truechoice.ultimavip.org/product/listByPage?search=&supplierId=" + supplierId
                            + "&buyerId=&status=" + status + "&pageNum=" + pageNum + "&categoryId=");
            connection.cookie("JSESSIONID", strCookie);
            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(10000);
            connection.ignoreContentType(true);
            document = connection.get();
            strDocJosn = document.text();

            JSONObject jsonDoc = JSONObject.fromObject(strDocJosn);
            JSONObject jsonData = jsonDoc.getJSONObject("data");
            JSONArray jsonArrayList = jsonData.getJSONArray("list");
            for (int i = 0; i < jsonArrayList.size(); i++) {
                JSONObject jsonResult = jsonArrayList.getJSONObject(i);
                strId = jsonResult.getString("id");//商品ID
                strTitle = jsonResult.getString("title");//商品标题
                strTag = jsonResult.getString("tag");//型号
                returnData = returnData + strId + "|" + strTitle + "|" + strTag + "\r\n";

            }
        } catch (Exception e) {
            System.err.println(pageNum);

        }
        return returnData;

    }

    // 2.商品批量上/下架的状态变更
    public static void setShopCommoditytUpdateStatus(String id, String status, String strCookie) {
        try {
            connection = Jsoup.connect("http://truechoice.ultimavip.org/product/updateStatus");
            connection.cookie("JSESSIONID", strCookie);
            connection.data("id", id);
            connection.data("status", status);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(10000);
            connection.ignoreContentType(true);

            document = connection.post();
            System.out.println("下架状态：" + document.text());

        } catch (Exception e) {
            System.err.println(id);

        }
    }

    public static void main(String[] args) throws Exception {
        // supplierId:10052 供应商：博库网络传媒集团有限公司
        // supplierId:10087 供应商：上海寺库电子商务有限公司

/*
        for (int i = 1; i <= 206; i++) {

            System.out.print(
                    ShopCommodityUpdateStatus.setShopCommodity("10087", "1", i, "F4C661ED67B849D37FA4EA81129B41CB")

            );

        }

 */

/*
        String[] ShopID = {"13661", "13660", "13658", "13657", "13655", "13654", "13652", "13650", "13649", "13648"};

        for (String ID : ShopID) {
            System.out.println(ID);
            ShopCommodityUpdateStatus.setShopCommoditytUpdateStatus(ID, "false", "F4C661ED67B849D37FA4EA81129B41CB");

        }
*/

    }
}
