package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.HomeBean;

import java.util.Map;

public interface MerContart {
    public interface Presenter extends BasePresenter<View> {
        void getMerchBean(Map<String, String> mMap);

    }
    public interface View{
        void showMerchBean(HomeBean homeBean);
    }
}
