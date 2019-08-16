package edges.temporaryjob;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

/**
 * 类： TakeConsumptionBill
 * 作用：给盒子取数据的临时代码
 *
 */

public class TakeConsumptionBill implements Runnable {

    @Override
    public void run() {
        try {
            for (int j = 1; j <= 18; j++) {
                Connection connection = Jsoup.connect("http://172.16.10.60:9095/bOrderBill/listByPage?groupSeq=&pageNum=" + j + "&billType=2&appId=1&supplierId=31&dateRange%5B0%5D=Tue%20Jan%2001%202019%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&dateRange%5B1%5D=Thu%20Jan%2031%202019%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&startTime=Tue%20Jan%2001%202019%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)&endTime=Thu%20Jan%2031%202019%2000%3A00%3A00%20GMT%2B0800%20(%E4%B8%AD%E5%9B%BD%E6%A0%87%E5%87%86%E6%97%B6%E9%97%B4)");
                connection.ignoreContentType(true);
                connection.timeout(5000);
                connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.119 Safari/537.36");
                Document document = connection.get();
//            System.out.println(document.text());

                String strTxt = document.text();
                JSONObject jsonObject = JSONObject.fromObject(strTxt);
                JSONObject jsonObject1 = jsonObject.getJSONObject("data");
                JSONArray jsonArray = jsonObject1.getJSONArray("list");
                for (int i = 0; i < jsonArray.size(); i++) {
                    JSONObject jsonObject2 = jsonArray.getJSONObject(i);

//                System.out.println(jsonObject2.getString("childOrderNo"));
//                System.out.println(jsonObject2.getString("settleWay"));
//                System.out.println(jsonObject2.getString("settleAmount"));
                    String childOrderNo = jsonObject2.getString("childOrderNo");//订单号
                    String settleWay = jsonObject2.getString("settleWay");//结算单号
                    String settleAmount = jsonObject2.getString("settleAmount");//结算金额
                    System.out.println("订单号:" + childOrderNo + ";" + "结算单号:" + settleWay + ";" + "结算金额:" + settleAmount);

                }
            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new TakeConsumptionBill()).start();

    }
}
