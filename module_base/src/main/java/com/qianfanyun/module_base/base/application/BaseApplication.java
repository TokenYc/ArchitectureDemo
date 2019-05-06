package com.qianfanyun.module_base.base.application;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.billy.cc.core.component.CC;

/**
 * @author ArcherYc
 * @date on 2019/4/19  10:18
 * @mail 247067345@qq.com
 */
public abstract class BaseApplication extends Application implements IApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        //每个module都要用到的初始化在这里
        Stetho.initializeWithDefaults(this);
        CC.enableDebug(isDebug());
        CC.enableVerboseLog(isDebug());
        CC.enableRemoteCC(isDebug());
        init();
    }

}
