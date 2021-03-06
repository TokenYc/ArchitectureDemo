package com.qianfanyun.architecturedemo;


import com.billy.cc.core.component.CC;
import com.qianfanyun.module_base.base.application.ApplicationManager;
import com.qianfanyun.module_base.base.application.BaseApplication;

/**
 * @author ArcherYc
 * @date on 2019/3/29  1:57 PM
 * @mail 247067345@qq.com
 */
public class MyApplication extends BaseApplication {

    @Override
    public void onCreate() {
        super.onCreate();
        CC.init(this);
        ApplicationManager.init();
    }

    @Override
    public boolean isDebug() {
        return BuildConfig.DEBUG;
    }

    @Override
    public void init() {

    }
}
