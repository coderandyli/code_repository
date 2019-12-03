//package com.coderandyli.jvm.chapter12.section03;
//
//import java.util.concurrent.*;
//
///**
// * Created by lizhen on 2019-11-19
// * <p>
// * volatile非线程安全测试
// * volatile 保证可见性、有序性、但并不是原子性的
// * 执行结果
// * 不是原子性
// * <p>
// * 分析
// * <p>
// * ============= increase方法字节码 =============
// * public static void increase();
// * stack=2, locals=0, args_size=0
// * 0: getstatic     #2                  // 获取静态字段的值  --volatile关键字，保证了race值在此时是正确的
// * 3: iconst_1                          // 将常量压入操作栈 --此时，race的值被其他线程加大
// * 4: iadd                              // 将栈顶int类型相加  --此时，race的值被其他线程加大
// * 5: putstatic     #2                  // 给静态字段赋值  -- 因此栈顶值可能变成了过期数据，所以putstatic可能会把较小的race值同步回主内存中
// * 8: return
// */
//public class VolatileTest {
//    public static final int THREADS_COUNT = 20;
//    public static final int CLIENT_TOTAL = 20000;
//
//    private static volatile int race = 0;
//
//    public static void main(String args[]) {
//        /**
//         *  创建一个线程池
//         * corePoolSize: 1
//         * maximumPoolSize: 20
//         * keepAliveTime 60s
//         */
//        // ExecutorService executorService = new ThreadPoolExecutor(1, THREADS_COUNT, 60L, TimeUnit.SECONDS, new SynchronousQueue<>());
//
//        // 创建线程池
//        ExecutorService executorService = Executors.newCachedThreadPool();
//        final Semaphore semaphore = new Semaphore(THREADS_COUNT); //20个线程
//        final CountDownLatch countDownLatch = new CountDownLatch(CLIENT_TOTAL); // 计数器
//        for (int i = 0; i < CLIENT_TOTAL; i++) {
//            executorService.execute(() -> {
//                try {
//                    semaphore.acquire(); //获得许可
//                    increase();
//                    semaphore.release(); //释放许可
//                } catch (InterruptedException e) {
//                    e.printStackTrace();
//                }
//                countDownLatch.countDown();
//            });
//        }
//        try {
//            countDownLatch.await();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//        executorService.shutdown();
//
//        System.out.println(race);
//    }
//
//
//    public static void increase() {
//        race++;
//    }
//
//
//}
