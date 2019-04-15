package com.qianfanyun.module_base.api;


import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.qianfanyun.module_base.BuildConfig;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * @author ArcherYc
 * @date on 2019/3/7  1:40 PM
 * @mail 247067345@qq.com
 */
public class ServiceCreater {

    private static Retrofit retrofit;

    public static <T> T createService(Class<T> service) {
        if (retrofit == null) {
            synchronized (ServiceCreater.class) {
                if (retrofit == null) {
                    retrofit = new Retrofit.Builder()
                            .client(getOkHttpClient())
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .baseUrl("http://fy.iciba.com/")
                            .build();
                }
            }
        }
        return retrofit.create(service);
    }

    private static OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder()
                .addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Request request = chain.request().newBuilder()
                                .header("Content-Type", "application/json;charset=UTF-8")
                                .build();
                        return chain.proceed(request);
                    }
                }).addInterceptor(new Interceptor() {
                    @Override
                    public Response intercept(Chain chain) throws IOException {
                        Response response = chain.proceed(chain.request());
                        if (response.body()!=null) {
                            response.body();
                        }
                        return response;
                    }
                });

        if (BuildConfig.DEBUG) {
            // Log信息拦截器
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
            //设置Debug Log 模式
            builder.addInterceptor(interceptor);
        }
        return builder.build();
    }
}
