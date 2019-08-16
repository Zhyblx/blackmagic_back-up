package businessunit.blackmagicproject;

/**
 * 类：SelectUserInfo
 * 作用：查询用户信息
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import repositories.BrowserEnum;

public class SelectUserInfo {

    private static final String URL = "http://winehouse.ultimavip.org/winehouse/user/getUserList?";
    private static final String TIME = "time=";
    private static final String SEARCHINFO = "&searchInfo=";
    private static final String NAMEINFO = "&nameInfo=";
    private static final String PHONEINFO = "&phoneInfo=";
    private static final String PAGENUM = "&pageNum=";
    private static final String PAGESIZE = "&pageSize=";

    private static Connection connection = null;
    private static Document document = null;

    /*
     * 注意：time的输入格式示例：2018-11-02+%E8%87%B3+2018-11-03
     *
     * 字段说明：
     * time:时间范围
     * searchInfo:黑卡ID
     * nameInfo:用户名
     * phoneInfo:手机号
     * pageNum:默认1
     * pageSize:默认20
     *
     */
    public static String getSearchInfo(String time , String searchInfo , String nameInfo , String phoneInfo , String pageNum , String pageSize , String CookieValue) {
        String URLINFO = URL + TIME + time + SEARCHINFO + searchInfo + NAMEINFO + nameInfo + PHONEINFO + phoneInfo + PAGENUM + pageNum + PAGESIZE + pageSize;
        String strDocJosn = "";
        String returnData = "";
        try {
            connection = Jsoup.connect(URLINFO);
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(5000);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            connection.cookie("JSESSIONID" , CookieValue);

            document = connection.get();
            strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("pageInfo");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject2);
                returnData = returnData + jsonObject2.toString() + "\r\n";
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return returnData;

    }


    public static void main(String[] args) throws Exception {
        System.out.println(
                SelectUserInfo.getSearchInfo("2018-11-02+%E8%87%B3+2018-11-03" , "" , "" , "" , "1" , "20" , "2E3475A683E7403D370028C77E89969B"));
//        System.out.println(
//                SelectUserInfo.getSearchInfo("" , "102042526" , "" , "" , "1" , "20" , "26B6334593D5BD0049A0255A72A14941"));

    }

}



