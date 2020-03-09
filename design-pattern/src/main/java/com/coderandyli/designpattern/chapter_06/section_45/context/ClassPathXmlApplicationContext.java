package com.coderandyli.designpattern.chapter_06.section_45.context;

import com.coderandyli.designpattern.chapter_06.section_45.factory.BeanFactory;
import com.coderandyli.designpattern.chapter_06.section_45.model.BeanDefinition;
import com.coderandyli.designpattern.chapter_06.section_45.parser.BeanConfigParser;
import com.coderandyli.designpattern.chapter_06.section_45.parser.XmlBeanConfigParser;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class ClassPathXmlApplicationContext implements ApplicationContext {
    private BeanFactory beanFactory;
    private BeanConfigParser beanConfigParser;

    public ClassPathXmlApplicationContext(String configLocation) {
        this.beanFactory = new BeanFactory();
        this.beanConfigParser = new XmlBeanConfigParser();
        loadBeanDefinitions(configLocation);
    }

    private void loadBeanDefinitions(String configLocation) {
        InputStream in = null;
        try {
            in = this.getClass().getResourceAsStream("/" + configLocation);
            if (in == null) {
                throw new RuntimeException("Can not find config file: " + configLocation);
            }
            List<BeanDefinition> beanDefinitions = beanConfigParser.parse(in);
            beanFactory.addBeanDefinitions(beanDefinitions);
        } finally {
            if (in != null){
                try {
                    in.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    // TODO: 2020/3/5 log error
                }
            }

        }
    }

    @Override
    public Object getBean(String beanId) {
        return beanFactory.getBean(beanId);
    }
}
