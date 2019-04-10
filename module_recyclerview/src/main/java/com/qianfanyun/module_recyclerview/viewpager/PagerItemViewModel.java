package com.qianfanyun.module_recyclerview.viewpager;

import com.qianfanyun.module_base.base.BaseItemViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

/**
 * @author ArcherYc
 * @date on 2019/4/9  9:17 AM
 * @mail 247067345@qq.com
 */
public class PagerItemViewModel extends BaseItemViewModel<ViewPagerViewModel> {
    private MutableLiveData<String> text = new MutableLiveData<>();

    public PagerItemViewModel(@NonNull ViewPagerViewModel parentViewModel) {
        super(parentViewModel);
    }

    public String getText() {
        return text.getValue();
    }

    public void setText(String text) {
        this.text.setValue(text);
    }
}
