package toolbox;


import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * 类：MD5Util
 * 作用：对参数字符"strTxt"串进行MD5加密
 */

public final class MD5Util {

    public static String setMD5(String strTxt) {
        byte[] secretBytes = null;
        try {
            secretBytes = MessageDigest.getInstance("md5").digest(strTxt.getBytes());
        } catch (NoSuchAlgorithmException e) {
            throw new RuntimeException("没有这个md5算法！");
        }
        String md5code = new BigInteger(1 , secretBytes).toString(16);
        for (int i = 0; i < 32 - md5code.length(); i++) {
            md5code = "0" + md5code;
        }
        return md5code;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(MD5Util.setMD5("123"));
    }

}
