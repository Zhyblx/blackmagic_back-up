package edges.kaoladata;

/**
 * 类：UCCCommentData
 * 作用：监控UCC咖啡的评论数据
 * 商品ID：1301844
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

public class UCCCommentData {

    private static Connection connection = null;
    private static Document document = null;

    public static final String setUCCCommentData(String goodsId, String pageNo) {
        String strReturn = "";
        try {
            connection = Jsoup.connect(KaoLaInterface.KaoLaCommentURL);
            connection.timeout(20000);
            connection.ignoreContentType(true);
            connection.userAgent(KaoLaInterface.UserAgent);

            connection.data("goodsId", goodsId);
            connection.data("pageNo", pageNo);
            connection.data("grade", "0");
            connection.data("tagType", "0");
            connection.data("hasContent", "1");
            connection.data("pageSize", "20");
//            connection.header("content-type", "application/json;charset=UTF-8");
//            connection.header("access-control-allow-credentials","true");
//            connection.header("access-control-allow-headers","Content-Type,X-Requested-With,ursAuth,origin, ursid, urstoken");
//            connection.header("access-control-allow-methods","GET,HEAD,POST,PUT,DELETE,TRACE,OPTIONS,PATCH");
//            connection.header("access-control-allow-origin","https://goods.kaola.com");
//            connection.header("access-control-max-age","86400");
//            connection.header("content-encoding","gzip");
//            connection.header("server","nginx");
//            connection.header("status","200");
//            connection.header("vary","Accept-Encoding");
//            connection.header("x-via-env","onlinejd");
            connection.header("Content-Type", "application/x-www-form-urlencoded");
            connection.header("Origin", "https://goods.kaola.com");
            connection.header("Referer", "https://goods.kaola.com/product/1301844.html?referPage=searchPage&referId=ucc%E5%92%96%E5%95%A1&from=page1&position=11&istext=0&srId=732a684473b86edb982d654d1d1bf72d&zn=result&zp=page1-11&ri=ucc%E5%92%96%E5%95%A1&rp=search");

            document = connection.post();

            String strDoc = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDoc);
            JSONObject jsonObject1 = jsonObject.getJSONObject("commentPage");
            JSONArray jsonArray = jsonObject1.getJSONArray("result");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject2.get("commentContent"));
                String commentContent = String.valueOf(jsonObject2.get("commentContent"));
                String createTime = String.valueOf(jsonObject2.get("createTime"));

                strReturn = strReturn + commentContent + "|" + createTime + "\r\n";

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
        return strReturn;

    }

    public static void main(String[] args) throws Exception {
        for (int i = 1; i < 43; i++) {
            System.out.println(
                    UCCCommentData.setUCCCommentData("1301844", String.valueOf(i))

            );
        }
    }
}
