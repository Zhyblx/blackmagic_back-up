package toolbox.databaseservice;


import toolbox.LogPrinting;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * 类：InsertService
 * 作用：执行Sql插入数据库服务
 * 将数据记录插入BlackCard中的AddressInfo表
 * 插入字段：type(类型)|address1(一级地址)|address2(二级级地址)|address3(三级地址)
 */

public class InsertService {

    // getInsertService() 方法名相同，参数个数/参数类型不同 称为方法重载
    // 将消息按照字段分隔插入数据库
    public static void getInsertService(String type, String address1, String address2, String address3, String address4) {
        try {

            Class.forName("org.sqlite.JDBC");
            // 连接到数据库Dxy.db
            Connection connection = DriverManager.getConnection("jdbc:sqlite:BlackCard.db");
            Statement statement = connection.createStatement();
            String sql = "INSERT INTO AddressInfo VALUES ('" + type + "','" + address1 + "','" + address2 + "','" + address3 + "','" + address4 + "');";
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

            System.out.println(sql);

        } catch (Exception e) {
            LogPrinting.getLog("INSERT INTO AddressInfo VALUES ('" + type + "','" + address1 + "','" + address2 + "','" + address3 + "','" + address4 + "');");//对Insert错误的语句进行记录
        }
    }

    // 通过完整的sql插入数据库
    public static void getInsertService(String strSql) {
        try {

            Class.forName("org.sqlite.JDBC");
            // 连接到数据库Dxy.db
            Connection connection = DriverManager.getConnection("jdbc:sqlite:BlackCard.db");
            Statement statement = connection.createStatement();
            String sql = strSql;
//            System.out.println(sql);
            statement.executeUpdate(sql);
            statement.close();
            connection.close();

            System.out.println(sql);

        } catch (Exception e) {
            LogPrinting.getLog(strSql);//对Insert错误的语句进行记录
        }
    }

    public static void main(String[] args) {
//        InsertService.getInsertService("2018-08-02 20:21:25","自动回复","杭州:周五,大雨转阴 南风微风,最低气温26度，最高气温31度");
//        InsertService.getInsertService("INSERT INTO tb_user_search VALUES (\"2018-12-11\",\"8912\",\"鹿晗同款，防霾口罩PITTA 防花粉灰尘过敏抗菌口罩黑灰色\",\"#N/A\",\"\",\"\",\"\");");
    }

}
