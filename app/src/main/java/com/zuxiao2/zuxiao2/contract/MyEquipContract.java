package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.MyEquipBean;

import java.util.Map;

public interface MyEquipContract {
    public interface Presenter extends BasePresenter<MyEquipContract.View> {
        void getMyEquipBean(Map<String, String> mMap);

    }
    public interface View{
        void showMyEquip(MyEquipBean myEquipBean);
    }
}
