package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.ApplyListBean;

import java.util.HashMap;

public interface ApplyListContract {
    public interface Presenter extends BasePresenter<View> {
        void getApplyList(HashMap<String, String> header);//认证列表

    }
    public interface  View{
        void showApplyListBean(ApplyListBean applyListBean);
    }
}
