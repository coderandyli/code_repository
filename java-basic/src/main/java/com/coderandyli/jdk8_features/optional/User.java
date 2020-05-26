package com.coderandyli.jdk8_features.optional;

/**
 * @author lizhenzhen
 * @version 1.0
 * @date 2020/5/25 下午2:49
 */
public class User {
    private String email;

    private String phone;

    public User(String email, String phone) {
        this.email = email;
        this.phone = phone;
    }

    public User() {
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
