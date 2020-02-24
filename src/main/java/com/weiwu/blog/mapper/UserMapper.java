package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.User;
import org.apache.ibatis.annotations.Param;

public interface UserMapper {

    /**
     * 查询用户信息
     * @param username
     * @param password
     * @return
     */
    User findByUsernameAndPassword(@Param("username") String username,
                                   @Param("password") String password);
}
