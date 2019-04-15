package com.qianfanyun.module_base.api;


import io.reactivex.Observable;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Function;
import io.reactivex.schedulers.Schedulers;

/**
 * @author ArcherYc
 * @date on 2019/4/12  12:01
 * @mail 247067345@qq.com
 */
public class RxApiHelper {

    public static <T> ObservableTransformer<T, T> rxSchedulerHelper() {
        return observable -> observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }

    public static <T> ObservableTransformer<BaseApiBean<T>, T> handleResult() {
        return httpResponseObservable ->
                httpResponseObservable.flatMap((Function<BaseApiBean<T>, Observable<T>>) baseResponse -> {
//                    if (baseResponse.getStatus() == 1) {
//                        return createData(baseResponse.getContent());
//                    } else {
                        return Observable.error(new ApiException(5));
//                    }
                });
    }

    private static <T> Observable<T> createData(final T t) {
        return Observable.create(emitter -> {
            try {
                emitter.onNext(t);
                emitter.onComplete();
            } catch (Exception e) {
                emitter.onError(e);
            }
        });
    }
}
