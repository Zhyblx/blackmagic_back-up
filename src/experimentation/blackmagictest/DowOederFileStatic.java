package experimentation.blackmagictest;

import businessunit.blackmagicproject.DowOederFile;

/**
 * 类：DowOederFileStatic
 * 作用：下载订单的应用类
 */

public class DowOederFileStatic {

    public static void main(String[] args){
        try{

            /*
             * 时间范围：2017-06-01～2017-06-30
             * 说明：Type=1 表示创建时间
             * http://172.16.10.60:9091/order/export?timeType=1&startTime=1496246400000&endTime=1498752000000
             */

            String URL[]={"http://truechoice.ultimavip.org/order/export?timeType=2&startTime=","&endTime="};

            // 下载(1496246400000)2017-06-01 00:00:00 到 (1504108800000)2017-08-31 00:00:00 之间的订单
            // 不要超过3个月的数据一起下载
            System.out.println(DowOederFile.getDowOederFile(
                    URL[0]+"1561910400000"+URL[1]+"1565712000000",

                    "2019-07-01到2019-08-14.xlsx",

                    "/Users/zhangyibin/Downloads/" ,
                    "BEEE48AE9341F92AF97A5584DA618A94"
            ));


        }catch(Exception e){
            e.printStackTrace();
        }
    }

}
