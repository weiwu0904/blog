package com.weiwu.blog.controller.admin;

import com.github.pagehelper.PageInfo;
import com.weiwu.blog.domain.Type;
import com.weiwu.blog.exception.ServiceException;
import com.weiwu.blog.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;

@Controller
@RequestMapping("/admin/types")
public class TypeController {

    @Autowired
    private TypeService typeService;

    // 获取所有分类列表
    @GetMapping("")
    public String types(@RequestParam(name = "page", defaultValue = "1") Integer page,
                        @RequestParam(name = "pageNum",defaultValue = "5") Integer pageNum,
                        Model model) {

        PageInfo<Type> pageInfo = typeService.list(page, pageNum);
        pageInfo.getList();
        model.addAttribute("page", pageInfo);
        return "admin/types";
    }

    // 删除分类
    @GetMapping("/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        typeService.deleteType(id);
        return "redirect:/admin/types";
    }

    // 跳转到 编辑 分类页面
    @GetMapping("/input/{id}")
    public String input(@PathVariable("id") Long id,
                        Model model) {
        // 新创建一个空的type，保证前端取到的值不为空
        Type type = typeService.getById(id);
        model.addAttribute("type",type);
        return "admin/types-input";
    }

    // 跳转到 新增 分类页面
    @GetMapping("/input")
    public String input(Model model) {
        // 新创建一个空的type，保证前端取到的值不为空
        model.addAttribute("type",new Type());
        return "admin/types-input";
    }

    // 提交 新增分类或者编辑分类的请求
    @PostMapping("/save")
    public String saveType(@Valid Type type,
                           RedirectAttributes redirectAttributes,
                           BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "admin/types-input";
        }
        /// 编辑
        if (type.getId() != null) {
            typeService.updateType(type);
            redirectAttributes.addFlashAttribute("message","操作成功");
            return "redirect:/admin/types";
        }

        /// 新增
        try {
            typeService.saveType(type);
            redirectAttributes.addFlashAttribute("message","操作成功");
        } catch (ServiceException e) {
            redirectAttributes.addFlashAttribute("message","操作失败");
        }
        return "redirect:/admin/types";
    }
}
