package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.Hot_sousou;

public interface SouSouContract {
    public interface Presenter extends BasePresenter<View> {
        void getSouSouBean();
    }
    public interface View{
        void showSouSou(Hot_sousou hot_sousou);
    }
}
