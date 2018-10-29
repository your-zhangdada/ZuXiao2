package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.Home_FL;

import java.util.Map;

public interface IMyContract {
    public interface Presenter extends BasePresenter<View> {
        void getPassLoginBean(Map<String, String> mMap);

    }
    public interface View{
        void showHomeFL(Home_FL home_fl);
    }
}
