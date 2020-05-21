package com.ydbzs.util;

import lombok.Data;

/**
 * @version 1.0
 * @Project regandlog
 * @Author 多宝
 * @Date 2020/4/7 9:37
 * @ClassName Result
 * @Description  自定义返回结果类
 */
@Data
public class Result<T> {

    private Integer code;
    private String msg;
    private T data;

    public Result(T data) {
        this.data = data;
    }

    public static <T> Result<T> success(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> successMsg(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    public static <T> Result<T> errorMsg(CodeMsg codeMsg){
        return new Result<T>(codeMsg);
    }

    public static <T> Result<T> errorMsg(T data){
        return new Result<T>(data);
    }

    public static <T> Result<T> errorMap(T data){
        return new Result<T>(0000,"err",data);
    }

    private Result(int code){
        this.code = code;
    }

    private Result(int code,String msg){
        this.code = code;
        this.msg = msg;
    }

    private Result(int code,String msg, T data){
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private Result(CodeMsg codeMsg) {
        if(codeMsg != null) {
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
        }
    }

    private Result(CodeMsg codeMsg, T data){
        if(codeMsg != null && data != null){
            this.code = codeMsg.getCode();
            this.msg = codeMsg.getMsg();
            this.data = data;
        }
    }

}
