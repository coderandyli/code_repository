package com.coderandyli.datastructure.a9_queue;

/**
 * Created by lizhen on 2019-07-22
 */
public class ArrayQueue {
    // 数组：items，数组大小：n
    private String[] items;
    private int n = 0;
    // head 表示队头下标，tail 表示队尾下标
    private int head = 0;
    private int tail = 0;

    // 申请一个大小为 capacity 的数组
    public ArrayQueue(int capacity) {
        items = new String[capacity];
        n = capacity;
    }

    /**
     * 入队
     *
     * <h3> 队列满了(tail == n) </>
     *  当tail == n，并不代表队列没有空闲，有可能有出列，队列前面有空位
     *  此时进行一次数据移动
     */
    public boolean enqueue(String item) {
        // Trigger the data move operation
        if (tail == n) {
            if (head == 0) return false;

            for (int i = 0; i < tail - head; i++) {
                items[i] = items[head + i];
                items[head + i] = null;
            }
            tail -= head;
            head = 0;
        }

        items[tail] = item;
        ++tail;
        return true;
    }

    /**
     * 出队
     */
    public String dequeue() {
        // 如果 head == tail 表示队列为空
        if (head == tail) return null;

        String ret = items[head];
        ++head;
        return ret;
    }

    public void printAll() {
        for (String item : items) {
            System.out.println(item);
        }
    }

    public static void main(String args[]) {
        ArrayQueue arrayQueue = new ArrayQueue(4);

        // 入队
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        arrayQueue.enqueue("d");

        // 出队
        System.out.println("出队：" + arrayQueue.dequeue());

        System.out.println("是否入队成功：" + arrayQueue.enqueue("e"));
        arrayQueue.printAll();
    }
}
