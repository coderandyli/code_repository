package com.coderandyli.redis.demo.main;

import org.redisson.Redisson;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.redisson.config.Config;

import java.util.concurrent.TimeUnit;

/**
 * Created by lizhen on 2019-08-08
 */
public class Main {

    public static void main(String args[]) {
        Config config = new Config();
//        config.useSentinelServers().addSentinelAddress("redis://106.12.28.134:26379")
//                .setMasterName("mymaster")
//                .setDatabase(1);

        config.useSingleServer().setAddress("106.12.28.134:6379").setDatabase(1);

        RedissonClient redissonClient = Redisson.create(config);

        // 还可以getFairLock(), getReadWriteLock()

        RLock redLock = redissonClient.getLock("REDLOCK_KEY");

        boolean isLock;

        try {
            isLock = redLock.tryLock();

            // 500ms拿不到锁, 就认为获取锁失败。10000ms即10s是锁失效时间。

            isLock = redLock.tryLock(500, 10000, TimeUnit.MILLISECONDS);

            if (isLock) {
                //TODO if get lock success, do something;
            }

        } catch (Exception e) {

        } finally {
            // 无论如何, 最后都要解锁
//            redLock.unlock();
        }
    }
}
