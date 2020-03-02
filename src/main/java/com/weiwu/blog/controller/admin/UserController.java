package com.weiwu.blog.controller.admin;

import com.weiwu.blog.domain.User;
import com.weiwu.blog.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
@Controller
@RequestMapping("/admin")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/doLogin")
    public String doLogin(String username,
                          String password,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {

        if (username == null || password == null) {
            return setErrorPage(redirectAttributes,"用户名或密码不能为空");
        }

        User user = userService.login(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/admin/index";
        }

        return setErrorPage(redirectAttributes,"用户名或密码错误");
    }


    @GetMapping("logout")
    public String logout(HttpSession session) {

        session.removeAttribute("user");
        return "redirect:/admin";
    }


    private String setErrorPage(RedirectAttributes redirectAttributes, String message) {

        redirectAttributes.addFlashAttribute("message",message);
        return "redirect:/admin";
    }
}
