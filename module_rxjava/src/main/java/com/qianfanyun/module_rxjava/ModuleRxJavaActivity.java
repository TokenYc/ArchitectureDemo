package com.qianfanyun.module_rxjava;


import android.os.Bundle;

import com.qianfanyun.module_base.base.BaseActivity;
import com.qianfanyun.module_rxjava.databinding.ActivityModuleRxjavaBinding;

public class ModuleRxJavaActivity extends BaseActivity<ActivityModuleRxjavaBinding, RxJavaViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_module_rxjava;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
