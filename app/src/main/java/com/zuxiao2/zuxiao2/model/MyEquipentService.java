package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.MyEquipBean;
import com.zuxiao2.zuxiao2.bean.MyOrederBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface MyEquipentService {
    @GET(Urls.MY_EQUIP)
    Observable<MyOrederBean> getMyEquip(@QueryMap Map<String, String> params);
}
