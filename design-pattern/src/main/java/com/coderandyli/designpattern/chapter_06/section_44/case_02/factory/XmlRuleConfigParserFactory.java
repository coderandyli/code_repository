package com.coderandyli.designpattern.chapter_06.section_44.case_02.factory;

import com.coderandyli.designpattern.chapter_06.section_44.case_02.parser.IRuleConfigParser;
import com.coderandyli.designpattern.chapter_06.section_44.case_02.parser.XmlRuleConfigParser;

public class XmlRuleConfigParserFactory implements RuleConfigParserFactory {
    @Override
    public IRuleConfigParser createParser() {
        // Other initialization information...
        return new XmlRuleConfigParser();
    }
}
