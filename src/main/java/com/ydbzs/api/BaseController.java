package com.ydbzs.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Auth：Axel
 * @Date：2020/4/23 11:34
 * @Project：regandlog com.ydbzs.api
 * @Description：所有Controller公用的成分
 */
public class BaseController {

    //用户密码加密盐值
    public static final String SALT = "1a2b3c4d";




    public  Map<String,String> getAllErr(BindingResult result){
        /**
        * @Author：Axel
        * @Date：2020/4/26 10:44
        * @Params：[result]
        * @Reture：java.util.Map<java.lang.String,java.lang.String>
        * @Descrip：封装获取所有的前端参数校验的错误字段以及是错误信息
        */
        Map<String,String> errmap = new HashMap<>();
        List<FieldError> fields = result.getFieldErrors();
        for (FieldError field : fields) {
            //获取所有发生错误的字段中的单独错误字段
            String fieldd = field.getField();
            //获取发生错误字段的错误信息
            String errMsg = field.getDefaultMessage();

            System.out.println(fieldd);
            System.out.println(errMsg);

            errmap.put(fieldd,errMsg);
        }
        return errmap;
    }


}
