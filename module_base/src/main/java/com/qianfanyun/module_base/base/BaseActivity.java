package com.qianfanyun.module_base.base;

import android.content.Intent;
import android.os.Bundle;


import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.databinding.ViewDataBinding;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProviders;

/**
 * @author ArcherYc
 * @date on 2019/3/26  3:11 PM
 * @mail 247067345@qq.com
 */
public abstract class BaseActivity<T extends ViewDataBinding, VM extends BaseViewModel> extends AppCompatActivity {

    public T dataBinding;
    private VM viewModel;
    private AlertDialog dialog;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        dataBinding = DataBindingUtil.setContentView(this, initContentView());
        viewModel = initViewModel();
        dataBinding.setVariable(initVariableId(), viewModel);
        dataBinding.setLifecycleOwner(this);
        registerUIChangeLiveDataCallBack();
    }

    private VM initViewModel() {
        VM viewModel;
        Class modelClass;
        Type type = getClass().getGenericSuperclass();
        if (type instanceof ParameterizedType) {
            modelClass = (Class) ((ParameterizedType) type).getActualTypeArguments()[1];
        } else {
            //如果没有指定泛型参数，则默认使用BaseViewModel
            modelClass = BaseViewModel.class;
        }
        viewModel = (VM) ViewModelProviders.of(this).get(modelClass);
        getLifecycle().addObserver(viewModel);
        return viewModel;
    }

    /**
     * 初始化布局id
     *
     * @return
     */
    public abstract int initContentView();

    /**
     * 初始化变量id，用于在dataBinding初始化
     *
     * @return
     */
    public abstract int initVariableId();


    /**
     * =====================================================================
     **/
    //注册ViewModel与View的契约UI回调事件
    private void registerUIChangeLiveDataCallBack() {
        //加载对话框显示
        viewModel.getUC().getShowDialogEvent().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String title) {
                showDialog(title);
            }
        });
        //加载对话框消失
        viewModel.getUC().getDismissDialogEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                dismissDialog();
            }
        });
        //跳入新页面
        viewModel.getUC().getStartActivityEvent().observe(this, new Observer<Map<String, Object>>() {
            @Override
            public void onChanged(@Nullable Map<String, Object> params) {
                Class<?> clz = (Class<?>) params.get(BaseViewModel.ParameterField.CLASS);
                Bundle bundle = (Bundle) params.get(BaseViewModel.ParameterField.BUNDLE);
                startActivity(clz, bundle);
            }
        });
        //关闭界面
        viewModel.getUC().getFinishEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                finish();
            }
        });
        //关闭上一层
        viewModel.getUC().getOnBackPressedEvent().observe(this, new Observer<Void>() {
            @Override
            public void onChanged(@Nullable Void v) {
                onBackPressed();
            }
        });
    }

    public void showDialog(String title) {
        if (dialog == null) {
            dialog = new AlertDialog.Builder(this).create();
        }
        dialog.setTitle(title);
        dialog.setMessage(title);
        dialog.show();
    }

    public void dismissDialog() {
        if (dialog != null && dialog.isShowing()) {
            dialog.dismiss();
        }
    }

    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(new Intent(this, clz));
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Intent intent = new Intent(this, clz);
        if (bundle != null) {
            intent.putExtras(bundle);
        }
        startActivity(intent);
    }


}
