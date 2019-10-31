package businessunit.blackmagicproject.userinfo;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import repositories.BrowserEnum;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


/**
 * 类：UserLocation
 * 作用：查询用户信息
 * 数据来源：用户中心
 */

public final class UserInfo {

    /*
     *方法:getUserLocation()
     * 作用：通过userID查询用户的所在地址
     *
     */

    private static Document document = null;
    private static Connection connection = null;


    // 使用UserID 进行查询
    public static String getUserLocation(String userID, String cookiesValue) {
        String URL = "http://winehouse.ultimavip.org/userAddress/list.do";
        String strDocHtml = "";
        String userInfo = "";
        try {
            connection = Jsoup.connect(URL);
            connection.cookie("JSESSIONID", cookiesValue);

            connection.header("Content-Type", "text/html;charset=utf-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.data("userId", userID);
            connection.data("phone", "");
            connection.data("isDefault", "1");//表示默认地址
            connection.data("isDel", "");

            connection.ignoreContentType(true);
            connection.timeout(100000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            document = connection.get();
            strDocHtml = document.html();

            Document documentHtml = Jsoup.parse(strDocHtml);
            System.out.println(documentHtml.text());

            Elements elements = documentHtml.select("[class=pageContent]");
            Elements elements1 = elements.select("[id=w_list_print]");
            Elements elements2 = elements1.select("[target=id]");

            userInfo = elements2.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return userInfo;

    }

    // 使用cardNum 进行查询
    public static String getUserCardNum(String cardNum, String cookiesValue) {
        String URL = "http://winehouse.ultimavip.org/user/list.do";
        String strDocHtml = "";
        String userInfo = "";
        try {
            connection = Jsoup.connect(URL);
            connection.cookie("JSESSIONID", cookiesValue);

            connection.header("Content-Type", "text/html;charset=utf-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.data("id", "");
            connection.data("no", "");
            connection.data("cardNum", cardNum);
            connection.data("idNum", "");
            connection.data("phone", "");
            connection.data("name", "");
            connection.data("status", "");
            connection.data("sex", "");
            connection.data("realStatus", "");
            connection.data("livingStatus", "");
            connection.data("iosFingerprint", "");
            connection.data("birthYear", "");
            connection.data("birthDay", "");
            connection.data("openId", "");
            connection.data("unionId", "");

            connection.ignoreContentType(true);
            connection.timeout(100000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            document = connection.get();
            strDocHtml = document.html();

            Document documentHtml = Jsoup.parse(strDocHtml);
            Elements elements = documentHtml.select("[class=pageContent]");
            Elements elements1 = elements.select("[id=w_list_print]");
            Elements elements2 = elements1.select("[target=id]");
            userInfo = elements2.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return userInfo;

    }

    // 使用cardNum 进行查询会员身份
    public static String getUserCardNum(String cardNum, String userId, String userMembershipId, String status, String vip, String adtSource, String cookiesValue) {
        String URL = "http://winehouse.ultimavip.org/cardNum/list.do";
        String strDocHtml = "";
        String userInfo = "";
        try {
            connection = Jsoup.connect(URL);
            connection.cookie("JSESSIONID", cookiesValue);

            connection.header("Content-Type", "text/html;charset=utf-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.data("cardNum", cardNum);
            connection.data("userId", userId);
            connection.data("userMembershipId", userMembershipId);
            connection.data("status", status);
            connection.data("vip", vip);
            connection.data("adtSource", adtSource);

            connection.ignoreContentType(true);
            connection.timeout(100000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            document = connection.get();
            strDocHtml = document.html();

            Document documentHtml = Jsoup.parse(strDocHtml);

            Elements elements = documentHtml.select("tbody");
            userInfo = elements.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return userInfo;

    }


    public static void main(String[] args) throws Exception {
        String strCookies = "283F6829DA5471206BF22B5E5C8926E5";
//        String[] strName = {"101310486", "102038334", "102046890", "102050344", "102060333", "102062811", "102063402", "102133350", "102143111", "102164177", "102204166", "102219896", "102231771", "102256967", "102375577", "102534777", "102664101", "102733450", "103211219", "103354277", "103390606", "103514310", "105236882", "105354333", "105610479", "105638808", "106539618", "107320497", "107783007", "107821596", "107919512", "108373246", "109017589", "109757909", "110024684", "110030806", "110083118", "110115528", "110260551", "110277585", "110371482", "110471925", "111131415", "400092505", "101012802", "101310229", "102051658", "102066180", "102082753", "102766677", "105830300", "106915621", "107019823", "107971901", "109069934", "110016526", "110088580", "110136818", "110161531", "110198960", "110497100", "102040063", "102076831", "109517136", "110176643", "106234588", "110167616", "110312817", "103784870", "107996614", "109754943", "110362183", "101310326", "110047998", "110090807", "110302968", "102059476", "102777314", "105864975", "110123666", "111173107", "105794742", "110156071", "101031302", "103740120", "110070990", "109825455", "103361114", "102224736", "101011392", "101017886", "102011406", "102016528", "102037310", "102059476", "102060333", "102060789", "102062516", "102066180", "102117889", "102121607", "102159938", "102162477", "102204166", "102230520", "102375577", "102384677", "102683178", "102690360", "102713558", "102750959", "102766677", "102798548", "103995019", "105225816", "105289946", "105294363", "105638808", "105785655", "105864975", "105995256", "106245453", "106506346", "106958008", "107101746", "107229530", "107604030", "107911821", "107914767", "107917527", "107919512", "107968300", "108218971", "108239999", "108251919", "108300033", "108331064", "108333936", "108587579", "108612434", "108627590", "108732211", "108743294", "109008505", "109626860", "110009952", "110055866", "110090807", "110113826", "110151973", "110161531", "110226500", "110242557", "110260551", "110261111", "110305309", "110332939", "110364589", "110375889", "110386684", "110410835", "110471925", "110497864", "201847669", "201996187", "102051658", "102062044", "102143111", "102164177", "102293850", "102309008", "103522116", "103740120", "103800165", "107362904", "107983020", "108328065", "108572606", "110024684", "110147346", "110371482", "101310326", "102050344", "102769667", "105830300", "111173107", "102078455", "107996614", "109825455", "110302968", "110047998", "110070990", "102224736", "110123666", "103361114", "101310229", "101310357", "102000483", "102020808", "102033255", "102034286", "102035434", "102052860", "102101742", "102698074", "102777314", "102896269", "102909081", "103122802", "103663618", "105798409", "105872775", "106211826", "106776506", "106920520", "107019823", "107580244", "107981224", "107988828", "108317989", "109592792", "110023168", "110123666", "110261111", "110289830", "110312817", "110349938", "110356766", "110362183", "110365911", "110414990", "110426420", "110428891", "110431192", "110442868", "110461262", "110484602", "110495783", "111113047", "111128560", "111182799", "111209522", "111240647", "111291904", "111292111", "102060333", "102092180", "102133350", "103740120", "105294363", "105599314", "108565145", "108612434", "109602809", "110051930", "110098945", "110234760", "110240169", "110467486", "111292213", "201996189", "101031302", "102982664", "103500989", "103616891", "105610479", "105794742", "107971901", "110271983", "101310023", "107981131", "110088580", "110303184", "111229080", "107362904", "110164723", "103232678", "111173107", "102059476", "107050521", "110156071", "108608541", "111198911", "101310326", "102224736", "102050344", "102060333", "102143111", "102164177", "102204166", "102375577", "105638808", "107919512", "110024684", "110260551", "110371482", "110471925", "102051658", "102066180", "102766677", "105830300", "110161531", "107996614", "101310326", "110047998", "110090807", "110302968", "102059476", "105864975", "110123666", "111173107", "103740120", "110070990", "109825455", "103361114", "102224736"};
//        for (String str : strName) {
//
//            System.out.println(UserInfo.getUserCardNum(str, "", "", "", "", "", strCookies));
////
//        }
//
//        System.out.println(UserInfo.getUserCardNum("101310486", strCookies));

        File file = new File("/Users/zhangyibin/Downloads/一年内购买用户卡号.txt");
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String strTxt = "";
        while ((strTxt = bufferedReader.readLine()) != null) {
            System.out.println(UserInfo.getUserCardNum(strTxt, strCookies));

        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();


    }
}


