package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.HotListBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import io.reactivex.Observable;
import retrofit2.http.GET;

public interface HotListService {
    //认证
    @GET(Urls.HOT_LIST)
    Observable<HotListBean> getHotList();
}
