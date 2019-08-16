package experimentation.blackmagictest;

/**
 * 类：DataReport(数据报告)
 * 作用：
 * 解决19年1月31日，所需的三点数据。
 * 1.对新闻日报的图片数据进行分词。
 * 2.关注环黑商品的商品销售情况。
 * 3.关注轻古集市的商品销售情况。
 */

import Institutes.changefilename.Kernel.DiskScan;
import org.apdplat.word.WordFrequencyStatistics;
import org.apdplat.word.segmentation.SegmentationAlgorithm;
import toolbox.Ocr;

import java.io.File;
import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;


public class DataReport {

    /*
     * 方法：getReadFileName()
     * 作用：读取文件名称
     *
     */
    public static final void getReadFileName(String filePath) {
        try {
            File file = new File(filePath);
            DiskScan.getFileName(file);
            System.out.println(DiskScan.getFileName(file));

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    /*
     * 方法：getNewsFileOcrRun()
     * 作用：完成对新闻图片的文字转化
     *
     */
    public static final void getNewsFileOcrRun() {
        try {
            String strPath = "/Users/zhangyibin/Downloads/news/";
            String[] strFileName = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png", "9.png", "10.png"
                    , "11.png", "12.png", "13.png", "14.png", "15.png", "16.png", "17.png", "18.png", "19.png", "20.png",
                    "21.png", "22.png", "23.png", "24.png", "25.png", "26.png", "27.png"};

            File file = new File("/Users/zhangyibin/Downloads/NewsFile.txt");
            OutputStream outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);
            for (String strName : strFileName) {
                System.out.println(strName);
                bufferedWriter.write(Ocr.getOcrRun(strPath + strName));
            }

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    /*
     * 方法：getNewsRun()
     * 作用：完成对新闻的内容分词
     *
     */

    public static final void getNewsRun() {
        try {
            File file = new File("/Users/zhangyibin/Downloads/news/NewsFile.txt");
            InputStream inputStream = new FileInputStream(file);
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String strFile = "";
            String strCommit="";
            while ((strFile = bufferedReader.readLine()) != null) {
//                System.out.println(strFile);
                strCommit=strCommit+strFile;
            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();
            System.out.println(strCommit);

            //词频统计
            WordFrequencyStatistics wordFrequencyStatistics = new WordFrequencyStatistics();
            wordFrequencyStatistics.setRemoveStopWord(false);
            wordFrequencyStatistics.setResultPath("word-frequency-statistics.txt");
            wordFrequencyStatistics.setSegmentationAlgorithm(SegmentationAlgorithm.MaxNgramScore);
            //清除之前的统计结果
            wordFrequencyStatistics.reset();
            //开始分词
            wordFrequencyStatistics.seg(strCommit);
            //输出词频统计结果
            wordFrequencyStatistics.dump();

        } catch (Exception e) {
            e.printStackTrace();

        }
    }


    public static void main(String[] args) {
//        DataReport.getReadFileName("/Users/zhangyibin/Downloads/news");// 读取文件名
//        DataReport.getNewsFileOcrRun();//新闻图片的文字转化
        DataReport.getNewsRun();//新闻内容分词

    }


}
