import java.util.List;

/**
 * Created by lizhen on 2019-05-11
 *
 * 数组的插入、删除、根据下标随机访问
 *
 */
public class Array {

    /**
     * 定义整型的数据data存储数据
     */
    public int data[];

    /**
     * 定义数组长度
     */
    public int n;

    /**
     * 定义实际个数
     */
    public int count;

    public Array(int capacity){
        this.data = new int[capacity];
        this.n = capacity;
        this.count = 0;
    }

    /**
     * 查询
     * @param index 索引
     * @return
     */
    public int find(int index ){
        if (index < 0 || index >= count) return -1;
        return  data[index];
    }

    /**
     * 插入元素
     * @param index
     * @param value
     * @return
     */
    public boolean insert(int index, int value){
        if (count == n){
            System.out.println("没有可插入的位置");
            return false;
        }
        if (index > count || index < 0){
            System.out.println("插入位置不合法");
            return false;
        }

        for (int i = count; i > index ; i--) {
            data[i] = data[i-1];
        }

        data[index] = value;
        count++;
        return true;
    }

    /**
     * 删除元素
     * @param index
     * @return
     */
    public boolean delete(int index){
        if (index < 0 || index >= count) {
            System.out.println("索引非法");
            return false;
        }

        for (int i = index+1; i < count ; i++) {
            data[i-1] = data[i];
        }
        --count;
        return true;
    }

    public void printAll() {
        for (int i = 0; i < count; ++i) {
            System.out.print(data[i] + " ");
        }
        System.out.println();
    }

    public static void main(String args[]) {
        /*int i = 0;
        int j = 0;
        System.out.println(i++); // 0 先赋值再+1
        System.out.println(++j); // 1 先+1再赋值*/

        Array array = new Array(5);
        array.printAll();
        array.insert(0, 3);
        array.insert(0, 4);
        array.insert(1, 5);
        array.insert(3, 9);
        array.insert(3, 10);
        //array.insert(3, 11);
        array.printAll();

    }
}
