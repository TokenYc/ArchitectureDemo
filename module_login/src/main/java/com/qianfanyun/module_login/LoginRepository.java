package com.qianfanyun.module_login;

import com.qianfanyun.module_base.api.ServiceCreater;
import com.qianfanyun.module_base.base.BaseModel;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import retrofit2.Retrofit;

/**
 * @author ArcherYc
 * @date on 2019/4/24  16:45
 * @mail 247067345@qq.com
 */
public class LoginRepository extends BaseModel implements HttpDataSource, LocalDataSource {

    private static LoginRepository mInstance;

    private LoginService loginService;


    public static LoginRepository getInstance() {
        if (mInstance == null) {
            synchronized (LoginRepository.class) {
                if (mInstance == null) {
                    mInstance = new LoginRepository(ServiceCreater.createService(LoginService.class));
                }
            }
        }
        return mInstance;
    }

    private LoginRepository(LoginService loginService) {
        this.loginService = loginService;
    }

    @Override
    public Observable<Boolean> login(String username, String password) {
//        return loginService.login(username, password);
        return Observable.just(true).delay(3, TimeUnit.SECONDS);
    }

    @Override
    public String getName() {
        return null;
    }

    @Override
    public String setName(String name) {
        return null;
    }
}
