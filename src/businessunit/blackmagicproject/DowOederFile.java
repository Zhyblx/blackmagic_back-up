package businessunit.blackmagicproject;

import repositories.BrowserEnum;
import toolbox.TimeStamp;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * 类：DowOederFile
 * 作用：下载业务订单
 */
public final class DowOederFile {

    /**
     * 从网络Url中下载文件
     *
     * @param urlStr:访问链接
     * @param fileName:下载的文件命名
     * @param savePath:文件下载路径
     * @param setCookie:设置Cookie值
     */
    public static String getDowOederFile(String urlStr, String fileName, String savePath, String setCookie) {
        String strCode = "";
        try {
            URL url = new URL(urlStr);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置链接超时,时间为1分钟;
            conn.setConnectTimeout(60000);
            //设置读取超时，时间为1分钟
            conn.setReadTimeout(60000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", BrowserEnum.userAgent.getStrBrowserEnum());
            //设置Cookie
            conn.setRequestProperty("Cookie", "JSESSIONID=" + setCookie);
            //提交请求模式
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            //输出访问状态码
            //System.out.println(conn.getResponseCode());
            //System.out.println("访问状态：" + conn.getResponseCode() + "；地址URL:" + url + "；下载成功");
            strCode = "下载成功;访问状态：" + conn.getResponseCode() + "；地址URL:" + url;
        } catch (Exception e) {
            strCode = "下载失败！";
        }

        return strCode;
    }

    /**
     * 从网络Url中下载文件
     *
     * @param startTime:订单查询开始时间
     * @param endTimer:订单查询结束时间
     * @param fileName:下载的文件命名
     * @param savePath:文件下载路径
     * @param setCookie:设置Cookie值
     */

    public static String getDowOederFile(String startTime, String endTimer, String fileName, String savePath, String setCookie) {
        String strCode = "";
        try {
            // timeType=2 代表支付时间
            URL url = new URL("http://172.16.10.60:9091/order/export?timeType=2&startTime=" + startTime + "&endTime=" + endTimer);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置链接超时,时间为1分钟;
            conn.setConnectTimeout(60000);
            //设置读取超时，时间为1分钟
            conn.setReadTimeout(60000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", BrowserEnum.userAgent.getStrBrowserEnum());
            //设置Cookie
            conn.setRequestProperty("Cookie", "JSESSIONID=" + setCookie);
            //提交请求模式
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            //输出访问状态码
            //System.out.println(conn.getResponseCode());
            //System.out.println("访问状态：" + conn.getResponseCode() + "；地址URL:" + url + "；下载成功");
            strCode = "下载成功;访问状态：" + conn.getResponseCode() + "；地址URL:" + url;
        } catch (Exception e) {
            strCode = "下载失败！";
        }

        return strCode;

    }


    /**
     * 从订单中心下载数据
     */
    @Deprecated
    public static String getDowOrderCenter(String startTime, String endTimer, String state, String fileName, String savePath) {
        String strCode = "";
        String[] parameter = new String[]{"{\"startTime\":\"", "\",\"endTime\":\"", "\",\"businessType\":\"-1\",\"state\":\"", "\",\"channel\":\"-1\",\"isMerge\":\"false\"}"};


        try {
            URL url = new URL("http://172.16.10.90:8066/order/query/exportExcel?json=" + parameter[0] + startTime + parameter[1] + endTimer + parameter[2] + state + parameter[3]);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            //设置链接超时,时间为1分钟;
            conn.setConnectTimeout(100000);
            //设置读取超时，时间为1分钟
            conn.setReadTimeout(100000);
            //防止屏蔽程序抓取而返回403错误
            conn.setRequestProperty("User-Agent", BrowserEnum.userAgent.getStrBrowserEnum());
            conn.setRequestProperty("Upgrade-Insecure-Requests", "1");
            conn.setRequestProperty("Referrer Policy", "no-referrer-when-downgrade");

            //设置Cookie
//            conn.setRequestProperty("Cookie", "JSESSIONID=" + setCookie);
            //提交请求模式
            conn.setRequestMethod("POST");
            conn.setDoOutput(true);
            conn.setDoInput(true);

            //得到输入流
            InputStream inputStream = conn.getInputStream();
            //获取自己数组
            byte[] getData = readInputStream(inputStream);

            //文件保存位置
            File saveDir = new File(savePath);
            if (!saveDir.exists()) {
                saveDir.mkdir();
            }
            File file = new File(saveDir + File.separator + fileName);
            FileOutputStream fos = new FileOutputStream(file);
            fos.write(getData);
            if (fos != null) {
                fos.close();
            }
            if (inputStream != null) {
                inputStream.close();
            }

            //输出访问状态码
            //System.out.println(conn.getResponseCode());
            //System.out.println("访问状态：" + conn.getResponseCode() + "；地址URL:" + url + "；下载成功");
            strCode = "下载成功;访问状态：" + conn.getResponseCode() + "；地址URL:" + url;
        } catch (Exception e) {
//            strCode = "下载失败！";
            e.printStackTrace();
        }

        return strCode;

    }


    /**
     * 从输入流中获取字节数组
     *
     * @param inputStream
     * @return
     * @throws IOException
     */
    private static byte[] readInputStream(InputStream inputStream) throws IOException {
        byte[] buffer = new byte[1024];
        int len = 0;
        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        while ((len = inputStream.read(buffer)) != -1) {
            bos.write(buffer, 0, len);
        }
        bos.close();
        return bos.toByteArray();
    }

    public static void main(String[] args) {
        try {
//            System.out.println(
//                    getDowOederFile("http://172.16.10.60:9091/order/export?timeType=1&startTime=1541001600000&endTime=1541779200000"
//                            , " 11.xlsx" , "/Users/zhangyibin/Downloads/" , "70A82C60ED6B831986941A79B7876C0F"));


            String startTime = TimeStamp.dateToStamp("2019-07-01 00:00:00");
            String endTime = TimeStamp.dateToStamp("2019-07-31 00:00:00");
            String strCookie = "D2516FC0DF452FCCBB914B090E5F8FC1";

            String excelName = TimeStamp.stampToDate(startTime).substring(0, 10) + "~" + TimeStamp.stampToDate(endTime).substring(0, 10)+".xlsx";

            System.out.println(
                    DowOederFile.getDowOederFile(startTime, endTime,
                            excelName, "/Users/zhangyibin/Downloads/", strCookie));

//            System.out.println(
//                    DowOederFile.getDowOrderCenter("2018-12-01","2018-12-02","20"," 11.xlsx", "/Users/zhangyibin/Downloads/")
//
//            );

        } catch (Exception e) {
            // TODO: handle exception

        }
    }

}
