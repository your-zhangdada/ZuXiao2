package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.AddressBean;

public interface AddressContract {
    public interface Presenter extends BasePresenter<View> {
        void getAddressBean();

    }
    public interface View{
        void showAddress(AddressBean addressBean);
    }
}
