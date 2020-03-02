package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_18_ISP.case_04;

/**
 * Created by lizhen on 2019-12-16
 */

public class Application {
    // ConfigSource configSource = new ZookeeperConfigSource(/*省略参数*/);
    public static final RedisConfig redisConfig = new RedisConfig(); //new RedisConfig(configSource);
    public static final KafkaConfig kafkaConfig = new KafkaConfig(); //new KakfaConfig(configSource);
    public static final MysqlConfig mysqlConfig = new MysqlConfig(); //new MysqlConfig(configSource);

    public static void main(String[] args) {
        ScheduledUpdater redisConfigUpdater = new ScheduledUpdater(redisConfig, 300, 300);
        redisConfigUpdater.run();

        ScheduledUpdater kafkaConfigUpdater = new ScheduledUpdater(kafkaConfig, 60, 60);
        redisConfigUpdater.run();

        SimpleHttpServer simpleHttpServer = new SimpleHttpServer("127.0.0.1", 2389);
        simpleHttpServer.addViewers("/config", redisConfig);
        simpleHttpServer.addViewers("/config", mysqlConfig);

        simpleHttpServer.run();
    }
}
