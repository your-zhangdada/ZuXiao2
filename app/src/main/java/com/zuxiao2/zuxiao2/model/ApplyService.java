package com.zuxiao2.zuxiao2.model;
import com.zuxiao2.zuxiao2.bean.HomeBean;
import com.zuxiao2.zuxiao2.utils.Urls;
import java.util.Map;
import io.reactivex.Observable;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApplyService {
    //认证
    @FormUrlEncoded
    @POST(Urls.USER_APPLY)
    Observable<HomeBean> getApply(@FieldMap Map<String,String> params);
}
