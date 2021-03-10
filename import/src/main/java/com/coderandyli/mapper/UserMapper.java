package com.coderandyli.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.coderandyli.entity.User;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户表
 *
 * @author coderandyli
 * @date 2019-04-03 22:15:20
 */
@Mapper
public interface UserMapper extends BaseMapper<User> {

    void insertBatchUsers(@Param("users")List<User> users);

    Integer isExsitById(Long id);
}
