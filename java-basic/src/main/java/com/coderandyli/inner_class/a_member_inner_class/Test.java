package com.coderandyli.inner_class.a_member_inner_class;

/**
 * Created by lizhen on 2019-05-14
 */
public class Test {

    @org.junit.Test
    public void test01(){
        Circle circle = new Circle(10.0d);

        // 方式一： 创建内部类
        Circle.Draw draw1 = circle.new Draw();

        // 方式二： 创建内部类
        Circle.Draw draw2 = circle.getDrawInstance();

        // draw1.drawSahpe();
    }

}
