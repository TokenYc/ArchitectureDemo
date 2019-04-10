package com.qianfanyun.module_login;


import android.os.Bundle;

import com.qianfanyun.module_base.base.BaseActivity;
import com.qianfanyun.module_login.databinding.ActivityLoginBinding;

public class LoginActivity extends BaseActivity<ActivityLoginBinding, LoginViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_login;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
