package businessunit.blackmagicproject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import repositories.BrowserEnum;
import toolbox.LogPrinting;
import toolbox.TimeStamp;

/**
 * 类：SelectInfo_Violation
 * 作用：查询金融和轻古的违规商品
 * 说明：为确保"电商每日上新"的商品质量，以下代码用于责查金融和轻古两域上架时间在2019年的商品；跑出列表并责令相关业务方将商品的上架时间改为2017年或更早的时间。
 */

public class SelectInfo_Violation extends SelectInfo {

    private String strCookie = "";

    private void setStrCookie(String strCookie) {
        this.strCookie = strCookie;

    }

    private String getStrCookie() {
        return this.strCookie;

    }

    public SelectInfo_Violation(String strCookie) {
        this.setStrCookie(strCookie);

    }

    /*
     * 方法：setShopOffline(String id) 【参数】 id 代表 商品ID
     * 作用：通过商品ID对违反电商规则的商品进行下架
     *
     */

    public String setShopOffline(String id) {
        String status = "false"; //代表商品的"下架"状态
        String success = "";// 返回 访问状态
        try {
            connection = Jsoup.connect("http://truechoice.ultimavip.org/product/updateStatus");
            connection.cookie("JSESSIONID", this.getStrCookie());
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(8000);
            connection.data("id", id);
            connection.data("status", status);
            document = connection.post();
            String strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            success = jsonObject.getString("success");

        } catch (Exception e) {
            e.printStackTrace();

        }
        return success;

    }

    /*
     * 方法：setSelectViolationInfo(String ShopIDorTitle, String status, int pageNum) 【参数】 ShopIDorTitle 代表 一级类目 ；String status 代表 商品的上/下架状态；pageNum 代表 页码
     * 作用：查询非电商业务且上架时间是2019年的商品；同时对商品进行下架处理。
     *
     */

    public String setSelectViolationInfo(String ShopIDorTitle, String status, int pageNum) {
        String strDocJosn = "";
        String shelfTime = "";
        String text = "";
        String strId = "";
        String strTitle = "";

        try {
            connection = Jsoup.connect("http://truechoice.ultimavip.org/product/listByPage?search=" + ShopIDorTitle + "&supplierId=&buyerId=&status=" + status + "&pageNum=" + pageNum + "&categoryId=");
            connection.cookie("JSESSIONID", this.getStrCookie());
            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(8000);
            connection.ignoreContentType(true);
            document = connection.get();
            strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                shelfTime = jsonObject2.getString("shelfTime");//上架时间
                strId = jsonObject2.getString("id");//商品ID
                strTitle = jsonObject2.getString("title");//商品标题
                text = TimeStamp.stampToDate(shelfTime);
                if (text.indexOf("2019") != -1) {
                    String shopStatus = this.setShopOffline(strId);
                    System.out.println(text + "\t" + strId + "\t" + strTitle + "\t" + shopStatus);

                }
            }
        } catch (Exception e) {
            LogPrinting.getLog("错误页码：" + pageNum);

        }
        return null;

    }

    public static void main(String[] args) {
        System.out.println("上架时间" + "\t" + "商品ID" + "\t" + "商品标题" + "\t" + "下架状态");
        for (int i = 1; i <= 30; i++) {
            new SelectInfo_Violation("7C67265D4E12823611F186C11EF75DAD").setSelectViolationInfo("轻古集市", "1", i);

        }
    }
}
