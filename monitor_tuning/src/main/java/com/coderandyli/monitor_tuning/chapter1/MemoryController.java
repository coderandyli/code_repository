package com.coderandyli.monitor_tuning.chapter1;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * Created by lizhen on 2019-04-18
 *
 * 演示 堆内存溢出 与 非堆内存溢出
 */
@RestController
@RequestMapping("/menory")
public class MemoryController {

    private List<User> userList = new ArrayList<>();
    private List<Class<?>>  classList = new ArrayList<>();

    /**
     * 堆内存溢出
     *
     * 运行参数:
     *
     * # 栈初始大小: 32M
     * -Xms32M
     * # 栈最大内存 32M
     * -Xmx32M
     * # JVM内存溢出时，自动生成快照
     * -XX:+HeapDumpOnOutOfMemoryError
     * # 内存溢出时，快照生成的路径
     * -XX:HeapDumpPath=/Users/lizhen/Desktop/heapdump.hprof
     *
     * -Xmx32M -Xms32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/lizhen/Desktop/heapdump.hprof
     *
     * 运行结果：
     *      java.lang.OutOfMemoryError: GC overhead limit exceeded
     *
     *
     */
    @GetMapping("/heap")
    public void heap(){
        while (true){
            userList.add(new User(UUID.randomUUID().toString(), UUID.randomUUID().toString()));
        }
    }

    /**
     * 非堆内存溢出（元空间 Matespace）
     *
     * 运行参数
     *      -XX:MetaspaceSize=32M -XX:MaxMetaspaceSize=32M -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/lizhen/Desktop/heapdump.hprof
     * 运行结果
     *      Exception in thread "main" java.lang.OutOfMemoryError: Metaspace
     */
    @GetMapping("/nonheap")
    public void nonheap(){
        while (true){
            classList.addAll(Metaspace.createClasses());
        }
    }
}
