package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.MyEquipBean;
import com.zuxiao2.zuxiao2.contract.MyEquipContract;
import com.zuxiao2.zuxiao2.model.MyEquipentService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyEquipPresenter implements MyEquipContract.Presenter {
    private MyEquipContract.View view;
    private MyEquipentService myEquipentService;
    public MyEquipPresenter(){
        myEquipentService = RetrofitUtils.getInstance().getMyEquipSercice();
    }
    @Override
    public void getMyEquipBean(Map<String, String> mMap) {
        myEquipentService.getMyEquip(mMap)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<MyEquipBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(MyEquipBean myEquipBean) {
                            view.showMyEquip(myEquipBean);
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
    public void attachView(MyEquipContract.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {

    }
}
