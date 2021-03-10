package com.coderandyli.mybatis;

import com.coderandyli.mybatis.entity.User;
import com.coderandyli.mybatis.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.io.Reader;

@SpringBootApplication
public class MybatisWithNoSpringApplication {

//    public static void main(String[] args) {
//        SpringApplication.run(MybatisWithNoSpringApplication.class, args);
//    }

    public static void main(String[] args) throws IOException {
        Reader reader = Resources.getResourceAsReader("mybatis.xml");
        // 创建 sqlSession
        SqlSessionFactory sessionFactory = new SqlSessionFactoryBuilder().build(reader);
        SqlSession session = sessionFactory.openSession();

        UserMapper userMapper = session.getMapper(UserMapper.class);
        User userDo = userMapper.selectById(8);
        System.out.println(userDo);
    }

}
