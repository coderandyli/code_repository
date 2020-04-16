//package com.coderandyli.designpattern.case_01.eventBus;
//
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.junit.jupiter.api.Assertions.*;
//
///**
// * @author lizhenzhen
// * @version 1.0
// * @date 2020/3/17 上午10:22
// */
//class ObserverRegisterTest {
//
//    @Test
//    void getAllSubscribeMethods() {
//        ObserverRegister observerRegister = new ObserverRegister();
//        List<ObserverMethod> allSubscribeMethods = observerRegister.getAllSubscribeMethods(new AnnotationTest());
//        assertEquals(allSubscribeMethods.size(), 1);
//    }
//}