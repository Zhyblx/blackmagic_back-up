package Institutes.itjuzi;

import org.jsoup.Connection;
import org.jsoup.nodes.Document;
import org.jsoup.Jsoup;
import toolbox.UnicodeConversion;

public class ClosureInFo {

    public static void main(String[] args) {
        try{
            Connection connection=Jsoup.connect("https://www.itjuzi.com/api/closure?com_prov=&sort=&page=2&keyword=&cat_id=");
            connection.ignoreContentType(true);
            connection.timeout(10000);
            connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36");

            Document document=connection.get();
            System.out.println(UnicodeConversion.getdecodeUnicode(document.text()));


        }catch (Exception e){
            e.printStackTrace();

        }
    }
}
