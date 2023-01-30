package com.baidu.mybatisplus.mapper;

import com.baidu.mybatisplus.pojo.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.MapKey;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface UserMapper extends BaseMapper<User> {
    /**
     * 根据id查询map返回值
     * @param id
     * @return
     */
    Map<String,Object> selectMapById(@Param("id") Long id);

    Page<User> selectPageVo(@Param("page") Page<User> page, @Param("age") Integer age);

}
