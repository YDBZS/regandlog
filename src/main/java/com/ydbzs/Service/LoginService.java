package com.ydbzs.Service;

import com.ydbzs.pojo.User;

/**
 * @Auth：Axel
 * @Date：2020/4/22 10:54
 * @Project：regandlog com.ydbzs.Service
 * @Description：
 */
public interface LoginService {

    /**
     * @Author：Axel
     * @Date：2020/4/23 15:55
     * @Params：[tel]
     * @Reture：int
     * @Descrip：查询数据库是否存在当前用户输入的账户
     */
    public int check_tel(String tel);



    /**
     * @Author：Axel
     * @Date：2020/4/23 16:31
     * @Params：[tel]
     * @Reture：java.lang.String
     * @Descrip：根据用户的一个账号查询用户在数据库存储的一个盐值
     */
    String findSalt(String tel);


    /**
     * @Author：Axel
     * @Date：2020/4/23 15:54
     * @Params：[tel, pass]
     * @Reture：com.ydbzs.pojo.User
     * @Descrip：用户登录的方法
     */
    public User searchByTelAndPass(String tel, String dbPass);
}
