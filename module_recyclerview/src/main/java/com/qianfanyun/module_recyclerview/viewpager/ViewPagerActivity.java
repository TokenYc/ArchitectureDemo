package com.qianfanyun.module_recyclerview.viewpager;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.qianfanyun.module_base.base.BaseActivity;
import com.qianfanyun.module_base.base.BaseModel;
import com.qianfanyun.module_recyclerview.BR;
import com.qianfanyun.module_recyclerview.R;
import com.qianfanyun.module_recyclerview.databinding.ActivityViewPagerBinding;

public class ViewPagerActivity extends BaseActivity<ActivityViewPagerBinding, ViewPagerViewModel> {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public int initContentView() {
        return R.layout.activity_view_pager;
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
