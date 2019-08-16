package businessunit.blackmagicproject.circleoffriends;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import toolbox.LogPrinting;
import toolbox.TimeStamp;


/**
 * 类：PostingMessage
 * 作用：环黑"卡友圈"的发帖管理
 */

public class PostingMessage {

    private static Connection connection = null;
    private static Document document = null;

    /*
     * 方法：getPostingDocuments()
     * 作用：获取用户的帖子信息
     */
    public static String getPostingDocuments(int page, String cookie) {
        final String URL = "http://spiritlink.ultimavip.org/essay/listPage";
        String strRecordContent = "";
        try {
            connection = Jsoup.connect(URL);
            connection.ignoreContentType(true);
            connection.timeout(5000);
            connection.cookie("JSESSIONID", cookie);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");

            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.data("checkFlag", "");
            connection.data("createdBegin", "2016-08-01 00:00:00");//环球黑卡的朋友圈上线时间为：2016年8月2日
            connection.data("createdEnd", "");
            connection.data("page", String.valueOf(page));
            connection.data("rows", "20");

            document = connection.post();
            String strDoucuments = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDoucuments);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String id = jsonObject2.getString("id");//帖子ID
                String userId = jsonObject2.getString("userId");//用户ID
                String userName = jsonObject2.getString("userName");//用户名称
                String cardNum = jsonObject2.getString("cardNum");//卡号
                String created = TimeStamp.stampToDate(jsonObject2.getString("created"));//帖子创建时间

                /*
                 * 帖子内容处理
                 */
                String content = jsonObject2.getString("content");// 获取到帖子内容
                String strContent = content.replaceAll("\r|\n", ""); //去掉帖子内容中的所有换行符号
                String strContent2 = strContent.replaceAll("|", ""); // 去掉帖子内容中的所有制表符

                /*
                 * strRecordContent为返回的帖子内容
                 */
                strRecordContent = strRecordContent + id + "|" + userId + "|" + userName + "|" + cardNum + "|" + strContent2 + "|" + created + "\r\n";

            }

        } catch (Exception e) {
            LogPrinting.getLog("出错页码：" + page);

        }
        return strRecordContent;

    }

    /*
     * 方法：getReplyDocuments()
     * 作用：获取用户的评论信息
     */

    public static String getReplyDocuments(int page, String cookie) {
        final String URL = "http://spiritlink.ultimavip.org/essayComment/listPage?starFlag=0";
        String strReplyContent = "";
        try {
            connection = Jsoup.connect(URL);
            connection.ignoreContentType(true);
            connection.timeout(5000);
            connection.cookie("JSESSIONID", cookie);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/71.0.3578.98 Safari/537.36");

            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.header("Accept", "application/json, text/javascript, */*; q=0.01");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.data("checkFlag", "");
            connection.data("comment", "");
            connection.data("createdBegin", "2016-08-01 00:00:00");//环球黑卡的朋友圈上线时间为：2016年8月2日
            connection.data("createdEnd", "");
            connection.data("fromUserCardNum", "");
            connection.data("page", String.valueOf(page));
            connection.data("rows", "20");

            document = connection.post();
            String strDoucuments = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDoucuments);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                String id = jsonObject2.getString("id");//评论ID
                String fromUserId = jsonObject2.getString("fromUserId");//用户ID
                String fromUserName = jsonObject2.getString("fromUserName");//用户名称
                String fromUserCardNum = jsonObject2.getString("fromUserCardNum");//卡号
                String toUserId = jsonObject2.getString("toUserId");// 发帖人ID
                String essay = jsonObject2.getString("essay");// 帖子ID
                String created = TimeStamp.stampToDate(jsonObject2.getString("created"));//评论创建时间

                /*
                 * 评论内容处理
                 */
                String comment = jsonObject2.getString("comment");
                String strComment = comment.replaceAll("\r|\n", "");//去掉评论内容中的所有换行符号
                String strComment1 = strComment.replaceAll("|", "");// 去掉评论内容中的所有制表符

                strReplyContent = strReplyContent + id + "|" + fromUserId + "|" + fromUserName + "|" + fromUserCardNum + "|" + toUserId + "|" + essay + "|" + strComment1 + "|" + created + "\r\n";

            }

        } catch (Exception e) {
            LogPrinting.getLog("出错页码：" + page);

        }
        return strReplyContent;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(PostingMessage.getPostingDocuments(2, "2A648B2C604B601BA6F6BF4436DB0126"));
        System.out.println(PostingMessage.getReplyDocuments(1, "2A648B2C604B601BA6F6BF4436DB0126"));

    }
}
