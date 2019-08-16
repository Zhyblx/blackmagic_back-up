package toolbox;

import org.oriboy.qrcode.common.QRCodeUtils;

/**
 * 类：QRcodeanalysis
 * 作用：解析二维码
 */
public class QRcodeanalysis {

    public static final String PATH = "/Users/zhangyibin/Downloads/";

    public static void main(String[] args) throws Exception {
        String[] fileName = {"1.png", "2.png", "3.png", "4.png", "5.png", "6.png", "7.png", "8.png"};

        for (String strPNG : fileName) {
            System.out.println(
                    QRCodeUtils.read(PATH + strPNG)
            );
        }

    }

}
