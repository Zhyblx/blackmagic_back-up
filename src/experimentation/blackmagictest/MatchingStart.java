package experimentation.blackmagictest;

import java.io.*;

/**
 * 类：MatchingStart
 * 作用：京东和考拉地址信息的匹配计算。
 * 分析：目前环球黑卡维护的是京东的地址库，所以只要找出考拉与京东不一样的地址信息即可
 */

public class MatchingStart {

    // 一级地址计算
//    private static String[] strKl={"云南省","西藏自治区","陕西省","辽宁省","北京市","天津市","河北省","山西省","内蒙古自治区","贵州省","甘肃省","四川省","重庆市","河南省","吉林省","黑龙江省","江苏省","山东省","安徽省","浙江省","湖北省","广东省","江西省","新疆维吾尔自治区","青海省","宁夏回族自治区","福建省","湖南省","广西壮族自治区","海南省","上海市","香港特别行政区","海外"};
//    private static String[] strJd={"北京","上海","天津","重庆","河北","山西","河南","辽宁","吉林","黑龙江","内蒙古","江苏","山东","安徽","浙江","福建","湖北","湖南","广东","广西","江西","四川","海南","贵州","云南","西藏","陕西","甘肃","青海","宁夏","新疆","港澳"};
//
//    public static void main(String[] args) {
//        try {
//
//            for(int i=0;i<strKl.length;i++){
//                String strklAddress=strKl[i];
//                System.out.println(strklAddress);
//
//                for(int j=0;j<strJd.length;j++){
//                    String strJdAddress=strJd[j];
//                    if(strklAddress.indexOf(strJdAddress)!=-1){
//                        System.out.println(strklAddress+","+strJdAddress);
//                    }
//                }
//
//
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }

    // 二级地址计算；考拉与京东不匹配的二级地址
//    private static String[] strKl={"普洱市","临沧市","楚雄彝族自治州","红河哈尼族彝族自治州","文山壮族苗族自治州","西双版纳傣族自治州","大理白族自治州","德宏傣族景颇族自治州","怒江傈僳族自治州","迪庆藏族自治州","拉萨市","昌都地区","山南地区","日喀则地区","那曲地区","阿里地区","林芝地区","西安市","铜川市","宝鸡市","咸阳市","渭南市","延安市","丹东市","锦州市","北京市","天津市","石家庄市","唐山市","秦皇岛市","邯郸市","邢台市","保定市","张家口市","承德市","沧州市","廊坊市","衡水市","太原市","大同市","阳泉市","长治市","晋城市","朔州市","晋中市","运城市","忻州市","临汾市","吕梁市","呼和浩特市","包头市","乌海市","赤峰市","通辽市","铜仁市","黔西南布依族苗族自治州","黔东南苗族侗族自治州","黔南布依族苗族自治州","昆明市","曲靖市","玉溪市","汉中市","榆林市","安康市","商洛市","兰州市","成都市","自贡市","攀枝花市","泸州市","德阳市","绵阳市","广元市","遂宁市","重庆市","郑州市","洛阳市","南阳市","沈阳市","大连市","鞍山市","葫芦岛市","长春市","大兴安岭地区","鄂尔多斯市","徐州市","淮安市","南通市","镇江市","无锡市","苏州市","济南市","潍坊市","烟台市","威海市","日照市","合肥市","淮南市","马鞍山市","安庆市","阜阳市","宿州市","宁波市","温州市","绍兴市","武汉市","深圳市","惠州市","东莞市","湛江市","潮州市","揭阳市","南昌市","宜宾市","贵阳市","嘉峪关市","阿勒泰地区","呼伦贝尔市","巴彦淖尔市","乌兰察布市","兴安盟","锡林郭勒盟","阿拉善盟","抚顺市","本溪市","内江市","乐山市","南充市","眉山市","广安市","达州市","雅安市","巴中市","资阳市","阿坝藏族羌族自治州","甘孜藏族自治州","凉山彝族自治州","六盘水市","遵义市","安顺市","毕节市","金昌市","白银市","天水市","武威市","张掖市","平凉市","酒泉市","庆阳市","定西市","陇南市","临夏回族自治州","甘南藏族自治州","西宁市","海东地区","海北藏族自治州","黄南藏族自治州","海南藏族自治州","果洛藏族自治州","玉树藏族自治州","海西蒙古族藏族自治州","银川市","石嘴山市","吴忠市","固原市","中卫市","乌鲁木齐市","克拉玛依市","吐鲁番地区","哈密地区","昌吉回族自治州","博尔塔拉蒙古自治州","巴音郭楞蒙古自治州","阿克苏地区","克孜勒苏柯尔克孜自治州","喀什地区","和田地区","伊犁哈萨克自治州","塔城地区","保山市","昭通市","丽江市","常州市","连云港市","盐城市","扬州市","泰州市","宿迁市","杭州市","嘉兴市","湖州市","金华市","衢州市","舟山市","台州市","丽水市","芜湖市","蚌埠市","淮北市","铜陵市","黄山市","滁州市","六安市","亳州市","池州市","宣城市","福州市","厦门市","莆田市","三明市","泉州市","漳州市","南平市","龙岩市","宁德市","景德镇市","萍乡市","九江市","新余市","鹰潭市","赣州市","吉安市","宜春市","抚州市","上饶市","青岛市","淄博市","枣庄市","东营市","济宁市","泰安市","莱芜市","临沂市","德州市","聊城市","滨州市","菏泽市","开封市","平顶山市","安阳市","鹤壁市","新乡市","焦作市","濮阳市","许昌市","漯河市","三门峡市","商丘市","信阳市","周口市","驻马店市","黄石市","十堰市","宜昌市","襄阳市","鄂州市","荆门市","孝感市","荆州市","黄冈市","咸宁市","随州市","恩施土家族苗族自治州","长沙市","株洲市","湘潭市","衡阳市","邵阳市","岳阳市","常德市","张家界市","益阳市","郴州市","永州市","怀化市","娄底市","湘西土家族苗族自治州","广州市","韶关市","珠海市","汕头市","佛山市","江门市","茂名市","肇庆市","梅州市","汕尾市","河源市","阳江市","清远市","云浮市","南宁市","柳州市","桂林市","梧州市","北海市","防城港市","钦州市","贵港市","玉林市","百色市","贺州市","河池市","来宾市","崇左市","海口市","营口市","阜新市","辽阳市","盘锦市","铁岭市","朝阳市","吉林市","四平市","辽源市","通化市","白山市","松原市","白城市","延边州","哈尔滨市","齐齐哈尔市","鸡西市","鹤岗市","双鸭山市","大庆市","伊春市","佳木斯市","七台河市","牡丹江市","黑河市","绥化市","上海市","南京市","三沙市","济源市","仙桃市","潜江市","神农架林区","天门市","五指山市","琼海市","儋州市","文昌市","万宁市","东方市","定安县","屯昌县","澄迈县","临高县","白沙黎族自治县","昌江黎族自治县","乐东黎族自治县","陵水黎族自治县","保亭黎族苗族自治县","琼中黎族苗族自治县","西沙群岛","南沙群岛","中沙群岛的岛礁及其海域","石河子市","阿拉尔市","图木舒克市","五家渠市","香港","中山市","日本","三亚市"};
//    private static String[] strJd={"石家庄市","邯郸市","邢台市","保定市","张家口市","承德市","秦皇岛市","唐山市","沧州市","廊坊市","衡水市","太原市","大同市","阳泉市","晋城市","朔州市","晋中市","忻州市","吕梁市","临汾市","运城市","长治市","郑州市","开封市","洛阳市","平顶山市","焦作市","鹤壁市","新乡市","安阳市","濮阳市","许昌市","漯河市","三门峡市","南阳市","商丘市","周口市","驻马店市","信阳市","济源市","沈阳市","大连市","鞍山市","抚顺市","本溪市","丹东市","锦州市","葫芦岛市","营口市","盘锦市","阜新市","辽阳市","朝阳市","铁岭市","长春市","吉林市","四平市","通化市","白山市","松原市","白城市","延边州","辽源市","哈尔滨市","齐齐哈尔市","鹤岗市","双鸭山市","鸡西市","大庆市","伊春市","牡丹江市","佳木斯市","七台河市","黑河市","绥化市","大兴安岭地区","呼和浩特市","包头市","乌海市","赤峰市","乌兰察布市","锡林郭勒盟","呼伦贝尔市","鄂尔多斯市","巴彦淖尔市","阿拉善盟","兴安盟","通辽市","南京市","徐州市","连云港市","淮安市","宿迁市","盐城市","扬州市","泰州市","南通市","镇江市","常州市","无锡市","苏州市","济南市","青岛市","淄博市","枣庄市","东营市","潍坊市","烟台市","威海市","莱芜市","德州市","临沂市","聊城市","滨州市","菏泽市","日照市","泰安市","济宁市","铜陵市","合肥市","淮南市","淮北市","芜湖市","蚌埠市","马鞍山市","安庆市","黄山市","滁州市","阜阳市","亳州市","宿州市","池州市","六安市","宣城市","宁波市","杭州市","温州市","嘉兴市","湖州市","绍兴市","金华市","衢州市","丽水市","台州市","舟山市","福州市","厦门市","三明市","莆田市","泉州市","漳州市","南平市","龙岩市","宁德市","武汉市","黄石市","襄阳市","十堰市","荆州市","宜昌市","孝感市","黄冈市","咸宁市","恩施州","鄂州市","荆门市","随州市","潜江市","天门市","仙桃市","神农架林区","长沙市","株洲市","湘潭市","衡阳市","邵阳市","岳阳市","常德市","张家界市","郴州市","益阳市","永州市","怀化市","娄底市","湘西州","广州市","深圳市","珠海市","汕头市","韶关市","河源市","梅州市","惠州市","汕尾市","东莞市","中山市","江门市","佛山市","阳江市","湛江市","茂名市","肇庆市","云浮市","清远市","潮州市","揭阳市","南宁市","柳州市","桂林市","梧州市","北海市","防城港市","钦州市","贵港市","玉林市","贺州市","百色市","河池市","来宾市","崇左市","南昌市","景德镇市","萍乡市","新余市","九江市","鹰潭市","上饶市","宜春市","抚州市","吉安市","赣州市","成都市","自贡市","攀枝花市","泸州市","绵阳市","德阳市","广元市","遂宁市","内江市","乐山市","宜宾市","广安市","南充市","达州市","巴中市","雅安市","眉山市","资阳市","阿坝州","甘孜州","凉山州","海口市","儋州市","琼海市","万宁市","东方市","三亚市","文昌市","五指山市","临高县","澄迈县","定安县","屯昌县","昌江县","白沙县","琼中县","陵水县","保亭县","乐东县","三沙市","贵阳市","六盘水市","遵义市","铜仁市","毕节市","安顺市","黔西南州","黔东南州","黔南州","昆明市","曲靖市","玉溪市","昭通市","普洱市","临沧市","保山市","丽江市","文山州","红河州","西双版纳州","楚雄州","大理州","德宏州","怒江州","迪庆州","拉萨市","那曲地区","山南地区","昌都地区","日喀则地区","阿里地区","林芝市","西安市","铜川市","宝鸡市","咸阳市","渭南市","延安市","汉中市","榆林市","商洛市","安康市","兰州市","金昌市","白银市","天水市","嘉峪关市","平凉市","庆阳市","陇南市","武威市","张掖市","酒泉市","甘南州","临夏州","定西市","西宁市","海东地区","海北州","黄南州","海南州","果洛州","玉树州","海西州","银川市","石嘴山市","吴忠市","固原市","中卫市","乌鲁木齐市","克拉玛依市","石河子市","吐鲁番地区","哈密地区","和田地区","阿克苏地区","喀什地区","克孜勒苏柯尔克孜自治州","巴音郭楞州","昌吉州","博尔塔拉州","伊犁州","塔城地区","阿勒泰地区","五家渠市","阿拉尔市","图木舒克市","铁门关市","昆玉市","台湾"};
//
//        public static void main(String[] args) {
//        try {
//
//            for(int i=0;i<strKl.length;i++){
//                String strklAddress=strKl[i];
//                System.out.println(strklAddress);
//
//                for(int j=0;j<strJd.length;j++){
//                    String strJdAddress=strJd[j];
//                    if(strklAddress.indexOf(strJdAddress)!=-1){
//                        System.out.println(strklAddress+","+strJdAddress);
//                    }
//                }
//
//            }
//
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }


    // 三级地址计算；考拉与京东不匹配的三级地址
//    private static File file=null;
//    private static InputStream inputStream=null;
//    private static InputStreamReader inputStreamReader=null;
//    private static BufferedReader bufferedReader=null;
//
//    private static File file1=null;
//    private static InputStream inputStream1=null;
//    private static InputStreamReader inputStreamReader1=null;
//    private static BufferedReader bufferedReader1=null;
//
//    public static void main(String[] args) throws Exception{
//
//        file=new File("/Users/zhangyibin/Downloads/kl3.txt");
//        inputStream=new FileInputStream(file);
//        inputStreamReader=new InputStreamReader(inputStream);
//        bufferedReader=new BufferedReader(inputStreamReader);
//        String strKl="";
//        while ((strKl=bufferedReader.readLine())!=null){
//            System.out.println(strKl);
//
//            file1=new File("/Users/zhangyibin/Downloads/jd3.txt");
//            inputStream1=new FileInputStream(file1);
//            inputStreamReader1=new InputStreamReader(inputStream1);
//            bufferedReader1=new BufferedReader(inputStreamReader1);
//            String strjd="";
//            while ((strjd=bufferedReader1.readLine())!=null){
//                if(strKl.indexOf(strjd)!=-1){
//                    System.out.println(strKl+","+strjd);
//                }
//            }
//
//            bufferedReader1.close();
//            inputStreamReader1.close();
//            inputStream1.close();
//
//
//        }
//
//        bufferedReader.close();
//        inputStreamReader.close();
//        inputStream.close();
//    }


//    private static File file = null;
//    private static InputStream inputStream = null;
//    private static InputStreamReader inputStreamReader = null;
//    private static BufferedReader bufferedReader = null;
//
//    private static File file1 = null;
//    private static InputStream inputStream1 = null;
//    private static InputStreamReader inputStreamReader1 = null;
//    private static BufferedReader bufferedReader1 = null;
//
//    public static void main(String[] args) throws Exception {
//
//        file = new File("/Users/zhangyibin/Downloads/三级考拉.txt");
//        inputStream = new FileInputStream(file);
//        inputStreamReader = new InputStreamReader(inputStream);
//        bufferedReader = new BufferedReader(inputStreamReader);
//        String strKl = "";
//        while ((strKl = bufferedReader.readLine()) != null) {
//            System.out.println(strKl);
//            String strKaadd=strKl.substring(0,2);
//            System.out.println(strKaadd);
//
//            file1 = new File("/Users/zhangyibin/Downloads/三级京东.txt");
//            inputStream1 = new FileInputStream(file1);
//            inputStreamReader1 = new InputStreamReader(inputStream1);
//            bufferedReader1 = new BufferedReader(inputStreamReader1);
//            String strjd = "";
//            while ((strjd = bufferedReader1.readLine()) != null) {
//                if (strjd.indexOf(strKaadd) != -1) {
//                    System.out.println(strKl + "；" + strjd);
//                }
//            }
//
//            bufferedReader1.close();
//            inputStreamReader1.close();
//            inputStream1.close();
//
//
//        }
//
//        bufferedReader.close();
//        inputStreamReader.close();
//        inputStream.close();
//    }


    private static File file = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    private static File file1 = null;
    private static InputStream inputStream1 = null;
    private static InputStreamReader inputStreamReader1 = null;
    private static BufferedReader bufferedReader1 = null;

    public static void main(String[] args) throws Exception {

        file = new File("/Users/zhangyibin/Downloads/京东未匹配3级地址.txt");
        inputStream = new FileInputStream(file);
        inputStreamReader = new InputStreamReader(inputStream);
        bufferedReader = new BufferedReader(inputStreamReader);
        String strKl = "";
        while ((strKl = bufferedReader.readLine()) != null) {
//            System.out.println(strKl);
//            String strKaadd=strKl.substring(0,2);
//            System.out.println(strKaadd);

            file1 = new File("/Users/zhangyibin/Downloads/tt.txt");
            inputStream1 = new FileInputStream(file1);
            inputStreamReader1 = new InputStreamReader(inputStream1);
            bufferedReader1 = new BufferedReader(inputStreamReader1);
            String strjd = "";
            while ((strjd = bufferedReader1.readLine()) != null) {
                if (strjd.indexOf(strKl) != -1) {
                    System.out.println(strKl + "；" + strjd);
                }
            }

            bufferedReader1.close();
            inputStreamReader1.close();
            inputStream1.close();


        }

        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();
    }

}
