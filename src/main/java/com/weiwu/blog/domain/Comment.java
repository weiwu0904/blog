package com.weiwu.blog.domain;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * 博客评论信息实体
 */
@Data
public class Comment {

    private Long id;
    private String nickname;
    private String email;
    private String content;
    private String avatar;
    private LocalDateTime createTime;

    /**
     * 评论属于哪篇博客
     */
    private Blog blog;

    /**
     * 父级评论
     */
    private Comment parentComment;
}
