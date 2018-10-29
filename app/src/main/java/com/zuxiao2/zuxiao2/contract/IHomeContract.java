package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.BannerBean;
import com.zuxiao2.zuxiao2.bean.Home_huodong;
import com.zuxiao2.zuxiao2.bean.Home_rezhu;

import java.util.Map;

public interface IHomeContract  {
    public interface Presenter extends BasePresenter<View> {
        void getHomeBean(Map<String, String> mMap);
    }
    //banner
    public interface View{
        void showHomeBean(BannerBean homeBean);
        void showRZ_Bean(Home_rezhu home_rezhu);
        void showHome_Tab(Home_huodong home_huodong);
    }
}
