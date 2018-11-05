package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.AddressBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface WholeAddressService {
    @POST(Urls.ADDRESS)
    Observable<AddressBean> getAddress();
}
