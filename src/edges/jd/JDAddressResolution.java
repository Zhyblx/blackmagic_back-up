package edges.jd;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

/**
 * 类：JDAddressResolution
 * 作用：解析京东地址列表
 */
public class JDAddressResolution {

    private File file = null;
    private InputStream inputStream = null;
    private InputStreamReader inputStreamReader = null;
    private BufferedReader bufferedReader = null;

    /*
     * 将京东的地址列表，根据省的维度进行Json数据拆分
     * 结果：存储到本地文件
     */
    public void getJDAddressJSONObject() {
        try {

            file = new File("/Users/zhangyibin/Downloads/jd.json");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String strJson = "";
            while ((strJson = bufferedReader.readLine()) != null) {
                JSONArray jsonArray = JSONArray.fromObject(strJson);

                for (int a = 0; a < jsonArray.size(); a++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(a);
                    String strAddressJson = jsonObject.toString();
                    System.out.println(strAddressJson);
                    File file = new File("/Users/zhangyibin/Downloads/str.txt");
                    OutputStream outputStream = new FileOutputStream(file , true);
                    OutputStreamWriter outputStreamWriter = new OutputStreamWriter(outputStream);
                    BufferedWriter bufferedWriter = new BufferedWriter(outputStreamWriter);

                    bufferedWriter.write(strAddressJson + "\r\n");

                    bufferedWriter.close();
                    outputStreamWriter.close();
                    outputStream.close();

                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 将京东的地址列表，根据省的维度进行Json数据拆分
     * 结果：存到List中返回
     */

    public List<String> getJDAddressJSONObject(String path) {
        List<String> list = new ArrayList<String>();

        try {

            file = new File(path);
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String strJson = "";
            while ((strJson = bufferedReader.readLine()) != null) {
                JSONArray jsonArray = JSONArray.fromObject(strJson);

                for (int a = 0; a < jsonArray.size(); a++) {
                    JSONObject jsonObject = jsonArray.getJSONObject(a);
                    String strAddressJson = jsonObject.toString();
//                    System.out.println(strAddressJson);
                    list.add(strAddressJson);

                }
            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }

        return list;

    }

    /*
     * 根据getJDAddressJSONObject()方法提供的省维度Json数据，进行地址分级。目前京东最多可划分到4级地址。
     * 处理本地数据
     */

    public void getAddressList() {

        String name1 = ""; //一级地址
        String name2 = ""; //二级地址
        String name3 = ""; //三级地址
        String name4 = ""; //四级地址

        try {

            file = new File("/Users/zhangyibin/Downloads/str.txt");
            inputStream = new FileInputStream(file);
            inputStreamReader = new InputStreamReader(inputStream);
            bufferedReader = new BufferedReader(inputStreamReader);
            String strTxt = "";
            while ((strTxt = bufferedReader.readLine()) != null) {
                JSONObject jsonObject = JSONObject.fromObject(strTxt);

                JSONObject jsonObjectProvince = JSONObject.fromObject(jsonObject.toString());//省(/直辖市)
                name1 = (String) jsonObjectProvince.get("name");//省(/直辖市)

                if (jsonObject.toString().indexOf("child") != -1) {
                    JSONArray jsonArrayCity = jsonObject.getJSONArray("child");

                    for (int i = 0; i < jsonArrayCity.size(); i++) {
                        JSONObject jsonObjectCity = jsonArrayCity.getJSONObject(i);
                        name2 = jsonObjectCity.getString("name");// 市

                        if (jsonObjectCity.toString().indexOf("child") != -1) {
                            JSONArray jsonArrayDistrict = jsonObjectCity.getJSONArray("child");
                            for (int j = 0; j < jsonArrayDistrict.size(); j++) {
                                JSONObject jsonObjectjsonArrayDistrict = jsonArrayDistrict.getJSONObject(j);
                                name3 = jsonObjectjsonArrayDistrict.getString("name"); //区县

                                if (jsonObjectjsonArrayDistrict.toString().indexOf("child") != -1) {
                                    JSONArray jsonArrayTownship = jsonObjectjsonArrayDistrict.getJSONArray("child");
                                    for (int x = 0; x < jsonArrayTownship.size(); x++) {
                                        JSONObject jsonObjectTownship = jsonArrayTownship.getJSONObject(x);
                                        name4 = jsonObjectTownship.getString("name"); // 乡镇
                                        System.out.println(name1 + "," + name2 + "," + name3 + "," + name4);

                                    }

                                } else {
                                    System.out.println(name1 + "," + name2 + "," + name3);

                                }

                            }
                        }

                    }

                }


            }
            bufferedReader.close();
            inputStreamReader.close();
            inputStream.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /*
     * 根据getJDAddressJSONObject()方法提供的省维度Json数据，进行地址分级。目前京东最多可划分到4级地址。
     * 处理List数据
     */
    public void getAddressList(List<String> list) {

        List<String> strJsonList = new ArrayList<String>();

        String name1 = ""; //一级地址
        String name2 = ""; //二级地址
        String name3 = ""; //三级地址
        String name4 = ""; //四级地址

        try {

            strJsonList = list;

            for (int y = 0; y < strJsonList.size(); y++) {
                String strTxt = strJsonList.get(y);
                JSONObject jsonObject = JSONObject.fromObject(strTxt);

                JSONObject jsonObjectProvince = JSONObject.fromObject(jsonObject.toString());//省(/直辖市)
                name1 = (String) jsonObjectProvince.get("name");//省(/直辖市)

                if (jsonObject.toString().indexOf("child") != -1) {
                    JSONArray jsonArrayCity = jsonObject.getJSONArray("child");

                    for (int i = 0; i < jsonArrayCity.size(); i++) {
                        JSONObject jsonObjectCity = jsonArrayCity.getJSONObject(i);
                        name2 = jsonObjectCity.getString("name");// 市

                        if (jsonObjectCity.toString().indexOf("child") != -1) {
                            JSONArray jsonArrayDistrict = jsonObjectCity.getJSONArray("child");
                            for (int j = 0; j < jsonArrayDistrict.size(); j++) {
                                JSONObject jsonObjectjsonArrayDistrict = jsonArrayDistrict.getJSONObject(j);
                                name3 = jsonObjectjsonArrayDistrict.getString("name"); //区县

                                if (jsonObjectjsonArrayDistrict.toString().indexOf("child") != -1) {
                                    JSONArray jsonArrayTownship = jsonObjectjsonArrayDistrict.getJSONArray("child");
                                    for (int x = 0; x < jsonArrayTownship.size(); x++) {
                                        JSONObject jsonObjectTownship = jsonArrayTownship.getJSONObject(x);
                                        name4 = jsonObjectTownship.getString("name"); // 乡镇
                                        System.out.println(name1 + "," + name2 + "," + name3 + "," + name4);

                                    }

                                } else {
                                    System.out.println(name1 + "," + name2 + "," + name3);

                                }

                            }
                        }

                    }

                }


            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) throws Exception {

//        new JDAddressResolution().getAddressList();
//        System.out.println(new JDAddressResolution().getJDAddressJSONObject("/Users/zhangyibin/Downloads/jd.json"));
//        new JDAddressResolution().getJDAddressJSONObject("/Users/zhangyibin/Downloads/jd.json");

        // 不需要分文件，直接通过list处理京东地址原文件
        List<String> list = new ArrayList<String>();
        list.addAll(new JDAddressResolution().getJDAddressJSONObject("/Users/zhangyibin/Documents/环球黑卡工作台/Bug项目/地址匹配错误/jd.json"));
        new JDAddressResolution().getAddressList(list);


    }

}
