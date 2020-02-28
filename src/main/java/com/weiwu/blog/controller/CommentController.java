package com.weiwu.blog.controller;

import com.weiwu.blog.domain.Comment;
import com.weiwu.blog.domain.User;
import com.weiwu.blog.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 博客评论控制器
 */
@Controller
public class CommentController {

    @Autowired
    private CommentService commentService;

    @Value("${comments.avatar}")
    private String avatarPath;

    @GetMapping("/comments/{blogId}")
    public String comments(@PathVariable Long blogId, Model model) {

        List<Comment> comments = commentService.getCommentsByBlogId(blogId);
        model.addAttribute("comments",comments);
        return "blog :: commentList";
    }


    @PostMapping("/comments")
    public String post(Comment comment, HttpSession session) {

        User user = (User) session.getAttribute("user");
        if (user != null) {
            comment.setAvatar(user.getAvatar());
            comment.setAdminComment(true);
        } else {
            comment.setAvatar(avatarPath);
        }
        if (comment.getParentComment().getId() == -1) {
            comment.getParentComment().setId(null);
        }
        commentService.saveComment(comment);
        return "redirect:/comments/" + comment.getBlog().getId();
    }
}
