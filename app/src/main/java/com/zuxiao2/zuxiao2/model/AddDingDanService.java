package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface AddDingDanService {
    //下单接口
    @POST(Urls.ADDDINGDAN_URL)
    Observable<MerChantentryBean> getAddDingDanBean(@HeaderMap Map<String,String> headers, @Body RequestBody mMap);
}
