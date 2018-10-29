package com.zuxiao2.zuxiao2.model;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface PassLoginService {

    @FormUrlEncoded
    @POST(Urls.PASSLOGINURL)
    Observable<PassLoginBean> getPassLoginBean(@FieldMap Map<String, String> params);


}
