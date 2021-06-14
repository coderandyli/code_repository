package com.coderandyli.jdk8_features.optional;

import org.junit.Assert;
import org.junit.Test;

import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/25 下午2:48
 */
public class OptionalTest {

    @Test(expected = NoSuchElementException.class)
    public void whenCreateEmptyOptional_thenNull() {
        Optional<User> emptyOpt = Optional.empty();

        // true if have the value; false otherwise
        boolean present = emptyOpt.isPresent();
        Assert.assertFalse(present);

        // get the value
        emptyOpt.get();
    }


    @Test(expected = NullPointerException.class)
    public void whenCreateOfEmptyOptional_thenNullPointerException() {
        // 创建一个包含某值的Optional对象，如果传入的null，会报NPE
        Optional<User> opt1 = Optional.of(null);

    }

    @Test()
    public void whenCreateOfEmptyOptional_thenOk() {
        // 创建一个包含某值的Optional对象，如果传入的null，不会报NPE
        Optional<User> opt = Optional.ofNullable(null);
    }

    @Test
    public void whenCreateOfNullableOptional_thenOk() {
        String name = "John";
        Optional<String> opt = Optional.ofNullable(name);

        // get the object in the class Optional
        String value = opt.get();
        Assert.assertEquals("John", opt.get());
    }

    /**
     * 返回默认值
     */
    @Test
    public void whenEmptyValue_thenReturnDefault() {
        User user = null;
        User user1 = new User("coderandyli@163.com","123456");
        User user2 = new User("anna@gmail.com", "1234");

        // orElse：有则返回，无则返回设定的的默认值
        User result = Optional.ofNullable(user1).orElse(user2);
        Assert.assertEquals(user2.getEmail(), result.getEmail());
    }

    /**
     * 返回异常
     */
    @Test(expected = IllegalArgumentException.class)
    public void whenThrowException_thenOk() {
        User user = null;
        User result = Optional.ofNullable(user)
                .orElseThrow( () -> new IllegalArgumentException());
    }

    @Test
    public void whenMap_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        String email = Optional.ofNullable(user)
                .map(u -> u.getEmail()).orElse("default@gmail.com");
        Assert.assertEquals(email, user.getEmail());
    }

    @Test
    public void whenFilter_thenOk() {
        User user = new User("anna@gmail.com", "1234");
        Optional<User> result = Optional.ofNullable(user)
                .filter(u -> u.getEmail() != null && u.getEmail().contains("@"));

        Assert.assertTrue(result.isPresent());
    }

}
