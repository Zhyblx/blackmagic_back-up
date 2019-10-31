package businessunit.activitytopics;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 执行删除专题商品列表的操作
 *
 */

public class TopicTest {

    public static void main(String[] args) throws Exception {
        List<String> list = new ArrayList<String>();
        int PageNumber=6;
        //男士修炼场(104)、情趣专场(105)、品质生活(106)、秋季养生(107)
        Topic topic = new Topic("193DDC9B59F13A8B42D9E1D5F4A5D696","105");
        // 循环值代表专题下商品的页码数
        for (int i = 1; i <= PageNumber; i++) {
            list.addAll(topic.setTopicShopID("1"));
            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String strID = iterator.next();
                System.out.println(strID);
                topic.getDeleteGoods(strID);

            }
        }
    }

}
