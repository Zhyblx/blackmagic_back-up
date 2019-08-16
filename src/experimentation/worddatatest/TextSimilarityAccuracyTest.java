package experimentation.worddatatest;

import org.apdplat.word.analysis.*;

/**
 * 类：TextSimilarityAccuracyTest
 * 作用：文本相似度的准确性测试
 *
 */
public class TextSimilarityAccuracyTest {

    public static void main(String[] args) {
        String text1 = "移动硬盘";
        String text2 = "硬盘移动";

        TextSimilarity textSimilarity0 = new CosineTextSimilarity();
        double score1pk0 = textSimilarity0.similarScore(text1, text2);// 余弦相似度

        TextSimilarity textSimilarity1 = new SimpleTextSimilarity();
        double score1pk1 = textSimilarity1.similarScore(text1, text2);// 简单共有词

        TextSimilarity textSimilarity2 = new EditDistanceTextSimilarity();
        double score1pk2 = textSimilarity2.similarScore(text1, text2);// 编辑距离

        TextSimilarity textSimilarity3 = new SimHashPlusHammingDistanceTextSimilarity();
        double score1pk3 = textSimilarity3.similarScore(text1, text2);// SimHash + 汉明距离

        TextSimilarity textSimilarity4 = new JaccardTextSimilarity();
        double score1pk4 = textSimilarity4.similarScore(text1, text2);// Jaccard相似性系数

        TextSimilarity textSimilarity5 = new EuclideanDistanceTextSimilarity();
        double score1pk5 = textSimilarity5.similarScore(text1, text2);// 欧几里得距离

        TextSimilarity textSimilarity6 = new ManhattanDistanceTextSimilarity();
        double score1pk6 = textSimilarity6.similarScore(text1, text2); // 曼哈顿距离

        TextSimilarity textSimilarity7 = new JaroDistanceTextSimilarity();
        double score1pk7 = textSimilarity7.similarScore(text1, text2);// Jaro距离

        TextSimilarity textSimilarity8 = new JaroWinklerDistanceTextSimilarity();
        double score1pk8 = textSimilarity8.similarScore(text1, text2);// Jaro–Winkler距离

        TextSimilarity textSimilarity9 = new SørensenDiceCoefficientTextSimilarity();
        double score1pk9 = textSimilarity9.similarScore(text1, text2);// Sørensen–Dice系数

        System.out.println("计算词：" + text1 + "VS" + text2);
        System.out.println("余弦相似度:" + score1pk0);
        System.out.println("简单共有词:" + score1pk1);
        System.out.println("编辑距离:" + score1pk2);
        System.out.println("SimHash + 汉明距离:" + score1pk3);
        System.out.println("Jaccard相似性系数:" + score1pk1);
        System.out.println("欧几里得距离:" + score1pk5);
        System.out.println("曼哈顿距离:" + score1pk6);
        System.out.println("Jaro距离:" + score1pk7);
        System.out.println("Jaro–Winkler距离:" + score1pk8);
        System.out.println("Sørensen–Dice系数:" + score1pk9);

        System.exit(0);

    }


}
