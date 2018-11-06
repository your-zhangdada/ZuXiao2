package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.BankListBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface BankListService {
    @GET(Urls.BANKLIST)
    Observable<BankListBean> getAddBank(@HeaderMap Map<String,String> headers);
}
