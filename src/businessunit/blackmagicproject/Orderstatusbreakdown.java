package businessunit.blackmagicproject;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.Connection;
import repositories.BrowserEnum;

import java.io.*;

/**
 * 类：Orderstatusbreakdown
 * 作用：可以支持查询订单明细
 * <p>
 * * 状态说明：
 * *  1：待付款
 * *  2：付款成功
 * *  3：付款失败
 * *  4：退款中
 * *  5：退款成功
 * *  6：退款失败
 * *  9：已取消
 * *  10：超时
 * *  12：审核中
 * *  13：审核失败
 */

public class Orderstatusbreakdown {

    private static final String[] URL =
            {"http://truechoice.ultimavip.org/order/listByPage?seqSearch=&userSearch=&title=&dateRange%5B%5D=&dateRange%5B%5D=&status=",
                    "&pageNum=",
                    "&startTime=&endTime="};

    public static String getOrderstatusbreakdown(String status, String pageNum, String Cookie) {
        try {
            //System.out.println(URL[0]+status+URL[1]+pageNum+URL[2]);
            Connection connection = Jsoup.connect(URL[0] + status + URL[1] + pageNum + URL[2]);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");
            connection.ignoreContentType(true);
            connection.timeout(100000);
            connection.cookie("JSESSIONID", Cookie);
            Document document = connection.get();
            String docHtml = document.text();
            JSONObject jsonObject = JSONObject.fromObject(docHtml);
            //supplierSeq  uid
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                //System.out.println(jsonObject2.get("supplierSeq") + "," + jsonObject2.get("uid"));

                String suppSeq = String.valueOf(jsonObject2.get("supplierSeq"));
                String struid = String.valueOf(jsonObject2.get("uid"));
                System.out.print(pageNum + "," + status + ",");
                getOrderDetail(suppSeq, struid, Cookie);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return null;

    }


    public static String getOrderDetail(String supplierSeq, String uid, String Cookie) {
        final String URL = "http://truechoice.ultimavip.org/order/orderDetail";
        try {
            File file = new File("/Users/zhangyibin/Downloads/1.txt");
            OutputStream outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            Connection connection = Jsoup.connect(URL);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.75 Safari/537.36");
            connection.ignoreContentType(true);
            connection.timeout(100000);

            connection.data("supplierSeq", supplierSeq);
            connection.data("uid", uid);
            connection.cookie("JSESSIONID", Cookie);

            Document document = connection.post();

            String docHtml = document.text();
            JSONObject jsonObject = JSONObject.fromObject(docHtml);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");

            String outsupplierSeq = String.valueOf(jsonObject1.get("supplierSeq"));
            String outprice = String.valueOf(jsonObject1.get("price"));

            System.out.println(outsupplierSeq + "," + outprice);
            bufferedWriter.write(outsupplierSeq + "," + outprice + "\r\n");
            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();


        } catch (Exception e) {
            e.printStackTrace();

        }

        return null;
    }


    private static File file = null;
    private static OutputStream outputStream = null;
    private static FileOutputStream fileOutputStream = null;
    private static OutputStreamWriter outputStreamWriter = null;
    private static BufferedWriter bufferedWriter = null;

    private static void setInfo(String strInfo) {
        try {
            file = new File("/Users/zhangyibin/Downloads/info.txt");
            outputStream = new FileOutputStream(file, true);
            outputStreamWriter = new OutputStreamWriter(outputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(strInfo + "\r\n");

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    // 重载方法：getOrderDetail(String pageNum, String Cookie)
    public static String getOrderDetail(String pageNum, String Cookie) {
        try {
            Connection connection = Jsoup.connect(
                    "http://truechoice.ultimavip.org/order/listByPage?seqSearch=&userSearch=&title=&dateRange%5B0%5D=Fri%20Mar%2001%202019%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&dateRange%5B1%5D=Thu%20May%2002%202019%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&status=2&pageNum="
                            + pageNum
                            + "&startTime=1551369600000&endTime=1556726400000"

            );

            connection.header("Content-Type", "application/json;charset=UTF-8");
            connection.header("Transfer-Encoding", "chunked");
            connection.header("Accept", "*/*");
            connection.header("Accept-Encoding", "gzip, deflate");
            connection.header("Accept-Language", "zh-CN,zh;q=0.9");
            connection.header("Connection", "keep-alive");

            connection.cookie("JSESSIONID", Cookie);
            connection.ignoreContentType(true);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.timeout(10000);

            Document document = connection.get();
//            System.out.println(document.text());
            String info = document.text();
            String supplierSeq = "";
            String groupSeq = "";
            String uid = "";
            String cardNum = "";
            String title = "";
            String status = "";


            JSONObject jsonObject = JSONObject.fromObject(info);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
                title = jsonObject2.getString("title");//商品名称
                if (title.indexOf("轻古集市") != -1) {
                    supplierSeq = jsonObject2.getString("supplierSeq");//供应商单号
                    groupSeq = jsonObject2.getString("groupSeq");//组单号
                    uid = jsonObject2.getString("uid");//用户ID
                    cardNum = jsonObject2.getString("cardNum");//卡号
                    status = jsonObject2.getString("status");//订单状态


//                    System.out.println(
//                            supplierSeq + "|" +
//                                    groupSeq + "|" +
//                                    uid + "|" +
//                                    cardNum + "|" +
//                                    title + "|" +
//                                    status
//
//                    );

                    Orderstatusbreakdown.setInfo(
                            supplierSeq + "|" +
                                    groupSeq + "|" +
                                    uid + "|" +
                                    cardNum + "|" +
                                    title + "|" +
                                    status
                    );
                }
            }

        } catch (Exception e) {
            System.err.println("错误页码：" + pageNum);

        }

        return null;

    }


    public static void main(String[] args) throws Exception {

        // 2019-03-01 ~ 2019-04-30
        for (int i = 1; i <= 1577; i++) {
            Orderstatusbreakdown.getOrderDetail(String.valueOf(i), "D5DE6D2A3818F886771BF65D22B33FDD");

        }

    }
}
