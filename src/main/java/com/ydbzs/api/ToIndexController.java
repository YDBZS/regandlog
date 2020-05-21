package com.ydbzs.api;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转首页Controller
 *
 * @author ：Axel
 * @date ：2020/5/19 11:49
 */
@Controller
public class ToIndexController {
    @RequestMapping
    public String toIndex(){
        return "Register";
    }
}
