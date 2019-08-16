package experimentation.worddatatest;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.tagging.PinyinTagging;

import java.util.List;
import java.util.Iterator;

import java.util.Scanner;

/**
 * 类：PinyinTaggingTest
 * 测试：测试标注拼音
 */

public class PinyinTaggingTest {

    private static Word word = new Word("");
    private static Scanner scanner = null;
    private static Iterator<Word> iterator = null;

    public static void main(String[] args) throws Exception {
        try {
            System.out.println("请输入词汇……");
            scanner = new Scanner(System.in);
            String vocabulary = scanner.next();//词汇
            List<Word> words = WordSegmenter.segWithStopWords(vocabulary);
            PinyinTagging.process(words);//拼音标注工具

            System.out.println(words);
//            System.out.println(vocabulary);

            iterator = words.iterator();
            while (iterator.hasNext()) {
                String iteratorWord = String.valueOf(iterator.next());
                /*
                 * 获取完整的全拼方法
                 */
                word.setFullPinYin(iteratorWord);
                String str = word.getFullPinYin();
                int numQuanpin = str.lastIndexOf(" ");
                System.out.println(str.substring(numQuanpin + 1, str.length()));

                /*
                 *获取首字母的缩略拼音方法
                 */
                int numSuolue = str.indexOf(" ");
                System.out.println(str.substring(numSuolue + 1, numQuanpin));

                /*
                 * 词汇
                 */
                System.out.println(str.substring(0, numSuolue));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }
}
