package com.zuxiao2.zuxiao2.model;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface FLService {
    //分类页面
    @FormUrlEncoded
    @POST(Urls.FL_LIST)
    Observable<Frist> getFL_list(@FieldMap Map<String, String> params);
    //分类页面
    @FormUrlEncoded
    @POST(Urls.FL_TWO)
    Observable<Second> getFL_Recycler(@FieldMap Map<String, String> params);
}
