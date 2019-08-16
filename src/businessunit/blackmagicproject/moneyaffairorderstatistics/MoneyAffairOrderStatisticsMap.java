package businessunit.blackmagicproject.moneyaffairorderstatistics;

import java.util.HashMap;
import java.util.Map;

/**
 * 类：MoneyAffairOrderStatisticsMap
 * 作用：map存储业务类型
 */

public class MoneyAffairOrderStatisticsMap {
    private static Map<String ,String> map=new HashMap<String, String>();
    private static String value="";

    public static String getMoneyAffairOrderStatisticsMapPing(String Key){
        map.put("1","卡销");
        map.put("2","电商");
        map.put("3","火车票");
        map.put("4","飞机票");
        map.put("5","酒店");
        map.put("6","服务");
        map.put("7","电影票");
        map.put("8","朋友圈");
        map.put("9","咖啡");
        map.put("10","卡面销售");
        map.put("11","门票");
        map.put("12","管家打赏");
        map.put("16","充值中心");
        map.put("21","会籍");
        map.put("22","定制旅行");
        map.put("25","专车");
        map.put("27","虚拟平台");

        value=map.get(Key);
        return value;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(
                MoneyAffairOrderStatisticsMap.getMoneyAffairOrderStatisticsMapPing("9"));

    }

}
