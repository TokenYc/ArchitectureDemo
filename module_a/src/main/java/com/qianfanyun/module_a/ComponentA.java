package com.qianfanyun.module_a;

import android.content.Context;
import android.content.Intent;

import com.billy.cc.core.component.CC;
import com.billy.cc.core.component.CCResult;
import com.billy.cc.core.component.CCUtil;
import com.billy.cc.core.component.IComponent;
import com.qianfanyun.module_base.statics.Component;

import androidx.activity.ComponentActivity;

/**
 * @author ArcherYc
 * @date on 2019/3/29  3:45 PM
 * @mail 247067345@qq.com
 */
public class ComponentA implements IComponent {
    @Override
    public String getName() {
        return Component.ComponentA;
    }

    @Override
    public boolean onCall(CC cc) {
        CCUtil.navigateTo(cc, ModuleAActivity.class);
        CC.sendCCResult(cc.getCallId(), CCResult.success());
        return false;
    }
}
