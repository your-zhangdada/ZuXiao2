package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.HotListBean;

public interface HotListContract {
    public interface Presenter extends BasePresenter<HotListContract.View> {
        void getHotList();

    }
    public interface View{
        void showHotList(HotListBean hotListBean);

    }
}
