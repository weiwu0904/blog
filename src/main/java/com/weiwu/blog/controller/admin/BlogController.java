package com.weiwu.blog.controller.admin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 后台管理页面博客控制器
 */
@Controller
@RequestMapping("admin")
public class BlogController {


    @RequestMapping("blogs")
    public String blogs() {
        return "admin/blogs";
    }
}
