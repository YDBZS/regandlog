package com.ydbzs.api;

import com.ydbzs.Service.registeService;
import com.ydbzs.Vo.LoginVO;
import com.ydbzs.util.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
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
 * 注册Controller
 *
 * @version 1.0
 * @project regandlog
 * @author 多宝
 * @date 2020/4/7 9:35
 * @className LoginController
 */
@Controller
@RequestMapping("/register")
@Api(value = "用户注册的接口", tags = "{用户注册的接口}")
public class RegisterController extends BaseController {

    @Autowired
    private registeService registeService;



    /**
     * 前端用户信息加密存储数据库
     * @author ：多宝
     * @date ：2020/4/22 10:19
     * @params ：[vo]
     * @return ：java.lang.Integer
     */
    @RequestMapping("do_regist")
    @ResponseBody
    @ApiOperation(value = "用户注册的接口", notes = "用户注册的接口", httpMethod = "POST")
    public Result<Object> doRegist(
            //前端参数校验
            @Valid LoginVO vo,
            //前端参数出现问题，错误信息
            BindingResult result
    ){
        //1.获取前端传递对象
        String name = vo.getName();
        String mobile = vo.getMobile();
        String password = vo.getPassword();
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
     * 跳转注册失败页面
     * @author ：多宝
     * @date ：2020/4/22 10:20
     * @params ：[]
     * @return ：java.lang.String
     */
    @RequestMapping("regerror")
    @ApiOperation(value = "用户注册失败跳转页面", notes = "用户注册失败跳转页面", httpMethod = "GET")
    public String regerror(){
        return "RegisterFailed";
    }



    /**
     * 跳转登录页面
     * @author ：多宝
     * @date ：2020/4/22 10:21
     * @params ：[]
     * @return ：java.lang.String
     */
    @RequestMapping("/do_Login")
    @ApiOperation(value = "用户跳转登录页面接口", notes = "用户跳转登录页面接口", httpMethod = "GET")
    public String do_Login(){
        return "Login";
    }


    /**
     * 只是简单的做一个页面的跳转，跳转登陆成功提示页面
     * @author ：多宝
     * @date ：2020/4/26 18:39
     * @params ：[]
     * @return ：java.lang.String
     */
    @RequestMapping("/reg_success")
    @ApiOperation(value = "用户登陆成功的跳转接口", notes = "用户登陆成功的跳转接口", httpMethod = "GET")
    public String reg_success(){
        return "RegisteSuccess";
    }


    /**
     * 前端获取验证码的Controller
     * @author ：多宝
     * @date ：2020/5/22 9:56
     * @params ：[httpRequest]
     * @return ：com.ydbzs.util.Result<java.lang.Object>
     */
    @PostMapping("/getCode")
    @ResponseBody
    @ApiOperation(value = "用户获取动态验证码的后端接口", notes = "用户获取动态验证码的后端接口", httpMethod = "POST")
    public Result<Object> getCode(HttpServletRequest httpRequest){
        String code = VerificationCodeGener.getCode();
        HttpSession session = httpRequest.getSession();
        session.setAttribute("code",code);
        return Result.success(code);
    }

    /**
     * 校验验证码的Controller
     * @author ：多宝
     * @date ：2020/5/22 9:57
     * @params ：[]
     * @return ：com.ydbzs.util.Result<com.ydbzs.util.CodeMsg>
     */
    @PostMapping("/checkCode")
    @ResponseBody
    @ApiOperation(value = "校验验证码的后端接口", notes = "校验验证码的后端接口", httpMethod = "POST")
    public Result<CodeMsg> checkCode(HttpServletRequest request,String code){

        HttpSession session = request.getSession();
        Object code1 = session.getAttribute("code");
        String s = String.valueOf(code1);
        if ("".equals(code)){
            return Result.errorMsg(CodeMsg.CODE_IS_BLANK);
        }
        if ("null".equals(s)){
            return Result.errorMsg(CodeMsg.CODE_MISS);
        }
        if (code.equals(s)){
            session.removeAttribute("code");
            return Result.successMsg(CodeMsg.CODE_IS_CORRECT);
        }

        return Result.errorMsg(CodeMsg.CODE_ERROR);
    }




}
