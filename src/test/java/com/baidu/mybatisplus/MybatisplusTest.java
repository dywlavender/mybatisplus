package com.baidu.mybatisplus;

import com.baidu.mybatisplus.enums.SexEnum;
import com.baidu.mybatisplus.mapper.UserMapper;
import com.baidu.mybatisplus.pojo.User;
import com.baidu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.toolkit.StringUtils;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import java.util.*;

@SpringBootTest
public class MybatisplusTest {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

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

    @Test
    public void testGetCount(){
        long count = userService.count();
        System.out.println(count);
    }

    @Test
    public void testSaveBatch(){
        List<User> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            User user = new User();
            user.setName("Vz" + i);
            user.setAge(20+i);
            list.add(user);
        }
        boolean b = userService.saveBatch(list);
        System.out.println(b);
    }

    @Test
    public void testDeleteById(){
//        int result = userMapper.deleteById(1577300476222078982L);
//        System.out.println(result);
//                  ==>  Preparing: UPDATE user SET is_deleted=1 WHERE id=? AND is_deleted=0
//                ==> Parameters: 1577300476222078981(Long)
//                <==    Updates: 1
        boolean b = userService.removeById(1577300476222078981L);
        System.out.println(b);
    }

    @Test
    public void testQueryWrapper(){
//        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
//        queryWrapper.like("user_name", "a").between("age", 20, 30).isNotNull("email");
//        List<User> users = userMapper.selectList(queryWrapper);
//        users.forEach(System.out::println);

//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.orderByDesc("age").orderByAsc("id");
//        Map<String, Object> map = userService.getMap(userQueryWrapper);
//        List<User> users = userMapper.selectList(userQueryWrapper);
//        users.forEach(System.out::println);
//        map.forEach((s, o) -> System.out.println(s+o));

//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.isNull("email");
//        int delete = userMapper.delete(userQueryWrapper);
//        System.out.println(delete);


    }

    @Test
    public void testUpdateMapper(){
//        UpdateWrapper<User> userQueryWrapper = new UpdateWrapper<User>();
//        userQueryWrapper.eq("age",20).like("user_name","a").or().isNull("email");
//        User user = new User();
//        user.setName("Ox");
//        user.setEmail("test@ox.com");
//        int update = userMapper.update(user,userQueryWrapper);
//        System.out.println(update);

        UpdateWrapper<User> userUpdateWrapper = new UpdateWrapper<>();
        userUpdateWrapper.like("user_name","a").and(i->i.gt("age",20).or().isNull("email"));
        User user = new User();
        user.setName("Vz");
        user.setEmail("test@vz.com");

        int update = userMapper.update(user, userUpdateWrapper);
        System.out.println(update);
    }


    @Test
    public void testSelectMaps(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.select("username","age","email");
        List<Map<String, Object>> maps = userMapper.selectMaps(userQueryWrapper);
        maps.forEach(System.out::println);
    }

    @Test
    public void testInSql(){
        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
        userQueryWrapper.inSql("uid","select uid from user where uid <= 100");
        List<User> users = userMapper.selectList(userQueryWrapper);
        users.forEach(System.out::println);
    }

    @Test
    public void testCondition(){
        String username = "a";
        Integer ageBegin = null;
        Integer ageEnd = 30;
//        QueryWrapper<User> userQueryWrapper = new QueryWrapper<>();
//        userQueryWrapper.like(StringUtils.isNotBlank(username),"username",username)
//                .ge(ageBegin != null,"age",ageBegin)
//                .le(ageEnd != null,"age",ageEnd);
//        List<User> users = userMapper.selectList(userQueryWrapper);
//        users.forEach(System.out::println);
//        System.out.println("---------");
//        List<User> users1 = userMapper.selectList(null);
//        users1.forEach(System.out::println);


        LambdaQueryWrapper<User> userLambdaQueryWrapper = new LambdaQueryWrapper<>();
        userLambdaQueryWrapper.like(StringUtils.isNotBlank(username),User::getName,
                username)
                        .ge(ageBegin!=null,User::getAge,ageBegin)
                                .le(ageEnd!=null,User::getAge,ageEnd);
        List<User> users2 = userMapper.selectList(userLambdaQueryWrapper);
        users2.forEach(System.out::println);
    }

    @Test
    public void testPage(){
        Page<User> userPage = userMapper.selectPage(new Page<>(1, 2), null);
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void testPaveVo(){
        Page<User> userPage = userMapper.selectPageVo(new Page<>(2, 2), 20);
        List<User> records = userPage.getRecords();
        records.forEach(System.out::println);
    }

    @Test
    public void testEnum(){
        User user = new User();
        user.setName("admin");
        user.setAge(33);
        user.setSex(SexEnum.MAIL);
        int insert = userMapper.insert(user);
        System.out.println(insert);
    }
}
