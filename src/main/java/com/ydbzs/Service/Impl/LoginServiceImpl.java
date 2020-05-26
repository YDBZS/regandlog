package com.ydbzs.Service.Impl;

import com.ydbzs.Service.LoginService;
import com.ydbzs.mapper.UserMapper;
import com.ydbzs.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author ：多宝
 * @date ：2020/4/22 10:56
 */
@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    UserMapper userMapper;

    /**
     * 查询数据库是否存在当前用户输入的账户
     * @author ：多宝
     * @date ：2020/4/23 15:57
     * @params ：[tel]
     * @return ：int
     */
    @Override
    public int check_tel(String tel) {
        int num = userMapper.check_tel(tel);
        return num;
    }


    /**
     * 根据用户的一个账号查询用户在数据库存储的一个盐值
     * @author ：多宝
     * @date ：2020/4/23 16:32
     * @params ：[tel]
     * @return ：java.lang.String
     */
    @Override
    public String findSalt(String tel) {
        String salt = userMapper.findSalt(tel);
        return salt;
    }

    /**
     * 用户登录的方法
     * @author ：多宝
     * @date ：2020/4/23 15:56
     * @params ：[tel, pass]
     * @return ：com.ydbzs.pojo.User
     */
    @Override
    public User searchByTelAndPass(String tel, String Dbpass) {
        User user = userMapper.searchByTelAndPass(tel, Dbpass);
        return user;
    }
}
