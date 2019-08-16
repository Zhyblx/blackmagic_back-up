package businessunit.blackmagicproject;

/**
 * 类：SelectOrderDataSize
 * 作用：查询订单量和退款单量
 */

import repositories.BrowserEnum;
import toolbox.TimeStamp;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

public class SelectOrderDataSize {

    private static Connection connection = null;
    private static Document document = null;

    /*
     * 1.退款单量查询
     * 状态说明：
     *  1：申请退款
     *  2：同意退款
     *  3：不同意退款
     *  4：退款中
     *  5：退款成功
     *  6：退款失败
     */

    private static String refundUrl = "http://truechoice.ultimavip.org/orderRefund/listByPage?seqSearch=&title=&dateRange%5B0%5D=Wed%20Aug%2001%202018%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&dateRange%5B1%5D=Sat%20Sep%2001%202018%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&status=";
    private static String[] parameter = {"&type=&pageNum=1&startTime=", "&endTime="};

    @Deprecated
    public static String getRefundData(String status, String startTime, String endTime, String strCookie) {

        String strDocJosn = "";
        String returnData = "";

        try {
            connection = Jsoup.connect(refundUrl + status + parameter[0] + startTime + parameter[1] + endTime);
            connection.cookie("JSESSIONID", strCookie);
            connection.ignoreContentType(true);
            connection.timeout(9000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());

            document = connection.get();
            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            returnData = jsonObject1.getString("total");
            System.out.println(returnData);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return returnData;

    }


    /*
     * 2.订单量查询
     * 状态说明：
     *  1：待付款
     *  2：付款成功
     *  3：付款失败
     *  4：退款中
     *  5：退款成功
     *  6：退款失败
     *  9：已取消
     *  10：超时
     *  12：审核中
     *  13：审核失败
     *
     */

    private static String orderUrl = "http://truechoice.ultimavip.org/order/listByPage?seqSearch=&userSearch=&title=&dateRange%5B0%5D=Sun%20Jul%2001%202018%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&dateRange%5B1%5D=Fri%20Aug%2003%202018%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&status=";
    private static String[] orderParameter = {"&pageNum=1&startTime=", "&endTime="};

    public static String getOrderData(String status, String startTime, String endTime, String strCookie) {
        String strDocJosn = "";
        String returnData = "";
        try {
            connection = Jsoup.connect(orderUrl + status + orderParameter[0] + startTime + orderParameter[1] + endTime);
            connection.cookie("JSESSIONID", strCookie);
            connection.ignoreContentType(true);
            connection.timeout(9000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());

            document = connection.get();
            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            returnData = jsonObject1.getString("total");

        } catch (Exception e) {
            e.printStackTrace();
        }

        return returnData;
    }


    public static void main(String[] args) throws Exception {
//        SelectOrderDataSize.getRefundData("5","1535731200000","1538409600000","73E3DCEEA49C3DCB88113A7E63217486");
//        SelectOrderDataSize.getOrderData("5", "1530374400000", "1533225600000", "73E3DCEEA49C3DCB88113A7E63217486");

        String[] startTime = {"2018-01-01 00:00:00", "2018-02-01 00:00:00", "2018-03-01 00:00:00", "2018-04-01 00:00:00", "2018-05-01 00:00:00", "2018-06-01 00:00:00", "2018-07-01 00:00:00", "2018-08-01 00:00:00", "2018-09-01 00:00:00", "2018-10-01 00:00:00"};
        String[] endTime = {"2018-01-31 00:00:00", "2018-02-28 00:00:00", "2018-03-31 00:00:00", "2018-04-30 00:00:00", "2018-05-31 00:00:00", "2018-06-30 00:00:00", "2018-07-31 00:00:00", "2018-08-31 00:00:00", "2018-09-30 00:00:00", "2018-10-31 00:00:00"};

//        for (int i = 0; i < startTime.length; i++) {
//            System.out.println(
//                    (6 + i) + "月" + "," +
//                            SelectOrderDataSize.getOrderData("", startTime[i], endTime[i], "73E3DCEEA49C3DCB88113A7E63217486") +
//                            "," +
//                            SelectOrderDataSize.getOrderData("5", startTime[i], endTime[i], "73E3DCEEA49C3DCB88113A7E63217486")
//            );
//        }

        String strCookie = "F8F45FEA5822EC8F34B7F8D570B70713";
        System.out.println("退款订单占比如下：");

        for (int i = 0; i < startTime.length; i++) {
            String strStartTime = TimeStamp.dateToStamp(startTime[i]);
            String strEndTime = TimeStamp.dateToStamp(endTime[i]);

            int orderTotal = Integer.valueOf(SelectOrderDataSize.getOrderData("", strStartTime, strEndTime, strCookie));//总订单量
            int orderNum = Integer.valueOf(SelectOrderDataSize.getOrderData("5", strStartTime, strEndTime, strCookie));//退款单量
            double proportion=((double)orderNum / orderTotal);//退款占比

            System.out.println(
                    (1 + i) + "月" + "," +
                            orderTotal +
                            "," +
                            orderNum +
                            "," +
                            proportion

            );

        }
    }
}








