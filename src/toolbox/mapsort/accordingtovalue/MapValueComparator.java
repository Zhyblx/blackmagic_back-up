package toolbox.mapsort.accordingtovalue;

import java.util.Comparator;
import java.util.Map;

/**
 * 类：MapValueComparator
 * 作用：map_Value 比较器
 *
 */
public final class MapValueComparator implements Comparator<Map.Entry<String, Double>> {

    @Override
    public int compare(Map.Entry<String, Double> o1, Map.Entry<String, Double> o2) {
        return o1.getValue().compareTo(o2.getValue());

    }
}


