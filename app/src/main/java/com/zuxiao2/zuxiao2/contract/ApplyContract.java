package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.ApplyBean;

import java.util.Map;

public interface ApplyContract {
    public interface Presenter extends BasePresenter<View>{
        void getApplyBean(Map<String,String> map);
        void  getApplyStu(Map<String,String> map);
        void  getApplyOperate(Map<String,String> map);
    }
    public interface  View{
        void showApplyBean(ApplyBean applyBean);
    }
}
