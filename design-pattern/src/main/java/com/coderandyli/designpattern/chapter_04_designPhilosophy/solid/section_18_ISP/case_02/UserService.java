package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_18_ISP.case_02;

/**
 * Created by lizhen on 2019-12-16
 */
public interface UserService {
    boolean register(String cellphone, String password);
    boolean login(String cellphone, String password);
    String getUserInfoById(long id);
    String getUserInfoByCellphone(String cellphone);
}


