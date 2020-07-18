/**
 * @ClassName ServerResponse
 * @Description
 * @Author HAHA
 * @Version V1.0.0
 * @Date 2019-02-28 20:01
 */
package com.zhh.guanli.common;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.codehaus.jackson.annotate.JsonIgnore;


import java.io.Serializable;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
//加上这个注解，保证序列化json的时候，如果是是null对象，key也会消失，（如果调用的构造器只有code参数，那么在序列化后没有msg和data变量）
public class ServerResponse<T> implements Serializable {

    private int code;
    private String msg;
    private T data;

    private ServerResponse(int code) {
        this.code = code;
    }

    private ServerResponse(int code, T data) {
        this.code = code;
        this.data = data;
    }

    private ServerResponse(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private ServerResponse(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    //加了这个注解后，这个字段在序列化后不会显示在json中
    @JsonIgnore
    public boolean isSuccess(){
        return this.code == ResponseCode.SUCCESS.getCode();
    }


    public int getCode(){
        return code;
    }
    public T getData(){
       return data;
    }
    public String getMsg(){
       return msg;
    }

    public static <T> ServerResponse<T> createBySuccess(){
       return new ServerResponse<T>(ResponseCode.SUCCESS.getCode());
    }

    public static <T> ServerResponse<T> createBySuccessMessage(String msg){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg);
    }

    public static <T> ServerResponse<T> createBySuccess(T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),data);
    }

    public static <T> ServerResponse<T> createBySuccess(String msg,T data){
        return new ServerResponse<T>(ResponseCode.SUCCESS.getCode(),msg,data);
    }

    public static <T> ServerResponse<T> createByError(){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getDesc());
    }

    public static <T> ServerResponse<T> createByErrorMessage(String errorMesssage){
        return new ServerResponse<T>(ResponseCode.ERROR.getCode(),errorMesssage);
    }

    public static <T> ServerResponse<T> createByErrorCodeMessage(int errorCode,String errorMessage){
        return new ServerResponse<T>(errorCode,errorMessage);
    }

}
