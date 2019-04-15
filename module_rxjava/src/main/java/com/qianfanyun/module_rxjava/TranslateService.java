package com.qianfanyun.module_rxjava;

import com.qianfanyun.module_base.api.BaseApiBean;
import com.qianfanyun.module_rxjava.bean.TranslationBean;

import io.reactivex.Observable;
import retrofit2.http.GET;

/**
 * @author ArcherYc
 * @date on 2019/4/12  09:14
 * @mail 247067345@qq.com
 */
public interface TranslateService {

    @GET("ajax.php?a=fy&f=auto&t=auto&w=hi%20world")
    Observable<BaseApiBean<TranslationBean>> getTranslationCall();
}
