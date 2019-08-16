package toolbox;

/**
 * 类：characterstatistics
 * 作用：统计一个字符在一段字符串中的出现次数
 *
 */

public class CharacterStatistics {

    /* 参数说明：
     * inputStrintCharacter:字符串
     * inputCharacter:字符
     */
    public static String getCharacterStatistics(String inputStrintCharacter, String inputCharacter) {
        String retrurnData = "";
        try {

            int count = 0;
            int start = 0;
            while (inputStrintCharacter.indexOf(inputCharacter, start) >= 0 && start < inputStrintCharacter.length()) {
                count++;
                start = inputStrintCharacter.indexOf(inputCharacter, start) + inputCharacter.length();
            }
            System.out.println(inputCharacter +"," + count);
            retrurnData=inputCharacter +"," + count;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return retrurnData;

    }

    public static void main(String[] args) throws Exception {
//        CharacterStatistics.getCharacterStatistics("希望尽快开通全球的机票","机票");

        String txt="手机-项链-手表-表-耳机-vip-充电宝-电脑-内裤-手机壳-手机-月饼-手表-iPhone新品-耳机-表-项链-苹果手机-充电宝-电脑-iPhone新品-手机-手表-耳机-鞋-项链-表-口红-充电宝-包-iPhone新品-手机-手表-纸巾-耳机-纸-项链-充电宝-鞋-内裤-iPhone新品-手机-耳机-手表-纸-电脑-iPhone-充电宝-项链-口红";
        String[] query={"手机","项链","手表","表","耳机","vip","充电宝","电脑","内裤","手机壳","月饼","iPhone新品","苹果手机","鞋","口红","包","纸巾","纸","iPhone"};
        for(String str:query){
            CharacterStatistics.getCharacterStatistics(txt,str);
        }



    }


}
