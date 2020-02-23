package com.weiwu.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping("/")
    String index() {
        int a = 1/0;
        return "index";
    }

    @GetMapping("/aa")
    String aa() {

        return "index";
    }
}
