package com.qianfanyun.module_base.base;

import android.app.Application;
import android.os.Bundle;

import com.trello.rxlifecycle3.LifecycleProvider;

import java.lang.ref.WeakReference;
import java.util.HashMap;
import java.util.Map;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.LifecycleEventObserver;
import androidx.lifecycle.LifecycleObserver;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.OnLifecycleEvent;
import io.reactivex.disposables.Disposable;

/**
 * @author ArcherYc
 * @date on 2019/3/26  3:13 PM
 * @mail 247067345@qq.com
 */
public class BaseViewModel<M extends BaseModel> extends AndroidViewModel implements LifecycleObserver {

    private M model;

    private UIChangeLiveData uc;

    private WeakReference<LifecycleProvider> lifecycleProvider;

    public BaseViewModel(@NonNull Application application) {
        super(application);
    }

    public M getModel() {
        return model;
    }

    public void setModel(M model) {
        this.model = model;
    }

    public void showDialog(String title) {
        uc.showDialogEvent.postValue(title);
    }

    public void dismissDialog() {
        uc.dismissDialogEvent.call();
    }

    public void setLifecycleProvider(LifecycleProvider lifecycleProvider) {
        this.lifecycleProvider = new WeakReference<>(lifecycleProvider);
    }

    public LifecycleProvider getLifecycleProvider() {
        return this.lifecycleProvider.get();
    }

    /**
     * 跳转页面
     *
     * @param clz 所跳转的目的Activity类
     */
    public void startActivity(Class<?> clz) {
        startActivity(clz, null);
    }

    /**
     * 跳转页面
     *
     * @param clz    所跳转的目的Activity类
     * @param bundle 跳转所携带的信息
     */
    public void startActivity(Class<?> clz, Bundle bundle) {
        Map<String, Object> params = new HashMap<>();
        params.put(ParameterField.CLASS, clz);
        if (bundle != null) {
            params.put(ParameterField.BUNDLE, bundle);
        }
        uc.startActivityEvent.postValue(params);
    }

    public void addDispose(Disposable disposable) {
        if (model != null) {
            model.addDisposable(disposable);
        }
    }

    /**
     * 关闭界面
     */
    public void finish() {
        uc.finishEvent.call();
    }

    /**
     * 返回上一层
     */
    public void onBackPressed() {
        uc.onBackPressedEvent.call();
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {

    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {

    }

    @Override
    protected void onCleared() {
        super.onCleared();
        if (model != null) {
            model.onClear();
        }
    }

    public UIChangeLiveData getUC() {
        if (uc == null) {
            uc = new UIChangeLiveData();
        }
        return uc;
    }


    public final class UIChangeLiveData extends SingleLiveEvent {
        private SingleLiveEvent<String> showDialogEvent;
        private SingleLiveEvent<Void> dismissDialogEvent;
        private SingleLiveEvent<Map<String, Object>> startActivityEvent;
        private SingleLiveEvent<Map<String, Object>> startContainerActivityEvent;
        private SingleLiveEvent<Void> finishEvent;
        private SingleLiveEvent<Void> onBackPressedEvent;

        public SingleLiveEvent<String> getShowDialogEvent() {
            return showDialogEvent = createLiveData(showDialogEvent);
        }

        public SingleLiveEvent<Void> getDismissDialogEvent() {
            return dismissDialogEvent = createLiveData(dismissDialogEvent);
        }

        public SingleLiveEvent<Map<String, Object>> getStartActivityEvent() {
            return startActivityEvent = createLiveData(startActivityEvent);
        }


        public SingleLiveEvent<Void> getFinishEvent() {
            return finishEvent = createLiveData(finishEvent);
        }

        public SingleLiveEvent<Void> getOnBackPressedEvent() {
            return onBackPressedEvent = createLiveData(onBackPressedEvent);
        }

        private SingleLiveEvent createLiveData(SingleLiveEvent liveData) {
            if (liveData == null) {
                liveData = new SingleLiveEvent();
            }
            return liveData;
        }

        @Override
        public void observe(LifecycleOwner owner, Observer observer) {
            super.observe(owner, observer);
        }
    }

    public static final class ParameterField {
        public static String CLASS = "CLASS";
        public static String CANONICAL_NAME = "CANONICAL_NAME";
        public static String BUNDLE = "BUNDLE";
    }
}
