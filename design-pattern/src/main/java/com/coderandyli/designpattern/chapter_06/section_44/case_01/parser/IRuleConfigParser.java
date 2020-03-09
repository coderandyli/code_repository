package com.coderandyli.designpattern.chapter_06.section_44.case_01.parser;

import com.coderandyli.designpattern.chapter_06.section_44.RuleConfig;

public interface IRuleConfigParser {

    RuleConfig parse(String configText);
}
