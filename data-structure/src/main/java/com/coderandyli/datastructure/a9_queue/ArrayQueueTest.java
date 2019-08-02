/**
 * Created by lizhen on 2019-07-22
 */
public class ArrayQueueTest {

    public static void main(String args[]) {
        ArrayQueue arrayQueue = new ArrayQueue(4);

        // 入队
        arrayQueue.enqueue("a");
        arrayQueue.enqueue("b");
        arrayQueue.enqueue("c");
        arrayQueue.enqueue("d");

        // 出队
        String dequeue = arrayQueue.dequeue();
        System.out.println(dequeue);
    }
}
