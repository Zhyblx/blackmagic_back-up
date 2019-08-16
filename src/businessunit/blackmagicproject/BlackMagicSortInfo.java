package businessunit.blackmagicproject;

/**
 * 类：BlackMagicSortInfo
 * 作用：获取环球黑卡的类目信息
 */

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import repositories.BrowserEnum;

import java.util.*;

public final class BlackMagicSortInfo {

    private final String URL_CatId1 = "http://172.16.10.60:9091/category/listByPage?name=&parentId=0&pageNum=";

    private String cookie = "";

    public BlackMagicSortInfo(String cookie) {
        this.cookie = cookie;

    }

    private Document document = null;
    private Connection connection = null;

    /*
     * 一级类目的获取方法
     */
    private Map<String, String> getCatId1(int pageNum) {
        String strDocJosn = "";
        Map<String, String> map = new LinkedHashMap();

        try {
            connection = Jsoup.connect(URL_CatId1 + pageNum);
            connection.ignoreContentType(true);
            connection.timeout(5000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            connection.cookie("JSESSIONID" , this.cookie);
            document = connection.get();

            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject2.get("id")+","+jsonObject2.get("name"));
                Object id = jsonObject2.get("id");
                Object name = jsonObject2.get("name");
                map.put(String.valueOf(id) , String.valueOf(name));
            }

//            System.out.println(map);


        } catch (Exception e) {
            e.printStackTrace();

        }
        return map;
    }

    /*
     * 二级类目的获取方法
     */

    private String getCatId2(String parentId , int pageNum) {

        String strDocJosn = "";
        String returnData = "";

        try {
            connection = Jsoup.connect("http://172.16.10.60:9091/category/listByPage?parentId=" + parentId + "&pageNum=" + pageNum);
            connection.ignoreContentType(true);
            connection.timeout(5000);
            connection.userAgent(BrowserEnum.userAgent.getStrBrowserEnum());
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            connection.cookie("JSESSIONID" , this.cookie);
            document = connection.get();

            strDocJosn = document.text();
            JSONObject jsonObject = JSONObject.fromObject(strDocJosn);
            JSONObject jsonObject1 = jsonObject.getJSONObject("data");
            JSONArray jsonArray = jsonObject1.getJSONArray("list");

            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject jsonObject2 = jsonArray.getJSONObject(i);
//                System.out.println(jsonObject2.get("id")+","+jsonObject2.get("name"));
                Object id = jsonObject2.get("id");
                Object name = jsonObject2.get("name");
                returnData = returnData + parentId + "," + id + "," + name + "\r\n";
            }

//            System.out.println(document.text());


        } catch (Exception e) {
            e.printStackTrace();

        }

        return returnData;
    }


    public static void main(String[] args) {

//        BlackMagicSortInfo blackMagicSortInfo = new BlackMagicSortInfo("4090C8B426EB54EFA83FB9831E8AC83A");
//        System.out.println(blackMagicSortInfo.getCatId1(1));
//        System.out.println(blackMagicSortInfo.getCatId2("1" , 2));

        Map<String, String> map = new LinkedHashMap<String, String>();
        List<String> list = new ArrayList<String>();
        Iterator<String> iterator = null;

        try {
            BlackMagicSortInfo blackMagicSortInfo = new BlackMagicSortInfo("46E9B497C376893DD384C0F4FB9C0BF2");
            // 循环4次代表有四页一级类目的内容
            for (int i = 1; i < 5; i++) {
                map.clear(); // 每查询完一页对map进行清空
                map.putAll(blackMagicSortInfo.getCatId1(i)); //将当前页面下的内容传如到map中
                // 输出map中的数据；包括 一级类目ID和一级类目名称
                for (Map.Entry<String, String> entry : map.entrySet()) {
                    System.out.println(entry.getKey() + ":" + entry.getValue());

                    list.add(entry.getKey());// 一级类目的ID传入List
                    iterator = list.iterator();
                    while (iterator.hasNext()) {
                        String parentId = iterator.next();
                        // 假设二级类目的页码为9页
                        for (int j = 1; j < 10; j++) {
                            String strCatId2 = blackMagicSortInfo.getCatId2(parentId , j);// 通过一级类目ID 查询到二级类目的内容
                            System.out.println(strCatId2); // 输出二级类目的内容
                            // 如果没有查询到二级类目内容，则跳出当前循环
                            if (strCatId2.length() == 0) {
                                break;

                            }
                        }
                    }
                    list.clear();// 当查询下一个一级类目是否有二级类目内容时，对当前list中的内容进行清空

                }
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
















