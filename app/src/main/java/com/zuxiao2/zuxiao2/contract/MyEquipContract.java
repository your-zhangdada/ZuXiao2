package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.MyEquipBean;
import com.zuxiao2.zuxiao2.bean.MyOrederBean;

import java.util.Map;

public interface MyEquipContract {
    public interface Presenter extends BasePresenter<View> {
        void getMyEquipBean(Map<String, String> mMap);

    }
    public interface View{
        void showMyEquip(MyOrederBean myOrederBean);
    }
}
