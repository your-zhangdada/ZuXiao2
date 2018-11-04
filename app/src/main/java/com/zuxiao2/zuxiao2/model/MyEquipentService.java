package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.MyEquipBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MyEquipentService {
    //认证
    @FormUrlEncoded
    @POST(Urls.MY_EQUIP)
    Observable<MyEquipBean> getMyEquip(@FieldMap Map<String,String> params);
}
