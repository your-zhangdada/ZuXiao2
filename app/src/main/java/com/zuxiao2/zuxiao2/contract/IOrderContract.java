package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.OrderTabBean;

import java.util.Map;

public interface IOrderContract {
    public interface Presenter extends BasePresenter<View> {
        void getOrderTabBean();

    }
    public interface View{
        void showOrderTabBean(OrderTabBean orderTabBean);
    }
}
