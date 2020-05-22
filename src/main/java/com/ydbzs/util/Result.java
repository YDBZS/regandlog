package com.ydbzs.util;

import lombok.Data;

/**
 * 自定义返回结果类
 *
 * @version 1.0
 * @project regandlog
 * @author 多宝
 * @date 2020/4/7 9:37
 * @className Result
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
        return new Result<T>(data);
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


    /*private Result(CodeMsg codeMsg, Object data){
            if(codeMsg != null && data != null){
                this.code = codeMsg.getCode();
                this.msg = codeMsg.getMsg();
                this.obj = data;
            }
        }*/

}
