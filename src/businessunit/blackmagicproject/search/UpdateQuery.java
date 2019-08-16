package businessunit.blackmagicproject.search;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.Connection.Response;

/**
 * 类：UpdateQuery
 * 作用：添加搜索词
 */
public class UpdateQuery {

    private final String URL = "http://172.16.30.68:9005/search/addLexicon";
    private Connection connection = null;
    private Response response = null;

    public void setUpdateQuery(String lexicon, String operationCn, String operationEn, String cookie) {
        try {
            connection = Jsoup.connect(URL);
            connection.ignoreContentType(true);
            connection.timeout(30000);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_14_3) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/72.0.3626.109 Safari/537.36");
            connection.cookie("JSESSIONID", cookie);

            connection.data("lexicon", lexicon);
            connection.data("operationCn", operationCn);
            connection.data("operationEn", operationEn);

            connection.post();
            response = connection.execute();

            System.out.println(response.statusCode());//输出访问状态码

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*
     * operationCn: "景点", operationEn: "menpiaodata"
     * operationCn: "酒店", operationEn: "hotelbase"
     * operationCn: "好物", operationEn: "dataware_truechoice2_product"
     * operationCn: "特权号", operationEn: "dataware_blackcard_app_newprivileges"
     * operationCn: "现金贷", operationEn: "dataware_finance_cash_credit_published"
     * operationCn: "信用卡", operationEn: "dataware_finance_credit_detail"
     *
     */

    public static void main(String[] args) throws Exception {
//        new UpdateQuery().setUpdateQuery("向阳店酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);

        new UpdateQuery().setUpdateQuery("万达酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("杭州伊美大酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("骏怡精选酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("雅博酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("白玉兰酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("酒店白玉兰", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("如家酒店从化", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("新希尔顿", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("上海上南路酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("华宿蘭悦酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("漕宝路艾美酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("湖璟酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("滨河酒店承德", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("滨河酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("奥姆酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("鸽子花酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("酒店鸽子花", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("香港旅馆", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("竞电酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("艾克威竞电酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("酒店情趣房", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("爱情主提酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("天天宾馆", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("安顺酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("朱砂大酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("柏高酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("云浮市河口维也纳酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("云浮市酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("富蓝特和酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("美季酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("杭州滨江喜来登酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("晴隆酒店预订", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("康帝国际酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("北京汉庭酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("桔子酒店西津渡", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("北京维也纳酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("东莞天鹅恋酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("博华酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("鲁诺R酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("云南丽江民宿", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("高逸酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("香港四季酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("西安凯悦酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("莫泰酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("民航大酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("金辉酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("山水酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("阳光快捷酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("渭塘酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("上海喜来登酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("喜来登上海", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("华府世家酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("泉州荣誉酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("西塘酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("杭州不舍野马岭酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("西子湖宾馆", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("新北喜来登酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("新北喜来登", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("酒店宾馆", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("白旗酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("大连酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("上海外滩W酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("成都原岛酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("宝德国际酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("北京北辰五洲皇冠酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("乌鲁木齐酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("无遇酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("特权服务酒店目录", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("如家酒店白龙", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("蜂鸟酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("紫微酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("汉庭北京陶然亭店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("富力凯悦酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("酒店富力凯", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("金华世贸饭店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("嘉峪关维也纳酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("美斯奇酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("华邑酒店自助餐", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("柳青宾馆", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("临汾饭店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("大连凯伦酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("亦恒轻奢酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("清远希尔顿欢朋酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("佛山金腾大酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("万达智选假日酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("昆明永都酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("银天酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("永都酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("上海圣诺亚皇冠假日酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("成都百花溪假日酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("道真酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("成都名宿", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("贵山大酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("漳州酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("香港w酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("东石唯美酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("海悦酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("丁香树大酒店", "酒店", "hotelbase", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("鹤壁五龙山", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("凤岗龙凤山庄", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("百花山庄", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("户外登山双肩包", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("户外登山包", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("故宫沈阳故宫", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("天山海世界", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("柯桥旅游", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("旅游广州", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("佛山游泳馆", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("深圳失恋博物馆", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("天露山", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("中国铁道博物馆", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("旅游汉溪长隆", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("武夷山7D", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("舟山群岛", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("平度茶山", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("青岛方特梦幻王国", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("青岛方特梦幻", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("灵山到太原", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("常州茅山", "景点", "menpiaodata", InterfaceCookie.Cookie);
        new UpdateQuery().setUpdateQuery("苏州吴中尹山湖", "景点", "menpiaodata", InterfaceCookie.Cookie);


    }
}
