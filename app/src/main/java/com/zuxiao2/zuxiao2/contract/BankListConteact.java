package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.BankListBean;

import java.util.HashMap;

public interface BankListConteact {
    public interface Presenter extends BasePresenter<View> {
        void getBankList(HashMap<String, String> header);

    }
    public interface View{
        void showBankList(BankListBean bankListBean);


    }
}
