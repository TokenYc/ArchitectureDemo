package com.qianfanyun.module_base.adapter;

import android.view.View;

import com.qianfanyun.module_base.utils.ClickUtils;

import androidx.databinding.BindingAdapter;

/**
 * @author ArcherYc
 * @date on 2019/4/2  8:40 AM
 * @mail 247067345@qq.com
 */
public class ListenerAdapter {

    @BindingAdapter("android:onClick")
    public static void setClickListener(View view, final View.OnClickListener listener){
        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (ClickUtils.isFastDoubleClick()){
                    return;
                }
                listener.onClick(v);
            }
        });
    }

}
