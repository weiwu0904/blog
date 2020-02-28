package com.weiwu.blog.mapper;

import com.weiwu.blog.domain.Comment;
import com.weiwu.blog.domain.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CommentMapper {

    /**
     * 根据 博客ID查询相关评论
     * @param blogId
     * @return
     */
    List<Comment> listByBlogId(Long blogId);

    /**
     * 保存评论
     * @param comment
     * @return
     */
    int saveComment(Comment comment);

    /**
     * 根据ID查询评论信息
     * @param id
     * @return
     */
    Comment getCommentById(Long id);
}
