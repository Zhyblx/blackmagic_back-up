package businessunit.activitytopics;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection.Response;

import java.util.ArrayList;
import java.util.List;

/**
 * 类：Topic
 * 作用于专题下的商品进行删除操作
 *
 */

public class Topic {

    private Connection connection = null;
    private Document document = null;
    private List<String> list = null;
    private String strDocument = "";
    private Response response = null;

    /*
     * 方法：setTopicShopID()
     * 获取专题下商品对应的ID
     */
    public List<String> setTopicShopID(String pageNum) throws Exception {
        list = new ArrayList<String>();
        connection = Jsoup.connect("http://truechoice.ultimavip.org/topicProduct/listByPage?pid=&title=&pageNum=" + pageNum + "&topicId=" + this.getTopicId());
        connection.userAgent(UserAgentInterface.UserAgent);
        connection.ignoreContentType(true);
        connection.timeout(5000);
        connection.cookie("JSESSIONID", this.getCookie());
        document = connection.get();
        strDocument = document.text();

        JSONObject jsonObject = JSONObject.fromObject(strDocument);
        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
        JSONArray jsonArray = jsonObject1.getJSONArray("list");

        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonResult = jsonArray.getJSONObject(i);
            String strId = jsonResult.getString("id");//商品ID
//            System.out.println(strId);
            list.add(strId);

        }

        return list;

    }


    /*
     * 方法getDeleteGoods()
     * 删除专题下的商品列表
     */
    public void getDeleteGoods(String topicShopID) throws Exception {
        connection = Jsoup.connect("http://truechoice.ultimavip.org/topicProduct/delete");
        connection.userAgent(UserAgentInterface.UserAgent);
        connection.ignoreContentType(true);
        connection.timeout(5000);

        connection.cookie("JSESSIONID", this.getCookie());
        connection.data("id", topicShopID);
        connection.data("topicId", this.getTopicId());
        connection.data("sort","");

        connection.post();
//        System.out.println(document);
        response = connection.execute();
        System.out.println(response.statusCode());//输出访问状态码


    }

    private String strCookie = "";

    private void setCookie(String strCookie) {
        this.strCookie = strCookie;

    }

    private String getCookie() {
        return this.strCookie;

    }

    private String topicId = "";

    private void setTopicId(String topicId) {
        this.topicId = topicId;

    }

    private String getTopicId() {
        return this.topicId;

    }

    public Topic(String strCookie, String topicId) {
        this.setCookie(strCookie);
        this.setTopicId(topicId);

    }

    public static void main(String[] args) throws Exception {
        Topic topic=new Topic("2A6F992EF472C47163C9AD7F3B4EFE78","97");
        System.out.println(topic.setTopicShopID("1"));


    }


}
