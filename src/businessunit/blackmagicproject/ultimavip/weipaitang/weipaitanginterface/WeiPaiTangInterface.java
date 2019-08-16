package businessunit.blackmagicproject.ultimavip.weipaitang.weipaitanginterface;

/**
 * 接口：WeiPaiTangInterface
 * 内容：微拍堂的线上地址
 * 微拍堂的H5地址：https://w.weipaitang.com/webApp/discovery
 *
 */

public interface WeiPaiTangInterface {

    // 精选推荐的商品接口
    public static final String URLrecommend_Together = "https://api.weipaitang.com/wechat/v1.0/sale/recommend-together?page=&time=";

    // 微排堂"热门"直播视频数据呈现
    public static final String URLvideo_home = "https://api.weipaitang.com/wechat/v1.0/live/get-hot-live-list?start=&page=";

    // 微排堂"分类"直播视频数据呈现
    public static final String URLvideo_classify = "https://api.weipaitang.com/wechat/v1.0/live/get-live-list?start=&page=&categoryId=1&secCategoryId=-1";

    // 浏览器身份
    public static final String UserAgent = "Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/73.0.3683.86 Safari/537.36";


}
