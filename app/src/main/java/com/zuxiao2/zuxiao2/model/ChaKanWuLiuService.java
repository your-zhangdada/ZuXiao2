package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.ApplyListBean;
import com.zuxiao2.zuxiao2.bean.ChaKanWuLiuBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

public interface ChaKanWuLiuService {

    @GET()
    Observable<ChaKanWuLiuBean> getChaKanWuLiuBean(@HeaderMap Map<String,String> map);
}
