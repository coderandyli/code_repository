package com.coderandyli.serializable;

import com.coderandyli.serializable.entity.Manager;
import com.coderandyli.serializable.entity.Position;
import com.coderandyli.serializable.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.util.http.fileupload.FileUtils;
import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.junit.Test;
import org.thymeleaf.context.Context;

import java.io.*;
import java.util.*;

/**
 * Created by lizhen on 2019-03-06
 *
 * 序列化 与 反序列化
 *
 * <p>
 * 前段时间，在实际开发中，在使用RabbitMQ中遇到了一个问题，将一个封装好的mail对象放到MQ中，
 * 然后通过消息服务去消费这条消息，但是却出现了序列化失败的情况，后来发现mail对象中包含一个
 * import org.thymeleaf.context.Context类，Context没有继承Serializable，
 * 不能被序列化，跑出异常： Caused by: java.io.NotSerializableException, 且是被final修饰的
 * 不能被继承。
 */
@Slf4j
public class Main {

    /**
     * 序列化测试
     * Transient 关键字的作用是控制变量的序列化，在变量声明前加上该关键字，
     * 可以阻止该变量被序列化到文件中，在被反序列化后，transient 变量的值被设为初始值，
     * 如 int 型的是 0，对象型的是 null。
     */
    @Test
    public void test1() {
//        ArrayList

        //Initializes The Object
        User user = new User();
        user.setName("andy");
        user.setGender("male");
        user.setAge(18);
        user.setBirthday(new Date());
        User.userName = "name";

        Context context = new Context();
        context.setVariable("name","name");
        context.setVariable("position","position");
        User.context = context;
//        user.setContext(context);

        // final 修饰的复杂变量，会导致序列化异常
        /*Position position = new Position();
        position.setId("position_id_001");
        position.setCode("position_code_001");
        position.setName("manager");
        user.setPosition(position);*/

        Manager manager = new Manager();
        manager.setId("position_id_001");
        manager.setCode("position_code_001");
        manager.setName("manager");
        user.setManager(manager);

        log.debug("{}", user);
        log.debug("User.userName {}", User.userName);
        log.debug("user.getManager().getName() = {}", user.getManager().getName());


        //Write Obj to File
        ObjectOutputStream oos = null;
        try {
            oos = new ObjectOutputStream(new FileOutputStream("tempFile"));
            oos.writeObject(user);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(oos);
        }

        //Read Obj from File
        File file = new File("tempFile");
        ObjectInputStream ois = null;
        try {
            ois = new ObjectInputStream(new FileInputStream(file));
            User newUser = (User) ois.readObject();
            log.debug("{}", newUser);
            log.debug("User.userName {}", User.userName);
            log.debug("user.getManager().getName() = {}", user.getManager().getName());
            log.debug("User.context = {}", User.context.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            IOUtils.closeQuietly(ois);
            try {
                FileUtils.forceDelete(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

    }
}
