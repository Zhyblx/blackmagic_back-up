package experimentation.worddatatest;

import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.segmentation.SegmentationAlgorithm;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

public class WordsClassification {

    public static String setTxtName(File file) {
        String dataText = "";
        try {
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String strTxt = "";
            while ((strTxt = bufferedReader.readLine()) != null) {
                dataText = dataText + strTxt + "\r\n";
//                System.out.println(strTxt);

            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return dataText;
    }


    public static String setTxtName1(File file) {
        String dataText = "";
        String[] strWord = {"6.4", "六四", "89年", "天安门", "学生潮", "自由", "民主", "国家", "习近平", "习大大", "习大", "习主席", "霸权", "事件", "强权", "共产党"};
        try {
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String strTxt = "";
            while ((strTxt = bufferedReader.readLine()) != null) {
                for (String str : strWord) {
//                    System.out.println(strTxt);
//                    System.out.println(str);
                    if (strTxt.indexOf(str) != -1) {
                        System.out.println(str + ":::" + strTxt);
                    }
                }

            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
        return dataText;
    }

//    public static void main(String[] args) throws Exception {
//        File file=new File("/Users/zhangyibin/Downloads/评论.txt");
//
//        String strData=WordsClassification.setTxtName(file);
//        System.out.println(strData);
//
//        词频统计
//        WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
//        wordFrequencyStatistics.setRemoveStopWord(false);
//        wordFrequencyStatistics.setResultPath("word-frequency-statistics.txt");
//        wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaxNgramScore);
//        清除之前的统计结果
//        wordFrequencyStatistics.reset();
//        开始分词
//        wordFrequencyStatistics.seg(strData);
//        输出词频统计结果
//        wordFrequencyStatistics.dump();
//
//
//    }


    public static void main(String[] args) {
        try {
            File file = new File("/Users/zhangyibin/Downloads/3月.csv");

            WordsClassification.setTxtName1(file);


        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
