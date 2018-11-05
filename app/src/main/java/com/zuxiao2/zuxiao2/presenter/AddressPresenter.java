package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.AddressBean;
import com.zuxiao2.zuxiao2.contract.AddressContract;
import com.zuxiao2.zuxiao2.model.WholeAddressService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class AddressPresenter implements AddressContract.Presenter {
    private AddressContract.View view;
    private WholeAddressService service;
    public AddressPresenter(){
        service = RetrofitUtils.getInstance().getAddressService();
    }
    @Override
    public void getAddressBean() {
        service.getAddress()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<AddressBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(AddressBean addressBean) {
                                view.showAddress(addressBean);
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
    public void attachView(AddressContract.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {

    }
}
