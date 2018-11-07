package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.AddAddressResultBean;
import com.zuxiao2.zuxiao2.bean.AddressBean;
import com.zuxiao2.zuxiao2.contract.AddressContract;
import com.zuxiao2.zuxiao2.model.WholeAddressService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
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
    public void getAddAdressResultBean(Map<String, String> headers,Map<String, String> map) {
        service.getAddAddressResultBean(headers,map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<AddAddressResultBean>() {
                    @Override
                    public void accept(AddAddressResultBean addAddressResultBean) throws Exception {
                        view.showAddAdressResultBean(addAddressResultBean);
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
