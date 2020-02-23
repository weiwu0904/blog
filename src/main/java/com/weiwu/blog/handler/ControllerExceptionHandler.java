package com.weiwu.blog.handler;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;

/**
 * spring mvc 统一异常处理
 */
@ControllerAdvice
public class ControllerExceptionHandler {

    /**
     * 记录日志对象
     */
    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 拦截Spring mvc controller 抛出的所有异常
     * @param req
     * @param e
     * @return
     */
    @ExceptionHandler(Exception.class)
    public ModelAndView exceptionHandler(HttpServletRequest req, Exception e) {

        // 记录错误的URL
        logger.error("request url: {}",req.getRequestURL());
        // 记录错误的异常信息
        logger.error("exception: {}",e);
        ModelAndView mv = new ModelAndView();
        mv.addObject("url", req.getRequestURL());
        mv.addObject("exception", e);

        // 展示自定义错误页面
        mv.setViewName("error/error");

        return mv;
    }
}
