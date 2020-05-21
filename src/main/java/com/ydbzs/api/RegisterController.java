package com.ydbzs.api;

import com.ydbzs.Service.registeService;
import com.ydbzs.Vo.LoginVO;
import com.ydbzs.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.util.Map;

/**
 * @version 1.0
 * @Project regandlog
 * @Author 多宝
 * @Date 2020/4/7 9:35
 * @ClassName LoginController
 * @Description
 */
@Controller
@RequestMapping("/register")
public class RegisterController extends BaseController {

    @Autowired
    private registeService registeService;



    /**
     * @Author：Axel
     * @Date：2020/4/22 10:19
     * @Params：[vo]
     * @Reture：java.lang.Integer
     * @Descrip：前端用户信息加密存储数据库
     */
    @RequestMapping("do_regist")
    @ResponseBody
    public Result doLogin(
            //前端参数校验
            @Valid LoginVO vo,
            //前端参数出现问题，错误信息
            BindingResult result
    ){

        //1.获取前端传递对象
        String name = vo.getName();
        String mobile = vo.getMobile();
        String password = vo.getPassword();
        //2.对前端参数进行空值判断
        if("" == name || "" == mobile || "" == password){
            if("" == name){
                return Result.errorMsg(CodeMsg.NAME_EMPTY);
            }else if ("" == mobile){
                return Result.errorMsg(CodeMsg.MOBILE_EMPTY);
            }else if("" == password){
                return Result.errorMsg(CodeMsg.PASS_EMPTY);
            }
        }
        //前端参数格式校验
        if(result.hasErrors()){
            //获取所有的错误字段以及是错误信息(封装在了BaseController)
            Map<String, String> allErr = getAllErr(result);
            return Result.errorMap(allErr);
        }


        System.out.println(vo);
        String salt = saltGener.Gener();
        String DBPass = MD5Util.inputPassToDbPass(password, salt);
        int i = registeService.doRegi(name, mobile, DBPass, salt);
        return Result.successMsg(CodeMsg.REG_SUCCESS);
    }



    /**
     * @Author：Axel
     * @Date：2020/4/22 10:20
     * @Params：[]
     * @Reture：java.lang.String
     * @Descrip：跳转注册失败页面
     */
    @RequestMapping("regerror")
    public String regerror(){
        return "RegisterFailed";
    }



    /**
     * @Author：Axel
     * @Date：2020/4/22 10:21
     * @Params：[]
     * @Reture：java.lang.String
     * @Descrip：跳转登录页面
     */
    @RequestMapping("/do_Login")
    public String do_Login(){
        return "Login";
    }


    /**
     * @Author：Axel
     * @Date：2020/4/26 18:39
     * @Params：[]
     * @Reture：java.lang.String
     * @Descrip：只是简单的做一个页面的跳转，跳转登陆成功提示页面
     */
    @RequestMapping("/reg_success")
    public String reg_success(){
        return "RegisteSuccess";
    }


    @PostMapping("/getCode")
    @ResponseBody
    public Result getCode(HttpServletRequest httpRequest){
        String code = VerificationCodeGener.getCode();
        HttpSession session = httpRequest.getSession();
        session.setAttribute("code",code);
        return Result.success(code);
    }




}
