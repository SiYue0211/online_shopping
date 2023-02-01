package com.mall.common.exception;

public enum ErrorCodeEnum {
    UNKNOWN_EXCEPTION(10000, "Unknown Exception."),
    VALID_EXCEPTION(10001, "Parameter validation Fails.");


    private int code;
    private String msg;

    ErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
