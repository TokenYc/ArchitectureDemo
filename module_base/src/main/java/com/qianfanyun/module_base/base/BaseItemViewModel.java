package com.qianfanyun.module_base.base;

import androidx.annotation.NonNull;

/**
 * @author ArcherYc
 * @date on 2019/4/2  4:47 PM
 * @mail 247067345@qq.com
 */
public class BaseItemViewModel<VM extends BaseViewModel> {

    protected VM parentViewModel;

    public BaseItemViewModel(@NonNull VM parentViewModel) {
        this.parentViewModel = parentViewModel;
    }

}
