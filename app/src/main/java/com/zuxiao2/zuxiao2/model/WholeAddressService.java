package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.AddAddressResultBean;
import com.zuxiao2.zuxiao2.bean.AddressBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.HeaderMap;
import retrofit2.http.POST;

public interface WholeAddressService {
    @POST(Urls.ADDRESS)
    Observable<AddressBean> getAddress();

    @FormUrlEncoded
    @POST(Urls.ADDADDRESS_URL)
    Observable<AddAddressResultBean> getAddAddressResultBean(@HeaderMap Map<String,String> headers, @FieldMap Map<String,String> params);
}
