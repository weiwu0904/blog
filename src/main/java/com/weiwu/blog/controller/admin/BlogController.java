package com.weiwu.blog.controller.admin;

import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.domain.User;
import com.weiwu.blog.req.AdminBlogReq;
import com.weiwu.blog.service.BlogService;
import com.weiwu.blog.service.TagService;
import com.weiwu.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

/**
 * Created by limi on 2017/10/15.
 */
@Controller
@RequestMapping("/admin/blogs")
public class BlogController {

    private static final String INPUT = "admin/blogs-input";
    private static final String LIST = "admin/blogs";
    private static final String REDIRECT_LIST = "redirect:/admin/blogs";


    @Autowired
    private BlogService blogService;
    @Autowired
    private TypeService typeService;
    @Autowired
    private TagService tagService;

    @GetMapping("")
    public String blogs(@RequestParam(value = "page",defaultValue = "1") int nowPage,
                        @RequestParam(value = "pageNum", defaultValue = "10") int pageNum,
                        Model model) {
        model.addAttribute("types", typeService.listAll());
        model.addAttribute("page", blogService.adminListByReq(nowPage,pageNum,null));
        return LIST;
    }

    @PostMapping("/search")
    public String search(@RequestParam(value = "nowPage",defaultValue = "1") int nowPage,
                         @RequestParam(value = "pageNum", defaultValue = "10") int pageNum,
                         AdminBlogReq blogReq,
                         Model model) {
        model.addAttribute("page", blogService.adminListByReq(nowPage,pageNum,blogReq));
        return "admin/blogs :: blogList";
    }


    //新增
    @GetMapping("/input")
    public String input(Model model) {
        setTypeAndTag(model);
        model.addAttribute("blog", new Blog());
        return INPUT;
    }

    // 编辑
    @GetMapping("/input/{id}")
    public String editInput(@PathVariable Long id, Model model) {
        setTypeAndTag(model);
        Blog blog = blogService.getBlog(id);
        model.addAttribute("blog",blog);
        return INPUT;
    }
//
    private void setTypeAndTag(Model model) {
        model.addAttribute("types", typeService.listAll());
        model.addAttribute("tags", tagService.list());
    }
//

    // 提交
    @PostMapping("/save")
    public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {
        blog.setUser((User) session.getAttribute("user"));
        if (blog.getId() == null) {
            blogService.saveBlog(blog);
        } else {
            blogService.updateBlog(blog);
        }

        return REDIRECT_LIST;
    }


    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功");
        return REDIRECT_LIST;
    }



}
