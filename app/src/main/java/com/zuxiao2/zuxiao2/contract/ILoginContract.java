package com.zuxiao2.zuxiao2.contract;


import com.zuxiao2.zuxiao2.base.BasePresenter;
import com.zuxiao2.zuxiao2.bean.CodeBean;
import com.zuxiao2.zuxiao2.bean.Frogetpass;
import com.zuxiao2.zuxiao2.bean.LoginCodeBean;
import com.zuxiao2.zuxiao2.bean.Password;

import java.util.Map;

public interface ILoginContract {
    public interface Presenter extends BasePresenter<View> {
        void getCodeBean(Map<String, String> phone);
        void getLoginBean(String phone, String code);

    }
    public interface View{
        void showCodeBean(CodeBean codeBean);
        void showLoginBean(LoginCodeBean loginCodeBean);
        void showPegisterBean(Password password);
        void showCzPwdBean(Frogetpass frogetpass);
    }
}
