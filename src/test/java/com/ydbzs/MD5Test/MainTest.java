package com.ydbzs.MD5Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 这是一个Test
 *
 * @author ：Axel
 * @date ：2020/5/28 11:46
 */
public class MainTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("aaa");
        list.add("bbb");
        list.add("ccc");
        List<String> list1 = new ArrayList<>();
        list1.add("aaa");
        list1.add("bbb");

//        list.addAll(list1);

        List<String> list2 = new ArrayList<>();
        for (String s : list) {
            for (String s1 : list1) {
                if (s.equals(s1)){
                    list2.add(s);
                }
            }
        }
//        list = list.stream().distinct().collect(Collectors.toList());

        for (String s : list2) {
            System.out.println(s);
        }
    }
}
