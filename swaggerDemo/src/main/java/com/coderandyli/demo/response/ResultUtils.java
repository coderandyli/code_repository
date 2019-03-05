package com.coderandyli.demo.response;

import com.alibaba.fastjson.JSONObject;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class ResultUtils {
    private static final String SUCCESS_MSG = "成功";

    /**
     * http回调成功
     *
     * @param object
     * @return
     */
    public static ResponseData success(Object object) {
        ResponseData result = new ResponseData();
        result.setCode(EnumResponseCode.SUCCESS.getCode());
        result.setMessage(EnumResponseCode.SUCCESS.getMessage());
        return result;
    }

    /**
     * 无object返回
     *
     * @return
     */
    public static ResponseData success() {
        return success(null);
    }

    /**
     * http回调错误
     *
     * @param code
     * @param msg
     * @return
     */
    public static ResponseData error(String code, String msg) {
        ResponseData result = new ResponseData();
        result.setCode(code);
        result.setMessage(msg);
        return result;
    }

    public static void errorResponse(HttpServletResponse response, String code, String message) {
        JSONObject json = new JSONObject();
        json.put("code", code);
        json.put("message", message);

        response.setCharacterEncoding("UTF-8");
        response.setContentType("application/json; charset=utf-8");
        PrintWriter out = null;
        try {
            out = response.getWriter();
            out.append(json.toString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}
