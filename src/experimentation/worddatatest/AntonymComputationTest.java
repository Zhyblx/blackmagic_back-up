package experimentation.worddatatest;

import org.apdplat.word.WordSegmenter;
import org.apdplat.word.segmentation.Word;
import org.apdplat.word.tagging.AntonymTagging;
import java.util.List;

/**
 * 类：AntonymComputationTest
 * 作用：反义词计算测试
 *
 */

public class AntonymComputationTest {
    public static void main(String[] args) throws Exception {

        List<Word> words = WordSegmenter.segWithStopWords("甜");
        AntonymTagging.process(words);

        System.out.println(words);
        System.out.println(AntonymTagging.process("甜"));
        System.exit(0);

    }

}
