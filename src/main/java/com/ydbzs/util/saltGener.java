package com.ydbzs.util;

import java.util.Random;

/**
 * @Auth：Axel
 * @Date：2020/4/23 14:52
 * @Project：regandlog com.ydbzs.util
 * @Description：从以下字符中随机取出8个字符作为用户密码加密盐值，存储数据库
 */
public class saltGener {

    public static String[] chars = new String[] { "a", "b", "c", "d", "e", "f",
            "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r", "s",
            "t", "u", "v", "w", "x", "y", "z", "0", "1", "2", "3", "4", "5",
            "6", "7", "8", "9", "A", "B", "C", "D", "E", "F", "G", "H", "I",
            "J", "K", "L", "M", "N", "O", "P", "Q", "R", "S", "T", "U", "V",
            "W", "X", "Y", "Z" };

    public static void main(String[] args) {

        /*//创建字符串缓冲区
        StringBuffer sb = new StringBuffer();

        Random random = new Random();
        int i = random.nextInt(chars.length);
        System.out.println(i);
        String aChar = chars[i];
        System.out.println("--------------------------------------------绿色分割--------------------------------------------------");
        System.out.println(aChar);


        System.out.println("--------------------------------------------绿色分割--------------------------------------------------");
        //循环往缓冲区添加字符形成字符串
        for (int j = 0; j <= 7; j++) {
            int w = random.nextInt(chars.length);
            String aChar1 = chars[w];
            sb.append(aChar1);
        }
        String s = sb.toString();
        System.out.println(s);*/
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
