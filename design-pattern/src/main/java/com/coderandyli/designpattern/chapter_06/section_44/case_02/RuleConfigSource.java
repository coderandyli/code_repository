package com.coderandyli.designpattern.chapter_06.section_44.case_02;
import com.coderandyli.designpattern.chapter_06.section_44.InvalidRuleConfigException;
import com.coderandyli.designpattern.chapter_06.section_44.RuleConfig;
import com.coderandyli.designpattern.chapter_06.section_44.case_02.factory.RuleConfigParserFactory;
import com.coderandyli.designpattern.chapter_06.section_44.case_02.parser.IRuleConfigParser;


public class RuleConfigSource {
    public RuleConfig load(String ruleConfigFilePath) {
        String ruleConfigFileExtension = getFileExtension(ruleConfigFilePath);
        RuleConfigParserFactory parserFactory = JsonRuleConfigParserFactoryMap.getParserFactory(ruleConfigFileExtension);
        if (parserFactory == null) {
            throw new InvalidRuleConfigException("Rule config file format is not supported: " + ruleConfigFilePath);
        }
        IRuleConfigParser parser = parserFactory.createParser();

        String configText = "";
        //从ruleConfigFilePath文件中读取配置文本到configText中
        RuleConfig ruleConfig = parser.parse(configText);
        return ruleConfig;
    }

    private String getFileExtension(String filePath) {
        //...解析文件名获取扩展名，比如rule.json，返回json
        return "json";
    }
}