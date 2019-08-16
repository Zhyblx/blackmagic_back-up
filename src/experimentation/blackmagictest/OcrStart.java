package experimentation.blackmagictest;

import toolbox.Ocr;

/**
 * 类：OcrStart
 * 作用：图片识别文字的应用
 */
public class OcrStart {

    public static void main(String[] args) {
        try {
            Ocr.getOcrRun("/Users/zhangyibin/Downloads/1.png");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
