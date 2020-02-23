package com.weiwu.blog.service;

import com.weiwu.blog.domain.User;

public interface UserService {

    /**
     * 用户登陆
     * @return
     */
    public User login(String username, String password);
}
