package com.qianfanyun.module_base.base;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;

/**
 * @author ArcherYc
 * @date on 2019/4/24  16:20
 * @mail 247067345@qq.com
 */
public class BaseModel implements IModel {

    private CompositeDisposable compositeDisposable;

    public void addDisposable(Disposable disposable) {
        if (compositeDisposable == null) {
            compositeDisposable = new CompositeDisposable();
        }
        compositeDisposable.add(disposable);
    }

    /**
     * 取消异步操作
     */
    @Override
    public void onClear() {
        if (compositeDisposable != null) {
            compositeDisposable.dispose();
        }
    }
}
