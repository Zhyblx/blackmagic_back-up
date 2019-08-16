package edges.analysisjson;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.File;
import java.io.InputStream;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.io.BufferedReader;

/**
 * 类：AnalysisJson
 * 作用：解析json数据
 */
public class AnalysisJson implements Runnable {

    private File file = null;
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;

    @Override
    public void run() {
        try {
            file = new File("/Users/zhangyibin/Documents/环球黑卡工作台/产品项目/基础业务/搜索项目/搜索项目二期/来电词频/一个字");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String strBuffer = "";
            String strJson = "";

            while ((strBuffer = bufferedReader.readLine()) != null) {
                strJson = strJson + strBuffer;

            }

            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

            JSONObject jsonObject = JSONObject.fromObject(strJson);
            JSONArray jsonArray = jsonObject.getJSONArray("buckets");
            for (int i = 0; i < jsonArray.size(); i++) {
                JSONObject strJSONObject = jsonArray.getJSONObject(i);
                System.out.println(strJSONObject.getString("key") + "," + strJSONObject.getString("doc_count"));

            }

        } catch (Exception e) {
            e.printStackTrace();

        }
    }

    public static void main(String[] args) throws Exception {
        new Thread(new AnalysisJson()).start();

    }

}
