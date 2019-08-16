package experimentation.blackmagictest;

import org.apdplat.word.analysis.SimHashPlusHammingDistanceTextSimilarity;
import org.apdplat.word.analysis.TextSimilarity;
import toolbox.mapsort.accordingtovalue.SortMapByValue;

import java.io.*;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

/**
 * 类：BusinessWord
 * 作用：计算输入词的业务隶属关系
 */

public class BusinessWord implements Runnable {

    private Map<String, Double> mapWordScore = new HashMap<String, Double>();// 存储文本相似度的计算结果
    private TextSimilarity textSimilarity = new SimHashPlusHammingDistanceTextSimilarity(); //文本相似度的计算实现
    private File file=null;
    private InputStream inputStream=null;
    private InputStreamReader inputStreamReader=null;
    private BufferedReader bufferedReader=null;

    @Override
    public void run() {
        try {
            System.out.println("输入关键词：");
            Scanner scanner = new Scanner(System.in);
            String inputWord = scanner.next();//存储输入的词汇
            double scorePk = 0.0;// 记录得分

            /*
             * 对输入的每一个词进行基础词库的遍历计算
             */
            file = new File("./vocabulary/BlackMagicVocabulary.txt");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String strWord = "";
            while ((strWord = bufferedReader.readLine()) != null) {
                scorePk = textSimilarity.similarScore(inputWord, strWord);// 获得计算的得分
                mapWordScore.put(strWord, scorePk);// 将基础词汇 和 得分存储到map中

            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            // 对结算结果根据得分进行排序输出
            Map<String, Double> resultMap = SortMapByValue.sortMapByValue(mapWordScore);
            for (Map.Entry<String, Double> m : resultMap.entrySet()) {
                System.out.println("输入词：" + inputWord + "," + VocabularyMap.getVocabularyMap(m.getKey()) + "," + m.getKey() + "," + m.getValue());
            }
            System.exit(0);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new BusinessWord()).start();

    }

}

