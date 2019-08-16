package experimentation.mapsortingtest;

import toolbox.mapsort.accordingtokey.SortMapByKey;

import java.util.Map;
import java.util.TreeMap;

/**
 * 类：MapKeySortingTest
 * 作用：测试Map_Key的排序功能
 *
 */


public class MapKeySortingTest {
    public static void main(String[] args) {

        Map<String, String> map = new TreeMap<String, String>();

        map.put("1", "kfc");
        map.put("3", "wnba");
        map.put("2", "nba");
        map.put("4", "cba");

        Map<String, String> resultMap = SortMapByKey.sortMapByKey(map);    //按Key进行排序

        for (Map.Entry<String, String> entry : resultMap.entrySet()) {
            System.out.println(entry.getKey() + " " + entry.getValue());
        }
    }
}
