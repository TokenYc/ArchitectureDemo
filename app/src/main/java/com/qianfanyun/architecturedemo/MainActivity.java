package com.qianfanyun.architecturedemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.os.Bundle;
import android.view.View;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.qianfanyun.architecturedemo.databinding.ActivityMainBinding;
import com.qianfanyun.module_base.statics.Component;

public class MainActivity extends AppCompatActivity {

    ActivityMainBinding activityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        activityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        activityMainBinding.setAction("jump to module A");
    }

    public void jumpModuleA(View view) {
        CCResult result = CC.obtainBuilder(Component.ComponentA)
                .build()
                .call();
    }
}
