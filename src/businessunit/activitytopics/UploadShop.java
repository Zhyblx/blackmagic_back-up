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
         * 长期专题4:[107]
         * 长期专题3:[106] 15106","14738","15096","10603","10631","15084","15032","14531","13256","15094","14870","13267","14917","14293","13218","14953","4325","2409
         * 长期专题2:[105] 15000","13329","14897","7555","13154","15007","13535","14192","14806","3490","13375","12953","13585","4240","15088","10477","12612","10705","10342","12772","14848","13321","3917","12964","12958","12740","12916","14232","14444","4428","14743","2516","13464","14847","12924","12889","10577
         * 长期专题1:[104] 15090","14998","14888","12486","13462","3942","14814","14906","15059","13512","12655","13140","15082","15061","15062","15098","15107
         *
         */
        String[] shopID = {"13526","14668","15111","15047","14991","14842","14444","3933","2573","14689","10435","10748","14324","14537","12147"};
        for (String ID : shopID) {
            System.out.println(ID);
            UploadShop.setUploadShop("193DDC9B59F13A8B42D9E1D5F4A5D696", ID, "105");
            Thread.sleep(1000);

        }
    }
}
