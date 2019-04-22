package com.qianfanyun.module_rxjava;

import android.annotation.SuppressLint;
import android.app.Application;
import android.util.Log;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qianfanyun.module_base.api.ApiException;
import com.qianfanyun.module_base.api.BaseApiBean;
import com.qianfanyun.module_base.api.RxApiHelper;
import com.qianfanyun.module_base.api.ServiceCreater;
import com.qianfanyun.module_base.base.BaseViewModel;
import com.qianfanyun.module_rxjava.bean.TranslationBean;
import com.trello.rxlifecycle3.RxLifecycle;
import com.trello.rxlifecycle3.android.ActivityEvent;

import java.util.concurrent.TimeUnit;

import androidx.annotation.NonNull;
import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Action;
import io.reactivex.functions.Consumer;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ArcherYc
 * @date on 2019/4/1  9:40 AM
 * @mail 247067345@qq.com
 */
public class RxJavaViewModel extends BaseViewModel {


    public RxJavaViewModel(@NonNull Application application) {
        super(application);
    }

    public void simpleCase() {
        requestTranslate();
    }

    @SuppressLint("CheckResult")
    public void requestTranslate() {
//        ServiceCreater.createService(TranslateService.class)
//                .getTranslationCall()
//                .compose(RxApiHelper.rxSchedulerHelper())
//                .compose(RxApiHelper.handleResult())
//                .doOnSubscribe(new Consumer<Disposable>() {
//                    @Override
//                    public void accept(Disposable disposable) throws Exception {
//
//                    }
//                })
//                .subscribe(new Observer<TranslationBean>() {
//                    @Override
//                    public void onSubscribe(Disposable d) {
//
//                    }
//
//                    @Override
//                    public void onNext(TranslationBean translationBean) {
//                        Log.d("xx", translationBean.toString());
//                    }
//
//                    @Override
//                    public void onError(Throwable e) {
//                        if (e instanceof ApiException){
//                            ApiException apiException = (ApiException) e;
//                            int status = apiException.getStatus()
//                            Log.d("xx","status--->"+status);
//                        }
//                    }
//
//                    @Override
//                    public void onComplete() {
//
//                    }
//                });

        Observable.interval(1, TimeUnit.SECONDS)
                .compose(getLifecycleProvider().bindToLifecycle())
                .doOnDispose(new Action() {
                    @Override
                    public void run() throws Exception {
                        Log.d("xx", "onDisPose");
                    }
                })
                .subscribe(new Observer<Long>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Long aLong) {
                        Log.d("xx","轮询一次");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("xx","onError");
                    }

                    @Override
                    public void onComplete() {
                        Log.d("xx","onComplete");
                    }
                });

    }


    @Override
    public void onPause() {
        super.onPause();
        Log.d("xx","onPause");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.d("xx","onStop");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.d("xx","onDestroy");
    }
}
