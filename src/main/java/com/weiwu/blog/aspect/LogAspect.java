package com.weiwu.blog.aspect;

import com.weiwu.blog.handler.ControllerExceptionHandler;
import lombok.*;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * 统一日志记录器 aop
 * 请求 URL
 * 访问者 IP
 * 调用的方法
 * 参数 args
 */
@Aspect
@Component
public class LogAspect {
    /**
     * 记录日志对象
     */
    private Logger logger = LoggerFactory.getLogger(ControllerExceptionHandler.class);

    /**
     * 定义切面
     */
    @Pointcut("execution(* com.weiwu.blog.controller..*.*(..))")
    private void pt() {
    }


    @Around("pt()")
    private Object doLog(ProceedingJoinPoint pjp) throws Throwable {

        logger.info("=========请求开始=========");

        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest req = requestAttributes.getRequest();
        String url = req.getRequestURL().toString();
        String ip = req.getRemoteAddr();
        String className = pjp.getSignature().getDeclaringTypeName();
        String method = pjp.getSignature().getName();
        Object[] args = pjp.getArgs();

        RequestLog reqInfo = RequestLog.builder()
                .url(url)
                .ip(ip)
                .className(className)
                .method(method)
                .args(args)
                .build();
        logger.info("{}", reqInfo);

        // 处理原始方法
        Object res =  pjp.proceed();

        logger.info("result：{}",res);
        logger.info("=========请求结束=========");
        return res;
    }

    @Builder
    @NoArgsConstructor
    @AllArgsConstructor
    @Data
    private static class RequestLog {
        private String url;
        private String ip;
        private String className;
        private String method;
        private Object[] args;
    }
}
