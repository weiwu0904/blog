package com.weiwu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Blog;
import com.weiwu.blog.domain.Type;
import com.weiwu.blog.service.BlogService;
import com.weiwu.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * Created by limi on 2017/10/23.
 */
@Controller
public class TypeShowController {

    @Autowired
    private TypeService typeService;

    @Autowired
    private BlogService blogService;

    @GetMapping("/types")
    public String types(@RequestParam(name = "nowPage", defaultValue = "1")Integer nowPage,
                        @RequestParam(name = "pageNum", defaultValue = "10")Integer pageNum,
                        Long id,
                        Model model) {
        List<Type> types = typeService.indexTypeTopList(1,1000).getList();
        if (id == null) {
           id = types.get(0).getId();
        }

        PageInfo<Blog> blogPage = blogService.indexListByType(nowPage, pageNum, id);

        model.addAttribute("types", types);
        model.addAttribute("page", blogPage);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
