package businessunit.blackmagicproject;


import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import repositories.BrowserEnum;

import java.util.Map;
import java.util.HashMap;

/**
 * 类：SelectgroupSeq
 * 作用：通过子订单号反查组订单号
 * <p>
 * 实现：
 * 1.填写正确的Coocie("JSESSIONID"，"手动填写")
 * 2.通过getSelectgroupSeq()方法填入"子订单号"进行反查组订单号
 * <p>
 * 特别说明：以下查询订单的代码比较凌乱，因没有时间进行优化
 */
public final class SelectgroupSeq {

    private static Connection connection = null;
    private static Document document = null;

    /*
     * 说明：查询子/组订单建议用该方法，同时该方法还可以查询到订单详情
     */
    public static String getSelectgroupSeq(String seqCard_ID, String strCookie) {

        String strSeq = ""; // 存放子订单
        String strGroupSeq = ""; //存放组订单号
        String strDocJosn = "";
        String receiveAddress = "";//用户地址

        Map<String, String> map = new HashMap<String, String>();
        SelectgroupSeq selectgroupSeq = new SelectgroupSeq();

        try {

            map.putAll(selectgroupSeq.getSupplierUid(seqCard_ID, strCookie));

            connection = Jsoup.connect("http://truechoice.ultimavip.org/order/orderDetail");
            connection.cookie("JSESSIONID", strCookie);
            connection.timeout(5000);
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.data("supplierSeq", seqCard_ID);
            connection.data("uid", map.get(seqCard_ID));
            document = connection.post();

            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");

            strSeq = jsonObject1.getString("supplierSeq");//子订单
            strGroupSeq = jsonObject1.getString("groupSeq");//组订单
            receiveAddress = jsonObject1.getString("receiveAddress");//订单地址

            map.clear();

        } catch (Exception e) {
            e.printStackTrace();
        }
        // 返回结果：组订单号+"，"+子订单号
        return strGroupSeq + "," + strSeq ;

    }

    // 说明：直接查询子/组订单的方法；效率较高，但是不可查询到订单详情
    public static String getSelectgroupSeq(String seqCard_ID, String strCookie, int timeout) {
        String strDocJosn = "";
        String strSupplierSeq = "";//子单号
        String strGroupSeq = "";// 组单号
        String strUid = "";// 用户ID

        try {

            connection = Jsoup.connect("http://172.16.10.60:9091/order/listByPage?seqSearch=" + seqCard_ID + "&userSearch=&title=&status=&pageNum=1&startTime=&endTime=");
            connection.cookie("JSESSIONID", strCookie);
            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(timeout);
            connection.ignoreContentType(true);
            document = connection.get();

            strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                strSupplierSeq = jsonObject2.getString("supplierSeq");//子订单
                strGroupSeq = jsonObject2.getString("groupSeq");

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return strSupplierSeq + "," + strGroupSeq;
    }


    // 方法getSupplierUid() 通过子订单获取到Uid(用户id)
    private Map<String, String> map = new HashMap<String, String>();

    public final Map<String, String> getSupplierUid(String seqCard_ID, String strCookie) {
        String strDocJosn = "";
        String strSupplierSeq = "";//子单号
        String strGroupSeq = "";// 组单号
        String strUid = "";// 用户ID

        try {
            map.clear();
            connection = Jsoup.connect("http://172.16.10.60:9091/order/listByPage?seqSearch=" + seqCard_ID + "&userSearch=&title=&status=&pageNum=1&startTime=&endTime=");
            connection.cookie("JSESSIONID", strCookie);
            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(5000);
            connection.ignoreContentType(true);
            document = connection.get();

            strDocJosn = document.text();

            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                strSupplierSeq = jsonObject2.getString("supplierSeq");//子订单
                strGroupSeq = jsonObject2.getString("groupSeq");
                strUid = jsonObject2.getString("uid");//用户ID
                map.put(strSupplierSeq, strUid);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return map;

    }

    /*
     * 说明：以下方法查询子/组订单必须知晓uid
     */
    @Deprecated
    public static String getSelectgroupSeq(String seqCard_ID, String uid, String strCookie) {

        String strSeq = ""; // 存放子订单
        String strGroupSeq = ""; //存放组订单号
        String strDocJosn = "";
        String receiveAddress = "";//用户地址

        try {
            connection = Jsoup.connect("http://truechoice.ultimavip.org/order/orderDetail");
            connection.cookie("JSESSIONID", strCookie);
            connection.timeout(5000);
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.header("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");
            connection.data("supplierSeq", seqCard_ID);
            connection.data("uid", uid);
            document = connection.post();

            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");

            strSeq = jsonObject1.getString("supplierSeq");//子订单
            strGroupSeq = jsonObject1.getString("groupSeq");//组订单
            receiveAddress = jsonObject1.getString("receiveAddress");//订单地址


        } catch (Exception e) {
            e.printStackTrace();
        }

        return strGroupSeq + "," + strSeq + "," + receiveAddress;

    }


    public static void main(String[] args) throws Exception {
        // 子单号
//        String[] receiveAddressList = {"OCT100818051964278",
//                "OCT100818051964178",
//                "OCT100818051964078",
//
//        };
//        System.out.println("子单号》》》组单号");
//        for (String str : receiveAddressList) {
//            System.out.println(SelectgroupSeq.getSelectgroupSeq(str, "ABC5785E531B230FF1DCD504EEC79D67"));
//        }

        System.out.println(SelectgroupSeq.getSelectgroupSeq("10082314429789010062", "D45B556A07FF1C567635194636FBB090"));
//
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C",5000));
//        System.out.println(SelectgroupSeq.getSelectgroupSeq("OCT100818051964278", "B5819EF13C042A8DA659DC278D0CAA3C", 5000));


    }

}
