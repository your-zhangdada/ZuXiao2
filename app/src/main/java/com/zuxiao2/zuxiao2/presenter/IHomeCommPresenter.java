package com.zuxiao2.zuxiao2.presenter;


import com.zuxiao2.zuxiao2.bean.CommodityBean;
import com.zuxiao2.zuxiao2.contract.IHomeCommContract;
import com.zuxiao2.zuxiao2.model.MyService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class IHomeCommPresenter implements IHomeCommContract.Presenter  {
    private IHomeCommContract.View view;
    private MyService myService;

    public IHomeCommPresenter() {
        myService = RetrofitUtils.getInstance().getMyService();

    }
    @Override
    public void getHomeCommody(Map<String, String> mMap) {
        myService.getHomeCommody(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommodityBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(CommodityBean commodityBean) {
                    view.showHomeCommodt(commodityBean);
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
    public void attachView(IHomeCommContract.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {

    }
}
