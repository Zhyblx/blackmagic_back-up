package experimentation.blackmagictest;

import org.apdplat.word.analysis.SimHashPlusHammingDistanceTextSimilarity;
import org.apdplat.word.analysis.TextSimilarity;
import toolbox.mapsort.accordingtovalue.SortMapByValue;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 类：BusinessWordSort
 * 作用：计算(电商)商品标题的分词结果与基础词库的文本相似度，遍历过程(分词)词汇划分在分最高的(基础)词汇所属业务
 *
 */

public class BusinessWordSort {

    private static File file1 = null;
    private static File file2=null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            try {

                // 文本相似的算法实现
                TextSimilarity textSimilarity = new SimHashPlusHammingDistanceTextSimilarity();

                // 将分词结果放入到list1 中
                List<String> list1 = new ArrayList<String>();
                file1 = new File("/Users/zhangyibin/Documents/环球黑卡工作台/产品项目/基础业务/搜索项目/搜索项目二期/Top2000的词汇对比/7");
                inputStream = new FileInputStream(file1);
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String str1 = "";
                while ((str1 = bufferedReader.readLine()) != null) {
                    list1.add(str1);

                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                // 将基础词库中的词汇放到list2 中
                List<String> list2 = new ArrayList<String>();
                file2 = new File("./vocabulary/BlackMagicVocabulary.txt");//基础词库地址
                inputStream = new FileInputStream(file2);
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String str2 = "";
                while ((str2 = bufferedReader.readLine()) != null) {
                    list2.add(str2);

                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();

                //System.out.println(list1);
                //System.out.println(list2);

                /*
                 * 遍历list1中的词；实现将list1 中的词汇和 list2中的词汇逐一的做一次文本相似度计算
                 *
                 */
                for (int i = 0; i < list1.size(); i++) {
                    Map<String, Double> mapWordScore = new HashMap<String, Double>();// 存放计算结果：即，输入词和基础词的文本相似度分值。
                    Map<String, Double> resultMap = null;// 存放map排序后的计算结果
                    String inputWord = list1.get(i);
                    double scorePk = 0.0;// 计算的结果得分
                    String strWord = "";// 计算的结果词汇

                    for (int j = 0; j < list2.size(); j++) {
                        strWord = list2.get(j);
                        scorePk = textSimilarity.similarScore(inputWord, strWord);// 对输入词和基础词进行文本相似度的计算
                        mapWordScore.put(strWord, scorePk);// 将计算结果存放到mapWordScore(map)中
//                        System.out.println(mapWordScore);

                    }
                    resultMap = SortMapByValue.sortMapByValue(mapWordScore);// 对计算结果进行排序
//                    System.out.println(resultMap);

                    String resultValue = "";//用于输出最后一个值(即,得分最高的值)
                    for (Map.Entry<String, Double> m : resultMap.entrySet()) {
                        // 通过替换结果得到最后一个元素(即，获得文本相似度分值最高的词汇)
                        resultValue = inputWord + "," + VocabularyMap.getVocabularyMap(m.getKey()) + "," + m.getKey() + "," + m.getValue();

                    }

                    System.out.println(resultValue);

                    resultMap.clear();
                    mapWordScore.clear();

                }
                System.exit(0);

            } catch (Exception e) {
                e.printStackTrace();

            }
        }
    };

    public static void main(String[] args) throws Exception {
        new Thread(runnable).start();

    }

}