package com.ydbzs.mapper;

import com.ydbzs.my.mapper.MyMapper;
import com.ydbzs.pojo.User;
import org.apache.ibatis.annotations.Mapper;


@Mapper
public interface UserMapper extends MyMapper<User> {

    /**
     * 用户注册，数据库插入用户数据
     * @author ：多宝
     * @date ：2020/4/22 10:57
     * @params ：[name, mobile, dbpass]
     * @reture ：int
     */
    int insertUser(String name, String mobile, String dbpass, String salt);


    /**
     * 查询数据库是否存在当前用户输入的账户
     * @author ：多宝
     * @date ：2020/4/23 15:58
     * @params ：[tel]
     * @reture ：int
     */
    int check_tel(String tel);



    /**
     * 根据用户的一个账号查询用户在数据库存储的一个盐值
     * @author ：多宝
     * @date ：2020/4/23 16:33
     * @params ：[tel]
     * @reture ：java.lang.String
     */
    String findSalt(String tel);



    /**
     * @Author：多宝
     * @Date：2020/4/22 11:00
     * @Params：[tel, pass]
     * @Reture：com.ydbzs.pojo.User
     * @Descrip：根据用户手机号以及是用户密码查询用户是否存在数据库
     */
    User searchByTelAndPass(String tel, String pass);






}