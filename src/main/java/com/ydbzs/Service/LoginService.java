package com.ydbzs.Service;

import com.ydbzs.pojo.User;

/**
 * 用户登录的一个Service
 * @author ：多宝
 * @date ：2020/4/22 10:54
 * @project ：regandlog com.ydbzs.Service
 */
public interface LoginService {

    /**
     * 查询数据库是否存在当前用户输入的账户
     * @author ：多宝
     * @date ：2020/4/23 15:55
     * @params ：[tel]
     * @return ：int
     */
    public int check_tel(String tel);



    /**
     * 根据用户的一个账号查询用户在数据库存储的一个盐值
     * @author ：多宝
     * @date ：2020/4/23 16:31
     * @params ：[tel]
     * @return ：java.lang.String
     */
    String findSalt(String tel);


    /**
     * 用户登录的方法
     * @author ：多宝
     * @date ：2020/4/23 15:54
     * @params ：[tel, pass]
     * @return ：com.ydbzs.pojo.User
     */
    public User searchByTelAndPass(String tel, String dbPass);
}
