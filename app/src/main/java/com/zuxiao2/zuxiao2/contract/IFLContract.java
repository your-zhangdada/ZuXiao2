package com.zuxiao2.zuxiao2.contract;


import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.Second;

import java.util.Map;

public interface IFLContract {
    public interface Presenter extends BasePresenter<View> {
        void getFLList(Map<String, String> mMap);

    }
    public interface View{
        void showFLList(Frist frist);
        void showFLRecycler(Second second);

    }
}
