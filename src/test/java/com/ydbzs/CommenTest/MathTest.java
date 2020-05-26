package com.ydbzs.CommenTest;

import com.ydbzs.regandlog.RegandlogApplication;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * 这是一个测试Math工具类的测试用例
 *
 * @author ：Axel
 * @date ：2020/5/26 9:50
 */


@SpringBootTest(classes = {RegandlogApplication.class})
public class MathTest {

    @Test
    public void test1(){
        Integer a = 123456;
        Integer b = 456;
        int i = Math.max(a, b);
        System.out.println(i);
    }

}
