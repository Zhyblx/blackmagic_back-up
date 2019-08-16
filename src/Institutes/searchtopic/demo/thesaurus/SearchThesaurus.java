package Institutes.searchtopic.demo.thesaurus;

import java.util.Map;
import java.util.HashMap;

/**
 * 类：SearchThesaurus
 * 作用：定义搜索词库
 */
public class SearchThesaurus {

    private static Map<String, String> map = new HashMap<String, String>();

    public static String getSearchThesaurusMap(String key) throws Exception {
        map.put("如家", "酒店");
        map.put("维也纳", "酒店");
        map.put("汉庭", "酒店");
        map.put("全季", "酒店");
        map.put("希尔顿", "酒店");
        map.put("亚朵", "酒店");
        map.put("万达", "酒店");
        map.put("民宿", "酒店");
        map.put("格林豪泰", "酒店");
        map.put("喜来登", "酒店");
        map.put("上海迪士尼", "景点");
        map.put("温泉", "景点");
        map.put("青秀山", "景点");
        map.put("宋城", "景点");
        map.put("雷峰塔", "景点");
        map.put("西湖", "景点");
        map.put("塘栖", "景点");
        map.put("灵隐寺", "景点");
        map.put("黄山", "景点");
        map.put("动物园", "景点");
        map.put("手机", "电商");
        map.put("iPhone新品", "电商");
        map.put("手表", "电商");
        map.put("耳机", "电商");
        map.put("项链", "电商");
        map.put("表", "电商");
        map.put("充电宝", "电商");
        map.put("纸巾", "电商");
        map.put("内裤", "电商");
        map.put("口红", "电商");
        return map.get(key);

    }

    public static void main(String[] args) throws Exception {
        System.out.println(
                SearchThesaurus.getSearchThesaurusMap("手机")

        );


    }

}
