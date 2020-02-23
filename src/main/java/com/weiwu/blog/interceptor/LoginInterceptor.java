package com.weiwu.blog.interceptor;

import com.weiwu.blog.domain.User;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Spring mvc 拦截器
 * 登陆拦截器
 */
public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        User user = (User) request.getSession().getAttribute("user");
        if (user == null) {
            response.sendRedirect("/admin");
            return false;
        } else {
            return true;
        }
    }
}
