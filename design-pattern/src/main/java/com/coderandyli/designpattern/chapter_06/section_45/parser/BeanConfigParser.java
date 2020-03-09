package com.coderandyli.designpattern.chapter_06.section_45.parser;

import com.coderandyli.designpattern.chapter_06.section_45.model.BeanDefinition;

import java.io.InputStream;
import java.util.List;

public interface BeanConfigParser {
    List<BeanDefinition> parse(InputStream inputStream);
    List<BeanDefinition> parse(String configContent);
}
