package com.coderandyli.designpattern.practices_02.alert;

import com.coderandyli.designpattern.practices_02.alert.alertHandle.ApiStatInfo;

public class Main {
    public static void main(String[] args) {
        ApplicationContext.getInstance().getAlert().check(new ApiStatInfo());
    }
}
