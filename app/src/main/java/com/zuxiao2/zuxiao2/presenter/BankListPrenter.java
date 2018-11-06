package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.BankListBean;
import com.zuxiao2.zuxiao2.contract.BankListConteact;
import com.zuxiao2.zuxiao2.model.BankListService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class BankListPrenter implements BankListConteact.Presenter {
    private BankListConteact.View view;
    private BankListService service;
    public BankListPrenter(){
        service = RetrofitUtils.getInstance().getBankListService();
    }
    @Override
    public void getBankList(HashMap<String, String> header) {
        service.getAddBank(header)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BankListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(BankListBean bankListBean) {
                        view.showBankList(bankListBean);
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
    public void attachView(BankListConteact.View view) {
            this.view = view;
    }
    @Override
    public void detachView() {
    }
}
