package com.coderandyli.hashMap_analysis.SingleLinkedList;

/**
 * Created by lizhen on 2019-04-21
 *
 * 节点类
 */
public class Node {
    protected Node next; //指针域
    public  int data;//数据域

    public Node( int data) {
        this. data = data;
    }

    //显示此节点
    public void display() {
        System. out.print( data + " ");
    }
}
