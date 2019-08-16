package toolbox;

import java.util.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

/**
 * 类：TimeStamp
 * 作用：时间戳转换工具
 */

public class TimeStamp {

    /*
     * 将时间转换为时间戳
     */
    public static String dateToStamp(String strDate) throws ParseException {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Date date = simpleDateFormat.parse(strDate);
        long ts = date.getTime();
        res = String.valueOf(ts);
        return res;
    }

    /*
     * 将时间戳转换为时间
     */
    public static String stampToDate(String strTimeStamp) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        long lt = Long.valueOf(strTimeStamp);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }


    public static void main(String[] args) throws Exception {
        System.out.println(TimeStamp.dateToStamp("2018-06-01 00:00:00"));
        System.out.println(TimeStamp.stampToDate("1527782400000"));

    }


}
