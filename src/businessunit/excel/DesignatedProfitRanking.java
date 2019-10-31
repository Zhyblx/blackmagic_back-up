package businessunit.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import toolbox.mapsort.accordingtovalue.MapValueComparator;

import java.io.File;
import java.util.*;

/**
 * 类：DesignatedProfitRanking
 * 作用：统计出指定商品的利润并进行排名
 */

public class DesignatedProfitRanking extends ProfitRanking implements Runnable {

    public DesignatedProfitRanking(String excleName) {
        super(excleName);

    }

    private void sortMapByValue(Map<String, Double> oriMap) {
        List<String> list = new ArrayList<String>();
        List<Map.Entry<String, Double>> entryList = new ArrayList<Map.Entry<String, Double>>(oriMap.entrySet());
        Collections.sort(entryList, new MapValueComparator());

        Iterator<Map.Entry<String, Double>> iter = entryList.iterator();
        Map.Entry<String, Double> tmpEntry = null;
        while (iter.hasNext()) {
            tmpEntry = iter.next();
            list.add(tmpEntry.toString());

        }
        int topNum = 1;
        int collectionSize = list.size() - 1;
        System.out.println("TOP值" + "\t" + "商品标题" + "\t" + "销售数量" + "\t" + "汇总利润");
        while (collectionSize >= 0) {
            if (topNum == 60) {
                break;// 只输出TOP20

            }
            System.out.println(topNum + "\t" + list.get(collectionSize).toString().replace("=", "\t"));
            collectionSize--;
            topNum++;


        }
    }

    private File file = null;
    private Map<String, Double> mapSort = new HashMap<String, Double>();
    private Collection<String> shopNameCollection = new LinkedHashSet<String>();
    private Iterator<String> iterator = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;
    private XSSFRow xssfRow = null;
    private XSSFCell shopNameXssfCell = null; //商品名称
    private XSSFCell shopIdXssfCell = null;
    private XSSFCell orderStatusXSSFCell = null;
    private XSSFCell classifyXSSFCell = null;
    private XSSFCell paymentPriceXSSFCell = null;
    private XSSFCell costPriceXSSFCell = null;
    private XSSFCell numberXSSFCell = null;

    public Map<String, Double> setMapSort(String shopID) {
        try {
            file = new File(this.path + this.getExcleName());
            xssfWorkbook = new XSSFWorkbook(file);
            xssfSheet = xssfWorkbook.getSheetAt(0);
            int rowsNum = xssfSheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowsNum; i++) {
                xssfRow = xssfSheet.getRow(i);
                shopNameXssfCell = xssfRow.getCell(10); //商品名称
                shopIdXssfCell = xssfRow.getCell(9);// 商品ID
                orderStatusXSSFCell = xssfRow.getCell(5); // 订单状态
                classifyXSSFCell = xssfRow.getCell(27); // 一级类目

                /*
                 * 排除条件：
                 * 1.订单状态【等于】付款成功
                 * 2.一级分类【不等于】金融、轻古集市、特权
                 */
                if (orderStatusXSSFCell.toString().equals("付款成功") &&
                        !(classifyXSSFCell.toString().equals("金融") || classifyXSSFCell.toString().equals("轻古集市") || classifyXSSFCell.toString().equals("特权"))) {
                    if (shopIdXssfCell.toString().equals(shopID)) {
//                        System.out.println(shopNameXssfCell.toString());
                        shopNameCollection.add(shopNameXssfCell.toString());

                    }
                }
            }

            iterator = shopNameCollection.iterator();
            while (iterator.hasNext()) {
                String shopName = iterator.next();// 商品名称
                double costPrice = 0.0;// 实际成本价
                double paymentPrice = 0.0; // 实际支付价
                int shopcount = 0;

                for (int i = 0; i < rowsNum; i++) {
                    xssfRow = xssfSheet.getRow(i);
                    paymentPriceXSSFCell = xssfRow.getCell(14);//支付金额
                    shopNameXssfCell = xssfRow.getCell(10); //商品名称
                    costPriceXSSFCell = xssfRow.getCell(31);//成本价
                    numberXSSFCell = xssfRow.getCell(12); // 商品数量
                    orderStatusXSSFCell = xssfRow.getCell(5); // 订单状态
                    classifyXSSFCell = xssfRow.getCell(27); // 一级类目

                    if (shopName.equals(shopNameXssfCell.toString()) && orderStatusXSSFCell.toString().equals("付款成功") &&
                            !(classifyXSSFCell.toString().equals("金融") || classifyXSSFCell.toString().equals("轻古集市") || classifyXSSFCell.toString().equals("特权"))) {
                        shopcount = shopcount + (Integer.valueOf(numberXSSFCell.toString()));
                        costPrice = costPrice + (Double.valueOf(numberXSSFCell.toString()) * Double.valueOf(costPriceXSSFCell.toString())); //实际成本汇总
                        paymentPrice = paymentPrice + (Double.valueOf(paymentPriceXSSFCell.toString())); // 支付金额汇总

                    }
                }
                mapSort.put((shopName + "\t" + shopcount), (paymentPrice - costPrice));

            }
            xssfWorkbook.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return mapSort;

    }

    @Override
    public void run() {
        try {
            Map<String, Double> map = new HashMap<String, Double>();
            for (String str : shopIDArray) {
                map.putAll(designatedProfitRanking.setMapSort(str));

            }
            this.sortMapByValue(map); //调用排序方法

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*
     * 1.构造参数：用于计算的指定文件
     * 2.shopIDArray:指定的商品ID
     */

//    private static DesignatedProfitRanking designatedProfitRanking = new DesignatedProfitRanking("2019-09-06至2019-09-08的订单.xlsx");
//    private static String[] shopIDArray = new String[]{"13291","14119","15057","14822","2750","14985","15036","3933","2573","15062","15061",
//            "15046","15045","15044","15038","15037","6745","14997","15013","15058","15006","15059","15056","15047","15054","15065","4333",
//            "2679","14642","3542","3556","14667","14998","14856","14444","14668","15071","13462","13533","15063","12948","10435","13140",
//            "12655","14814","14825","14321","15080","14888","12486","14896","15082"};

    // 以下是个护
    private static DesignatedProfitRanking designatedProfitRanking = new DesignatedProfitRanking("2019-09-27至2019-09-30的订单.xlsx");
    private static String[] shopIDArray = new String[]{"15117","15098","15107"};

    public static void main(String[] args) {
        new Thread(designatedProfitRanking).start();

    }
}
