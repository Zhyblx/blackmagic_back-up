package businessunit.excel;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * 类：ProfitCalculation
 * 作用：计算Excel中的实际利润汇总值
 */

public class ProfitCalculation {

    private String path = "";

    private void setPath(String path) {
        this.path = path;

    }

    private String getPath() {
        return this.path;

    }

    /*
     * 构造方法
     *
     */
    public ProfitCalculation(String path) {
        this.setPath(path);

    }

    private List<Double> list1 = new ArrayList<Double>();
    private List<Double> list2 = new ArrayList<Double>();
    private File file = null;
    private InputStream inputStream = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;

    /*
     * 排除商品ID 12810、13038 的利润价
     */

    public List<Double> getProfitCalculationList() throws Exception {
        file = new File(this.getPath());
        inputStream = new FileInputStream(file);

        xssfWorkbook = new XSSFWorkbook(inputStream);
        xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowsNum = xssfSheet.getPhysicalNumberOfRows();
        double costPrice = 0.0;// 成本价
        double paymentPrice = 0.0; // 支付价

        for (int i = 0; i < rowsNum; i++) {
            if (i != 0) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                XSSFCell orderStatusXSSFCell = xssfRow.getCell(5); // 订单状态
                XSSFCell classifyXSSFCell = xssfRow.getCell(27); // 订单状态
                XSSFCell numberXSSFCell = xssfRow.getCell(12); // 商品数量
                XSSFCell costPriceXSSFCell = xssfRow.getCell(31);//成本价
                XSSFCell paymentPriceXSSFCell = xssfRow.getCell(14);//支付金额
                XSSFCell goodsIDXSSFCell = xssfRow.getCell(9); // 商品ID

                /*
                 * 条件：
                 * 1.订单状态【等于】付款成功
                 * 2.一级分类【不等于】金融、轻古集市、特权
                 * 3.排除商品ID 12810、13038
                 */
                if (orderStatusXSSFCell.toString().equals("付款成功") &&
                        !(classifyXSSFCell.toString().equals("金融") || classifyXSSFCell.toString().equals("轻古集市") || classifyXSSFCell.toString().equals("特权")) &&
                        !(goodsIDXSSFCell.toString().equals("12810") || goodsIDXSSFCell.toString().equals("13038"))
                ) {
//                    System.out.println(orderStatusXSSFCell.toString() + "_" + classifyXSSFCell.toString());
                    costPrice = costPrice + (Double.valueOf(numberXSSFCell.toString()) * Double.valueOf(costPriceXSSFCell.toString())); //实际成本汇总
                    paymentPrice = paymentPrice + (Double.valueOf(paymentPriceXSSFCell.toString())); // 支付金额汇总

                }
            }
        }

        Double Profit = paymentPrice - costPrice;
        list1.add(paymentPrice);
        list1.add(costPrice);
        list1.add(Profit);

//        System.out.println("当前利润：" + (paymentPrice - costPrice));

        return list1;
    }

    /*
     * 单独计算商品ID 12810、13038 的利润
     * 备注:价格要等于0的才会进入以下的方法进行计算
     *
     */

    public List<Double> getSpecialGoods() throws Exception {
        file = new File(this.getPath());
        inputStream = new FileInputStream(file);

        xssfWorkbook = new XSSFWorkbook(inputStream);
        xssfSheet = xssfWorkbook.getSheetAt(0);
        int rowsNum = xssfSheet.getPhysicalNumberOfRows();
        double costPrice = 0.0;// 成本价
        double paymentPrice = 0.0; // 支付价
        double count = 0;

        for (int i = 0; i < rowsNum; i++) {
            if (i != 0) {
                XSSFRow xssfRow = xssfSheet.getRow(i);
                XSSFCell goodsIDXSSFCell = xssfRow.getCell(9); // 商品ID
                XSSFCell paymentPriceXSSFCell = xssfRow.getCell(14);//支付金额
                /*
                 * 如果商品ID 等于12810、13038）并且 支付金额等于0，那么它的成本是25元，实际支付金额29元
                 */
                if ((goodsIDXSSFCell.toString().equals("12810") || goodsIDXSSFCell.toString().equals("13038"))) {
                    if ((paymentPriceXSSFCell.toString().equals("0.00"))) {
                        count++;

                    }
                }
            }
        }
//        System.out.println("商品ID 12810、13038两款红酒一共卖出去" + count + "瓶");
        costPrice = 25 * count;
        paymentPrice = 29 * count;

        Double Profit = paymentPrice - costPrice;
        list2.add(paymentPrice);
        list2.add(costPrice);
        list2.add(Profit);

        return list2;

    }


    public static void main(String[] args) throws Exception {
        //"/Users/zhangyibin/Downloads/2019-08-15至2019-08-15的订单.xlsx"
        ProfitCalculation profitCalculation = new ProfitCalculation("/Users/zhangyibin/Downloads/2018-09-01至2018-09-30的订单.xlsx");
        System.out.println(profitCalculation.getProfitCalculationList());
        System.out.println(profitCalculation.getSpecialGoods());

        // 排除商品ID 12810、13038 的利润LIST
        List<Double> fullProfitList = new ArrayList<Double>();
        fullProfitList.addAll(profitCalculation.getProfitCalculationList());

        // 单独计算商品ID 12810、13038 的利润LIST
        List<Double> profitOfSpecialGoods = new ArrayList<Double>();
        profitOfSpecialGoods.addAll(profitCalculation.getSpecialGoods());

        System.out.println("当日支付金额汇总：" + (fullProfitList.get(0) + profitOfSpecialGoods.get(0)));
        System.out.println("当日实际成本汇总：" + (fullProfitList.get(1) + profitOfSpecialGoods.get(1)));
        System.out.println("当日实际利润汇总：" + (fullProfitList.get(2) + profitOfSpecialGoods.get(2)));

    }

}

