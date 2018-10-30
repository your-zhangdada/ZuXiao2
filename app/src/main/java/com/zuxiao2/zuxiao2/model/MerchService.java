package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface MerchService {
    //我的页面商家入住
    @FormUrlEncoded
    @POST(Urls.MY_MERCH)
    Observable<RequestBody> getMyMerch(@FieldMap Map<String, String> params);
}
