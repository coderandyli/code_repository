package com.coderandyli.nio;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.Selector;

/**
 * Created by lizhen on 2019-12-04
 *
 * 待学习
 *
 * 参考
 * https://www.cnblogs.com/dolphin0520/p/3919162.html
 * https://mp.weixin.qq.com/s?__biz=Mzg2OTA0Njk0OA==&mid=2247484951&amp;idx=1&amp;sn=0cef67df4b883b198da467c927533316&source=41#wechat_redirect
 * http://tutorials.jenkov.com/java-nio/overview.html
 */
public class Main {
    public static void main(String args[]) throws IOException {
        test_01();
    }

    /**
     * a basic example that users FileChannel to write some data from a Buffer into a Channel
     * @throws IOException
     */
    public static void test_01() throws IOException {
        RandomAccessFile file = new RandomAccessFile("/Users/lizhen/Desktop/data.txt", "rw");
        // FileOutputStream outputStream = new FileOutputStream(file);
        FileChannel channel = file.getChannel();
        ByteBuffer buf = ByteBuffer.allocate(48);
        String str = "java nio";
        buf.put(str.getBytes());
        buf.flip(); //此处必须要调用buffer的flip方法
        channel.write(buf);
        channel.close();
        file.close();
    }

    /**
     * a basic example that uses a FileChannel to read some data into a Buffer:
     * @throws IOException
     */
    public static void test_02() throws IOException {
        RandomAccessFile aFile = new RandomAccessFile("/Users/lizhen/Desktop/data.txt", "rw");
        FileChannel channel = aFile.getChannel();

        ByteBuffer buf = ByteBuffer.allocate(48);
        int bytesRead = channel.read(buf);
        while (bytesRead != -1) {
            System.out.println("Read " + bytesRead);
            buf.flip();

            while(buf.hasRemaining()){
                System.out.print((char) buf.get());
            }

            buf.clear();
            bytesRead = channel.read(buf);
        }
        aFile.close();
    }
}
