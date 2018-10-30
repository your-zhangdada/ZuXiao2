package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.FincBean;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.PinPaiBean;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.QueryMap;

public interface FincService {
    @FormUrlEncoded
    @POST(Urls.FINC_URL)
    Observable<FincBean> getFincBean(@FieldMap Map<String, String> params);

    @GET(Urls.FINCPINPAI_URL)
    Observable<PinPaiBean> getPinPaiBean( @QueryMap Map<String, String> params);
    @FormUrlEncoded
    @POST(Urls.FL_TWO)
    Observable<Second> getFenLeiCeHuaBean(@FieldMap Map<String, String> params);
}
