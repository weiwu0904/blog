package com.weiwu.blog.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 博客系统用户信息
 */
@Data
public class User {

    /**
     * 主键ID
     */
    private Long id;

    /**
     * 昵称
     */
    private String nickname;
    private String username;
    private String password;
    private String email;
    /**
     * 头像
     */
    private String avatar;

    /**
     * 用户类型
     */
    private Integer type;

    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}
