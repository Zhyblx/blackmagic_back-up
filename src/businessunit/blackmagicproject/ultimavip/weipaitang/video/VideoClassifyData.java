package businessunit.blackmagicproject.ultimavip.weipaitang.video;

import businessunit.blackmagicproject.ultimavip.weipaitang.weipaitanginterface.WeiPaiTangInterface;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;

/**
 * 类：VideoClassifyData
 * 作用：获取具体分类的直播视频数据
 *
 */

public class VideoClassifyData {

    private static Connection connection = null;
    private static Document document = null;

    public static String setVideoClassifyData(String start, String page, String categoryId, String secCategoryId) {
        String strReturn = "";
        try {

            connection = Jsoup.connect(WeiPaiTangInterface.URLvideo_classify);
            connection.ignoreContentType(true);
            connection.timeout(100000);
            connection.userAgent(WeiPaiTangInterface.UserAgent);

            connection.data("start", start);
            connection.data("page", page);
            connection.data("categoryId", categoryId);
            connection.data("secCategoryId", secCategoryId);

            document = connection.get();
            //System.out.println(document.text());

            String strList = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strList);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject2.get("id")+","+jsonObject2.get("name"));
                String roomName = String.valueOf(jsonObject2.get("roomName"));//商品标题
                String title = String.valueOf(jsonObject2.get("title"));//视频标题
                String roomNum = String.valueOf(jsonObject2.get("roomNum"));//直播观看人数
                String userinfoUri = String.valueOf(jsonObject2.get("userinfoUri"));//视频ID
                String address = String.valueOf(jsonObject2.get("address"));//直播所在地
                strReturn = strReturn + roomName + "|" + title + "|" + roomNum + "|" + userinfoUri + "|" + address + "|" + "\r\n";
            }

        } catch (Exception e) {
            e.printStackTrace();

        }

        return strReturn;
    }

    public static void main(String[] args) throws Exception {
        for (int i = 1; i <= 8; i++) {
            System.out.println(
                    VideoClassifyData.setVideoClassifyData("", String.valueOf(i), "3", "-1")
            );
        }


    }

}
