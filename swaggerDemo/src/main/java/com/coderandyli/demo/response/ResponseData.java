package com.coderandyli.demo.response;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import java.util.Calendar;

@SuppressWarnings({"unchecked"})
@ApiModel(value = "返回对象")
public class ResponseData<T> {

    @ApiModelProperty(value = "返回码")
    private String code;

    @ApiModelProperty(value = "错误信息")
    private String message;

    @ApiModelProperty(value = "请求时间")
    private long timestamp;

    @ApiModelProperty(value = "返回值")
    private T result = (T) new Object();

    public ResponseData() {
        this.code = EnumResponseCode.SUCCESS.getCode();
        this.timestamp = Calendar.getInstance().getTimeInMillis();
        String ok = "ok";
        this.result = (T) ok;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }
}
