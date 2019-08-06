package com.coderandyli.redis.demo.service;

import org.springframework.data.redis.core.ZSetOperations;

import java.util.List;

/**
 * Created by lizhen on 2019-07-19
 */
public interface HotKeySearchService {

    boolean addTestData();

    List<ZSetOperations.TypedTuple<String>> search(String searchKey);

    Double incrementScore(String searchKey);
}
