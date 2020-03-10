package com.coderandyli.designpattern.practices.alert;


        import com.coderandyli.designpattern.practices.alert.handler.ApiStatInfo;

/**
 * Created by lizhen on 2019-12-14
 */
public class Demo {
    public static void main(String[] args) {
        ApiStatInfo apiStatInfo = new ApiStatInfo("/api/test",
                1000,
                200,
                1,
                150);
        ApplicationContext.getInstance().getAlert().check(apiStatInfo);
    }
}
