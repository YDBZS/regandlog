package com.ydbzs.util;

import org.springframework.stereotype.Component;

import java.util.Random;

/**
 * @Auth：Axel
 * @Date：2020/4/28 14:28
 * @Project：regandlog com.ydbzs.util
 * @Description：随机生成六位数字验证码
 */
public class VerificationCodeGener {
    public static String[] chars = new String[] {"0","1","2","3","4","5","6","7","8","9"};


    public static String getCode(){
        StringBuffer db = new StringBuffer();
        Random random = new Random();
        for (int i = 0; i < 6; i++) {
            int i1 = random.nextInt(chars.length);
            String aChar = chars[i1];
            db.append(aChar);
        }
        return db.toString();
    }

    public static void main(String[] args) {
        String code = getCode();
        System.out.println(code);
    }
}
