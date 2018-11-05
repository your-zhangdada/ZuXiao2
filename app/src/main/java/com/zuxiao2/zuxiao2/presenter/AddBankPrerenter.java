package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.HomeBean;
import com.zuxiao2.zuxiao2.contract.AddBankContract;
import com.zuxiao2.zuxiao2.model.AddBankService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddBankPrerenter implements AddBankContract.Presenter {
    private AddBankContract.View view;
    private AddBankService service;
    public AddBankPrerenter(){
        service = RetrofitUtils.getInstance().getAddBankService();
    }

    @Override
    public void getAddBanks(Map<String, String> mMap) {
        service.getAddBank(mMap)
        .subscribeOn(Schedulers.newThread())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Observer<HomeBean>() {
            @Override
            public void onSubscribe(Disposable d) {

            }

            @Override
            public void onNext(HomeBean homeBean) {

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
    public void attachView(AddBankContract.View view) {
                    this.view = view;
    }

    @Override
    public void detachView() {
    }
}
