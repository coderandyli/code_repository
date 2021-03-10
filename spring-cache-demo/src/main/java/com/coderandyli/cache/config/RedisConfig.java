//package com.coderandyli.cache.config;
//
//
//import org.apache.log4j.Logger;
//import org.springframework.boot.autoconfigure.data.redis.RedisProperties;
//import org.springframework.boot.context.properties.ConfigurationProperties;
//import org.springframework.cache.annotation.CachingConfigurerSupport;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
//import org.springframework.data.redis.core.StringRedisTemplate;
//import org.springframework.data.redis.serializer.StringRedisSerializer;
//import redis.clients.jedis.JedisPoolConfig;
//
//
///**
// *redis 配置
// */
//@Configuration
//public class RedisConfig extends CachingConfigurerSupport {
//
//    private static Logger logger = Logger.getLogger(RedisConfig.class);
//
//    @Bean
//    @ConfigurationProperties(prefix="spring.redis")
//    public JedisPoolConfig getRedisConfig(){
//        JedisPoolConfig config = new JedisPoolConfig();
//        return config;
//    }
//
//
//
//    @Bean
//    public JedisConnectionFactory getConnectionFactory(RedisProperties redisProperties){
//        JedisConnectionFactory factory = new JedisConnectionFactory();
//        JedisPoolConfig config = getRedisConfig();
//        factory.setDatabase(redisProperties.getDatabase());
//        factory.setHostName(redisProperties.getHost());
//        factory.setPassword(redisProperties.getPassword());
//        factory.setPort(redisProperties.getPort());
//        factory.setPoolConfig(config);
//        logger.info("JedisConnectionFactory bean init success.");
//        return factory;
//    }
//
//
//    @Bean
//    public StringRedisTemplate getRedisTemplate( RedisProperties redisProperties){
//        JedisConnectionFactory connectionFactory = getConnectionFactory(redisProperties);
//        StringRedisTemplate template = new StringRedisTemplate(connectionFactory);
//        //设置redis 序列化
//        template.setStringSerializer(new StringRedisSerializer());
//        return template;
//    }
//
//}
//
