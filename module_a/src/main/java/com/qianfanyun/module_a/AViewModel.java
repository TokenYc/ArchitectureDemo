package com.qianfanyun.module_a;

import android.app.Application;

import com.qianfanyun.module_base.base.BaseViewModel;

import androidx.annotation.NonNull;

/**
 * @author ArcherYc
 * @date on 2019/4/1  9:40 AM
 * @mail 247067345@qq.com
 */
public class AViewModel extends BaseViewModel {

    public final String pageName= "this is module A";

    public AViewModel(@NonNull Application application) {
        super(application);
    }
}
