package com.qianfanyun.module_b;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import com.qianfanyun.module_b.databinding.ActivityModuleBBinding;
import com.qianfanyun.module_base.base.BaseActivity;
import com.qianfanyun.module_base.base.BaseModel;


public class ModuleBActivity extends BaseActivity<ActivityModuleBBinding, BViewModel> {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_module_b;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }

    @Override
    public BaseModel initModel() {
        return null;
    }

}
