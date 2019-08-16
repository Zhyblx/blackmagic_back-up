package experimentation.mapsortingtest;

import toolbox.mapsort.accordingtovalue.SortMapByValue;

import java.util.Map;
import java.util.TreeMap;

/**
 * 类：MapValueSortingTest
 * 作用：测试Map_value的排序功能
 *
 */

public class MapValueSortingTest {

    public static void main(String[] args) throws Exception {
        Map<String, Double> map = new TreeMap<String, Double>();
        map.put("KFC", 1.0);
        map.put("WNBA", 3.0);
        map.put("NBA", 4.0);
        map.put("CBA", 2.0);

        Map<String, Double> resultMap = SortMapByValue.sortMapByValue(map); //按Value进行排序

        for (Map.Entry<String, Double> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());

        }
    }
}
