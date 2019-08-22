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
         * 长期专题4:滋补专场(确定);topicId: 107
         * 长期专题3:日化专场(确定);topicId: 106
         * 长期专题2:情趣专场(确定);topicId: 105
         * 长期专题1:男人专场(确定);topicId: 104
         *
         */
        String[] shopID = {"14989","14932","14357","2215","13242","14979","14668","14917","12745","13254","4086","10115","10575","4085","2894","14080","13533","12807","10198","4029","4414","14848","15004","15003","14995","10408","12924","2748","6838"};
        for (String ID : shopID) {
            System.out.println(ID);
            UploadShop.setUploadShop("9F46938986ED3E0932DA1343FB6771A0", ID, "104");
            Thread.sleep(1000);

        }
    }
}
