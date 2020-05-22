package com.ydbzs.Vo;

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
public class LoginVO {

    @NotBlank(message = "用户名不能为空")
    @Length(max = 3 ,min = 2, message = "用户名格式在2-3个中文字符")
    private String Name;

    @NotBlank(message = "注册手机号不能为空")
    @Length(min = 11 , max = 11 , message = "正确的输入手机号码格式，十一位数字")
    private String Mobile;

    @NotBlank(message = "设置的密码不能为空")
    @Length(min = 8 , max = 16 , message = "密码请控制在8-16个字符")
    private String Password;

    @NotBlank(message = "验证码不能为空")
    private String code;
}
