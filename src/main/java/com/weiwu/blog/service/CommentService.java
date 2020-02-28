package com.weiwu.blog.service;

import com.weiwu.blog.domain.Comment;

import java.util.List;

public interface CommentService {

    /**
     * 查询博客下的所有评论信息
     * @param id
     * @return
     */
    List<Comment> getCommentsByBlogId(Long id);


    /**
     * 保存评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment);
}
