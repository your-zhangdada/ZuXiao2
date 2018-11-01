package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public interface IAddDingDanContract {
    public interface Presenter extends BasePresenter<View> {
        void getMerChantentryBean(Map<String,String> headers,RequestBody mMap);

    }
    public interface View{
        void showMerChantentryBean(MerChantentryBean merChantentryBean);
    }
}
