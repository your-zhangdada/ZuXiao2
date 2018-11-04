package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.HotListBean;
import com.zuxiao2.zuxiao2.contract.HotListContract;
import com.zuxiao2.zuxiao2.model.HotListService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HotListPresenter implements HotListContract.Presenter {
    private  HotListContract.View view;
    private HotListService hotListService;
    public  HotListPresenter(){
        hotListService = RetrofitUtils.getInstance().getHotListService();
    }
    @Override
    public void getHotList() {
        hotListService.getHotList()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HotListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(HotListBean hotListBean) {
                        view.showHotList(hotListBean);
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
    public void attachView(HotListContract.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {

    }
}
