package com.qianfanyun.module_base.base;


import androidx.annotation.NonNull;

/**
 * Create Author：goldze
 * Create Date：2019/01/25
 * Description：RecycleView多布局ItemViewModel是封装
 */

public class BaseMultiItemViewModel<VM extends BaseViewModel> extends BaseItemViewModel<VM> {
    protected Object multiType;

    public Object getItemType() {
        return multiType;
    }

    public void multiItemType(@NonNull Object multiType) {
        this.multiType = multiType;
    }

    public BaseMultiItemViewModel(@NonNull VM viewModel) {
        super(viewModel);
    }
}
