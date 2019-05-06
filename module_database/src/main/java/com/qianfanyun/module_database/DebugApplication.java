package com.qianfanyun.module_database;

import android.util.Log;

import com.qianfanyun.module_base.base.application.BaseApplication;
import com.qianfanyun.module_database.BuildConfig;

/**
 * @author ArcherYc
 * @date on 2019/3/29  3:36 PM
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
        Log.d("xx","module database application init");
    }
}
