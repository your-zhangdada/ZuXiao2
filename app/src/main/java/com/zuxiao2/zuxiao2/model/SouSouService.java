package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.Hot_sousou;
import com.zuxiao2.zuxiao2.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface SouSouService {

    @GET(Urls.SOUSOU)
    Observable<Hot_sousou> getSouSou();
}
