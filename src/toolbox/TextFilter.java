package toolbox;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * 类：TextFilter
 * 作用：进行文字过滤
 */

public final class TextFilter {

    private static final String[] DELETEVOCABULARY = {
            "管家", "区", "卡", "雪", "谷", "会", "所", "查", "进", "园"
            , "院", "地", "分", "期", "城", "保险", "理", "公", "寓", "门"
            , "票", "派对", "贷", "团", "vip", "湾", "签", "景"
            , "信", "厅", "机场", "温", "浴", "密码", "县", "镇", "体育馆", "汽车站"
            , "附近"};

    private static final String[] HOTELVOCABULARY = {"酒店", "宾馆", "民宿", "名宿",
            "套房", "希尔顿", "饭店", "喜来登", "香格里拉", "皇冠假日", "钟点房", "如家", "汉庭","旅馆"};
    private static final String[] TOURVOCABULARY = {"旅游", "长隆", "方特", "山",
            "博物馆", "艺术馆", "山庄", "灵隐寺", "千古情", "布达拉宫", "故宫", "栈道", "茶马古道"};

    public static boolean textFilter(String text) {

        /*
         * token的作用：
         * 如果词汇进入删除词库，那么该词汇将不会在进入"酒店"、"景点"两个词库中进行计算。这里的计算逻辑是：删除词库>酒店词库>景点词库
         *
         */
        boolean token = false;

        if (token == false) {
            for (String delvoc : DELETEVOCABULARY) {
                // 判断delvoc词汇与删除词库的数组元素匹配到就进行记录，并且跳出循环不在与其它数组元素进行匹配，而是直接拿下一个delvoc词汇进行计算。
                if (text.indexOf(delvoc) != -1) {
                    //System.out.println(delvoc + "," + text);
                    writeFile("/Users/zhangyibin/Downloads/删除.txt", text);
                    token = true;
                    break;

                }
            }
        }

        if (token == false) {
            for (String hotelvoc : HOTELVOCABULARY) {
                // 判断hotelvoc词汇与酒店词库的数组元素匹配到就进行记录，并且跳出循环不在与其它数组元素进行匹配，而是直接拿下一个hotelvoc词汇进行计算。
                if (text.indexOf(hotelvoc) != -1) {
                    //System.out.println(hotelvoc + "," + text);
                    writeFile("/Users/zhangyibin/Downloads/酒店.txt", text);
                    token = true;
                    break;

                }
            }
        }

        if (token == false) {
            for (String tourvoc : TOURVOCABULARY) {
                // 判断tourvoc词汇与景点词库的数组元素匹配到就进行记录，并且跳出循环不在与其它数组元素进行匹配，而是直接拿下一个tourvoc词汇进行计算。
                if (text.indexOf(tourvoc) != -1) {
                    //System.out.println(tourvoc + "," + text);
                    writeFile("/Users/zhangyibin/Downloads/景点.txt", text);
                    token = true;
                    break;

                }
            }
        }
        return token;

    }

    private static void writeFile(String path, String text) {
        try {
            File file = new File(path);
            OutputStream outputStream = new FileOutputStream(file, true);
            OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
            BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

            bufferedWriter.write(text);

            bufferedWriter.close();
            outputStreamWriter.close();
            outputStream.close();

        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    public static void main(String[] args) throws Exception {

//        File file = new File("/Users/zhangyibin/Downloads/test.txt");
//        InputStream inputStream = new FileInputStream(file);
//        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
//        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//        String strTxt = "";
//        while ((strTxt = bufferedReader.readLine()) != null) {
//            TextFilter.textFilter(strTxt);
//
//        }
//
//        bufferedReader.close();
//        inputStreamReader.close();
//        inputStream.close();


    }

}
