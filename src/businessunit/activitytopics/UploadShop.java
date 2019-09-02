package businessunit.activitytopics;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;
/**
 * 类：UploadShop
 * 作用于按顺序导入商品
 *
 */
public class UploadShop {

    private static Connection connection = null;
    private static Response response = null;

    public static void setUploadShop(String strCookie, String productIds, String topicId)  {

        try{
            connection = Jsoup.connect("http://truechoice.ultimavip.org/topicProduct/upload");
            connection.userAgent(UserAgentInterface.UserAgent);
//        connection.ignoreContentType(false);
            connection.timeout(5000);

            connection.cookie("JSESSIONID", strCookie);
            connection.data("productIds", productIds);
            connection.data("topicId", topicId);

            connection.post();
            response = connection.execute();
            System.out.println(response.statusCode());//输出访问状态码

        }catch (Exception e){
            // 不作处理，防止请求两次

        }
    }

    public static void main(String[] args) throws Exception {
        // 下面是商品ID，按倒序导入
        /*
         * 长期专题4:[107] 14825","4333","2679","13140","3542","3556","14667","14856","14642","14998","14444","14814
         * 长期专题3:[106] 15059","15054","15047","15046","15056","15006
         * 长期专题2:[105] 2573","13291","14119","15057","3933","14822","14549","15036","14985
         * 长期专题1:[104] 15046","15045","15044","15038","15037","6745","14997","15013","15058
         *
         */
        String[] shopID = {"15046","15045","15044","15038","15037","6745","14997","15013","15058"};
        for (String ID : shopID) {
            System.out.println(ID);
            UploadShop.setUploadShop("2AADBDCBDECD9BA368AD419DAD06B65C", ID, "105");
            Thread.sleep(1000);

        }
    }
}
