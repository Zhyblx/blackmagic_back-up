package toolbox.mapsort.accordingtokey;

import java.util.Comparator;
/**
 * 类：MapKeyComparator
 * 作用：map_Key 比较器
 *
 */
public class MapKeyComparator implements Comparator<String> {

    @Override
    public int compare(String str1, String str2) {
        return str1.compareTo(str2);

    }

}
