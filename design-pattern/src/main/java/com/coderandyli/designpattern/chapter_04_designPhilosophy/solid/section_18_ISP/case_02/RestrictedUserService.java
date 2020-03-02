package com.coderandyli.designpattern.chapter_04_designPhilosophy.solid.section_18_ISP.case_02;

/**
 * Created by lizhen on 2019-12-16
 */
public interface RestrictedUserService {
    boolean deleteUserByCellphone(String cellphone);
    boolean deleteUserById(String id);
}


