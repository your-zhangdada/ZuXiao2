package com.zuxiao2.zuxiao2.model;


import com.zuxiao2.zuxiao2.bean.CodeBean;
import com.zuxiao2.zuxiao2.bean.Frogetpass;
import com.zuxiao2.zuxiao2.bean.LoginCodeBean;
import com.zuxiao2.zuxiao2.bean.Password;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface LoginService {

    @FormUrlEncoded
    @POST(Urls.CODEURL)
    Observable<CodeBean> getCodeBean(@FieldMap Map<String, String> params);


    @FormUrlEncoded
    @POST(Urls.REGISTER)
    Observable<Password> getRegsterBean(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(Urls.LOGINCODEURL)
    Observable<LoginCodeBean> getLoginCodeBean(@FieldMap Map<String, String> params);
    @FormUrlEncoded
    @POST(Urls.CZPWD)
    Observable<Frogetpass> getCzPwdBean(@FieldMap Map<String, String> params);
}
