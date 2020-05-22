package com.coderandyli.redis.demo.service.impl;

import com.coderandyli.redis.demo.service.HotKeySearchService;
import com.coderandyli.redis.demo.service.RedisService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * Created by lizhen on 2019-07-19
 */
@Service
public class HotKeySearchServiceImpl implements HotKeySearchService {

    private static final String HOT_KEYS_KEY = "searchKey";

    @Autowired
    private RedisService redisService;

    @Override
    public boolean addTestData() {
        List<String> keys = Arrays.asList("kobe", "johnson", "jabbar", "west", "o'neal", "baylor", "mccann", "worthy", "gasol", "chamberlain",
                "fisher", "odom", "bynum", "horry", "rambis", "riley", "clarkson", "Williams", "young", "Russell",
                "ingram", "randle", "nance", "brown", "deng", "yi", "ariza", "artest", "walton", "vujacic",
                "james", "paul", "curry", "park", "yao", "kevin", "wade", "rose", "popovich", "leonard",
                "aldridge", "ginobili", "duncan", "lavine", "rubio", "garnett", "wiggins", "westbrook", "durant", "ibaka",
                "nowitzki", "pierce", "crawford", "love", "smith", "iguodala", "barnes", "green", "thompson", "harden",
                "lillard", "mccollum", "lin", "jackson", "nash", "stoudemire", "whiteside", "dragic", "Howard", "batum");
        for (String key : keys) {
            redisService.zAdd(HOT_KEYS_KEY, key, 1);
        }
        return true;
    }

    @Override
    public List<ZSetOperations.TypedTuple<String>> search(String searkey) {
        Set<ZSetOperations.TypedTuple<String>> typedTupleSet = redisService.reverseRangeWithScores(HOT_KEYS_KEY, 0l, -1l);
        List<ZSetOperations.TypedTuple<String>> list = typedTupleSet.stream().
                filter(stringTypedTuple -> stringTypedTuple.getValue().contains(searkey)).
                limit(10).map(typedTuple -> {
            incrementScore(typedTuple.getValue());
            return typedTuple;
        }).collect(Collectors.toList());

        // 添加到集合
        if (list == null || list.isEmpty()) {
            redisService.zAdd(HOT_KEYS_KEY, searkey, 1);
        }
        return list;
    }

    @Override
    public Double incrementScore(String searchKey) {
        return redisService.incrementScore(HOT_KEYS_KEY, searchKey, 1);
    }
}
