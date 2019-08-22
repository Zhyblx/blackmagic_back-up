package businessunit.blackmagicproject;

/**
 * 类：SelectInfo
 * 作用：
 * 1.查询用户是否在电商业务中下过订单,方法getSelectUid();
 * 2.查询供应商的商品列表
 */

import repositories.BrowserEnum;
import toolbox.LogPrinting;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import toolbox.TimeStamp;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

public class SelectInfo {

    private static Connection connection = null;
    private static Document document = null;

    // 1.方法getSelectUid();查询用户是否在电商业务中下过订单,
    public static String getSelectUid(String userid, String strCookie) {
        String strDocJosn = "";
        String isStatus = "";
        String returnData = "";

        try {
            connection = Jsoup.connect("http://172.16.10.60:9091/order/listByPage?seqSearch=&userSearch=" + userid + "&title=&status=&pageNum=1&startTime=&endTime=");
            connection.cookie("JSESSIONID", strCookie);
            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(5000);
            connection.ignoreContentType(true);
            document = connection.get();

            strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            //如果数组[jsonArray]为空说明用户没有在环球黑卡电商业务中下过订单
            if (jsonArray.size() >= 1) {
                isStatus = "true";
            } else {
                isStatus = "false";
            }

            returnData = userid + "," + isStatus;

        } catch (Exception e) {
            LogPrinting.getLog(userid);

        }

        return returnData;

    }

    // 2.方法getShopCommodity();查询供应商的商品列表
    public static String getShopCommodity(String supplierId, int pageNum, String strCookie) {

        String strDocJosn = "";
        String strId = "";
        String strTitle = "";
        String strTag = "";
        String returnData = "";
        try {

            connection = Jsoup.connect("http://172.16.10.60:9091/product/listByPage?search=&supplierId=" + supplierId + "&buyerId=&status=&pageNum=" + pageNum + "&categoryId=");
            connection.cookie("JSESSIONID", strCookie);
            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");
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
                strId = jsonObject2.getString("id");//商品ID
                strTitle = jsonObject2.getString("title");//商品标题
                strTag = jsonObject2.getString("tag");//型号
                returnData = returnData + strId + "|" + strTitle + "|" + strTag + "\r\n";
            }


        } catch (Exception e) {
            LogPrinting.getLog(pageNum);
        }

        return returnData;
    }


    // 3.方法 getCommodityData();查询全量商品信息
    public static String getCommodityData(String ShopID, String status, int pageNum, String strCookie) {

        String strDocJosn = "";
        String strId = "";
        String strTitle = "";
        String strCid = "";
        String returnData = "";
        String categoryName = "";
        String strReleaseTime = "";
        String strQuantity = "";
        String strStatus = "";
        String strPrice = "";

        try {
            connection = Jsoup.connect("http://truechoice.ultimavip.org/product/listByPage?search=" + ShopID + "&supplierId=&buyerId=&status=" + status + "&pageNum=" + pageNum + "&categoryId=");
            connection.cookie("JSESSIONID", strCookie);
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
                strId = jsonObject2.getString("id");//商品ID
                strTitle = jsonObject2.getString("title");//商品标题
                strCid = jsonObject2.getString("cid");//当前类目ID
                categoryName = ClassificationCorrespondence.getClassificationMapPing(Integer.valueOf(strCid));// 类目名称
                strReleaseTime = TimeStamp.stampToDate(jsonObject2.getString("releaseTime"));//发布时间
                strQuantity = jsonObject2.getString("quantity");// 已售数量
                strStatus = jsonObject2.getString("status");// 状态：true表示已上架；flesh表示已下架
                strPrice = jsonObject2.getString("price");//售价


                returnData = returnData + strId + "|" + strTitle + "|" + categoryName + "|" + strReleaseTime + "|" + strQuantity + "|" + strStatus + "|" + strPrice + "\r\n";
            }


        } catch (Exception e) {
//            System.err.println("错误页码：" + pageNum);
            LogPrinting.getLog("错误页码：" + pageNum);

        }

        return returnData;

    }

    /**
     * 最新的商品信息查询接口
     */

    public static Set<String> getCommodityData_New(String search, String categoryIds1, String categoryIds2, String supplierId, String buyerId, String status, String pageNum, String Cookie) {
        Set<String> set = new HashSet<String>();

        try {
            connection = Jsoup.connect(
                    "http://truechoice.ultimavip.org/product/listByPage?"
                            + "search=" + search
                            + "&categoryIds%5B%5D=" + categoryIds1
                            + "&categoryIds%5B%5D=" + categoryIds2
                            + "&supplierId=" + supplierId
                            + "&buyerId=" + buyerId
                            + "&status=" + status
                            + "&pageNum=" + pageNum
                            + "&categoryId=" + categoryIds2

            );

            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.cookie("JSESSIONID", Cookie);
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(8000);

            document = connection.get();
//            System.out.println(document.text());
            String supplierName = document.text();
            JSONObject jsonObject = JSONObject.fromObject(supplierName);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String supID = jsonObject2.getString("supplierId");
                set.add(supID);

            }


        } catch (Exception e) {
            e.printStackTrace();

        }

        return set;

    }


    public static void main(String[] args) throws Exception {

//        String strCommodity=SelectInfo.getCommodityData("12810","",1,"409EBB75D089B47A09A5D83480A50893");
//        if(strCommodity.indexOf("12810")!=-1){
//            System.out.println(strCommodity);
//
//        }

        /*
         * 以下是通过商品ID查询商品信息
         * 字段：商品ID、商品标题、类目名称、发布时间、已售数量、状态：true表示已上架；flesh表示已下架、售价
         *
         */
        String[] shopID={"3438"};

        for(String strid:shopID){
            System.out.println(SelectInfo.getCommodityData(strid, "", 1, "9F46938986ED3E0932DA1343FB6771A0"));
        }




//        System.out.println(SelectInfo.getSelectUid("1146050" , "CB3DC8C3FD66C98A26D0327E558287E5"));
//        System.out.println(SelectInfo.getSelectUid("1293378" , "CB3DC8C3FD66C98A26D0327E558287E5"));
//        System.out.println(SelectInfo.getSelectUid("1018136" , "CB3DC8C3FD66C98A26D0327E558287E5"));
//        System.out.println(SelectInfo.getSelectUid("1267769" , "CB3DC8C3FD66C98A26D0327E558287E5"));
//        System.out.println(SelectInfo.getSelectUid("9513685854" , "CB3DC8C3FD66C98A26D0327E558287E5"));
//        System.out.println(SelectInfo.getSelectUid("114600" , "CB3DC8C3FD66C98A26D0327E558287E5"));
//        System.out.println(SelectInfo.getSelectUid("618108", "31C4FCE946C7CF5462882F6705177316"));

//        Integer[] pageNum = new Integer[]{103, 163};
//
//        for (Integer integer : pageNum) {
//            System.out.println(
//                    SelectInfo.getCommodityData("", integer, "31C4FCE946C7CF5462882F6705177316"));
//        }

//        Set<String> mset = new HashSet<String>();
//
//        for (int i = 1; i <= 11; i++) {
//            mset.addAll(
//
//                    SelectInfo.getCommodityData_New(
//                            "",
//                            "172",
//                            "173",
//                            "",
//                            "",
//                            "",
//                            String.valueOf(i),
//                            "1AED3573A45B2FD981F3578F6E4E8DA7")
//
//            );
//        }
//
//        Iterator<String> iterator = mset.iterator();
//        do {
//            String str = iterator.next();
//            System.out.println(str);
//
//        } while (iterator.hasNext());


    }

}
