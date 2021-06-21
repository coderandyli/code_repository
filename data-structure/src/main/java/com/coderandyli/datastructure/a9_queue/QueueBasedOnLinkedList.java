package com.coderandyli.datastructure.a9_queue;

/**
 * 基于链表实现的队列
 *
 * <p> 队列数据结构
 * <pre>
 *          +-----+  next  +-----+        +-----+
 *     head |     |  --->  |     |  --->  |     | tail
 *          +-----+        +-----+        +-----+
 * <pre/>
 *
 * <p> 同时也是AQS等待队列的基本数据结构
 *
 * @Date 2021/6/18 3:28 下午
 * @Created by lizhenzhen
 *
 */
public class QueueBasedOnLinkedList {
    /**
     * 头部节点
     */
    private Node head;
    /**
     * 尾部节点
     */
    private Node tail;

    /**
     * 入队
     */
    public void enqueue(Node node) {
        if (head == null) {
            head = node;
            tail = node;
        } else {
            tail.next = node;
            tail = tail.next;
        }
    }

    /**
     * 出队
     */
    public Node dequeue() {
        if (head == null) return null;

        Node queNode = head;
        head = head.next;
        if (head == null) {
            tail = null;
        }
        return queNode;
    }

    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.print(p.getValue() + " ");
            p = p.next;
        }
        System.out.println();
    }

    private static class Node {
        private String value;
        private Node next;

        public Node(String value) {
            this.value = value;
        }

        public String getValue() {
            return value;
        }
    }

    public static void main(String[] args) {
        QueueBasedOnLinkedList queue = new QueueBasedOnLinkedList();

        queue.enqueue(new Node("001"));
        queue.enqueue(new Node("002"));
        queue.enqueue(new Node("003"));

        queue.printAll();
        queue.dequeue();
        System.out.println("进行一次出列之后，打印...");
        queue.printAll();
    }
}
