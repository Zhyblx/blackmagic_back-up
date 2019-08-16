package businessunit.blackmagicproject.moneyaffairorderstatistics;

/**
 * 类：MoneyAffairOrderStatistics
 * 作用：对财务需要的对账订单进行统计
 */

import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import repositories.BrowserEnum;

import java.util.Map;
import java.util.HashMap;


public final class MoneyAffairOrderStatistics {

    private static final String STRMONEYAFFAIRURL = "http://moneyaffair.ultimavip.org/moneyaffair/orderInfo/listByPage?time=";
    private static final String[] PARAMETER = {"+%E8%87%B3+", "&orderNo=&orderSeq=&appId=", "&payChannel=&status=&pageNum=1&pageSize=20"};

    private static Document document = null;
    private static Connection connection = null;

    public static Map<String, String> getMoneyAffairOrderStatistics(String startTime, String endTime, String appId, String strCookie) {
        Map<String, String> map = new HashMap<String, String>();
        String strDocJosn = "";
        String totalOrders = "";

        try {
            connection = Jsoup.connect(STRMONEYAFFAIRURL + startTime + PARAMETER[0] + endTime + PARAMETER[1] + appId + PARAMETER[2]);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(20000);
            connection.ignoreContentType(true);
            connection.cookie("JSESSIONID", strCookie);

            document = connection.get();
            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            totalOrders = jsonObject1.getString("total");
            map.put(appId, totalOrders);// 返回：AppID(业务类型) 和 totalOrders(订单总量)

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }

    /**
     * status: 1[已付款]
     * status: 2[已退款]
     */

    private static final String[] PARAMETER1 = {"+%E8%87%B3+", "&orderNo=&orderSeq=&appId=", "&payChannel=&status=", "&pageNum=1&pageSize=20"};

    public static Map<String, String> getMoneyAffairOrderStatistics(String startTime, String endTime, String appId, String status, String strCookie) {
        Map<String, String> map = new HashMap<String, String>();
        String strDocJosn = "";
        String totalOrders = "";

        try {
            connection = Jsoup.connect(STRMONEYAFFAIRURL + startTime + PARAMETER1[0] + endTime + PARAMETER1[1] + appId + PARAMETER1[2] + status + PARAMETER1[3]);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(20000);
            connection.ignoreContentType(true);
            connection.cookie("JSESSIONID", strCookie);

            document = connection.get();
            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            totalOrders = jsonObject1.getString("total");
            map.put(appId, totalOrders);// 返回：AppID(业务类型) 和 totalOrders(订单总量)

        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;

    }


    public static void main(String[] args) throws Exception {
//        System.out.println(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics("2018-11-01","2018-11-03",MoneyAffairOrderStatisticsAppIdEnum.咖啡.getStrAppIdEnum(),"EA00F82EA000A855F0F6BA2775B51D80"));

        System.out.println(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(
                "2018-06-01", "2018-06-30",
                "2", "1", "FB7B76A6FA0B0E3A883FFD64B8549742"


        ));

    }


}
