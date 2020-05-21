package com.ydbzs.util;

/**
 * @version 1.0
 * @Project miaosha
 * @Author 多宝
 * @Date 2020/1/2 14:55
 * @ClassName CodeMsg
 */
public class CodeMsg {
    private int code;    //状态
    private String msg;   //返回信息

    //通常异常返回信息
    public static CodeMsg USER_EMPTY = new CodeMsg(404,"该用户不存在，请检查用户名以及是密码！");
    public static CodeMsg LOGIN_SUCCESS = new CodeMsg(200,"登陆成功！");
    public static CodeMsg REG_SUCCESS = new CodeMsg(200,"注册成功！");
    public static CodeMsg USER_EXIST = new CodeMsg(200,"用户名存在！！");
    public static CodeMsg LOGIN_FAILD = new CodeMsg(400,"登陆失败，请检查用户名密码是否匹配！！");

    //用户注册必填项数据为空
    public static CodeMsg NAME_EMPTY = new CodeMsg(502,"注册时间用户名不能为而空！！");
    public static CodeMsg MOBILE_EMPTY = new CodeMsg(503,"用户注册手机号不能为空！！");
    public static CodeMsg PASS_EMPTY = new CodeMsg(504,"用户密码不能为空！！");



    private CodeMsg(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

    public CodeMsg fillArgs(Object... args){
        int code = this.code;
        String message = String.format(this.msg,args);
        return new CodeMsg(code,message);
    }

    @Override
    public String toString() {
        return "CodeMsg{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                '}';
    }
}
