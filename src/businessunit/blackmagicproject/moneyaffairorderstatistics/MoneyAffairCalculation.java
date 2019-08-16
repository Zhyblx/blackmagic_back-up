package businessunit.blackmagicproject.moneyaffairorderstatistics;

/**
 * 类：MoneyAffairCalculation
 * 作用：订单量计算
 *
 */

import java.util.Map;
import java.util.HashMap;
import java.util.Set;

public class MoneyAffairCalculation implements Runnable {

    private Map<String,String> mapOrderAmount=new HashMap<String,String>();
    private String startTime="2018-09-01";//开始时间
    private String endTime="2018-09-30";//结束时间
    /**
     * status: 1[已付款]
     * status: 2[已退款]
     *
     */
    private String status="2";
    private String strCookie="48B6B30899A9BDEA57D75F584B7D6D29";

    private Map<String,String> mapNum=new HashMap<String,String>();

    @Override
    public void run(){
        try {
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.专车.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.会籍.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.充值中心.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.卡销.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.卡面销售.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.咖啡.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.定制旅行.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.朋友圈.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.服务.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.火车票.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.电商.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.电影票.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.管家打赏.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.虚拟平台.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.酒店.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.门票.getStrAppIdEnum(),status,strCookie));
            mapOrderAmount.putAll(MoneyAffairOrderStatistics.getMoneyAffairOrderStatistics(startTime,endTime,MoneyAffairOrderStatisticsAppIdEnum.飞机票.getStrAppIdEnum(),status,strCookie));

            mapNum.putAll(mapOrderAmount);

            Set<String> set = mapNum.keySet(); //取出所有的key值

            int intOrderNum=0;// 订单量求和
            for (String key:set) {
                intOrderNum = intOrderNum + Integer.valueOf(mapNum.get(key));

            }

            for (String key:set) {
                System.out.println(
                        MoneyAffairOrderStatisticsMap.getMoneyAffairOrderStatisticsMapPing(key)
                        +","+
                        mapNum.get(key)
                        +","+
                        ((double)Integer.valueOf(mapNum.get(key)) / intOrderNum)

                );
            }


        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception{
        new Thread(new MoneyAffairCalculation()).start();
    }

}
