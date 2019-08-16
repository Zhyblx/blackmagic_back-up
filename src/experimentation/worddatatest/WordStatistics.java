package experimentation.worddatatest;

import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.segmentation.SegmentationAlgorithm;

import java.io.File;

/**
 * 类：WordStatistics 作用：词频统计
 */

public class WordStatistics implements Runnable {

    @Override
    public void run() {
        try {
            File file = new File("/Users/zhangyibin/Downloads/物流.txt");
            String strData = WordsClassification.setTxtName(file);
//            System.out.println(strData);

//        词频统计
        WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
        wordFrequencyStatistics.setRemoveStopWord(false);
        wordFrequencyStatistics.setResultPath("word-frequency-statistics.txt");
        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaxNgramScore);
//        清除之前的统计结果
        wordFrequencyStatistics.reset();
//        开始分词
        wordFrequencyStatistics.seg(strData);
//        输出词频统计结果
        wordFrequencyStatistics.dump();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new WordStatistics()).start();

    }

}