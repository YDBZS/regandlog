package com.ydbzs.util;

import java.util.Random;

/**
 * 从以下字符中随机取出8个字符作为用户密码加密盐值，存储数据库
 * @author ：多宝
 * @date ：2020/4/23 14:52
 * @project ：regandlog com.ydbzs.util
 */
public class saltGener {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static void main(String[] args) {
        Gener();
    }

    public static String Gener(){
        Random random = new Random();
        StringBuffer sb = new StringBuffer();
        for (int j = 0; j <= 7; j++) {
            int i = random.nextInt(chars.length);
            String aChar = chars[i];
            sb.append(aChar);
        }
        String s = sb.toString();
        return s;
    }


}
