package com.coderandyli.designpattern.chapter_06.section_44.case_02;

import com.coderandyli.designpattern.chapter_06.section_44.case_02.factory.*;
import org.apache.commons.lang3.StringUtils;

import java.util.HashMap;
import java.util.Map;

public class JsonRuleConfigParserFactoryMap {

    private static final Map<String, RuleConfigParserFactory> cachedFactories = new HashMap<>();
    static {
        cachedFactories.put("json", new JsonRuleConfigParserFactory());
        cachedFactories.put("xml", new XmlRuleConfigParserFactory());
        cachedFactories.put("yaml", new YamlRuleConfigParserFactory());
        cachedFactories.put("properties", new PropertiesRuleConfigParserFactory());
    }

    public static RuleConfigParserFactory getParserFactory(String type) {
        if (StringUtils.isBlank(type)){
            return null;
        }

        RuleConfigParserFactory parserFactory = cachedFactories.get(type);
        return parserFactory;
    }

}
