package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;
import retrofit2.http.PartMap;

public interface MerchantentryService {
    @FormUrlEncoded
    @POST(Urls.MERCHANTENTRY_URL)
    Observable<MerChantentryBean> getMerChantentryBean(@FieldMap Map<String, String> params);

    @Multipart
    @POST(Urls.COMMITIMG)
    Observable<MerChantentryBean> getCommitImgBean( @Part MultipartBody.Part mMap);

}
