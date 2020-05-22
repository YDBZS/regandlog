package com.ydbzs.Service.Impl;

import com.ydbzs.Service.registeService;
import com.ydbzs.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @version 1.0
 * @project regandlog
 * @author 多宝
 * @date 2020/4/7 10:39
 * @className registeServiceImpl
 */
@Service
public class registeServiceImpl implements registeService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public int doRegi(String name, String mobile, String dbpass, String salt) {
        int num = userMapper.insertUser(name,mobile,dbpass,salt);
        return num;
    }
}
