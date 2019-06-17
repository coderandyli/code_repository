import java.util.Arrays;

/**
 * Created by lizhen on 2019-05-21
 * 基于数组的顺序栈
 */
public class ArrayStack {
    private String[] items; //数组
    private int count; //栈中元素个数
    private int n; // 栈的大小

    public ArrayStack(int capacity) {
        this.items = new String[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 入栈操作
     *
     * @param item
     */
    public boolean push(String item) {
        // 空间不足,入栈失败
        // if (count == n) return false;

        // 空间不足,扩容
        if (count == n){
            resize(count * 2);
        }

        // 将item放到下标为count的位置，并且count+1
        items[count] = item;
        count++;
        return true;
    }

    /**
     * 出栈
     */
    public String pop() {
        // 栈为空，直接返回null
        if (count == 0) return null;

        String temp = items[count - 1];
        count--;
        return temp;
    }


    // 扩容方法，时间复杂度 O(n)
    private void resize(int capacity) {
        String[] newData = new String[capacity];

        for (int i = 0; i < count; i++) {
            newData[i] = items[i];
        }
        items = newData;
    }


    public static void main(String args[]) {
        ArrayStack arrayStack = new ArrayStack(3);
        arrayStack.push("111");
        arrayStack.push("222");
        arrayStack.push("333");
        arrayStack.push("444"); // 触发扩容操作

        Arrays.asList(arrayStack.items).forEach(System.out::println);
    }

}
