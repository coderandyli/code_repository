package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.case_03;

import com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_16_OCP.alert.case_03.handle.ApiStatInfo;


/**
 * Created by lizhen on 2019-12-14
 */
public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo();
        // ...省略设置apiStatInfo数据值的代码
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
