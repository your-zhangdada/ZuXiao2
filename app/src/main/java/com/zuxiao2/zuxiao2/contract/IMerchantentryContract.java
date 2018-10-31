package com.zuxiao2.zuxiao2.contract;

import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.Home_FL;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;

import java.util.Map;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public interface IMerchantentryContract {
    public interface Presenter extends BasePresenter<View> {
        void getMerchantentryBean(Map<String, String> mMap);
        void getCommitImgBean(MultipartBody.Part mMap);

    }
    public interface View{
        void showMerchantentryBean(MerChantentryBean merChantentryBean);
        void showCommitImgBean(MerChantentryBean merChantentryBean);
    }
}
