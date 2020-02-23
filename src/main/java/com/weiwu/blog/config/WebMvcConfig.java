package com.weiwu.blog.config;

import com.weiwu.blog.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        //后台登陆页
        registry.addViewController("/admin").setViewName("/admin/login");
        registry.addViewController("/admin/login").setViewName("/admin/login");

        // 映射后台首页，登陆成功后跳转
        registry.addViewController("/admin/index").setViewName("/admin/index");
        registry.addViewController("/admin/blogs").setViewName("/admin/blogs");
        registry.addViewController("/admin/types").setViewName("/admin/types");
        registry.addViewController("/admin/tags").setViewName("/admin/tags");
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginInterceptor())
                .addPathPatterns("/admin/**")
                .excludePathPatterns("/admin")
                .excludePathPatterns("/admin/login")
                .excludePathPatterns("/admin/doLogin");
    }
}
