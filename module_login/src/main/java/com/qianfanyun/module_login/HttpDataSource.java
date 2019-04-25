package com.qianfanyun.module_login;

import io.reactivex.Observable;

/**
 * @author ArcherYc
 * @date on 2019/4/24  16:37
 * @mail 247067345@qq.com
 */
public interface HttpDataSource {

    /**
     * 请求登录接口
     * @param username
     * @param password
     * @return
     */
    Observable<Boolean> login(String username,String password);
}
