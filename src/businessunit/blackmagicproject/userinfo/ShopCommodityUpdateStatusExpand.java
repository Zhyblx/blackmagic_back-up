package businessunit.blackmagicproject.userinfo;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import repositories.BrowserEnum;

/**
 * 类：ShopCommodityUpdateStatusExpand
 * 作用：ShopCommodityUpdateStatus的功能拓展类
 */

public class ShopCommodityUpdateStatusExpand {

    // 查询供应商的上架商品列表
    public static void setShopCommodityExpand(String supplierId, String selectStatus, String shopStatus, int pageNum, String strCookie) {
        String strDocJosn = "";
        String strId = "";
        try {
            ShopCommodityUpdateStatus.connection = Jsoup.connect(
                    "http://truechoice.ultimavip.org/product/listByPage?search=&supplierId=" + supplierId
                            + "&buyerId=&status=" + selectStatus + "&pageNum=" + pageNum + "&categoryId=");
            ShopCommodityUpdateStatus.connection.cookie("JSESSIONID", strCookie);
            ShopCommodityUpdateStatus.connection.header("Content-Type", "application/json;charset=UTF-8");
            ShopCommodityUpdateStatus.connection.header("Transfer-Encoding", "chunked");
            ShopCommodityUpdateStatus.connection.header("Accept", "*/*");
            ShopCommodityUpdateStatus.connection.header("Accept-Encoding", "gzip, deflate");
            ShopCommodityUpdateStatus.connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            ShopCommodityUpdateStatus.connection.header("Connection", "keep-alive");
            ShopCommodityUpdateStatus.connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            ShopCommodityUpdateStatus.connection.timeout(10000);
            ShopCommodityUpdateStatus.connection.ignoreContentType(true);
            ShopCommodityUpdateStatus.document = ShopCommodityUpdateStatus.connection.get();
            strDocJosn = ShopCommodityUpdateStatus.document.text();

            JSONObject jsonDoc = JSONObject.fromObject(strDocJosn);
            JSONObject jsonData = jsonDoc.getJSONObject("data");
            JSONArray jsonArrayList = jsonData.getJSONArray("list");
            for (int i = 0; i < jsonArrayList.size(); i++) {
                JSONObject jsonResult = jsonArrayList.getJSONObject(i);
                strId = jsonResult.getString("id");//商品ID
                System.out.println("商品ID：" + strId);
                ShopCommodityUpdateStatus.setShopCommoditytUpdateStatus(strId, shopStatus, strCookie);
            }
        } catch (Exception e) {
            System.err.println("页码：" + pageNum + "；商品ID：" + strId);

        }

    }

    public static void main(String[] args) throws Exception {
        // supplierId:10062 供应商：北京京东世纪信息技术有限公司
        // supplierId:113 供应商：网易严选
        // supplierId:10070 供应商：(考拉)杭州优买科技有限公司

        int i = 1;
        while (i<=1) {
            System.out.println("-----------处理次数：" + i+"-----------");// 即，处理的页面数
            ShopCommodityUpdateStatusExpand.setShopCommodityExpand("10070", "1", "false", 1, "9317AE643A3F37B0024CEFDD5A4AEA2B");
            i++;

        }

    }
}
