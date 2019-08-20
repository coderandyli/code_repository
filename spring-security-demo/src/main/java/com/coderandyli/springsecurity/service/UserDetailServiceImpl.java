package com.coderandyli.springsecurity.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

/**
 * Created by lizhen on 2019-08-11
 */
@Component
@Slf4j
public class UserDetailServiceImpl implements UserDetailsService {
    //    @Autowired
//    UserAdminMapper userAdminMapper;
    @Autowired
    private PasswordEncoder passwordEncoder;
    /**
     * 超级用户
     */
    private static final Integer USER_POWER_ADMIN = 1;
    /**
     * 普通用户
     */
    private static final Integer USER_POWER_USER = 2;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
//        try {
//            UserAdmin userAdmin = userAdminMapper.selectByUsername(username);
//            log.info("登录用户名" + username);
//            log.info("数据库密码" + userAdmin.getPassword());
//            if (userAdmin == null) {
//                throw new UsernameNotFoundException("没有找到");
//            }
//            //获取用户使用状态
//            boolean status = false;
//            if (userAdmin.getUserStatus() == 1){
//                status = true;
//            }
//            if (userAdmin.getUserPower() == 1) {
//                log.info("ADMIN用户"+userAdmin.getUserAdminName()+"登录");
//                return new User(username, passwordEncoder.encode(userAdmin.getPassword()),
//                        status, true, true, true,
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("ADMIN"));
//            } else if (userAdmin.getUserPower() == 2) {
//                log.info("ADMIN用户"+userAdmin.getUserAdminName()+"登录");
//                return new User(username, passwordEncoder.encode(userAdmin.getPassword()),
//                        true, true, true, true,
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
//            } else {
//                log.error("用户权限错误异常,默认为USER普通用户");
//                return new User(username, passwordEncoder.encode(userAdmin.getPassword()),
//                        true, true, true, true,
//                        AuthorityUtils.commaSeparatedStringToAuthorityList("USER"));
//            }
//        }catch (Exception e){
//            log.error("用户权限错误异常"+e.getMessage());
//            throw new MyException("用户权限错误异常");
//        }
        return null;
    }
}
