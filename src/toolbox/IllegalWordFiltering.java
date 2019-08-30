package toolbox;

/**
 * 类：IllegalWordFiltering
 * 作用：过滤(排查)违禁词汇
 */

import java.io.File;

import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class IllegalWordFiltering implements Runnable {
    /*
     * 违禁词词汇定义：
     *
     * 与“最”、“一”、“级/极”、“首/家/国”、“品牌/虚假/欺诈/时间”有关的词汇样本
     *
     */
    private String[] prohibitedWords = {"最", "最佳", "最具", "最爱", "最赚", "最优", "最优秀", "最好", "最大", "最大程度", "最高",
            "最高级", "最高档", "最奢侈", "最低", "最低级", "最低价", "最底", "最便宜", "时尚最低价", "最流行", "最受欢迎", "最时尚", "最聚拢",
            "最符合", "最舒适", "最先", "最先进", "最先进科学", "最先进加工工艺", "最先享受", "最后", "最后一波", "最新", "最新科技", "最新科学",
            "第一", "中国第一", "全网第一", "销量第一", "排名第一", "唯一", "第一品牌", "NO.1", "TOP.1", "独一无二", "全国第一", "一流",
            "一天", "仅此一次", "最后一波", "大品牌之一", "仅此一款", "国家级", "国家级产品", "全球级", "宇宙级", "世界级", "顶级", "顶级工艺",
            "顶级享受", "极品", "极佳", "终极", "极致", "顶尖", "尖端", "绝佳", "绝对", "首个", "首选", "独家", "独家配方", "全国首发", "首款",
            "全国销量冠军", "国家级产品", "国家领导人", "填补国内空白", "王牌", "领袖品牌", "世界领先", "领导者", "缔造者", "创领品牌",
            "领先上市", "至尊", "巅峰", "领袖", "之王", "王者", "冠军", "史无前例", "前无古人", "永久", "万能", "祖传", "特效", "无敌",
            "纯天然", "100%", "点击领奖", "恭喜获奖", "全民免单", "点击有惊喜", "点击获取", "点击转身", "点击试穿", "点击翻转",
            "领取奖品涉嫌诱导消费者秒杀", "抢爆", "再不抢就没了", "不会更便宜了", "错过就没机会了", "万人疯抢", "全民疯抢", "抢疯了",
            "今日", "今天", "几天几夜", "倒计时", "趁现在", "就", "仅限", "周末", "周年庆", "特惠趴", "购物大趴", "闪购", "品牌团",
            "精品团", "随时涨价", "马上降价", "国家"

    };

    private final String PATH = "/Users/zhangyibin/Downloads/";
    private File file = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;
    private XSSFRow xssfRow = null;
    private XSSFCell shopIdXssfCell = null; // 商品ID
    private XSSFCell shopNameXssfCell = null; //商品名称
    private XSSFCell subshopNameXssfCell = null; //副商品名称

    @Override
    public void run() {
        try {
            file = new File(PATH + "商品信息.xlsx");
            xssfWorkbook = new XSSFWorkbook(file);
            xssfSheet = xssfWorkbook.getSheetAt(0);
            int rowsNum = xssfSheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowsNum; i++) {
                xssfRow = xssfSheet.getRow(i);
                shopIdXssfCell = xssfRow.getCell(0);// 商品ID
                shopNameXssfCell = xssfRow.getCell(1);//商品名称
                subshopNameXssfCell = xssfRow.getCell(2);//副商品名称
                for (int j = 0; j < prohibitedWords.length; j++) {
                    if ((shopNameXssfCell.toString().indexOf(prohibitedWords[j]) != -1 || subshopNameXssfCell.toString().indexOf(prohibitedWords[j]) != -1)
                    ) {
                        System.out.println(prohibitedWords[j] + "\t" + shopIdXssfCell.toString() + "\t" + shopNameXssfCell.toString() + "\t" + subshopNameXssfCell.toString());

                    }
                }
            }
            xssfWorkbook.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        IllegalWordFiltering illegalWordFiltering = new IllegalWordFiltering();
        new Thread(illegalWordFiltering).start();

    }
}




















