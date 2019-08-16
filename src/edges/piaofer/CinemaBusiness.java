package edges.piaofer;

/**
 * 类：CinemaBusiness
 * 作用：验证趣满满电影票业务的API接口
 */

import toolbox.MD5Util;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

public class CinemaBusiness {
    private final String URL = "http://dev.imanm.com";
    private final String USERAGENT = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_13_6) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/69.0.3497.100 Safari/537.36";

    private final long channelId =0;
    private final String key = " ";

    private Connection connection = null;
    private Document document = null;
    private Elements elements = null;

    /*
     * 1.地区列表接口[返回中国大陆所有地区]
     * 说明：返回地区列表JSON数据
     */
    public String getQueryCitys() {
        String queryCitys = "";
        try {
            connection = Jsoup.connect(URL + CinemaBusinessEnum.地区列表接口.getStrEnum());
            connection.userAgent(USERAGENT);
            String strKey = "channelId" + channelId + "cityId2" + key;
            String sign = MD5Util.setMD5(strKey);
            connection.requestBody("{\"channelId\":" + channelId + ",\"cityId\":2,\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();
            queryCitys = document.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return queryCitys;

    }

    /*
     * 2.影院接口[返回当前地区影院列表;必须字段:cityId]
     * 说明：返回list集合数据；格式{JSON,CinemaId(影院ID)}
     */

    public List<String> getQueryCinemas() {
        List<String> cinemaIdList = new ArrayList<String>();

        String queryCinemas = "";
        String strCityJson = "";

        JSONObject jsonObjectStrCityJson = null;
        JSONObject jsonObjectStrCityJsonResult = null;
        JSONArray jsonObjectStrCityJsonResultArray = null;

        String strCinemasJson = "";
        JSONObject jsonObjectStrCinemasJson = null;
        JSONObject jsonObjectStrCinemasJsonResult = null;
        JSONArray jsonObjectStrCinemasJsonResultArray = null;
        JSONObject jsonObjectStrCinemasJsonCinemasID = null;

        String cinemaId = "";

        try {
            strCityJson = this.getQueryCitys();
            jsonObjectStrCityJson = JSONObject.fromObject(strCityJson);
            jsonObjectStrCityJsonResult = jsonObjectStrCityJson.getJSONObject("result");
            jsonObjectStrCityJsonResultArray = jsonObjectStrCityJsonResult.getJSONArray("cityList");
            JSONObject jsonObject2 = JSONObject.fromObject(jsonObjectStrCityJsonResultArray.getJSONObject(82));// 【82】代表北京
            long cityId = Integer.valueOf(jsonObject2.get("cityId").toString());
            String strKey = "channelId" + channelId + "cityId" + cityId + key;
            String sign = MD5Util.setMD5(strKey);

            connection = Jsoup.connect(URL + CinemaBusinessEnum.影院接口.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"cityId\":" + cityId + ",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();
            queryCinemas = document.text();
            cinemaIdList.add(queryCinemas);// Json数据加入List

            strCinemasJson = queryCinemas;
            jsonObjectStrCinemasJson = JSONObject.fromObject(strCinemasJson);
            jsonObjectStrCinemasJsonResult = jsonObjectStrCinemasJson.getJSONObject("result");
            jsonObjectStrCinemasJsonResultArray = jsonObjectStrCinemasJsonResult.getJSONArray("cinemasList");
            jsonObjectStrCinemasJsonCinemasID = JSONObject.fromObject(jsonObjectStrCinemasJsonResultArray.getJSONObject(0));
            cinemaId = jsonObjectStrCinemasJsonCinemasID.get("cinemaId").toString();

            cinemaIdList.add(cinemaId);// 影院ID加入List

        } catch (Exception e) {
            e.printStackTrace();

        }
        return cinemaIdList;

    }

    /*
     * 3.影片列表[返回影片列表;必须字段:cinemaId]
     * 说明：返回list集合数据；格式{JSON,CinemaId(影院ID),filmId(影片id)}
     *
     */

    public List<String> getQueryFilms(String CinemaId) {
        List<String> FlmsIdList = new ArrayList<String>();
        String queryFilms = "";
        String strFilmsJson = "";

        JSONObject jsonObjectStrFilmsJson = null;
        JSONObject jsonObjectStrFilmsJsonResult = null;
        JSONArray jsonObjectStrFilmsJsonResultArray = null;
        JSONObject jsonObjectStrCinemasJsonFilmsID = null;

        String filmId = "";

        try {
            long cinemaId = Integer.valueOf(CinemaId);
            String strKey = "channelId" + channelId + "cinemaId" + cinemaId + key;
            String sign = MD5Util.setMD5(strKey);
            connection = Jsoup.connect(URL + CinemaBusinessEnum.影片列表.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"cinemaId\":" + cinemaId + ",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();
            queryFilms = document.text();

            FlmsIdList.add(queryFilms);// Json数据加入List
            FlmsIdList.add(String.valueOf(cinemaId));// 影院ID加入List

            strFilmsJson = queryFilms;
            jsonObjectStrFilmsJson = JSONObject.fromObject(strFilmsJson);
            jsonObjectStrFilmsJsonResult = jsonObjectStrFilmsJson.getJSONObject("result");
            jsonObjectStrFilmsJsonResultArray = jsonObjectStrFilmsJsonResult.getJSONArray("filmList");
            jsonObjectStrCinemasJsonFilmsID = JSONObject.fromObject(jsonObjectStrFilmsJsonResultArray.getJSONObject(0));
            filmId = jsonObjectStrCinemasJsonFilmsID.get("filmId").toString();

            FlmsIdList.add(filmId);//影片ID加入List

        } catch (Exception e) {
            e.printStackTrace();
        }
        return FlmsIdList;
    }

    /*
     * 4.影院场次接口[返回场次列表;必须字段:cinemaId\filmId]
     * 说明：返回list集合数据；格式{JSON,showId(场次号),CinemaId(影院ID),filmId(影片id)}
     *
     */
    public List<String> getQueryShows(String CinemaId , String FilmId) {
        List<String> ShowsIdList = new ArrayList<String>();
        String queryShows = "";

        String strShowsJson = "";
        JSONObject jsonObjectStrShowsJson = null;
        JSONObject jsonObjectStrShowsJsonResult = null;
        JSONArray jsonObjectStrShowsJsonResultArray = null;
        JSONObject jsonObjectStrShowsJsonShowsID = null;
        String showId = "";

        try {
            long cinemaId = Integer.valueOf(CinemaId);
            long filmId = Integer.valueOf(FilmId);

            String strKey = "channelId" + channelId + "cinemaId" + cinemaId + "filmId" + filmId + key;
            String sign = MD5Util.setMD5(strKey);

            Connection connection = Jsoup.connect(URL + CinemaBusinessEnum.影院场次接口.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"cinemaId\":" + cinemaId + ",\"filmId\":" + filmId + ",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");

            Document document = connection.post();
            Elements elements = document.select("body");
            String str = elements.text();
            int intStr = str.indexOf("{\"code\":0");
            queryShows = str.substring(intStr , str.length());

            ShowsIdList.add(queryShows);// Json数据加入List

            strShowsJson = queryShows;
            jsonObjectStrShowsJson = JSONObject.fromObject(strShowsJson);
            jsonObjectStrShowsJsonResult = jsonObjectStrShowsJson.getJSONObject("result");
            jsonObjectStrShowsJsonResultArray = jsonObjectStrShowsJsonResult.getJSONArray("showList");
            jsonObjectStrShowsJsonShowsID = JSONObject.fromObject(jsonObjectStrShowsJsonResultArray.getJSONObject(0));
            showId = jsonObjectStrShowsJsonShowsID.get("showId").toString();

            ShowsIdList.add(showId);// 场次号加入List
            ShowsIdList.add(String.valueOf(cinemaId));// 影院ID加入List
            ShowsIdList.add(String.valueOf(filmId));//影片ID加入List

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ShowsIdList;

    }

    /*
     * 5.场次座位图接口[返回座位图列表;必须字段:showId]
     * 说明：返回list集合数据；格式{JSON,seatId(座位id),showId(场次号)}
     */

    public List<String> getQueryShowSeat(String showId) {
        List<String> ShowSeatList = new ArrayList<String>();

        String strShowSeatJson = "";
        JSONObject jsonObjectStrShowSeatJson = null;
        JSONObject jsonObjectStrShowSeatJsonResult = null;
        JSONArray jsonObjectStrShowSeatJsonResultArray = null;
        JSONObject jsonObjectStrShowSeatJsonShowSeat = null;
        String seatId = "";

        String queryShowSeat = "";

        try {
            String strKey = "channelId" + channelId + "showId" + showId + key;
            String sign = MD5Util.setMD5(strKey);

            connection = Jsoup.connect(URL + CinemaBusinessEnum.场次座位图接口.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"showId\":\"" + showId + "\",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();
            String strDoc = document.text();
            int intStrDoc = strDoc.indexOf("A PHP");
            queryShowSeat = strDoc.substring(0 , intStrDoc);

            ShowSeatList.add(queryShowSeat);// Json数据加入List

            strShowSeatJson = queryShowSeat;
            jsonObjectStrShowSeatJson = JSONObject.fromObject(strShowSeatJson);
            jsonObjectStrShowSeatJsonResult = jsonObjectStrShowSeatJson.getJSONObject("result");
            jsonObjectStrShowSeatJsonResultArray = jsonObjectStrShowSeatJsonResult.getJSONArray("seats");
            jsonObjectStrShowSeatJsonShowSeat = JSONObject.fromObject(jsonObjectStrShowSeatJsonResultArray.getJSONObject(0));
            seatId = jsonObjectStrShowSeatJsonShowSeat.get("seatId").toString();

            ShowSeatList.add(seatId);// 座位id加入List
            ShowSeatList.add(showId);// 场次号加入List

        } catch (Exception e) {
            e.printStackTrace();

        }
        return ShowSeatList;

    }

    /*
     * 6.锁座接口[下单进行锁座;必须字段:seatId/phone]
     * 说明：返回list集合数据；格式{JSON,orderId(订单ID),total(订单金额),seatId(座位id)}
     *
     */
    public List<String> getSubmitOrder(String seatId) {
        List<String> SubmitOrderList = new ArrayList<String>();

        String strSubmitOrderJson = "";
        JSONObject jsonObjectSubmitOrderJson = null;
        JSONObject jsonObjectSubmitOrderJsonResult = null;

        String orderId = "";
        String price = "";

        try {
            String strKey = "channelId" + channelId + "phone" + "13067760265" + "seatId" + seatId + key;
            String sign = MD5Util.setMD5(strKey);

            connection = Jsoup.connect(URL + CinemaBusinessEnum.锁座接口.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"phone\":\"" + "13067760265" + "\",\"seatId\":\"" + seatId + "\",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();
            elements = document.select("body");

            String str = elements.text();
            int intStr = str.indexOf("{\"code\":0");
            String submitOrder = str.substring(intStr , str.length());

            SubmitOrderList.add(submitOrder);// Json数据加入List

            strSubmitOrderJson = submitOrder;
            jsonObjectSubmitOrderJson = JSONObject.fromObject(strSubmitOrderJson);
            jsonObjectSubmitOrderJsonResult = jsonObjectSubmitOrderJson.getJSONObject("result");
            orderId = jsonObjectSubmitOrderJsonResult.get("orderid").toString();
            price = jsonObjectSubmitOrderJsonResult.get("price").toString();

            SubmitOrderList.add(orderId);// 订单ID加入List
            SubmitOrderList.add(price);// 订单金额加入List
            SubmitOrderList.add(seatId);//座位id加入List


        } catch (Exception e) {
            e.printStackTrace();

        }
        return SubmitOrderList;
    }

    /*
     * 7.扣款接口[对订单进行支付同时扣除已经支付的保证金接口;必须字段:channelId/orderId/total/payStatus]
     * 说明：返回JSON数据；
     */

    public String getConfirmOrder(String orderId , String price) {
        String confirmOrder = "";

        try {
            int[] payStatus = new int[]{0 , 1};//1代表支付成功0代表取消订单

            String strKey = "channelId" + channelId + "orderId" + orderId + "payStatus" + payStatus[1] + "total" + price + key;
            String sign = MD5Util.setMD5(strKey);

            connection = Jsoup.connect(URL + CinemaBusinessEnum.扣款接口.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"orderId\":\"" + orderId + "\",\"payStatus\":\"" + 1 + "\",\"total\":\"" + price + "\",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();
            elements = document.select("body");

            confirmOrder = elements.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return confirmOrder;

    }

    /*
     * 8.订单详情查询[查询订单详情，票详情接口;必须字段:channelId/orderId]
     * 说明：返回JSON数据；
     */
    public String getQueryOrder(String strOrderId) {
        String queryOrder = "";

        try {
            String strKey = "channelId" + channelId + "orderId" + strOrderId + key;
            String sign = MD5Util.setMD5(strKey);
            Connection connection = Jsoup.connect(URL + CinemaBusinessEnum.订单详情查询.getStrEnum());
            connection.userAgent(USERAGENT);
            connection.requestBody("{\"channelId\":" + channelId + ",\"orderId\":\"" + strOrderId + "\",\"sign\":\"" + sign + "\"}");
            connection.timeout(10000);
            connection.ignoreContentType(true);
            connection.header("Content-Type" , "application/json;charset=UTF-8");
            document = connection.post();

            queryOrder = document.text();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return queryOrder;

    }

}



