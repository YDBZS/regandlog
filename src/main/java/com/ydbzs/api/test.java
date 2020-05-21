package com.ydbzs.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @version 1.0
 * @Project regandlog
 * @Author 多宝
 * @Date 2020/4/6 18:39
 * @ClassName test
 * @Description
 */
@Controller
public class test {
    @RequestMapping("/test")
    public String test(){
        return "Register";
    }
}
