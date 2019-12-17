package com.coderandyli.designpattern.chapter_04_SOLID.section_18_ISP.case_01;

/**
 * Created by lizhen on 2019-12-16
 */
public class UserServiceImpl implements UserService {
    @Override
    public boolean register(String cellphone, String password) {
        return false;
    }

    @Override
    public boolean login(String cellphone, String password) {
        return false;
    }

    @Override
    public String getUserInfoById(long id) {
        return null;
    }

    @Override
    public String getUserInfoByCellphone(String cellphone) {
        return null;
    }

    @Override
    public boolean deleteUserByCellphone(String cellphone) {
        return false;
    }

    @Override
    public boolean deleteUserById(String id) {
        return false;
    }
}
