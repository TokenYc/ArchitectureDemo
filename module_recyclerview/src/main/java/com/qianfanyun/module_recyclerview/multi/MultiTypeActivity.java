package com.qianfanyun.module_recyclerview.multi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.qianfanyun.module_base.base.BaseActivity;
import com.qianfanyun.module_recyclerview.BR;
import com.qianfanyun.module_recyclerview.R;
import com.qianfanyun.module_recyclerview.databinding.ActivityMultiTypeBinding;

public class MultiTypeActivity extends BaseActivity<ActivityMultiTypeBinding, MultiViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_multi_type;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
