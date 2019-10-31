package businessunit.excel;

/**
 * 类：MachineGuns(加特林)
 */

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

public class MachineGuns {

    /*
     * 确定日期时间范围
     * strDate：日期
     * startTimer：开始时间
     * endTimer：结束时间
     * 格式：2019-10-24 12
     */

    private List<String> dateArray = new ArrayList<String>();

    public List<String> getDate(String strDate, int startTimer, int endTimer) {
        for (int i = startTimer; i <= endTimer; i++) {
            if (i < 10) {
                dateArray.add(strDate + " " + "0" + i);
            } else {
                dateArray.add(strDate + " " + i);

            }
        }
        return dateArray;

    }

    /*
     * 数据检索
     *
     */

    private File file = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;
    private XSSFRow xssfRow = null;
    private XSSFCell iDCell = null;
    private XSSFCell dateCell = null;
    private XSSFCell costPriceXSSFCell = null;
    private XSSFCell numberXSSFCell = null;
    private XSSFCell paymentPriceXSSFCell = null;
    private XSSFCell orderStatusXSSFCell = null;
    private Iterator<String> iterator = null;

    public void getRetrieval(String ID, String excelName) {
        try {
            int order = 0;//订单数
            Double costPrice = 0.0;// 成本价
            Double paymentPrice = 0.0; // 支付价

            file = new File("/Users/zhangyibin/Downloads/" + excelName);
            xssfWorkbook = new XSSFWorkbook(file);
            xssfSheet = xssfWorkbook.getSheetAt(0);
            int excelRow = xssfSheet.getPhysicalNumberOfRows();
            for (int i = 0; i < excelRow; i++) {
                xssfRow = xssfSheet.getRow(i);
                iDCell = xssfRow.getCell(9);
                dateCell = xssfRow.getCell(24);
                orderStatusXSSFCell = xssfRow.getCell(5); // 订单状态
                costPriceXSSFCell = xssfRow.getCell(31);//成本价
                numberXSSFCell = xssfRow.getCell(12); // 商品数量
                paymentPriceXSSFCell = xssfRow.getCell(14);//支付金额

                if (iDCell.toString().equals(ID) && orderStatusXSSFCell.toString().equals("付款成功")) {
                    iterator = this.dateArray.iterator();
                    while (iterator.hasNext()) {
                        if (dateCell.toString().indexOf(iterator.next()) != -1) {
                            order++;
                            costPrice = costPrice + (Double.valueOf(numberXSSFCell.toString()) * Double.valueOf(costPriceXSSFCell.toString())); //实际成本汇总
                            paymentPrice = paymentPrice + (Double.valueOf(paymentPriceXSSFCell.toString())); // 支付金额汇总

                        }
                    }
                }
            }
            xssfWorkbook.close();
            BigDecimal bigDecimal1 = new BigDecimal(paymentPrice);
            BigDecimal bigDecimal2 = new BigDecimal(costPrice);

            System.out.println("订单笔数：" + order + "笔");
            System.out.println("总支付金额：" + bigDecimal1.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "元");
            System.out.println("总成本：" + bigDecimal2.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue() + "元");
            System.out.println("利润：：" + ((bigDecimal1.subtract(bigDecimal2)).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue()) + "元");

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) {
        MachineGuns machineGuns = new MachineGuns();
//        System.out.println(machineGuns.getDate("2019-10-24", 0, 23)); //小于10 的要处理的
        machineGuns.getDate("2019-10-24", 0, 23);
        machineGuns.getRetrieval("15224", "2019-10-24至2019-10-24的订单.xlsx");

    }
}
