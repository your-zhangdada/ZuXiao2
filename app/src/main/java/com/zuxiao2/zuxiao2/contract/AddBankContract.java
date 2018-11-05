package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.HomeBean;

import java.util.Map;

public interface AddBankContract {
    public interface Presenter extends BasePresenter<View> {
        void getAddBanks(Map<String, String> mMap);

    }
    public interface View{
        void showAddBank(HomeBean  homeBean);


    }
}
