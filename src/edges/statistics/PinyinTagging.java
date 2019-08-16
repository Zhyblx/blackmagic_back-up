package edges.statistics;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;

import java.util.Iterator;
import java.util.List;

/**
 * 类：PinyinTagging
 * 作用：拼音标注
 * 1.方法：getTaggingQuanPin(String vocabulary) 标注全拼拼音
 * 2.方法：getTaggingSuolue(String vocabulary)  标注缩略拼音
 */

public final class PinyinTagging {
    private static Iterator<Word> iterator = null;
    private static Word word = new Word("");

    /*
     * 返回：拼音全拼
     */
    public static String getTaggingQuanPin(String vocabulary) {
        String strQuanpin = "";
        try {
            List<Word> words = WordSegmenter.segWithStopWords(vocabulary);
            org.apdplat.word.tagging.PinyinTagging.process(words);//拼音标注工具
            iterator = words.iterator();
            while (iterator.hasNext()) {
                String iteratorWord = String.valueOf(iterator.next());
                /*
                 * 获取完整的全拼方法
                 */
                word.setFullPinYin(iteratorWord);
                String str = word.getFullPinYin();
                int numQuanpin = str.lastIndexOf(" ");
                strQuanpin = str.substring(numQuanpin + 1, str.length());

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
        return strQuanpin;

    }

    /*
     * 返回：缩略拼音
     */
    public static String getTaggingSuolue(String vocabulary) {
        String strSuolue = "";
        try {
            List<Word> words = WordSegmenter.segWithStopWords(vocabulary);
            org.apdplat.word.tagging.PinyinTagging.process(words);//拼音标注工具
            iterator = words.iterator();
            while (iterator.hasNext()) {
                String iteratorWord = String.valueOf(iterator.next());
                /*
                 * 获取完整的全拼方法
                 */
                word.setFullPinYin(iteratorWord);
                String str = word.getFullPinYin();
                int numSuolue = str.indexOf(" ");
                strSuolue = str.substring(numSuolue + 1, str.lastIndexOf(" "));

            }
        } catch (Exception e) {
            e.printStackTrace();

        }
        return strSuolue;

    }

    public static void main(String[] args) throws Exception {
        System.out.println(PinyinTagging.getTaggingQuanPin("水杯"));
        System.out.println(PinyinTagging.getTaggingSuolue("水杯"));

    }

}
