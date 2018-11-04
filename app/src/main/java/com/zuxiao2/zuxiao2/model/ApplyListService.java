package com.zuxiao2.zuxiao2.model;

import com.zuxiao2.zuxiao2.bean.ApplyListBean;
import com.zuxiao2.zuxiao2.utils.Urls;

import java.util.Map;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.HeaderMap;

//  用户的认证情况-认证列表
public interface ApplyListService {
    @GET(Urls.APPLY_LIST)
    Observable<ApplyListBean> getUserApplyListBean(@HeaderMap Map<String,String> map);
}
