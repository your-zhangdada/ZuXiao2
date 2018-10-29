package com.zuxiao2.zuxiao2.model;


import com.zuxiao2.zuxiao2.bean.CommodityBean;
import com.zuxiao2.zuxiao2.bean.Home_FL;
import com.zuxiao2.zuxiao2.bean.SHDZ_Bean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyService{
    //首页Tab 下
    @FormUrlEncoded
    @POST(Urls.HOME_LIST)
    Observable<Home_FL> getHome_fl(@FieldMap Map<String, String> params);

    //首页Tab 商品详情
    @FormUrlEncoded
    @POST(Urls.HOME_COMMODY)
    Observable<CommodityBean> getHomeCommody(@FieldMap Map<String, String> params);

    //首页 添加收货地址
    @FormUrlEncoded
    @POST(Urls.HOME_DZ)
    Observable<SHDZ_Bean> getHomeAddDZ();
}
