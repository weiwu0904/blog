package com.weiwu.blog.domain;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 博客评论信息实体
 */
@Data
public class Comment {

    // 评论只有2级, 其他都属于子评论

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
     * 父亲评论
     */
    private Comment parentComment;

    /**
     * 我 @ 的评论
     */
    private Comment atComment;

    /**
     * 子评论
     */
    private List<Comment> childComments;

    /**
     * 属否是管理员评论
     */
    private boolean adminComment;
}
