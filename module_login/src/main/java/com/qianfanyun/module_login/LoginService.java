package com.qianfanyun.module_login;


import io.reactivex.Observable;
import retrofit2.http.POST;

/**
 * Retrofit定义请求的接口
 * @author ArcherYc
 * @date on 2019/4/24  16:46
 * @mail 247067345@qq.com
 */
public interface LoginService {

    @POST
    Observable<Boolean> login(String username,String password);
}
