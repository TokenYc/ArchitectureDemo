package com.qianfanyun.module_b;

import android.app.Application;

import com.qianfanyun.module_base.base.BaseViewModel;

import androidx.annotation.NonNull;

/**
 * @author ArcherYc
 * @date on 2019/4/1  10:49 AM
 * @mail 247067345@qq.com
 */
public class BViewModel extends BaseViewModel {
    public final String des = "this is module B";

    public BViewModel(@NonNull Application application) {
        super(application);
    }

    public void jumpNew() {
        startActivity(NewBActivity.class);
    }
}
