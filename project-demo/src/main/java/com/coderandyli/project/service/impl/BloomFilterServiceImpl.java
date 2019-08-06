package com.coderandyli.project.service.impl;

import com.coderandyli.project.service.BloomFilterService;
import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;

/**
 * Created by lizhen on 2019-08-06
 */
@Service
public class BloomFilterServiceImpl implements BloomFilterService {

    private BloomFilter<Integer> bf;

    @PostConstruct
    public void initBloomFilter() {
        //创建布隆过滤器(默认误差3%  初始化测试数据
        bf = BloomFilter.create(Funnels.integerFunnel(), 10);
        for (int i = 0; i < 10; i++) {
            bf.put(i);
        }
    }

    public boolean idExists(int id){
        return bf.mightContain(id);
    }


}
