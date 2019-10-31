package Institutes.zjlottery;

import java.io.File;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

public class LotteryNum implements Runnable{
    private File file=null;
    private XSSFWorkbook xssfWorkbook=null;
    private XSSFSheet xssfSheet=null;
    private XSSFRow xssfRow=null;
    private XSSFCell xssfCell=null;

    @Override
    public void run(){
        try {
            file=new File("/Users/zhangyibin/Downloads/体彩号码.xlsx");
            xssfWorkbook=new XSSFWorkbook(file);
            xssfSheet=xssfWorkbook.getSheetAt(0);
            int numXssfRow=xssfSheet.getPhysicalNumberOfRows();
            for(int i=3;i<numXssfRow;i=i+4){
                xssfRow=xssfSheet.getRow(i);
                xssfCell=xssfRow.getCell(0);
                System.out.println(xssfCell.toString());
            }
            xssfWorkbook.close();

        }catch (Exception e){
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new LotteryNum()).start();

        //6713708
        //6713908
    }
}
