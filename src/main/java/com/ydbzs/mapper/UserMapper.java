package com.ydbzs.mapper;

import com.ydbzs.my.mapper.MyMapper;
import com.ydbzs.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends MyMapper<User> {

    /**
     * @Author：Axel
     * @Date：2020/4/22 10:57
     * @Params：[name, mobile, dbpass]
     * @Reture：int
     * @Descrip：用户注册，数据库插入用户数据
     */
    int insertUser(String name, String mobile, String dbpass, String salt);


    /**
     * @Author：Axel
     * @Date：2020/4/23 15:58
     * @Params：[tel]
     * @Reture：int
     * @Descrip：查询数据库是否存在当前用户输入的账户
     */
    int check_tel(String tel);



    /**
     * @Author：Axel
     * @Date：2020/4/23 16:33
     * @Params：[tel]
     * @Reture：java.lang.String
     * @Descrip：根据用户的一个账号查询用户在数据库存储的一个盐值
     */
    String findSalt(String tel);



    /**
     * @Author：Axel
     * @Date：2020/4/22 11:00
     * @Params：[tel, pass]
     * @Reture：com.ydbzs.pojo.User
     * @Descrip：根据用户手机号以及是用户密码查询用户是否存在数据库
     */
    User searchByTelAndPass(String tel, String pass);






}