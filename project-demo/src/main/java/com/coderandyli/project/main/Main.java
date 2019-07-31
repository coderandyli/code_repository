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
        String widthAndHeight = getWidthAndHeight("http://192.168.30.103:8888/group1/M00/00/37/wKgeZ10wFKmAbEoiAD4uYT9rf38103.jpg");
        System.out.println(widthAndHeight);
    }


    /**
     * 获取网络图片的宽和高
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
