package com.zuxiao2.zuxiao2.utils;

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import com.zuxiao2.zuxiao2.application.MyApplication;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.model.AddDingDanService;
import com.zuxiao2.zuxiao2.model.ApplyService;
import com.zuxiao2.zuxiao2.model.FLService;
import com.zuxiao2.zuxiao2.model.FincService;
import com.zuxiao2.zuxiao2.model.HomeService;
import com.zuxiao2.zuxiao2.model.LoginService;
import com.zuxiao2.zuxiao2.model.MerchantentryService;
import com.zuxiao2.zuxiao2.model.MyOrderService;
import com.zuxiao2.zuxiao2.model.MyService;
import com.zuxiao2.zuxiao2.model.OrderTabService;
import com.zuxiao2.zuxiao2.model.PassLoginService;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by hp on 2018/5/15.
 */

public class RetrofitUtils {
    private static RetrofitUtils retrofitUtils;
    private Retrofit retrofit;

    private RetrofitUtils() {

        Cache cache = new Cache(MyApplication.context.getCacheDir(),1024*1024*50);
        OkHttpClient build = new OkHttpClient.Builder().cache(cache).connectTimeout(1000, TimeUnit.MILLISECONDS).build();
        retrofit = new Retrofit.Builder()
                .baseUrl(Urls.SERVICE)
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(build)
                .build();
    }
    public static RetrofitUtils getInstance(){
        if (retrofitUtils==null) {
            synchronized (RetrofitUtils.class) {
                if (retrofitUtils == null) {
                    retrofitUtils = new RetrofitUtils();
                }
            }
        }
        return retrofitUtils;
    }

    public HomeService getHomeService(){
        return retrofit.create(HomeService.class);
    }
    public LoginService getLoginService(){
        return retrofit.create(LoginService.class);
    }
    public PassLoginService getPassLoginService(){
        return retrofit.create(PassLoginService.class);
    }
    public MyService getMyService(){
        return retrofit.create(MyService.class);
    }
    public FLService getFLService(){
        return retrofit.create(FLService.class);
    }
    public FincService getFincService(){
        return retrofit.create(FincService.class);
    }
    //认证
    public ApplyService getApplyService(){
        return retrofit.create(ApplyService.class);
    }
    public MerchantentryService getMerchantentryService(){
        return retrofit.create(MerchantentryService.class);
    }
    public AddDingDanService getAddDingDanService(){
        return retrofit.create(AddDingDanService.class);
    }
    public OrderTabService getOrderTabService(){
        return retrofit.create(OrderTabService.class);
    }
    public MyOrderService getMyOrderService(){
        return retrofit.create(MyOrderService.class);
    }
}
