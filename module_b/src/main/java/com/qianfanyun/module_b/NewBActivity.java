package com.qianfanyun.module_b;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.qianfanyun.module_b.databinding.ActivityNewBBinding;
import com.qianfanyun.module_base.base.BaseActivity;

public class NewBActivity extends BaseActivity<ActivityNewBBinding, NewViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_new_b;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
