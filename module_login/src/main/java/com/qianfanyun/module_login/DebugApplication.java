package com.qianfanyun.module_login;

import android.util.Log;

import com.qianfanyun.module_base.base.application.BaseApplication;
import com.qianfanyun.module_login.BuildConfig;

/**
 * @author ArcherYc
 * @date on 2019/4/1  9:21 AM
 * @mail 247067345@qq.com
 */
public class DebugApplication extends BaseApplication {
    @Override
    public void onCreate() {
        super.onCreate();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public void init() {
        Log.d("xx","module login application init");
    }
}
