package businessunit.excel;

/**
 * 类：ProfitRanking
 * 作用：根据利润进行降序(排序)
 */

import java.io.File;
import java.util.*;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import toolbox.mapsort.accordingtovalue.MapValueComparator;

public class ProfitRanking implements Runnable {

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
            if (topNum == 21) {
                break;// 只输出TOP10

            }
            System.out.println(topNum + "\t" + list.get(collectionSize).toString().replace("=", "\t"));
            collectionSize--;
            topNum++;


        }
    }

    private final String path = "/Users/zhangyibin/Downloads/";
    private String excleName = "";

    private void setExcleName(String excleName) {
        this.excleName = excleName;

    }

    public String getExcleName() {
        return this.excleName;

    }

    public ProfitRanking(String excleName) {
        this.setExcleName(excleName);

    }

    private File file = null;
    private Map<String, Double> mapSort = new HashMap<String, Double>();
    private Collection<String> shopNameCollection = new LinkedHashSet<String>();
    private Iterator<String> iterator = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;
    private XSSFRow xssfRow = null;
    private XSSFCell shopNameXssfCell = null; //商品名称
    private XSSFCell orderStatusXSSFCell = null;
    private XSSFCell classifyXSSFCell = null;
    private XSSFCell paymentPriceXSSFCell = null;
    private XSSFCell costPriceXSSFCell = null;
    private XSSFCell numberXSSFCell = null;

    @Override
    public void run() {
        try {
            file = new File(this.path + this.getExcleName());
            xssfWorkbook = new XSSFWorkbook(file);
            xssfSheet = xssfWorkbook.getSheetAt(0);
            int rowsNum = xssfSheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowsNum; i++) {
                xssfRow = xssfSheet.getRow(i);
                shopNameXssfCell = xssfRow.getCell(10); //商品名称
                orderStatusXSSFCell = xssfRow.getCell(5); // 订单状态
                classifyXSSFCell = xssfRow.getCell(27); // 一级类目

                /*
                 * 排除条件：
                 * 1.订单状态【等于】付款成功
                 * 2.一级分类【不等于】金融、轻古集市、特权
                 */
                if (orderStatusXSSFCell.toString().equals("付款成功") &&
                        !(classifyXSSFCell.toString().equals("金融") || classifyXSSFCell.toString().equals("轻古集市") || classifyXSSFCell.toString().equals("特权"))) {

                    shopNameCollection.add(shopNameXssfCell.toString());

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
//                System.out.println(shopName + "|" + shopcount + "|" + (paymentPrice - costPrice));
                mapSort.put((shopName + "\t" + shopcount), (paymentPrice - costPrice));

            }
//            System.out.println(SortMapByValue.sortMapByValue(mapSort));
            this.sortMapByValue(mapSort); //调用排序方法

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        new Thread(new ProfitRanking("2019-08-22至2019-08-22的订单.xlsx")).start();

    }
}
