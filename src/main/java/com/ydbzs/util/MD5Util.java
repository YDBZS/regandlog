package com.ydbzs.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * @version 1.0
 * @Project miaosha_2
 * @Author 多宝
 * @Date 2020/1/5 10:04
 * @ClassName MD5Util
 * @Description
 */
public class MD5Util {
    //对明文字符串做一个md5的加密
    public static String md5(String str){
        return DigestUtils.md5Hex(str);     //对用户密码明文做一次md5加密处理
    }

    private static final  String salt = "1a2b3c4d";

    //用户输入密码向后端进行传递时间进行一次md5加密  (第一层MD5)
    //用户输入完密码传递给后台是加密后的一个字符串
    public static String inputPassToFormPass(String inputPass){

        /**
         * 前端
         * salt = 1a2b3c4d
         * pass = "" + salt.charAt(0) + salt.charAt(2) + pass + salt.charAt(5) + salt.charAt(4);
         *
         *  a94abbfa0c1d24c9826eca0155af9a74
         *
         * 后台
         * private static final  String salt = "1a2b3c4d";
         * pass = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4)
         *
         * */

        String str = "" + salt.charAt(0) + salt.charAt(2) + inputPass + salt.charAt(5) + salt.charAt(4);
        //拼串之后在做一次MD5
        return md5(str);
    }



    //这里将用户传递给后台加密之后的串在进行一次MD5加密存储到数据库
    public static String formPassToDBmPass(String formPass,String salt){
        String str = "" + salt.charAt(0) + salt.charAt(2) + formPass + salt.charAt(5) + salt.charAt(4);
        return md5(str);
    }

    //将用户输入的密码直接存储到数据库的密码
    public static  String inputPassToDbPass(String input,String saltDB){
        //将明文密码转换为form密码
        String formPass = inputPassToFormPass(input);
        //form密码转化为db里面的密码
        String DBPass = formPassToDBmPass(formPass, saltDB);
        return DBPass;
    }


    public static void main(String[] args) {
        System.out.println(inputPassToFormPass("123456"));
        System.out.println(inputPassToDbPass("123456", "1a2b3c4d"));
    }
}
