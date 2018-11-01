package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.ApplyBean;

import java.util.Map;

public interface ApplyContract {
    public interface Presenter extends BasePresenter<View>{
        void getApplyBean(Map<String,String> map);
        void  getApplyStu(Map<String,String> map);
        void  getApplyOperate(Map<String,String> map);
        void getApplyCard(Map<String,String> map);//社保卡
        void getApplyAssets(Map<String,String> map);//固定资产
        void getEducationApply(Map<String,String> map);//学历认证
        void getComApply(Map<String,String> map);//公司信息认证
        void getLicenseApply(Map<String ,String > map);//营业执照认证
        void getEnterpriseApply(Map<String,String> map);//企业信息认证
    }
    public interface  View{
        void showApplyBean(ApplyBean applyBean);
    }
}
