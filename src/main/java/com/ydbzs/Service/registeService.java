package com.ydbzs.Service;


/**
 * @version 1.0
 * @Project regandlog
 * @Author 多宝
 * @Date 2020/4/7 10:36
 * @ClassName registeService
 * @Description
 */

public interface registeService {
    public int doRegi(String name, String mobile, String dbpass, String salt);
}
