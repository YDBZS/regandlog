package com.ydbzs.Service.Impl;

import com.ydbzs.Service.LoginService;
import com.ydbzs.mapper.UserMapper;
import com.ydbzs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @Auth：Axel
 * @Date：2020/4/22 10:56
 * @Project：regandlog com.ydbzs.Service.Impl
 * @Description：
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    /**
     * @Author：Axel
     * @Date：2020/4/23 15:57
     * @Params：[tel]
     * @Reture：int
     * @Descrip：查询数据库是否存在当前用户输入的账户
     */
    @Override
    public int check_tel(String tel) {
        int num = userMapper.check_tel(tel);
        return num;
    }


    /**
     * @Author：Axel
     * @Date：2020/4/23 16:32
     * @Params：[tel]
     * @Reture：java.lang.String
     * @Descrip：根据用户的一个账号查询用户在数据库存储的一个盐值
     */
    @Override
    public String findSalt(String tel) {
        String salt = userMapper.findSalt(tel);
        return salt;
    }

    /**
     * @Author：Axel
     * @Date：2020/4/23 15:56
     * @Params：[tel, pass]
     * @Reture：com.ydbzs.pojo.User
     * @Descrip：用户登录的方法
     */
    @Override
    public User searchByTelAndPass(String tel, String Dbpass) {
        User user = userMapper.searchByTelAndPass(tel, Dbpass);
        return user;
    }
}
