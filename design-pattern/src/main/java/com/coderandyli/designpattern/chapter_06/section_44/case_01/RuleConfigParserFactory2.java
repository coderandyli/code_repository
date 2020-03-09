package com.coderandyli.designpattern.chapter_06.section_44.case_01;

import com.coderandyli.designpattern.chapter_06.section_44.case_01.parser.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 简单工厂模式2
 */
public class RuleConfigParserFactory2 {
    private static final Map<String, IRuleConfigParser> cacheParser = new HashMap<>();

    static {
        cacheParser.put("json", new JsonRuleConfigParser());
        cacheParser.put("xml", new XmlRuleConfigParser());
        cacheParser.put("yaml", new YamlRuleConfigParser());
        cacheParser.put("properties", new PropertiesRuleConfigParser());
    }

    public static IRuleConfigParser createParser(String configFormat) {
        if (configFormat == null || configFormat.isEmpty()) {
            return null;//返回null还是IllegalArgumentException全凭你自己说了算
        }
        IRuleConfigParser parser = cacheParser.get(configFormat);
        return parser;
    }
}
