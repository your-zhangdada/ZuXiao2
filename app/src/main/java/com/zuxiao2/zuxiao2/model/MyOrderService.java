package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.MyOrederBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface MyOrderService {
    //我的订单
    @POST(Urls.GETMYORDER_URL)
    Observable<MyOrederBean> getMyOrederBean(@HeaderMap Map<String,String> headers, @Body RequestBody mMap);


}
