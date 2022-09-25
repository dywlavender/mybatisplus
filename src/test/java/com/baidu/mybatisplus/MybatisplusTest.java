package com.baidu.mybatisplus;

import com.baidu.mybatisplus.mapper.UserMapper;
import com.baidu.mybatisplus.pojo.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class MybatisplusTest {
    @Autowired
    private UserMapper userMapper;

    @Test
    public void testSelectList(){
        List<User> users = userMapper.selectList(null);
        users.forEach(System.out::println);
    }

    @Test
    public void testInsert(){
        User user = new User();
        user.setName("张三");
        user.setAge(23);
        user.setEmail("zhangsan@qq.com");
        int result = userMapper.insert(user);
        System.out.println("result: " + result);
        System.out.println("id: " + user.getId());
    }

    @Test
    public void testDelete(){
//        int result = userMapper.deleteById(1574038049397268481L);
//        System.out.println(result);
//        Map<String,Object> map = new HashMapp<>();
//        map.put("name","张三");
//        map.put("age",23);
//        int result = userMapper.deleteByMap(map);
//        System.out.println(result);
        List<Long> list = Arrays.asList(1L,2L,3L);
        int reslut = userMapper.deleteBatchIds(list);
        System.out.println(reslut);
    }

    @Test
    public void testUpdate(){
        User user = new User();
        user.setId(4L);
        user.setName("李四");
        user.setEmail("lisi@qq.com");
        int result = userMapper.updateById(user);
        System.out.println(result);
    }

    @Test
    public void testSelect(){
//        User user = userMapper.selectById(1L);
//        System.out.println(user);
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("name","Jack");
//        map.put("age",20);
//        List<User> users = userMapper.selectByMap(map);
//        users.forEach(System.out::println);

//        List<User> users = userMapper.selectList(null);
//        users.forEach(System.out::println);
        Map<String, Object> map = userMapper.selectMapById(1L);
        System.out.println(map);

    }

}
