package com.qianfanyun.module_base.base;

import android.app.Application;

import com.facebook.stetho.Stetho;

/**
 * @author ArcherYc
 * @date on 2019/4/19  10:18
 * @mail 247067345@qq.com
 */
public class BaseApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Stetho.initializeWithDefaults(this);
    }
}
