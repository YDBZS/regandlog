package com.ydbzs.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 跳转首页Controller
 *
 * @author ：多宝
 * @date ：2020/5/19 11:49
 */
@Controller
@Api(value = "默认跳转页面Controller", tags = {"默认跳转页面Controller"})
public class ToIndexController {

    @RequestMapping
    @ApiOperation(value = "访问端口默认的欢迎页面", notes = "访问端口默认的欢迎页面", httpMethod = "POST")
    public String toIndex(){
        return "Register";
    }

}
