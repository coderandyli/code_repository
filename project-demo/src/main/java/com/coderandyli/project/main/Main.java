package com.coderandyli.project.main;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;

/**
 * Created by lizhen on 2019-07-31
 */
public class Main {

    public static void main(String args[]) {
        String widthAndHeight = getWidthAndHeight("http://storage.e-ports.com/group1/M00/00/3B/wKgeZ11aN_iACzg1AAVYRSn_sQ0344.jpg");
        System.out.println(widthAndHeight);
        //test01();
    }

    public static void test01() {
//        EWAHCompressedBitmap ewahBitmap1 = EWAHCompressedBitmap.bitmapOf(0, 2, 55, 64, 1 << 30);
//        System.out.println(ewahBitmap1);
    }

    /**
     * 获取网络图片的宽和高
     *
     * @param url
     * @return
     */
    public static String getWidthAndHeight(String url) {
        try {
            InputStream is = new URL(url).openStream();
            BufferedImage sourceImg = ImageIO.read(is);
            int width = sourceImg.getWidth();
            int height = sourceImg.getHeight();
            return width + "*" + height;
        } catch (IOException e) {
//            log.error("获取图片宽高失败");
            e.printStackTrace();
        }
        return "";
    }


}
