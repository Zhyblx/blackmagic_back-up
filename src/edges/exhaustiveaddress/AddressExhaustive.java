package edges.exhaustiveaddress;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

import java.util.ArrayList;
import java.util.List;

import java.io.OutputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.BufferedWriter;

/**
 * 类：AddressExhaustive
 * 作用：针对城市列表进行穷举
 * 例如：文件中存在三个城市北京、杭州、上海，那么可穷举出的列表有6种情况：
 * 1.北京——杭州
 * 2.北京——上海
 * 3.杭州——上海
 * 4.杭州——北京
 * 5.上海——北京
 * 6.上海——杭州
 */

public class AddressExhaustive {

    /**
     * 方法：setCityName()
     * 作用：实现从A到B的词汇输出
     * 案例：
     *
     * @param CityA
     * @param CityB
     * @return CityA 到 CityB
     */
    private String setCityName(String CityA, String CityB) {
        String searchWord = CityA + "到" + CityB;
        return searchWord;

    }

    /**
     * 方法：getCityName()
     * 作用：循环穷举,同时输出词汇输出
     */
    public void getCityName() throws Exception {
        File file = new File(this.outputPath);
        OutputStream outputStream = new FileOutputStream(file, true);
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
        BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

        String[] cityName = setArray();
        for (int i = 0; i < cityName.length; i++) {
            for (int j = 0; j < cityName.length; j++) {
                if (i != j) {
                    bufferedWriter.write(setCityName(cityName[i], cityName[j]) + "\r\n");
                    System.out.println(
                            setCityName(cityName[i], cityName[j])
                    );
                }
            }
        }
        bufferedWriter.close();
        outputStreamWriter.close();
        outputStream.close();

    }

    /**
     * 方法：setArray()
     * 作用：实现将文件转化为数组
     *
     * @return
     * @throws Exception
     */
    private String[] setArray() throws Exception {
        List<String> list = new ArrayList<String>();

        File file = new File(this.readPath);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String strTxt = "";
        while ((strTxt = bufferedReader.readLine()) != null) {
            list.add(strTxt);
        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        String[] arr = (String[]) list.toArray(new String[list.size()]);

        return arr;
    }

    private String readPath = ""; // 作用于读取文件地址
    private String outputPath = ""; // 作用于输出文件地址

    public AddressExhaustive(String readPath, String outputPath) {
        this.readPath = readPath;
        this.outputPath = outputPath;


    }
}
