package com.ydbzs.Validate;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 名字必须符合中英文、数字、不超过20个字符。
 *
 * @author ：Axel
 * @date ：2020/6/1 9:42
 */
public class NameValidate {
    public static void main(String[] args) {
        System.out.println(isSpecialChar("oppo findx"));
    }


    /**
     * 判断是否含有特殊字符
     *
     * @param str
     * @return true为包含，false为不包含
     */
    public static boolean isSpecialChar(String str) {
        String regex="^[a-zA-Z0-9\u4E00-\u9FA5]+$";
        Pattern pattern = Pattern.compile(regex);
        Matcher match=pattern.matcher(str);
        return match.find();
    }
}
