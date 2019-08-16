package businessunit.blackmagicproject.ultimavip.weipaitang.Selected;


import businessunit.blackmagicproject.ultimavip.weipaitang.timeprocessor.TimeProcessor;
import businessunit.blackmagicproject.ultimavip.weipaitang.weipaitanginterface.WeiPaiTangInterface;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import toolbox.UnicodeConversion;

/**
 * 类：RecommendTogetherData
 * 作用：获取精选分类的拍品数据
 *
 */

public class RecommendTogetherData {

    private static Connection connection = null;
    private static Document document = null;

    /**
     *
     * @param page: 2
     * @param timer: 1553238120
     * @return
     */
    public static String setRecommendTogetherData(String page,String timer) {
        try {
            connection = Jsoup.connect(WeiPaiTangInterface.URLrecommend_Together);
            connection.ignoreContentType(true);
            connection.timeout(10000);
            connection.userAgent(WeiPaiTangInterface.UserAgent);

            connection.data("page", page);
            connection.data("time", timer);

            document = connection.get();
            System.out.println(document.text());


        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }

    public static void main(String[] args) throws Exception {
//        RecommendTogetherData.setRecommendTogetherData("2","1553238120");

        System.out.println(TimeProcessor.getTimeProcessor());
        //UnicodeConversion.getdecodeUnicode("\\u5047\\u5fc5\\u8d54");
        System.out.println(UnicodeConversion.getdecodeUnicode("\\u5927\\u5510\\u5fa1\\u5e9c\\u7fe1\\u7fe0"));

    }

}
