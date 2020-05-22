package com.coderandyli.project.mapper;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.coderandyli.project.entity.Test;
import org.apache.ibatis.annotations.Mapper;import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 
 *
 * @author Andy
 * @date 2019-07-30 13:53:44
 */
@Mapper
public interface TestMapper extends BaseMapper<Test> {


    void batchInsert(@Param("list")List<Test> list);

}
