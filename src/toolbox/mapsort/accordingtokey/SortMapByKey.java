package toolbox.mapsort.accordingtokey;

import java.util.Map;
import java.util.TreeMap;

/**
 * 类:SortMapByKey
 * 作用：map集合可以根据Key值的大小进行排序输出
 *
 */

public class SortMapByKey {

    public static Map<String, String> sortMapByKey(Map<String, String> map) {
        if (map == null || map.isEmpty()) {
            return null;
        }

        Map<String, String> sortMap = new TreeMap<String, String>(
                new MapKeyComparator());

        sortMap.putAll(map);

        return sortMap;

    }

}
