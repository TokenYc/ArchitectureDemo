package com.qianfanyun.module_recyclerview;

import android.app.Application;
import android.widget.TextView;

import com.qianfanyun.module_base.base.BaseViewModel;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.databinding.ViewDataBinding;
import androidx.recyclerview.widget.RecyclerView;
import me.tatarka.bindingcollectionadapter2.BindingRecyclerViewAdapter;
import me.tatarka.bindingcollectionadapter2.ItemBinding;

/**
 * @author ArcherYc
 * @date on 2019/4/2  4:33 PM
 * @mail 247067345@qq.com
 */
public class RecyclerViewViewModel extends BaseViewModel {

    public final ObservableList<ItemViewModel> items = new ObservableArrayList<>();
    public final ItemBinding<ItemViewModel> itemBinding = ItemBinding.of(BR.viewModel, R.layout.item);
    public final MyBindingHandler adapter = new MyBindingHandler();

    public RecyclerViewViewModel(@NonNull Application application) {
        super(application);
        for (int i = 0; i < 20; i++) {
            ItemViewModel itemViewModel = new ItemViewModel(this);
            if (i == 0) {
                itemViewModel.setText("跳转多类型列表");
            } else if (i == 1) {
                itemViewModel.setText("跳转ViewPager");
            } else {
                itemViewModel.setText("number " + i);
            }
            items.add(itemViewModel);
        }
    }

    public class MyBindingHandler extends BindingRecyclerViewAdapter<ItemViewModel> {

        @Override
        public void onBindBinding(@NonNull ViewDataBinding binding, int variableId, int layoutRes, int position, ItemViewModel item) {
            super.onBindBinding(binding, variableId, layoutRes, position, item);
            if (position == 2) {
                TextView textView = binding.getRoot().findViewById(R.id.textView);
                textView.setText("操控view");
            }
        }
    }

}
