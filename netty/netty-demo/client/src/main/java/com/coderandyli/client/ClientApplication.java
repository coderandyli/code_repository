package com.coderandyli.client;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * 参考 https://www.jianshu.com/p/b60180a0a0e6
 */
@SpringBootApplication
public class ClientApplication {

    public static void main(String[] args) {
        SpringApplication.run(ClientApplication.class, args);
        //启动netty客户端
        NettyClient nettyClient = new NettyClient();
        nettyClient.start();
    }

}
