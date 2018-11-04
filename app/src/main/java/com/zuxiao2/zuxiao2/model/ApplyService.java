package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.MultipartBody;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApplyService {
    //认证
    @FormUrlEncoded
    @POST(Urls.USER_APPLY)
    Observable<ApplyBean> getApply(@HeaderMap Map<String,String> map, @FieldMap Map<String,String> params);

    @Multipart
    @POST(Urls.COMMITIMG)  // 上传图片 接口
    Observable<MerChantentryBean> getCommitImgBean(@Part MultipartBody.Part mMap);
}
