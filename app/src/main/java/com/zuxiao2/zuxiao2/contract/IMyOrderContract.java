package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.MyOrederBean;

import java.util.Map;

import okhttp3.RequestBody;

public interface IMyOrderContract {
    public interface Presenter extends BasePresenter<View> {
        void getMyOrederBean(Map<String,String> headers, RequestBody mMap);

    }
    public interface View{
        void showMyOrederBean(MyOrederBean myOrederBean);
    }
}
