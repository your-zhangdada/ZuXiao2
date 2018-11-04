package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.bean.WXPayBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface AddDingDanService {
    //下单接口
    @POST(Urls.ADDDINGDAN_URL)
    Observable<MerChantentryBean> getAddDingDanBean(@HeaderMap Map<String,String> headers, @Body RequestBody mMap);


    //微信支付
    @GET(Urls.TOWXPAI_URL)
    Observable<WXPayBean> getWxPayBean(@HeaderMap Map<String,String> headers, @QueryMap Map<String,String> params);

}
