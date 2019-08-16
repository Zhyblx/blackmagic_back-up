package businessunit.blackmagicproject;


/**
 * 类：ClassificationCorrespondence
 * 作用：映射环球黑卡的分类对应关系
 *
 */

import java.util.Map;
import java.util.HashMap;

public class ClassificationCorrespondence {

    private static Map<Integer ,String> map=new HashMap<Integer, String>();
    private static String value="";
    public static String getClassificationMapPing(int Key){
        map.put(60,"美食/饼干");
        map.put(61,"美食/糕点");
        map.put(62,"美食/巧克力");
        map.put(63,"美食/天然养生");
        map.put(64,"美食/干果");
        map.put(65,"美食/零食");
        map.put(103,"美食/糖果");
        map.put(128,"美食/精选美食");
        map.put(112,"严选/居家");
        map.put(113,"严选/穿搭");
        map.put(114,"严选/个护");
        map.put(115,"严选/数码");
        map.put(116,"严选/箱包");
        map.put(117,"严选/其他");
        map.put(122,"博库/文学");
        map.put(123,"博库/教育");
        map.put(124,"博库/小说");
        map.put(132,"京东自营/手机数码");
        map.put(133,"京东自营/箱包手袋");
        map.put(134,"京东自营/钟表珠宝");
        map.put(135,"京东自营/运动户外");
        map.put(136,"京东自营/汽车用品");
        map.put(137,"京东自营/电脑办公");
        map.put(142,"京东自营/家具家装");
        map.put(146,"京东自营/养生保健");
        map.put(34,"居家/床品");
        map.put(35,"居家/水杯");
        map.put(36,"居家/雨伞");
        map.put(37,"居家/灯具");
        map.put(38,"居家/收纳");
        map.put(39,"居家/小家电");
        map.put(40,"居家/餐厨");
        map.put(41,"居家/清洁");
        map.put(42,"居家/香薰");
        map.put(43,"居家/其他");
        map.put(91,"居家/毛巾");
        map.put(98,"居家/化妆镜");
        map.put(99,"居家/口罩");
        map.put(100,"居家/装饰");
        map.put(104,"居家/汽车用品");
        map.put(129,"居家/居家1");
        map.put(73,"数码/移动电源");
        map.put(74,"数码/耳机");
        map.put(75,"数码/蓝牙音响");
        map.put(76,"数码/手机配件");
        map.put(87,"数码/其他");
        map.put(102,"数码/摄影");
        map.put(44,"文创/笔记本");
        map.put(45,"文创/笔");
        map.put(84,"文创/其他");
        map.put(105,"文创/办公");
        map.put(53,"玩物/电子烟");
        map.put(54,"玩物/打火机");
        map.put(55,"玩物/模型/玩具");
        map.put(86,"玩物/其他");
        map.put(77,"酒饮/葡萄酒");
        map.put(78,"酒饮/起泡酒");
        map.put(79,"酒饮/果酒");
        map.put(80,"酒饮/洋酒");
        map.put(81,"酒饮/咖啡");
        map.put(82,"酒饮/茶");
        map.put(83,"酒饮/饮料");
        map.put(88,"酒饮/其他");
        map.put(56,"箱包/行李箱");
        map.put(57,"箱包/钱包");
        map.put(58,"箱包/小皮具");
        map.put(59,"箱包/背包");
        map.put(90,"定制/限量定制");
        map.put(66,"穿搭/鞋袜");
        map.put(67,"穿搭/饰品");
        map.put(68,"穿搭/手表");
        map.put(69,"穿搭/服饰");
        map.put(70,"穿搭/围巾/帽子/手套");
        map.put(89,"穿搭/其他");
        map.put(131,"穿搭/穿搭1");
        map.put(71,"运动/运动装备");
        map.put(72,"运动/塑型/健身");
        map.put(46,"个护/护肤");
        map.put(47,"个护/护发");
        map.put(48,"个护/美妆");
        map.put(49,"个护/香水");
        map.put(50,"个护/牙膏");
        map.put(51,"个护/美容仪");
        map.put(52,"个护/情趣");
        map.put(85,"个护/其他");
        map.put(94,"个护/剃须刀");
        map.put(101,"个护/护眼");
        map.put(130,"个护/个护1");
        map.put(138,"京东超市/休闲零食");
        map.put(139,"京东超市/粮油调味");
        map.put(140,"京东超市/水饮冲调");
        map.put(141,"京东超市/纸品湿巾");
        map.put(143,"京东超市/美妆个护");
        map.put(147,"网易考拉/美妆个护");
        map.put(148,"网易考拉/母婴");
        map.put(149,"网易考拉/轻奢");
        map.put(150,"网易考拉/营养保健");
        map.put(151,"网易考拉/家居家电");
        map.put(152,"网易考拉/户外");
        map.put(153,"网易考拉/考拉工厂店");
        map.put(154,"网易考拉/环球美食");
        map.put(95,"特权/特权2级类目");
        map.put(92,"新年送礼/送客户");
        map.put(93,"新年送礼/送长辈");
        map.put(96,"新年送礼/送领导");
        map.put(97,"新年送礼/送朋友");
        map.put(107,"课程/思维");
        map.put(118,"课程/理财");
        map.put(119,"课程/大咖");
        map.put(120,"课程/沟通");
        map.put(121,"课程/女性");
        map.put(127,"课程/职场");
        map.put(109,"新人专享活动/新人专享");
        map.put(111,"限时购商品/限时购");
        map.put(145,"签单/签单不可用");
        map.put(157,"爆品专区/人气榜单");
        map.put(159,"白城/欧包");
        map.put(160,"白城/软欧包");
        map.put(6,"旅行");
        map.put(23,"礼物");
        map.put(25,"寺库");
        map.put(27,"服");
        map.put(29,"5");
        map.put(30,"活动秒杀");
        map.put(31,"周年折扣");
        map.put(32,"新人专享");
        map.put(156,"人气榜单");

        value=map.get(Key);
        return value;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(
        ClassificationCorrespondence.getClassificationMapPing(50));

    }

}
