package Institutes.zjlottery;

import org.jsoup.Connection;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

public class ZjLottery61 implements Runnable {

    private Connection connection = null;
    private Document document = null;

    @Override
    public void run() {
        try {

            for (int page = 1; page <= 54; page++) {
                Thread.sleep(2000);
                connection = Jsoup.connect("https://www.zjlottery.com/win/SResult.asp?flag=1&Sissue=01001&Eissue=19123&Sdate=&page=" + page);
                connection.ignoreContentType(true);
                connection.timeout(5000);
                connection.userAgent("Mozilla/5.0 (Macintosh; Intel Mac OS X 10_15_0) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/78.0.3904.70 Safari/537.36");

                document = connection.get();
                Element element = document.body();
                Elements elements = element.getElementsByTag("tbody");
                Elements elements1 = elements.select("td");

                for (int i = 0; i < elements1.size(); i++) {
                    System.out.println(elements1.get(i).text());

                }
            }
        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new ZjLottery61()).start();

    }


}
