package edges.statistics;

import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.segmentation.SegmentationAlgorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 类：lexicostatistics
 * 作用：统计文档中的词汇量
 */

public class lexicostatistics {

    private static File file = null;
    private static InputStream inputStream = null;
    private static InputStreamReader inputStreamReader = null;
    private static BufferedReader bufferedReader = null;

    private static Runnable runnable = new Runnable() {
        @Override
        public void run() {
            String strTxt = "";
            try {

                file = new File("/Users/zhangyibin/Downloads/演讲稿.txt");
                inputStream = new FileInputStream(file);
                inputStreamReader = new InputStreamReader(inputStream);
                bufferedReader = new BufferedReader(inputStreamReader);
                String strCom = "";
                while ((strCom = bufferedReader.readLine()) != null) {

                    strTxt = strTxt + strCom;

                }
                bufferedReader.close();
                inputStreamReader.close();
                inputStream.close();
                System.out.println(strTxt);

                //词频统计设置
                WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
                wordFrequencyStatistics.setRemoveStopWord(false);
                wordFrequencyStatistics.setResultPath("word-frequency-statistics.txt");
                wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaxNgramScore);
                //开始分词
                wordFrequencyStatistics.seg(strTxt);
                //输出词频统计结果
                wordFrequencyStatistics.dump();

                //清除之前的统计结果
                wordFrequencyStatistics.reset();

                //输出词频统计结果
                wordFrequencyStatistics.dump("file-seg-statistics-result.txt");

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    };

    public static void main(String[] args) throws Exception {
        new Thread(runnable).start();

    }
}
