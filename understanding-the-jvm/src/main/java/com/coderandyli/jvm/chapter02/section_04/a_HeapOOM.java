//package com.coderandyli.jvm.chapter02.section_04;
//
//import java.util.ArrayList;
//import java.util.List;
//
///**
// * Created by lizhen on 2019-12-09
// *
// * 栈内存溢出
// *
// * VM args
// *  -Xms20m -Xmx20m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/lizhen/Desktop/logs/dump/heapoom.hprof
// */
//public class a_HeapOOM {
//    static class OOMObject{
//    }
//
//    public static void main(String args[]) {
//        List<OOMObject> oomObjects = new ArrayList<>();
//        while (true){
//            oomObjects.add(new OOMObject());
//        }
//    }
//}
