package com.ydbzs.api;

import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 所有Controller公用的成分
 * @author ：多宝
 * @date ：2020/4/23 11:34
 * @project ：regandlog com.ydbzs.api
 */
public class BaseController {

    //用户密码加密盐值
    public static final String SALT = "1a2b3c4d";



    /**
     * 封装获取所有的前端参数校验的错误字段以及是错误信息
     * @author ：多宝
     * @date ：2020/4/26 10:44
     * @params ：[result]
     * @return ：java.util.Map<java.lang.String,java.lang.String>
     */
    public Map<String,String> getAllErr(BindingResult result){
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
