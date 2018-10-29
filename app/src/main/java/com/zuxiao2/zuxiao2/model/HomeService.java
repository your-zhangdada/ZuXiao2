package com.zuxiao2.zuxiao2.model;


import com.zuxiao2.zuxiao2.bean.BannerBean;
import com.zuxiao2.zuxiao2.bean.Home_huodong;
import com.zuxiao2.zuxiao2.bean.Home_rezhu;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface HomeService {
    @FormUrlEncoded
    @POST(Urls.HOME_COMMODITY)
    Observable<Home_huodong> getHomeTab(@FieldMap Map<String, String> params);
    //banner
    @FormUrlEncoded
    @POST(Urls.BANNER)
    Observable<BannerBean> getLoginCodeBean(@FieldMap Map<String, String> params);
    //热阻
    @FormUrlEncoded
    @POST(Urls.HOME_RZ)
    Observable<Home_rezhu> getHomeRZ(@FieldMap Map<String, String> params);


}
