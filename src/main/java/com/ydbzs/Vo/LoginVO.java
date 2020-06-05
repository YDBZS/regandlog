package com.ydbzs.Vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * 接收前端参数
 * @version 1.0
 * @project regandlog
 * @author 多宝
 * @date 2020/4/7 9:38
 * @className LoginVO
 */
@Data
@ApiModel(value = "用户注册登录通用VO对象", description = "用户注册登录通用入参对象封装")
public class LoginVO {

    @NotBlank(message = "用户名不能为空")
    @Length(max = 3 ,min = 2, message = "用户名格式在2-3个中文字符")
    @ApiModelProperty(value = "用户名", name = "用户姓名", required = true)
    private String Name;

    @NotBlank(message = "注册手机号不能为空")
    @Length(min = 11 , max = 11 , message = "正确的输入手机号码格式，十一位数字")
    @ApiModelProperty(value = "用户手机号", notes = "用户手机号", required = true)
    private String Mobile;

    @NotBlank(message = "设置的密码不能为空")
    @Length(min = 8 , max = 16 , message = "密码请控制在8-16个字符")
    @ApiModelProperty(value = "用户密码", notes = "用户设置的登录密码", required = true)
    private String Password;

    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(value = "用户验证码", notes = "只做参数校验，不存储数据库，防止代刷接口", required = true)
    private String code;
}
