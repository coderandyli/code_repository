package com.coderandyli.designpattern.chapter_06.section_44.case_02.factory;

import com.coderandyli.designpattern.chapter_06.section_44.case_02.parser.*;

/**
 * 简单工厂模式1
 */
public interface RuleConfigParserFactory {

    IRuleConfigParser createParser();
//    {

//        IRuleConfigParser parser = null;
//        if ("json".equalsIgnoreCase(configFormat)) {
//            parser = new JsonRuleConfigParser();
//        } else if ("xml".equalsIgnoreCase(configFormat)) {
//            parser = new XmlRuleConfigParser();
//        } else if ("yaml".equalsIgnoreCase(configFormat)) {
//            parser = new YamlRuleConfigParser();
//        } else if ("properties".equalsIgnoreCase(configFormat)) {
//            parser = new PropertiesRuleConfigParser();
//        }
//        return parser;
//    }
}
