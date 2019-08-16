package businessunit.blackmagicproject.search;

/**
 * 类：Take
 * 作用：采集关键词
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import toolbox.TextFilter;

public class TakeQuery {

    public final String URL = "http://172.16.30.68:9005/search/showLexicons?";

    public final void setTakeQuery(Integer page, Integer limit, String word, String operationEn, String dateRange, String cookie) {
        Document document = null;
        Connection connection = null;
        try {
            String requestURL = URL + "page=" + page + "&limit=" + limit + "&word=" + word + "&operationEn=" + operationEn + "&dateRange=" + dateRange;

            connection = Jsoup.connect(requestURL);
            connection.ignoreContentType(true);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
            connection.timeout(30000);
            connection.cookie("JSESSIONID", cookie);

            document = connection.get();
            //System.out.println(document.text());
            String strDoc = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDoc);
            JSONArray jsonArray = jsonObject.getJSONArray("data");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);

                String strId = jsonObject2.getString("id");
                String strOperationCn = jsonObject2.getString("operationCn");
                String strOperationEn = jsonObject2.getString("operationEn");
                String strWord = jsonObject2.getString("word");
                String strCreateTime1 = jsonObject2.getString("createTime");
                String strCreateTime2 = jsonObject2.getString("createTime").substring(0, 10);

                String strPrintLn = strId + "," + strOperationCn + "," + strOperationEn + "," + strWord + "," + strCreateTime1 + "," + strCreateTime2 + "\r\n";
                //System.out.println(strId + "," + strOperationCn + "," + strOperationEn + "," + strWord + "," + strCreateTime1 + "," + strCreateTime2);
                boolean token=TextFilter.textFilter(strPrintLn);
                if(token==false){
                    System.out.print(strPrintLn);
                }


            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        try {
            TakeQuery takeQuery = new TakeQuery();

            // 根据时间跑出关键词
            for (int i = 1; i <= 200; i++) {
                takeQuery.setTakeQuery(i, 10, "", "", "2019-06-11 - 2019-06-18", InterfaceCookie.Cookie);

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
