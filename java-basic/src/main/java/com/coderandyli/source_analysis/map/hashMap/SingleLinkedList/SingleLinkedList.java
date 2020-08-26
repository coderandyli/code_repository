package com.coderandyli.source_analysis.map.hashMap.SingleLinkedList;

/**
 * Created by lizhen on 2019-04-21
 */
public class SingleLinkedList {
    public Node first; // 定义一个头结点
    private int pos = 0;// 节点的位置

    /**
     * 构造函数
     */
    public SingleLinkedList() {
        this.first = null;
    }

    /**
     * 插入一个头节点
     * @param data
     */
    public void addFirstNode(int data) {
        Node node = new Node(data);
        node.next = first;
        first = node;
    }

    /**
     * 删除一个头结点,并返回头结点
     * @return
     */
    public Node deleteFirstNode() {
        Node tempNode = first;
        first = tempNode.next;
        return tempNode;
    }

    /**
     * 在任意位置插入节点 在index的后面插入
     * @param index
     * @param data
     */
    public void add(int index, int data) {
        if (index == 0){ // index = 0,插入头结点
            this.addFirstNode(data);
            return;
        }
        Node node = new Node(data);
        Node current = first;
        Node previous = first;
        while (pos != index) {
            previous = current;
            current = current.next;
            pos++;
        }
        node.next = current;
        previous.next = node;
        pos = 0;
    }

    /**
     * 删除任意位置的节点
     * @param index
     * @return
     */
    public Node deleteByPos(int index) {
        Node current = first;
        Node previous = first;
        while (pos != index) {
            pos++;
            previous = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            pos = 0;
            previous.next = current.next;
        }
        return current;
    }

    /**
     * 根据节点的data删除节点(仅仅删除第一个)
     * @param data
     * @return
     */
    public Node deleteByData(int data) {
        Node current = first;
        Node previous = first; // 记住上一个节点
        while (current.data != data) {
            if (current.next == null) {
                return null;
            }
            previous = current;
            current = current.next;
        }
        if (current == first) {
            first = first.next;
        } else {
            previous.next = current.next;
        }
        return current;
    }

    /**
     * 显示出所有的节点信息
     */
    public void displayAllNodes() {
        Node current = first;
        while (current != null) {
            current.display();
            current = current.next;
        }
        System.out.println();
    }

    /**
     * 根据位置查找节点信息
     * @param index
     * @return
     */
    public Node findByPos(int index) {
        Node current = first;
        if (pos != index) {
            current = current.next;
            pos++;
        }
        return current;
    }

    /**
     * 根据数据查找节点信息
     * @param data
     * @return
     */
    public Node findByData(int data) {
        Node current = first;
        while (current.data != data) {
            if (current.next == null)
                return null;
            current = current.next;
        }
        return current;
    }
}
