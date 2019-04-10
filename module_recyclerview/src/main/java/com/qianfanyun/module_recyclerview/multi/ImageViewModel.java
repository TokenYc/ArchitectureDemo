package com.qianfanyun.module_recyclerview.multi;

import com.qianfanyun.module_base.base.BaseItemViewModel;
import com.qianfanyun.module_base.base.BaseMultiItemViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

/**
 * @author ArcherYc
 * @date on 2019/4/8  2:58 PM
 * @mail 247067345@qq.com
 */
public class ImageViewModel extends BaseMultiItemViewModel<MultiViewModel> {

    private MutableLiveData<String> text = new MutableLiveData<>();
    private MutableLiveData<Integer> color = new MutableLiveData<>();

    public ImageViewModel(@NonNull MultiViewModel parentViewModel) {
        super(parentViewModel);
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public String getText() {
        return text.getValue();
    }

    public void setColor(int color) {
        this.color.setValue(color);
    }

    public int getColor() {
        return color.getValue();
    }

}
