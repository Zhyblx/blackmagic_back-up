package businessunit.excel;

/**
 * 类：LossStatistics
 * 作用：统计出非电商域的优惠券，给电商域带来的损失
 */

import java.io.File;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFCell;

import java.util.Set;
import java.util.HashSet;
import java.util.Iterator;

import org.jsoup.Jsoup;
import org.jsoup.Connection;
import org.jsoup.nodes.Document;


public class LossStatistics implements Runnable {

    private final String PATH = "/Users/zhangyibin/Downloads/";
    private File file = null;
    private XSSFWorkbook xssfWorkbook = null;
    private XSSFSheet xssfSheet = null;
    private XSSFRow xssfRow = null;
    private XSSFCell couponIDXSSFCell = null;
    private XSSFCell orderStatusXSSFCell = null;
    private XSSFCell classifyXSSFCell = null;
    private Set<String> listSet = new HashSet<String>();
    private Iterator<String> iterator = null;

    @Override
    public void run() {
        try {
            this.file = new File(this.PATH + this.getExcleName());
            this.xssfWorkbook = new XSSFWorkbook(this.file);
            this.xssfSheet = this.xssfWorkbook.getSheetAt(0);
            int rowsNum = this.xssfSheet.getPhysicalNumberOfRows();
            for (int i = 0; i < rowsNum; i++) {
                this.xssfRow = this.xssfSheet.getRow(i);
                this.couponIDXSSFCell = this.xssfRow.getCell(18); // 优惠券ID
                this.orderStatusXSSFCell = this.xssfRow.getCell(5); // 订单状态
                this.classifyXSSFCell = this.xssfRow.getCell(27); // 一级类目
                /*
                 * 排除条件：
                 * 1.订单状态【等于】付款成功
                 * 2.一级分类【不等于】金融、轻古集市、特权
                 */
                if (this.orderStatusXSSFCell.toString().equals("付款成功") &&
                        !(this.classifyXSSFCell.toString().equals("金融") || this.classifyXSSFCell.toString().equals("轻古集市") || this.classifyXSSFCell.toString().equals("特权") || this.classifyXSSFCell.toString().equals("特权号"))) {
//                    System.out.println(this.couponIDXSSFCell.toString());
                    this.listSet.add(this.couponIDXSSFCell.toString());

                }
            }

            iterator = this.listSet.iterator();
            do {
                int count = 0;
                String id = this.iterator.next(); // 优惠券ID
                if (!(id.equals("")) && !(id.equals("0"))) {
//                    System.out.println(id);
                    for (int i = 0; i < rowsNum; i++) {
                        this.xssfRow = this.xssfSheet.getRow(i);
                        this.couponIDXSSFCell = this.xssfRow.getCell(18); // 优惠券ID
                        this.orderStatusXSSFCell = this.xssfRow.getCell(5); // 订单状态
                        this.classifyXSSFCell = this.xssfRow.getCell(27); // 一级类目
                        if (id.equals(this.couponIDXSSFCell.toString()) && this.orderStatusXSSFCell.toString().equals("付款成功") &&
                                !(this.classifyXSSFCell.toString().equals("金融") || this.classifyXSSFCell.toString().equals("轻古集市") || this.classifyXSSFCell.toString().equals("特权"))) {
                            count++;

                        }
                    }
                    String couponInfo=this.getCouponInfo(id);
                    System.out.println("优惠券ID：" + id + "," + "数量：" + count+","+couponInfo);

                }
            } while (iterator.hasNext());

        } catch (Exception e) {
            e.printStackTrace();

        }
    }



    private Connection connection=null;
    private Document document=null;

    public String getCouponInfo(String couponID) throws Exception {


        String info="";

        this.connection=Jsoup.connect("http://cos.ultimavip.org/project/remote/coupon/%2F1.0%2Fcoupon%2Fcoupon%2FgetCoupons/false/form");
        this.connection.cookie("connect.sid",this.getStrCookie());
        this.connection.ignoreContentType(true);
        this.connection.timeout(10000);
        this.connection.data("couponId",couponID);
        this.connection.data("pageNum","1");
        this.document=this.connection.post();
//        System.out.println(this.document.text());
        String strDocument=this.document.text();
        JSONObject jsonObject = JSONObject.fromObject(strDocument);
        JSONObject jsonObject1 = jsonObject.getJSONObject("data");
        JSONArray jsonArray = jsonObject1.getJSONArray("list");
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonResult = jsonArray.getJSONObject(i);
            String id = jsonResult.getString("id");//优惠券ID
            String name=jsonResult.getString("name"); // 优惠券名称
            String typeStr=jsonResult.getString("typeStr"); // 优惠券类型
            String bName=jsonResult.getString("bName"); // 优惠券业务
            String costBName=jsonResult.getString("costBName"); // 优惠券成本方
            String substractPrice=jsonResult.getString("substractPrice"); // 优惠券礼券价值

            info="券id："+id+","+"券名称："+name+","+"类型："+typeStr+","+"业务："+bName+","+"成本方："+costBName+","+"礼券价值："+substractPrice;
        }

        return info;
    }

    private String strCookie = "";

    private void setStrCookie(String strCookie) {
        this.strCookie = strCookie;

    }

    private String getStrCookie() {
        return this.strCookie;

    }

    private String excleName="";

    private void setExcleName(String excleName){
        this.excleName=excleName;

    }

    private String getExcleName(){
        return this.excleName;

    }

    public LossStatistics(String strCookie,String excleName){
        this.setStrCookie(strCookie);
        this.setExcleName(excleName);

    }

    public static void main(String[] args) throws Exception {
        new Thread(new LossStatistics("s%3Aljq7HKy4DU4yjEN2puMN6cAqcZVXwUci.kkMSaruhcaJ7tQtdyZNqatbiFZOJjoBg35ZgVuprWTM","2019-07-01至2019-09-24的订单.xlsx")).start();
//        System.out.println(new LossStatistics().getCouponInfo("1256"));
//"s%3AqMeIA9R_ybeeLLxTDTqBKhJOtf4M7y1P.3NG9WtV%2BKSdCyUucJ1BJSLBv0lTB2VLyQOKC4emavFQ"

    }
}
