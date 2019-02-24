package com.coderandyli.service;

import com.github.dadiyang.httpinvoker.annotation.HttpApi;
import com.github.dadiyang.httpinvoker.annotation.HttpReq;
import com.github.dadiyang.httpinvoker.annotation.Param;

import java.util.Map;

/**
 * Created by lizhen on 2019-02-11
 */
@HttpApi(prefix = "http://api.k780.com")
public interface ExchangeService {

    @HttpReq("")
    Map getExchange(@Param("appkey") String appkey,
                    @Param("sign") String sign,
                    @Param("app") String app,
                    @Param("format") String format,
                    @Param("curno") String curno,
                    @Param("bankno") String bankno);
}
