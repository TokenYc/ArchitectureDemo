package com.qianfanyun.module_login;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import com.qianfanyun.module_base.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author ArcherYc
 * @date on 2019/4/1  11:37 AM
 * @mail 247067345@qq.com
 */
public class LoginViewModel extends BaseViewModel {

    private MutableLiveData<String> name;
    private MutableLiveData<String> password;

    public LoginViewModel(@NonNull Application application) {
        super(application);
    }

    public void onLoginButtonClick(String name, String password) {
        showDialog("name--->" + name + "\t" + "password--->" + password);
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
