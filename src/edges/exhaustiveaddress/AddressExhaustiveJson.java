package edges.exhaustiveaddress;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 类：AddressExhaustiveJson
 * 作用：解析json文件中的城市名称
 */

public class AddressExhaustiveJson {

    /**
     * 方法：setAddressExhaustiveJson()
     * 作用：读取json文件内容并完成解析工作
     * 场景：飞机票/火车票城市解析
     *
     * @param path
     * @throws Exception
     */

    public static void setAddressExhaustiveJson(String path) throws Exception {
        File file = new File(path);
        InputStream inputStream = new FileInputStream(file);
        InputStreamReader inputStreamReader = new InputStreamReader(inputStream);
        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
        String strTxt = "";
        String strJson = "";
        while ((strTxt = bufferedReader.readLine()) != null) {
            strJson = strJson + strTxt;

        }
        bufferedReader.close();
        inputStreamReader.close();
        inputStream.close();

        JSONArray jsonArray = JSONArray.fromObject(strJson);
        for (int i = 0; i < jsonArray.size(); i++) {
            JSONObject jsonObject = jsonArray.getJSONObject(i);
            /*
             飞机票
             */
//            String shortName = jsonObject.getString("shortName");
//            System.out.println(shortName);

            /*
             火车票
             */
            String stationName=jsonObject.getString("stationName");
            System.out.println(stationName);

        }

    }

    public static void main(String[] args) throws Exception {
        String path = "/Users/zhangyibin/Downloads/火车票城市.json";
        AddressExhaustiveJson.setAddressExhaustiveJson(path);


    }

}
