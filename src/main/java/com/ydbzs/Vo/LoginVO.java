package com.ydbzs.Vo;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;

/**
 * @version 1.0
 * @Project regandlog
 * @Author 多宝
 * @Date 2020/4/7 9:38
 * @ClassName LoginVO
 * @Description  接收前端参数
 */
@Data
public class LoginVO {

    @NotBlank
    @Length(max = 3 ,min = 2, message = "用户名格式在2-3个中文字符")
    private String Name;

    @NotBlank
    @Length(min = 11 , max = 11 , message = "正确的输入手机号码格式，十一位数字")
    private String Mobile;

    @NotBlank
    @Length(min = 8 , max = 16 , message = "密码请控制在8-16个字符")
    private String Password;
}
