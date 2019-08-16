package businessunit.blackmagicproject.ultimavip.weipaitang.timeprocessor;

import toolbox.TimeStamp;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 类：TimeProcessor
 * 作用：时间处理器，返回时间戳
 *
 */

public class TimeProcessor {

    public static String getTimeProcessor() throws Exception {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//设置日期格式
        //System.out.println(df.format(new Date()));// new Date()为获取当前系统时间
        String strDateToStamp = TimeStamp.dateToStamp(df.format(new Date()));
        //System.out.println(strDateToStamp.substring(0,10));
        return strDateToStamp.substring(0, 10);
    }

}
