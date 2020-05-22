package com.ydbzs.Service;


/**
 * 注册Service接口
 * @version 1.0
 * @project regandlog
 * @author 多宝
 * @date 2020/4/7 10:36
 * @className registeService
 */

public interface registeService {
    public int doRegi(String name, String mobile, String dbpass, String salt);
}
