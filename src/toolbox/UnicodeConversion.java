package toolbox;

/**
 * 类：UnicodeConversion
 * 作用：对Unicode编码进行字符转化。
 *
 */

public class UnicodeConversion {

    /*
     * unicode编码转中文
     */
    public static String getdecodeUnicode(String unicodeData) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();

        while (start > -1) {
            end = unicodeData.indexOf("\\u" , start + 2);
            String charStr = "";

            if (end == -1) {
                charStr = unicodeData.substring(start + 2 , unicodeData.length());

            } else {
                charStr = unicodeData.substring(start + 2 , end);

            }
            char letter = (char) Integer.parseInt(charStr , 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter).toString());
            start = end;

        }
        return buffer.toString();

    }

    /*
     * 中文转unicode编码
     */
    public static String getgbEncoding(String stringData) {
        char[] utfBytes = stringData.toCharArray();
        String unicodeBytes = "";
        for (int i = 0; i < utfBytes.length; i++) {
            String hexB = Integer.toHexString(utfBytes[i]);
            if (hexB.length() <= 2) {
                hexB = "00" + hexB;

            }
            unicodeBytes = unicodeBytes + "\\u" + hexB;

        }
        return unicodeBytes;

    }


    public static void main(String[] args) throws Exception {
        System.out.println(UnicodeConversion.getdecodeUnicode("\\u60a8\\u53ef"));
        System.out.println(UnicodeConversion.getdecodeUnicode("Notice that URL encode"));
        System.out.println(UnicodeConversion.getgbEncoding("Notice that URL encode"));


    }


}
