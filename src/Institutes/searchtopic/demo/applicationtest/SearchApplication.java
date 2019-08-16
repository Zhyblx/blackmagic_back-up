package Institutes.searchtopic.demo.applicationtest;

import Institutes.searchtopic.demo.lucene.SearchBuilder;
import Institutes.searchtopic.demo.thesaurus.SearchThesaurus;

import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

/**
 * 类：SearchApplication
 * 作用：结合搜项目一期的规则，完成对搜索结果的校验：
 * 规则：
 * 1.同一个词不会出现在不同的词库中。
 * 2.用户的输入词完全等于词库中的某一个词，那么完全匹配的结果展示第一条，其他的按照业务权重展示。
 * 3.用户的输入词约等于词库中的业务词，那么按照业务权重展示。
 * 4.用户的输入词完全没有匹配到业务词库，那么按照业务权重展示。
 */

public class SearchApplication implements Runnable {
    private final String INDEX_DIR_PATH = "./SearchTest/index";

    @Override
    public void run() {
        try {
            System.out.println("请输入搜索词……");
            Scanner scanner = new Scanner(System.in);
            String query = scanner.nextLine();//输入的关键词
            String thesaurus = SearchThesaurus.getSearchThesaurusMap(query);//查询用户的输入词是否在业务词库中
            System.out.println("对应业务：" + thesaurus);

            List<String> list = new ArrayList<String>();
            list.addAll(SearchBuilder.doSearch(INDEX_DIR_PATH, query));//搜索结果存储list

            Iterator<String> iterator = list.iterator();
            while (iterator.hasNext()) {
                String strQuery = iterator.next();
                //判断用户的输入词是否在业务词库中；如果存在就根据该词所在的业务，按找业务进行输出，否则就直接根据搜索结果进行输出
                if (thesaurus != null && thesaurus.length() != 0) {
                    // 按业务线的输出结果
                    if (strQuery.indexOf(thesaurus) != -1) {
                        System.out.println(strQuery);
                    } else {
                        System.out.println("--------过滤掉--------" + strQuery);//过滤掉不在该业务下的搜索结果

                    }

                } else {
                    System.out.println(strQuery);
                }

            }


        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new SearchApplication()).start();

    }

}
