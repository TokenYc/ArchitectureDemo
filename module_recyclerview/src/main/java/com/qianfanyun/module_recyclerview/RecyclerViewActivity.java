package com.qianfanyun.module_recyclerview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.qianfanyun.module_base.base.BaseActivity;
import com.qianfanyun.module_recyclerview.databinding.ActivityRecyclerViewBinding;

public class RecyclerViewActivity extends BaseActivity<ActivityRecyclerViewBinding, RecyclerViewViewModel> {


    @Override
    public int initContentView() {
        return R.layout.activity_recycler_view;
    }

    @Override
    public int initVariableId() {
        return BR.viewModel;
    }
}
