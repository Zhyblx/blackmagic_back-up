package edges.piaofer;

import java.util.ArrayList;
import java.util.List;

/**
 * 类：CinemaInterfaceVerification
 * 作用：电影票接口验证程序
 */
public class CinemaInterfaceVerification {

    private static CinemaBusiness cinemaBusiness = new CinemaBusiness();

    private static List<String> CinemasList = new ArrayList<String>();
    private static List<String> FilmsList = new ArrayList<String>();
    private static List<String> ShowsList = new ArrayList<String>();
    private static List<String> ShowSeatList = new ArrayList<String>();
    private static List<String> SubmitOrderList = new ArrayList<String>();


    public static void main(String[] args) {
        try {

            System.out.println("地区列表:" + cinemaBusiness.getQueryCitys());

            CinemasList.addAll(cinemaBusiness.getQueryCinemas());
            String cinemaIdCinemasList = CinemasList.get(1);
            System.out.println("影院列表:" + CinemasList.get(0));

            FilmsList.addAll(cinemaBusiness.getQueryFilms(cinemaIdCinemasList));
            String cinemaIdFilmsList = FilmsList.get(1);//(影院ID)
            String filmIdFilmsList = FilmsList.get(2);//(影片id)
            System.out.println("影片列表:" + FilmsList.get(0));


            ShowsList.addAll(cinemaBusiness.getQueryShows(cinemaIdFilmsList , filmIdFilmsList));
            String showIdShowsList = ShowsList.get(1);
            String cinemaIdShowsList = ShowsList.get(2);//(影院ID)
            String filmIdShowsList = ShowsList.get(3);//(影片id)
            System.out.println("影院场次:" + ShowsList.get(0));

            ShowSeatList.addAll(cinemaBusiness.getQueryShowSeat(showIdShowsList));
            String seatIdShowSeatList = ShowSeatList.get(1);
            String showIdShowSeatList = ShowSeatList.get(2);
            System.out.println("场次座位:" + ShowSeatList.get(0));


            SubmitOrderList.addAll(cinemaBusiness.getSubmitOrder(seatIdShowSeatList));
            String orderIdSubmitOrderList = SubmitOrderList.get(1);
            String priceSubmitOrderList = SubmitOrderList.get(2);
            String seatIdSubmitOrderList = SubmitOrderList.get(3);

            System.out.println("锁座坐位:" + SubmitOrderList.get(0));

            System.out.println("执行扣款:" + cinemaBusiness.getConfirmOrder(orderIdSubmitOrderList , priceSubmitOrderList));
            System.out.println("订单详情:" + cinemaBusiness.getQueryOrder(orderIdSubmitOrderList));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
