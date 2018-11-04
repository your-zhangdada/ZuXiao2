package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.OrderTabBean;
import com.zuxiao2.zuxiao2.bean.SHDZ_Bean;
import com.zuxiao2.zuxiao2.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface OrderTabService {

    @GET(Urls.GETORDERTAB_URL)
    Observable<OrderTabBean> getOrderTabBean();
}
