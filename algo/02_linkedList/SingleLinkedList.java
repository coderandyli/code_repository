/**
 * Created by lizhen on 2019-05-11
 * <p>
 * 单链表的插入、删除、查找操作
 */
public class SingleLinkedList {

    private Node head = null;

    /**
     * 根据下标查询
     * @param index
     * @return
     */
    public Node findByIndex(int index){
        Node p = head;

        int pos = 0;
        while (p != null && pos != index){
            p = p.next;
            pos++;
        }
        return p;
    }

    /**
     * 逆序插入
     * 头部插入，与输入的顺序相反
     */
    public void insertToHead(int value) {
        Node node = new Node(value, null);
        insertToHead(node);
    }

    /**
     * 顺序插入
     * @param value
     */
    public void insertTail(int value){
        insertTail(new Node(value, null));
    }

    /**
     * 插入到某个node后面
     * @param p
     * @param value
     */
    public void insertAfter(Node p, int value){
        insertAfter(p, new Node(value, null));
    }

    /**
     * 插入到某个node前面
     * @param p
     * @param value
     */
    public void insertBefore(Node p, int value){
        insertBefore(p, new Node(value, null));
    }

    /**
     * 根据下标删除
     * @param index
     */
    public void deleteByIndex(int index){
        Node p = head;
        int pos = 0;
        index = index - 1;
        while (p != null && pos != index){
            p = p.next;
            pos++;
        }

        p.next = p.next.next;
    }

    /**
     * 打印
     */
    public void printAll() {
        Node p = head;
        while (p != null) {
            System.out.println(p.getData());
            p = p.next;
        }
    }

    /**
     * =============================================================================
     * =========          private method             =========
     * =============================================================================
     */

    private void insertToHead(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            newNode.next = head;
            head = newNode;
        }
    }

    private void insertTail(Node newNode) {
        if (head == null) {
            head = newNode;
        } else {
            // 从头开始迭代，找到最后一个节点，然后插入
            Node p = head;
            while (p.next != null) {
                p = p.next;
            }
            newNode.next = p.next; // null
            p.next = newNode;
        }
    }

    private void insertAfter(Node p, Node newNode){
        if (p == null) return;

        newNode.next = p.next;
        p.next = newNode;
    }

    private void insertBefore(Node p, Node newNode){
        if (p == null) return;

        if (p == head){
            insertToHead(newNode);
            return;
        }

        /**
         * 1、从头遍历找到 节点p 的前置节点q
         * 2、设置q的next = newNode, newNode的next = p
         */
        Node q = head;
        while (q != null && q.next != p){
            q = q.next;
        }

        q.next = newNode;
        newNode.next = p;
    }


    /**
     * 静态内部类 Node
     */
    public static class Node {
        private int data;
        private Node next;

        public Node(int data, Node next) {
            this.data = data;
            this.next = next;
        }

        public int getData() {
            return data;
        }
    }

    public static void main(String args[]) {
        SingleLinkedList singleLinkedList = new SingleLinkedList();
        singleLinkedList.insertToHead(10);
        singleLinkedList.insertToHead(11);
        singleLinkedList.insertTail(12);
        singleLinkedList.insertTail(13);

        Node node = singleLinkedList.findByIndex(2);// 查询
        singleLinkedList.insertAfter(node, 100); // 某个节点后插入
        singleLinkedList.insertBefore(node, 99); // 某个节点前插入

        singleLinkedList.printAll();

        System.out.println("--------------------");

        singleLinkedList.deleteByIndex(2); // 删除某个节点

        singleLinkedList.printAll();
    }
}
