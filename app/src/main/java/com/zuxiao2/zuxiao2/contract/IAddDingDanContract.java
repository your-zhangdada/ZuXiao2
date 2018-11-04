package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.bean.WXPayBean;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

public interface IAddDingDanContract {
    public interface Presenter extends BasePresenter<View> {
        void getMerChantentryBean(Map<String,String> headers,RequestBody mMap);
        void getWXPayBean(Map<String,String> headers,Map<String,String> params);

    }
    public interface View{
        void showMerChantentryBean(MerChantentryBean merChantentryBean);
        void showWXPayBean(WXPayBean wxPayBean);
    }
}
