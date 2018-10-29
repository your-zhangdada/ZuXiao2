package com.zuxiao2.zuxiao2.contract;


import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.CommodityBean;

import java.util.Map;

public interface IHomeCommContract {
    public interface Presenter extends BasePresenter<View> {
        void getHomeCommody(Map<String, String> mMap);

    }
    public interface View{
        void showHomeCommodt(CommodityBean frist);
    }
}
