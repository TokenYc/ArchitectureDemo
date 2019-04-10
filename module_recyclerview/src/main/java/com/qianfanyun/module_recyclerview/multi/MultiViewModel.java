package com.qianfanyun.module_recyclerview.multi;

import android.app.Application;
import android.graphics.Color;

import com.qianfanyun.module_base.base.BaseViewModel;
import com.qianfanyun.module_base.base.BaseMultiItemViewModel;
import com.qianfanyun.module_recyclerview.BR;
import com.qianfanyun.module_recyclerview.R;

import java.util.Arrays;

import androidx.annotation.NonNull;
import androidx.databinding.ObservableArrayList;
import androidx.databinding.ObservableList;
import androidx.recyclerview.widget.DiffUtil;
import me.tatarka.bindingcollectionadapter2.ItemBinding;
import me.tatarka.bindingcollectionadapter2.OnItemBind;
import me.tatarka.bindingcollectionadapter2.collections.DiffObservableList;
import me.tatarka.bindingcollectionadapter2.collections.MergeObservableList;
import me.tatarka.bindingcollectionadapter2.itembindings.OnItemBindClass;

/**
 * @author ArcherYc
 * @date on 2019/4/2  5:21 PM
 * @mail 247067345@qq.com
 */
public class MultiViewModel extends BaseViewModel {

    public static final String TYPE_TEXT = "item_text";
    public static final String TYPE_IMAGE = "item_image";

    public final ObservableList<BaseMultiItemViewModel> observableList = new ObservableArrayList<>();

    DiffObservableList<Item> list = new DiffObservableList(new DiffUtil.ItemCallback() {
        @Override
        public boolean areItemsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
            return false;
        }

        @Override
        public boolean areContentsTheSame(@NonNull Object oldItem, @NonNull Object newItem) {
            return false;

        }
    });



    public MultiViewModel(@NonNull Application application) {
        super(application);
        for (int i = 0; i < 20; i++) {
            if (i % 2 == 0) {
                TextViewModel itemViewModel = new TextViewModel(this);
                itemViewModel.multiItemType(TYPE_TEXT);
                itemViewModel.setText("text-->" + i);
                observableList.add(itemViewModel);
            } else {
                ImageViewModel imageViewModel = new ImageViewModel(this);
                imageViewModel.multiItemType(TYPE_IMAGE);
                imageViewModel.setText("image text-->" + i);
                imageViewModel.setColor(Color.BLUE);
                observableList.add(imageViewModel);
            }
        }

        list.update(Arrays.asList(new Item("1", "a"), new Item("2", "b1")));
        list.update(Arrays.asList(new Item("2", "b2"), new Item("3", "c"), new Item("4", "d")));
    }


    public final ItemBinding<BaseMultiItemViewModel> itemBinding = ItemBinding.of(new OnItemBindClass<BaseMultiItemViewModel>()
            .map(TextViewModel.class, BR.viewModel, R.layout.item_text)
            .map(ImageViewModel.class, BR.viewModel, R.layout.item_image)
    );

    public class Item{
        String first;
        String second;

        public Item(String first, String second) {
            this.first = first;
            this.second = second;
        }

        public String getFirst() {
            return first;
        }

        public void setFirst(String first) {
            this.first = first;
        }

        public String getSecond() {
            return second;
        }

        public void setSecond(String second) {
            this.second = second;
        }
    }
}
