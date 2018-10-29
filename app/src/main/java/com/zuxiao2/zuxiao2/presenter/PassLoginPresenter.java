package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.contract.IPassLoginContract;
import com.zuxiao2.zuxiao2.model.PassLoginService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class PassLoginPresenter implements IPassLoginContract.Presenter {
    private IPassLoginContract.View view;
    private PassLoginService passLoginService;
    public PassLoginPresenter() {
        passLoginService =  RetrofitUtils.getInstance().getPassLoginService();
    }

    @Override
    public void getPassLoginBean(String phone,String password) {
        HashMap<String,String> params = new HashMap<>();
        params.put("mobile",phone);
        params.put("pwd",password);
        passLoginService.getPassLoginBean(params).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<PassLoginBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(PassLoginBean passLoginBean) {
                        view.showPassLoginBean(passLoginBean);
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
    public void attachView(IPassLoginContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
