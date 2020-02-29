package com.weiwu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.domain.Type;
import com.weiwu.blog.service.BlogService;
import com.weiwu.blog.service.TagService;
import com.weiwu.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class IndexController {

    @Autowired
    private BlogService blogService;

    @Autowired
    private TypeService typeService;

    @Autowired
    private TagService tagService;


    @GetMapping("/")
    String index(@RequestParam(name = "nowPage",defaultValue = "1") int nowPage,
                 @RequestParam(name = "pageNum", defaultValue = "10") int pageNum,
                 Model model) {

        return indexPage(nowPage,pageNum,model);
    }

    @GetMapping("/index")
    String indexPage(@RequestParam(name = "nowPage",defaultValue = "1") int nowPage,
                     @RequestParam(name = "pageNum", defaultValue = "10") int pageNum,
                     Model model) {

        PageInfo<Blog> blogPageInfo = blogService.indexList(nowPage, pageNum);
        PageInfo<Type> typePageInfo = typeService.indexTypeTopList(1, 6);
        PageInfo<Tag> tagPageInfo = tagService.indexTagTopList(1, 10);
        PageInfo<Blog> recommendBlogPageInfo = blogService.indexRecommendBlogList(1, 10);

        model.addAttribute("page",blogPageInfo);
        model.addAttribute("types",typePageInfo.getList());
        model.addAttribute("tags",tagPageInfo.getList());
        return "index";
    }

    @GetMapping("/search")
    public String search(@RequestParam(name = "nowPage",defaultValue = "1") int nowPage,
                         @RequestParam(name = "pageNum", defaultValue = "10") int pageNum,
                         @RequestParam String query,
                         Model model) {
        PageInfo<Blog> blogPageInfo = blogService.searchBlogList(query,nowPage, pageNum);
        model.addAttribute("page",blogPageInfo);
        model.addAttribute("query",query);
        return "search";
    }

    // 跳转博客详情页面
    @GetMapping("/blog/{id}")
    public String blogDetail(@PathVariable Long id, Model model) {

        Blog blog = blogService.getBlogDetail(id);
        model.addAttribute("blog",blog);
        return "blog";
    }

}
