package com.qianfanyun.module_login;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.qianfanyun.module_base.api.RxApiHelper;
import com.qianfanyun.module_base.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;

/**
 * @author ArcherYc
 * @date on 2019/4/1  11:37 AM
 * @mail 247067345@qq.com
 */
public class LoginViewModel extends BaseViewModel<LoginRepository> {

    private MutableLiveData<String> name;
    private MutableLiveData<String> password;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void onLoginButtonClick(String name, String password) {
        showDialog("name--->" + name + "\t" + "password--->" + password);
        addDispose(getModel().login(name, password)
                .compose(RxApiHelper.rxSchedulerHelper())
                .doOnComplete(new Action() {
                    @Override
                    public void run() throws Exception {
                        dismissDialog();
                    }
                })
                .subscribe(new Consumer<Boolean>() {
                    @Override
                    public void accept(Boolean aBoolean) throws Exception {
                        if (aBoolean) {
                            Toast.makeText(getApplication(), "登录成功", Toast.LENGTH_SHORT).show();
                        }
                    }
                }));
    }


    public String getName() {
        if (name == null) {
            name = new MutableLiveData<>();
        }
        return name.getValue();
    }

    public void setName(String name) {
        if (this.name == null) {
            this.name = new MutableLiveData<>();
        }
        this.name.setValue(name);
    }

    public String getPassword() {
        if (password == null) {
            password = new MutableLiveData<>();
        }
        return password.getValue();
    }

    public void setPassword(String password) {
        if (this.password == null) {
            this.password = new MutableLiveData<>();
        }
        this.password.setValue(password);
    }
}
