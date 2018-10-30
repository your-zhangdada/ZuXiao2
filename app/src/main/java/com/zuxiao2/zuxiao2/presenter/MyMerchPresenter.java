package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.contract.MerContart;
import com.zuxiao2.zuxiao2.model.MerchService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class MyMerchPresenter implements MerContart.Presenter {
    private MerContart.View view;
    private MerchService merchService;
    //商家入住
    public MyMerchPresenter(){
        merchService = RetrofitUtils.getInstance().getMerchService();
    }
    @Override
    public void getMerchBean(Map<String, String> mMap) {
        merchService.getMyMerch(mMap).observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<RequestBody>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(RequestBody requestBody) {
                        String s = requestBody.toString();

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
    public void attachView(MerContart.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {

    }
}
