package com.baidu.mybatisplus.service.impl;

import com.baidu.mybatisplus.mapper.UserMapper;
import com.baidu.mybatisplus.pojo.User;
import com.baidu.mybatisplus.service.UserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl extends ServiceImpl<UserMapper, User> implements UserService {
}
