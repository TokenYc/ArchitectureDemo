package com.qianfanyun.module_recyclerview.viewpager;

import android.app.Application;

import com.qianfanyun.module_base.base.BaseViewModel;
import com.qianfanyun.module_recyclerview.BR;
import com.qianfanyun.module_recyclerview.R;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @author ArcherYc
 * @date on 2019/4/9  9:14 AM
 * @mail 247067345@qq.com
 */
public class ViewPagerViewModel extends BaseViewModel {
    public final ObservableList<PagerItemViewModel> list = new ObservableArrayList<>();

    public ViewPagerViewModel(@NonNull Application application) {
        super(application);
        for (int i = 0; i < 5; i++) {
            PagerItemViewModel itemViewModel = new PagerItemViewModel(this);
            itemViewModel.setText("dd" + i + "号");
            list.add(itemViewModel);
        }
    }

    public final ItemBinding<PagerItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item_pager);


}
