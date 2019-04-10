package com.qianfanyun.module_a;


import android.os.Bundle;

import com.qianfanyun.module_a.databinding.ActivityModuleABinding;
import com.qianfanyun.module_base.base.BaseActivity;

import androidx.lifecycle.ViewModelProviders;

public class ModuleAActivity extends BaseActivity<ActivityModuleABinding,AViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_module_a;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

}
