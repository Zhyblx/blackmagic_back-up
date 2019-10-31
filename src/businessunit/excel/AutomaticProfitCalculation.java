package businessunit.excel;

import businessunit.blackmagicproject.DowOederFile;
import toolbox.TimeStamp;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;
import java.io.File;

/**
 * 类：AutomaticProfitCalculation
 * 作用：利润计算自动化
 */

public class AutomaticProfitCalculation {

    public AutomaticProfitCalculation(String startDate, String endDate, String strCookie) {
        this.startDateName = startDate;
        this.endDateName = endDate;
        this.setStartDate(startDate);
        this.setEndDate(endDate);
        this.setStrCookie(strCookie);

    }

    private String startDate = "";
    private String startDateName = "";

    private void setStartDate(String startDate) {
        this.startDate = startDate + " 00:00:00";

    }

    private String getStartDate() {
        return this.startDate;

    }

    private String endDate = "";
    private String endDateName = "";

    private void setEndDate(String endDate) {
        this.endDate = endDate + " 00:00:00";

    }

    private String getEndDate() {
        return this.endDate;

    }

    private String strCookie = "";

    private void setStrCookie(String strCookie) {
        this.strCookie = strCookie;

    }

    private String getStrCookie() {
        return this.strCookie;

    }

    private final String Path = "/Users/zhangyibin/Downloads/";
    private File file=null;
    private boolean isFileExists=false;

    private String getExcelName() {
        return startDateName + "至" + endDateName + "的订单.xlsx";// 文件名格式：2019-08-16至2019-08-16的订单.xlsx

    }

    /*
     * 线程：thread
     * 作用：下载订单数据
     *
     */

    private Thread thread = new Thread() {
        @Override
        public void run() {
            System.out.println("线程(Thread)名称:"+Thread.currentThread().getName());
            try {
                String startTime = TimeStamp.dateToStamp(getStartDate());
                String endTime = TimeStamp.dateToStamp(getEndDate());
                System.out.println(startTime);
                System.out.println(endTime);

                file=new File(Path+getExcelName());
                isFileExists=IsFileExists.setIsFileExists(file);
                if(isFileExists){
                    System.out.println("存在文件已更新！");

                }else{
                    System.out.println("新文件已下载！");

                }

//                System.out.println(IsFileExists.setIsFileExists(file));
                Thread.sleep(1000);

                String URL[] = {"http://truechoice.ultimavip.org/order/export?timeType=2&startTime=", "&endTime="};

                // 不要超过3个月的数据一起下载
                System.out.println(DowOederFile.getDowOederFile(
                        URL[0] + startTime + URL[1] + endTime,
                        getExcelName(),
                        Path,
                        getStrCookie()
                ));

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };

    /*
     * 线程：timer
     * 作用：计算电商的实际利润值
     *
     */

    private static Timer timer = new Timer();
    private static TimerTask timerTask = new TimerTask() {
        @Override
        public void run() {
            System.out.println("线程(timer)名称:"+Thread.currentThread().getName());
            try {
                boolean order = false;
                int i = 5;
                automaticProfitCalculation.thread.start();
                Thread.sleep(6000);
                while (i >= 0) {
                    Thread.sleep(1000);
                    if (i == 0) {
                        break;

                    }
                    System.out.println("sleep:" + i);
                    i--;

                }

                ProfitCalculation profitCalculation = new ProfitCalculation(automaticProfitCalculation.Path + automaticProfitCalculation.getExcelName());
                System.out.println(profitCalculation.getProfitCalculationList());
                System.out.println(profitCalculation.getSpecialGoods());

                // 排除商品ID 12810、13038 15121 的利润LIST
                List<Double> fullProfitList = new ArrayList<Double>();
                fullProfitList.addAll(profitCalculation.getProfitCalculationList());

                // 单独计算商品ID 12810、13038 的利润LIST
                List<Double> profitOfSpecialGoods = new ArrayList<Double>();
                profitOfSpecialGoods.addAll(profitCalculation.getSpecialGoods());

                System.out.println("当日支付金额汇总：" + (fullProfitList.get(0) + profitOfSpecialGoods.get(0)));
                System.out.println("当日实际成本汇总：" + (fullProfitList.get(1) + profitOfSpecialGoods.get(1)));
                System.out.println("当日实际利润汇总：" + (fullProfitList.get(2) + profitOfSpecialGoods.get(2)));

                timer.cancel();

            } catch (Exception e) {
                e.printStackTrace();

            }

        }

    };

    private static AutomaticProfitCalculation automaticProfitCalculation =
            new AutomaticProfitCalculation("2019-10-24", "2019-10-24", "930F769364BEFDE29AEC4CEE54E053D1");

    /*
     * 线程：main
     * 作用：程序入口
     *
     */
    public static void main(String[] args) throws Exception {
        System.out.println("线程(main)名称:"+Thread.currentThread().getName());
        timer.schedule(timerTask, 0);

    }
}
