package com.coderandyli.annotation;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.lang.reflect.Method;

/**
 * Created by lizhen on 2019-04-14
 */
@Aspect
@Slf4j
@Component //注入依赖
public class MyAnnotationAspect {

    private ThreadLocal<Long> startTime = new ThreadLocal<>();

    /**
     * 切入点
     */
    @Pointcut("@annotation(MyAnnotation)")
    public void pointcut() {
    }

    /**
     * 前置通知：目标方法执行之前执行以下方法体的内容
     *
     * @param joinPoint
     */
    @Before(value = "pointcut()")
    public void doBefore(JoinPoint joinPoint) {
        log.debug("++++++++++++++++++++ 前置通知 ++++++++++++++++++++");
        startTime.set(System.currentTimeMillis());
    }

    /**
     * 后置通知：不管是否发生异常，目标方法执行之后执行以下方法体的内容，
     *
     * @param joinPoint
     */
    @After(value = "pointcut()&& @annotation(myAnnotation)")
    public void afterMethod(JoinPoint joinPoint, MyAnnotation myAnnotation) {
        log.debug("++++++++++++++++++++ 后置通知 ++++++++++++++++++++");

        // 接收到请求，记录请求内容
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        Class clazz = joinPoint.getTarget().getClass(); //拦截的类名
        Method method = ((MethodSignature) joinPoint.getSignature()).getMethod(); ////拦截的方法
        log.debug("MyAnnotation value = {}", myAnnotation.value());
        log.debug("执行了 类: {}, 方法：{}, 自定义请求地址: {} ", clazz, method, request.getRequestURL());


        HttpSession session = (HttpSession) attributes.resolveReference(RequestAttributes.REFERENCE_SESSION);
        //获取传入目标方法的参数
        Object[] args = joinPoint.getArgs();
        for (int i = 0; i < args.length; i++) {
            Object o = args[i];
            if (o instanceof ServletRequest || (o instanceof ServletResponse) || o instanceof MultipartFile) {
                args[i] = o.toString();
            }
        }
    }

    /**
     * 返回通知：目标方法正常执行完毕时执行以下代码
     *
     * @param joinPoint
     * @param myAnnotation
     * @param result
     * @return
     */
    @AfterReturning(value = "pointcut() && @annotation(myAnnotation)", returning = "result")
    public Object afterReturning(JoinPoint joinPoint, MyAnnotation myAnnotation, Object result) {
        log.debug("++++++++++++++++++++ 返回通知 ++++++++++++++++++++");
        log.debug("执行结果 : {}, 耗时：{}ms", result, System.currentTimeMillis() - startTime.get());
        return result;
    }


    /**
     * 异常通知
     *
     * @param joinPoint
     * @param myAnnotation
     * @param ex
     */
    @AfterThrowing(value = "pointcut() && @annotation(myAnnotation)", throwing = "ex")
    public void afterThrowing(JoinPoint joinPoint, MyAnnotation myAnnotation, Exception ex) {
        log.debug("++++++++++++++++++++ 异常通知 ++++++++++++++++++++");
        log.error("请求：【{}】 跑出异常", myAnnotation.value());
    }

    /**
     * 环绕通知：环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     *
     * @param point
     * @param myAnnotation
     * @return
     */
    @Around(value = "pointcut() && @annotation(myAnnotation)")
    public Object around(ProceedingJoinPoint point, MyAnnotation myAnnotation) {
        log.debug("++++++++++++++++++++ 环绕通知 ++++++++++++++++++++");

        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();

        String servletPath = request.getServletPath();
        log.debug("自定义请求路径 : {}", servletPath);

        Class clazz = point.getTarget().getClass(); //拦截的类名
        Method method = ((MethodSignature) point.getSignature()).getMethod(); ////拦截的方法
        log.debug("MyAnnotation value = {}", myAnnotation.value());
        log.debug("执行了 类: {}, 方法：{}, 自定义请求地址: {} ", clazz, method, request.getRequestURL());

        String methodName = point.getSignature().getName();
        Object result = null;


        try {
            log.debug("【环绕通知中的--->前置通知】");
            result = point.proceed(); //执行目标方法
            log.debug("【环绕通知中的--->返回通知】");
        } catch (Throwable throwable) {
            log.debug("【环绕通知中的--->异常通知");
            throwable.printStackTrace();
            return throwable.getMessage();
        }
        log.debug("【环绕通知中的--->后置通知");
        return result;
    }

}
