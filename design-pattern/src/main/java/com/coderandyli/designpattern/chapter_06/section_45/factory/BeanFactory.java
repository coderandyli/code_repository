package com.coderandyli.designpattern.chapter_06.section_45.factory;

import com.coderandyli.designpattern.chapter_06.section_45.model.BeanDefinition;

import java.util.List;
import java.util.concurrent.ConcurrentHashMap;

public class BeanFactory {
    private ConcurrentHashMap<String, Object> singletonObjects = new ConcurrentHashMap<>();
    private ConcurrentHashMap<String, BeanDefinition> beanDefinitions = new ConcurrentHashMap<>();

    public void addBeanDefinitions(List<BeanDefinition> beanDefinitions) {
        for (BeanDefinition beanDefinition : beanDefinitions) {
            this.beanDefinitions.putIfAbsent(beanDefinition.getId(), beanDefinition);
        }
    }

    public Object getBean(String beanId) {
        BeanDefinition beanDefinition = beanDefinitions.get(beanId);
        return createBean(beanDefinition);
    }

    private Object createBean(BeanDefinition beanDefinition) {
        return null;
    }

}
