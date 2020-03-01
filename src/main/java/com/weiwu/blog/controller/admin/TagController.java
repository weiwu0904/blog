package com.weiwu.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Tag;
import com.weiwu.blog.exception.ServiceException;
import com.weiwu.blog.service.TagService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/tags")
public class TagController {

    @Autowired
    private TagService tagService;

    @GetMapping("")
    public String tags(@RequestParam(value = "page",defaultValue = "1") int page,
                       @RequestParam(value = "pageNum",defaultValue = "5") int pageNum,
                       Model model) {
        PageInfo<Tag> pageInfo = tagService.listTag(page,pageNum);
        model.addAttribute("page",pageInfo);
        return "admin/tags";
    }

    // 删除分类
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        tagService.deleteTag(id);
        return "redirect:/admin/tags";
    }

    // 跳转到 编辑 分类页面
    @GetMapping("/input/{id}")
    public String input(@PathVariable("id") Long id,
                        Model model) {
        Tag tag = tagService.getTag(id);
        model.addAttribute("tag",tag);
        return "admin/tags-input";
    }

    // 跳转到 新增 分类页面
    @GetMapping("/input")
    public String input(Model model) {
        // 新创建一个空的type，保证前端取到的值不为空
        model.addAttribute("tag",new Tag());
        return "admin/tags-input";
    }

    // 提交 新增分类或者编辑分类的请求
    @PostMapping("/save")
    public String saveType(@Valid Tag tag,
                           RedirectAttributes redirectAttributes,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/tags-input";
        }
        /// 编辑
        if (tag.getId() != null) {
            tagService.updateTag(tag);
            redirectAttributes.addFlashAttribute("message","操作成功");
            return "redirect:/admin/tags";
        }

        /// 新增
        try {
            tagService.saveTag(tag);
            redirectAttributes.addFlashAttribute("message","操作成功");
        } catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/tags";
    }


}
