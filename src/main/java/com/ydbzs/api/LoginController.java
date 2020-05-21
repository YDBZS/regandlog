package com.ydbzs.api;

import com.ydbzs.Service.LoginService;
import com.ydbzs.Vo.LoginVO;
import com.ydbzs.pojo.User;
import com.ydbzs.util.CodeMsg;
import com.ydbzs.util.MD5Util;
import com.ydbzs.util.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @Auth：Axel
 * @Date：2020/4/22 9:43
 * @Project：regandlog com.ydbzs.api
 * @Description：用户登录的Controller
 */
@Controller
@RequestMapping("/login")
public class LoginController extends BaseController {

    @Autowired
    LoginService loginService;


    /**
     * @Author：Axel
     * @Date：2020/4/23 15:41
     * @Params：[vo]
     * @Reture：com.ydbzs.util.Result
     * @Descrip：查询数据库是否存在用户信息
     */
    @PostMapping("/check_tel")
    @ResponseBody
    public Result check_tel(LoginVO vo){
        String mobile = vo.getMobile();
        int i = loginService.check_tel(mobile);
        if(i == 0) {
            return Result.successMsg(CodeMsg.USER_EMPTY);
        }
        return Result.successMsg(CodeMsg.USER_EXIST);
    }






    /**
     * @Author：Axel
     * @Date：2020/4/23 16:30
     * @Params：[vo]
     * @Reture：com.ydbzs.util.Result
     * @Descrip：用户登录的方法
     */
    @PostMapping("/do_login")
    @ResponseBody
    public Result doLogin(LoginVO vo){

        //根据用户账号查询数据库对应的盐值
        String mobile = vo.getMobile();
        String password = vo.getPassword();

        if(null == mobile || null == password){
            if(null == mobile){
                return Result.errorMsg(CodeMsg.MOBILE_EMPTY);
            }else if(null == password){
                return Result.errorMsg(CodeMsg.PASS_EMPTY);
            }
        }

        //判空之后根据用户账号查找数据库，是否有该用户注册信息
        Result result = check_tel(vo);
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


    @RequestMapping("/login_success")
    public String loginSuc(){
        return "loginsuccess";
    }


}
