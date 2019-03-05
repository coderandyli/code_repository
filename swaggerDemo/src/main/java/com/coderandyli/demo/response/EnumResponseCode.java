package com.coderandyli.demo.response;

public enum EnumResponseCode {
    BAD_REQUEST("400", "Bad Request!"),
    NOT_AUTHORIZATION("401", "NotAuthorization"),
    NOT_FOUND_REQUEST("404", "Not Found Request Path"),
    METHOD_NOT_ALLOWED("405", "Method Not Allowed"),
    NOT_ACCEPTABLE("406", "Not Acceptable"),
    INTERNAL_SERVER_ERROR("500", "Internal Server Error"),
    OUTOF_SERVER_ERROR("600", "Outof Server Error"),
    INVALID_SIGN_ERROR("700", "Invalid Sign Error"),
    LOGIN_FIRST("999", "[服务器]请登录"),
    RUNTIME_EXCEPTION("1000", "[服务器]运行时异常"),
    NULL_POINTER_EXCEPTION("1001", "[服务器]空值异常"),
    CLASS_CAST_EXCEPTION("1002", "[服务器]数据类型转换异常"),
    IO_EXCEPTION("1003", "[服务器]IO异常"),
    NO_SUCH_METHOD_EXCEPTION("1004", "[服务器]未知方法异常"),
    INDEX_OUT_OF_BOUNDS_EXCEPTION("1005", "[服务器]数组越界异常"),
    CONNECT_EXCEPTION("1006", "[服务器]网络异常"),
    ERROR_MEDIA_TYPE("1007", "[服务器]Content-type错误，请使用application/json"),
    EMPTY_REQUEST_BOYD("1008", "[服务器]request请求body不能为空"),
    ERROR_REQUEST_BOYD("1009", "[服务器]request请求body非json对象"),
    ERROR_VERSION("2000", "[服务器]版本号错误"),
    ERROR_FORMAT_PARAMETER("2001", "[服务器]参数格式错误"),
    ERROR_VALIDATE_PARAMETER("2002", "[服务器]参数校验异常"),

    SUCCESS("S1000", "成功"),
    UN_LOGIN("EL0001", "请登录"),
    TASK_NOT_EXIST("EL0010", "任务不存在");

    private final String code;
    private final String message;

    EnumResponseCode(String code, String message) {
        this.code = code;
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}
