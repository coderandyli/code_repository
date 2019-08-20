package com.coderandyli.springsecurity.config;

import com.coderandyli.springsecurity.service.UserDetailServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * Created by lizhen on 2019-08-11
 */
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    //返回 BCrypt  加密对象
    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
//    @Autowired
//    private AuthenticationSuccessHandler myAuthenticationSuccessHandler;
//    @Autowired
//    private MyAuthenticationFailHandler myAuthenticationFailHandler;


    @Bean
    protected UserDetailsService userDetailServiceImpl(){
        return new UserDetailServiceImpl();
    }
    @Override
    protected void configure(HttpSecurity http)throws Exception{
//        ValidateCodeFilter filter = new ValidateCodeFilter();
//        //写入自定义错误过滤器
//        filter.setAuthenticationFailureHandler(myAuthenticationFailHandler);
        //表单登录
        http.formLogin()
                //        http.httpBasic()
                .and()
                .authorizeRequests()
                .anyRequest()
                .authenticated();

        http
                .headers()
                .frameOptions()
                .sameOrigin();


    }
}