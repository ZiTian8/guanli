/**
 * @ClassName ResponseCode
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019-02-28 20:10
 */
package com.zhh.guanli.common;

public enum ResponseCode {

    SUCCESS(200,"SUCCESS"),
    ERROR(400,"ERROR"),
    NEED_LOGIN(401,"NEED_LOGIN"),
    ILLEGAL_ARGUMENT(500,"ILLEGAL_ARGUMENT");

    private final int code;
    private final String desc;

    ResponseCode(int code, String desc) {
        this.code=code;
        this.desc=desc;
    }

    public int getCode(){
        return code;
    }

    public   String getDesc(){
        return desc;
    }




}
