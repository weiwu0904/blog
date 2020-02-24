package com.weiwu.blog.controller.admin;

import com.weiwu.blog.req.AdminBlogReq;
import com.weiwu.blog.service.BlogService;
import com.weiwu.blog.service.TagService;
import com.weiwu.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

/**
 * Created by limi on 2017/10/15.
 */
@Controller
@RequestMapping("/admin")
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

    @GetMapping("/blogs")
    public String blogs(@RequestParam(value = "page",defaultValue = "1") int nowPage,
                        @RequestParam(value = "pageNum", defaultValue = "10") int pageNum,
                        Model model) {
        model.addAttribute("types", typeService.listAll());
        model.addAttribute("page", blogService.adminList(nowPage,pageNum));
        return LIST;
    }

    @PostMapping("/blogs/search")
    public String search(@RequestParam(value = "page",defaultValue = "1") int nowPage,
                         @RequestParam(value = "pageNum", defaultValue = "10") int pageNum,
                         AdminBlogReq blogReq,
                         Model model) {
        model.addAttribute("page", blogService.adminListByReq(nowPage,pageNum,blogReq));
        return "admin/blogs :: blogList";
    }


//    @GetMapping("/blogs/input")
//    public String input(Model model) {
//        setTypeAndTag(model);
//        model.addAttribute("blog", new Blog());
//        return INPUT;
//    }
//
//    private void setTypeAndTag(Model model) {
//        model.addAttribute("types", typeService.listType());
//        model.addAttribute("tags", tagService.listTag());
//    }
//
//
//    @GetMapping("/blogs/{id}/input")
//    public String editInput(@PathVariable Long id, Model model) {
//        setTypeAndTag(model);
//        Blog blog = blogService.getBlog(id);
//        blog.init();
//        model.addAttribute("blog",blog);
//        return INPUT;
//    }
//
//
//
//    @PostMapping("/blogs")
//    public String post(Blog blog, RedirectAttributes attributes, HttpSession session) {
//        blog.setUser((User) session.getAttribute("user"));
//        blog.setType(typeService.getType(blog.getType().getId()));
//        blog.setTags(tagService.listTag(blog.getTagIds()));
//        Blog b;
//        if (blog.getId() == null) {
//            b =  blogService.saveBlog(blog);
//        } else {
//            b = blogService.updateBlog(blog.getId(), blog);
//        }
//
//        if (b == null ) {
//            attributes.addFlashAttribute("message", "操作失败");
//        } else {
//            attributes.addFlashAttribute("message", "操作成功");
//        }
//        return REDIRECT_LIST;
//    }


    @GetMapping("/blogs/{id}/delete")
    public String delete(@PathVariable Long id,RedirectAttributes attributes) {
        blogService.deleteBlog(id);
        attributes.addFlashAttribute("message", "删除成功");
        return REDIRECT_LIST;
    }



}
