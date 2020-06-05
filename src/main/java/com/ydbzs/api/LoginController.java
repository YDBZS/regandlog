package com.ydbzs.api;

import com.ydbzs.Service.LoginService;
import com.ydbzs.Vo.LoginVO;
import com.ydbzs.pojo.User;
import com.ydbzs.util.CodeMsg;
import com.ydbzs.util.MD5Util;
import com.ydbzs.util.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.validation.Valid;

/**
 * 用户登录的Controller
 * @author ：多宝
 * @date ：2020/4/22 9:43
 * @project ：regandlog com.ydbzs.api
 */
@Controller
@RequestMapping("/login")
@Api(value = "用于用户登录的后端接口", tags = "{用户用户登录的后端接口}")
public class LoginController extends BaseController {

    @Autowired
    private LoginService loginService;


    /**
     * 查询数据库是否存在用户信息
     * @author ：多宝
     * @date ：2020/5/21 16:38
     * @params ：[vo]
     * @return ：com.ydbzs.util.Result
     */
    @PostMapping("/check_tel")
    @ResponseBody
    @ApiOperation(value = "校验用户手机号是否存在", notes = "校验用户手机号是否存在", httpMethod = "POST")
    public Result<CodeMsg> check_tel(LoginVO vo){
        String mobile = vo.getMobile();
        int i = loginService.check_tel(mobile);
        if(i == 0) {
            return Result.successMsg(CodeMsg.USER_EMPTY);
        }
        return Result.successMsg(CodeMsg.USER_EXIST);
    }


    /**
     * 用户登录的方法
     * @author ：多宝
     * @date ：2020/5/21 16:40
     * @params ：[vo]
     * @return ：com.ydbzs.util.Result
     */
    @PostMapping("/do_login")
    @ResponseBody
    @ApiOperation(value = "用户登录的接口", notes = "专用于用户登录的接口", httpMethod = "POST")
    public Result<CodeMsg> doLogin(
            @Valid LoginVO vo,
            BindingResult results
    ){
        //根据用户账号查询数据库对应的盐值
        String mobile = vo.getMobile();
        String password = vo.getPassword();

        if(null == mobile) {
            return Result.errorMsg(CodeMsg.MOBILE_EMPTY);
        }else if(null == password){
            return Result.errorMsg(CodeMsg.PASS_EMPTY);
        }

        //判空之后根据用户账号查找数据库，是否有该用户注册信息
        Result<CodeMsg> result = check_tel(vo);
        Integer code = result.getCode();   //用户不存在的错误码是404
        if(code == 404){
            return Result.errorMsg(CodeMsg.USER_EMPTY);
        }

        String salt = loginService.findSalt(mobile);
        String dbpass = MD5Util.inputPassToDbPass(password, salt);
        User user = loginService.searchByTelAndPass(mobile, dbpass);
        if (null != user){
            return Result.successMsg(CodeMsg.LOGIN_SUCCESS);
        }
        return Result.errorMsg(CodeMsg.LOGIN_FAILD);
    }

    @PostMapping(value = "checkCode")


    @ApiOperation(value = "用户登录成功跳转接口")
    @RequestMapping("/login_success")
    public String loginSuc(){
        return "loginsuccess";
    }


}
