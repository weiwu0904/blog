package com.weiwu.blog.controller;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.constant.PageConstant;
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
    public String types(Model model) {
        return typesPage(0L, PageConstant.DEFAULT_PAGE, model);
    }

    @GetMapping("/types/{id}/{page}")
    public String typesPage(@PathVariable Long id,
                            @PathVariable int page,
                            Model model) {
        List<Type> types = typeService.indexTypeTopList(1, PageConstant.PAGE_SIZE_MAX).getList();

        if ((id == null || id == 0) && types.size() > 0) {
            id = types.get(0).getId();
        }
        if (page == 0) {
            page = PageConstant.DEFAULT_PAGE;
        }

        PageInfo<Blog> blogPage = blogService.indexListByType(page, PageConstant.DEFAULT_PAGE_SIZE, id);

        model.addAttribute("types", types);
        model.addAttribute("page", blogPage);
        model.addAttribute("activeTypeId", id);
        return "types";
    }
}
