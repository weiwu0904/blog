package com.weiwu.blog.service.impl;

import com.weiwu.blog.domain.User;
import com.weiwu.blog.mapper.UserMapper;
import com.weiwu.blog.service.UserService;
import com.weiwu.blog.uitl.MD5Utils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;


@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public User login(String username, String password) {

        password = MD5Utils.code(password);
        // 加密处理
        return userMapper.findByUsernameAndPassword(username,password);
    }
}
