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
@RequestMapping("admin")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("doLogin")
    public String doLogin(String username,
                          String password,
                          HttpSession session,
                          RedirectAttributes redirectAttributes) {

        User user = userService.login(username, password);
        if (user != null) {
            user.setPassword(null);
            session.setAttribute("user",user);
            return "redirect:/admin/index";
        }

        redirectAttributes.addFlashAttribute("message","用户名或密码错误");
        return "redirect:/admin";
    }


    @GetMapping("logout")
    public String logout(HttpSession session) {

        session.removeAttribute("user");
        return "redirect:/admin";
    }
}
