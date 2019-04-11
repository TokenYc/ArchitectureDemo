package com.qianfanyun.module_rxjava;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponent;
import com.qianfanyun.module_base.statics.Component;

/**
 * @author ArcherYc
 * @date on 2019/3/29  3:45 PM
 * @mail 247067345@qq.com
 */
public class ComponentRxJava implements IComponent {
    @Override
    public String getName() {
        return Component.ComponentA;
    }

    @Override
    public boolean onCall(CC cc) {
        CCUtil.navigateTo(cc, ModuleRxJavaActivity.class);
        CC.sendCCResult(cc.getCallId(), CCResult.success());
        return false;
    }
}
