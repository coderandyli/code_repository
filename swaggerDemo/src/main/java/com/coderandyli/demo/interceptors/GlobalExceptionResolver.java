package com.coderandyli.demo.interceptors;

import com.coderandyli.demo.exception.BusinessException;
import com.coderandyli.demo.response.EnumResponseCode;
import com.coderandyli.demo.response.ResponseData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by lizhen on 2018-12-16
 */
@RestControllerAdvice
@Slf4j
public class GlobalExceptionResolver {

    //声明要捕获的异常
    @ExceptionHandler(Exception.class)
    @ResponseBody
    public ResponseData<String> defultExcepitonHandler(HttpServletRequest request, Exception e) {
        e.printStackTrace();
        if (e instanceof BusinessException) {
            log.error("{},业务异常：{}", this.getClass(), e.getMessage());
            BusinessException businessException = (BusinessException) e;
            ResponseData<String> responseData = new ResponseData<>();
            responseData.setCode(EnumResponseCode.BAD_REQUEST.getCode());
            responseData.setMessage(EnumResponseCode.BAD_REQUEST.getMessage());

            return responseData;
        }
        //未知错误
        return null;
    }

}
