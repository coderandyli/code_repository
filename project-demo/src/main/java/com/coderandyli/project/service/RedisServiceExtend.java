package com.coderandyli.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.connection.RedisConnection;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by lizhen on 2019-08-04
 */
@Repository
public class RedisServiceExtend {
    private static String redisCode = "utf-8";

    @Autowired
    RedisTemplate<String, String> redisTemplate;

    /**
     * Executes the given action within a Redis connection. Application exceptions thrown by the action object get propagated to the caller (can only be unchecked)
     * whenever possible. Redis exceptions are transformed into appropriate DAO ones. Allows for returning a result object, that is a domain object
     * or a collection of domain objects. Performs automatic serialization/deserialization for the given objects to and from binary data suitable for the Redis storage.
     * Note: Callback code is not supposed to handle transactions itself! Use an appropriate transaction manager. Generally,
     * callback code must not touch any Connection lifecycle methods, like close, to let the template do its work.
     *
     * 获取value
     * @param key
     * @return
     *
     */
    public byte[] get(final String key){
        return redisTemplate.execute(new RedisCallback<byte[]>() {
            @Override
            public byte[] doInRedis(RedisConnection connection) throws DataAccessException {
                byte[] result;
                result = connection.get(key.getBytes());
                return result;
            }
        });
    }

}
