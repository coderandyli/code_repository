package com.coderandyli.redis.demo.aspect;

import com.coderandyli.redis.demo.annotation.RepeatSubmit;
import com.coderandyli.redis.demo.utils.RedisLock;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lizhen on 2019-07-10
 */
@Aspect
@Component
@Slf4j
public class RepeatSubmitAspect {

    @Autowired
    private RedisLock redisLock;

    /**
     * 切入点
     */
    @Pointcut("@annotation(com.coderandyli.redis.demo.annotation.RepeatSubmit)")
    public void pointcut() {
    }


    /**
     * 环绕通知：环绕通知：目标方法执行前后分别执行一些代码，发生异常的时候执行另外一些代码
     *
     * @param point
     * @param repeatSubmit
     * @return
     */
    @Around(value = "pointcut() && @annotation(repeatSubmit)")
    public Object around(ProceedingJoinPoint point, RepeatSubmit repeatSubmit) {
        ServletRequestAttributes attributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
        HttpServletRequest request = attributes.getRequest();
        String servletPath = request.getServletPath();
        String token = request.getHeader("Authorization");

        String key = getKey(token, servletPath);
        String value = String.valueOf(System.currentTimeMillis() + 60 * 1000);

        boolean isLock = redisLock.lock(key, value);
        if (isLock) {
            Object result = null;
            try {
                result = point.proceed(); //执行目标方法
            } catch (Throwable throwable) {
                throwable.printStackTrace();
            } finally {
                Boolean unloack = redisLock.unloack(key, value);
                if (!unloack) {
                    log.error("【Redis分布式锁】解锁异常");
                }
            }
            return result;
        } else {
            return "请求重复，请稍后重试！！！";
        }
    }

    private String getKey(String token, String path) {
        return token + path;
    }

}
