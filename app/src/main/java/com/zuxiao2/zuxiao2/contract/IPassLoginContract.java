package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;

public interface IPassLoginContract {
    public interface Presenter extends BasePresenter<View> {
        void getPassLoginBean(String phone, String password);

    }
    public interface View{
        void showPassLoginBean(PassLoginBean passLoginBean);
    }
}
