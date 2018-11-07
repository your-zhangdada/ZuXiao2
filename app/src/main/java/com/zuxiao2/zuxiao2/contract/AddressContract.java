package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.AddAddressResultBean;
import com.zuxiao2.zuxiao2.bean.AddressBean;

import java.util.Map;

public interface AddressContract {
    public interface Presenter extends BasePresenter<View> {
        void getAddressBean();
        void getAddAdressResultBean(Map<String,String> header, Map<String,String> map);

    }
    public interface View{
        void showAddress(AddressBean addressBean);
        void showAddAdressResultBean(AddAddressResultBean addAddressResultBean);
    }
}
