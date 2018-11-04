package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;

import java.util.HashMap;
import java.util.Map;

import okhttp3.MultipartBody;

public interface ApplyContract {
    public interface Presenter extends BasePresenter<View>{
        void getApplyBean(HashMap<String, String> header, Map<String, String> map);
        void  getApplyStu(HashMap<String, String> header, Map<String, String> map);
        void  getApplyOperate(HashMap<String, String> header, Map<String, String> map);
        void getApplyCard(HashMap<String, String> header, Map<String, String> map);//社保卡
        void getApplyAssets(Map<String, String> map, Map<String, String> stringStringMap);//固定资产
        void getEducationApply(HashMap<String, String> header, Map<String, String> map);//学历认证
        void getComApply(HashMap<String, String> header, Map<String, String> map);//公司信息认证
        void getLicenseApply(HashMap<String, String> header, Map<String, String> map);//营业执照认证
        void getEnterpriseApply(HashMap<String, String> header,Map<String,String> map);//企业信息认证

        void getCommitImgBean(MultipartBody.Part mMap);// 相机相关
    }
    public interface  View{
        void showApplyBean(ApplyBean applyBean);
        void showCommitImgBean(MerChantentryBean merChantentryBean);//相机相关
    }
}
