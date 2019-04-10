package com.qianfanyun.module_recyclerview.multi;

import com.qianfanyun.module_base.base.BaseItemViewModel;
import com.qianfanyun.module_base.base.BaseMultiItemViewModel;
import com.qianfanyun.module_recyclerview.RecyclerViewViewModel;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

/**
 * @author ArcherYc
 * @date on 2019/4/2  4:43 PM
 * @mail 247067345@qq.com
 */
public class TextViewModel extends BaseMultiItemViewModel<MultiViewModel> {

    private MutableLiveData<String> text = new MutableLiveData<>();

    public TextViewModel(@NonNull MultiViewModel parentViewModel) {
        super(parentViewModel);
    }

    private int getIndex() {
        return parentViewModel.observableList.indexOf(this);
    }

    public void onItemClick() {
        if (getIndex() == 0) {
            parentViewModel.startActivity(MultiTypeActivity.class);
        }
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public String getText() {
        return text.getValue();
    }

}
