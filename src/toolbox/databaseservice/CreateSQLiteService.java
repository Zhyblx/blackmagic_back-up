package toolbox.databaseservice;

import java.lang.Class;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

// 连接(创建)数据库

/**
 * 类：CreateSQLiteService
 * 作用：
 * 1.提供数据库服务
 * 2.创建数据库BlackCard.db
 * 3.使用sqlite数据库
 *
 */
public class CreateSQLiteService {

    private static Connection connection = null;
    private static Statement statement = null;

    public static void main(String[] args) {
        try {

            Class.forName("org.sqlite.JDBC");
            connection = DriverManager.getConnection("jdbc:sqlite:BlackCard.db");
            statement = connection.createStatement();
//            String sql = "CREATE TABLE AddressInfo(type varchar(255),address1 varchar(255),address2 varchar(512),address3 varchar(512),address4 varchar(512));"; //京东地址
//            String sql = "CREATE TABLE category(catId1 varchar(255),catId2 varchar(255),catId3 varchar(512),catId4 varchar(512),catId5 varchar(512));"; //类目

            String sql="CREATE TABLE tb_bm_goods(\n" +
                    "goodsID varchar(255),\n" +
                    "goodsTitle varchar(255),\n" +
                    "goodsSubheading varchar(255),\n" +
                    "Model varchar(255),\n" +
                    "FrontClassification varchar(255),\n" +
                    "Background classification varchar(255),\n" +
                    "DeliveryExpress varchar(255),\n" +
                    "Supplier varchar(255),\n" +
                    "WaysOfCooperation varchar(255),\n" +
                    "OpeningTime varchar(255),\n" +
                    "ShelfTime varchar(255),\n" +
                    "OnShelfStatus varchar(255),\n" +
                    "Sold varchar(255),\n" +
                    "Skuid varchar(255),\n" +
                    "SKUAttribute varchar(255),\n" +
                    "price varchar(255),\n" +
                    "MarketReferencePrice varchar(255),\n" +
                    "CostPrice varchar(255),\n" +
                    "Stock varchar(255));";

            statement.executeUpdate(sql);
            statement.close();
            connection.close();
            System.out.println("数据库创建成功!");

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
