package edges.piaofer;

public enum CinemaBusinessEnum {
    地区列表接口("/manman/index.php/open/partner/queryCitys"),
    影院接口("/manman/index.php/open/partner/queryCinemas"),
    影片列表("/manman/index.php/open/partner/queryFilms"),
    影院场次接口("/manman/index.php/open/partner/queryShows"),
    场次座位图接口("/manman/index.php/open/partner/queryShowSeats"),
    锁座接口("/manman/index.php/open/partner/submitOrder"),
    扣款接口("/manman/index.php/open/partner/confirmOrder"),
    订单详情查询("/manman/index.php/open/partner/queryOrder");

    private String strEnum="";

    private CinemaBusinessEnum(String strEnum){
        this.strEnum=strEnum;

    }

    public String getStrEnum(){
        return this.strEnum;

    }

}
