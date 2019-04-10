package com.qianfanyun.module_recyclerview;

import android.app.Application;

import com.qianfanyun.module_base.base.BaseItemViewModel;
import com.qianfanyun.module_base.base.BaseViewModel;
import com.qianfanyun.module_recyclerview.multi.MultiTypeActivity;
import com.qianfanyun.module_recyclerview.viewpager.ViewPagerActivity;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

/**
 * @author ArcherYc
 * @date on 2019/4/2  4:43 PM
 * @mail 247067345@qq.com
 */
public class ItemViewModel extends BaseItemViewModel<RecyclerViewViewModel> {

    private MutableLiveData<String> text = new MutableLiveData<>();

    public ItemViewModel(@NonNull RecyclerViewViewModel parentViewModel) {
        super(parentViewModel);
    }

    private int getIndex() {
        return parentViewModel.items.indexOf(this);
    }

    public void onItemClick() {
        if (getIndex() == 0) {
            parentViewModel.startActivity(MultiTypeActivity.class);
        } else if (getIndex() == 1) {
            parentViewModel.startActivity(ViewPagerActivity.class);
        } else {
            parentViewModel.items.remove(this);
        }
    }

    public void setText(String text) {
        this.text.setValue(text);
    }

    public String getText() {
        return text.getValue();
    }

}
