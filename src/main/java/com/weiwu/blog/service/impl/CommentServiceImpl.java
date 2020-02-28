package com.weiwu.blog.service.impl;

import com.weiwu.blog.domain.Comment;
import com.weiwu.blog.mapper.CommentMapper;
import com.weiwu.blog.service.CommentService;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CommentServiceImpl implements CommentService {

    @Resource
    private CommentMapper commentMapper;

    @Override
    public List<Comment> getCommentsByBlogId(Long id) {
        List<Comment> comments = commentMapper.listByBlogId(id);
        // 构建评论之间的关系
        return refactorComments(comments);
    }

    @Override
    public int saveComment(Comment comment) {

        comment.setCreateTime(LocalDateTime.now());

        return commentMapper.saveComment(comment);
    }

    private List<Comment> refactorComments(List<Comment> comments) {

        // 所有一级的comments
        List<Comment> topComments = comments.stream().filter(comment -> {
            return comment.getParentComment() == null || comment.getParentComment().getId() == null;
        }).collect(Collectors.toList());

        // 构建其子评论
        topComments.stream().forEach(comment -> {
            // 获取当前评论的子评论
            List<Comment> childComments = comments.stream().filter(comment1 -> {
                if (comment1.getParentComment() != null) {
                    return comment1.getParentComment().getId() == comment.getId();
                }
                return false;

            }).collect(Collectors.toList());
            comment.setChildComments(childComments);
        });

        return topComments;
    }
}