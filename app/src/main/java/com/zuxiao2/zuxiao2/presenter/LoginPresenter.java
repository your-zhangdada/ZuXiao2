package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.CodeBean;
import com.zuxiao2.zuxiao2.bean.Frogetpass;
import com.zuxiao2.zuxiao2.bean.LoginCodeBean;
import com.zuxiao2.zuxiao2.bean.Password;
import com.zuxiao2.zuxiao2.contract.ILoginContract;
import com.zuxiao2.zuxiao2.model.LoginService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class LoginPresenter implements ILoginContract.Presenter {
    private ILoginContract.View view;
    private LoginService loginService;

    public LoginPresenter() {
        loginService =  RetrofitUtils.getInstance().getLoginService();
    }

    @Override//获取验证码
    public void getCodeBean(Map<String, String> phone) {
        loginService.getCodeBean(phone).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CodeBean codeBean) {
                        view.showCodeBean(codeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override // 登录
    public void getLoginBean(String phone, String code) {
        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",phone);
        params.put("code",code);
        loginService.getLoginCodeBean(params).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<LoginCodeBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(LoginCodeBean loginCodeBean) {
                        view.showLoginBean(loginCodeBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public  void  getRegister(Map<String, String> map){
        loginService.getRegsterBean(map).observeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Password>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Password password) {
                        view.showPegisterBean(password);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
             }
    public void  getCZPwd(HashMap<String, String> map){
        loginService.getCzPwdBean(map).observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Frogetpass>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Frogetpass frogetpass) {
                        view.showCzPwdBean(frogetpass);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
    @Override
    public void attachView(ILoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
