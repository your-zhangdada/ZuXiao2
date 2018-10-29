package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.Hot_sousou;
import com.zuxiao2.zuxiao2.contract.SouSouContract;
import com.zuxiao2.zuxiao2.model.SouSouService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
// 热门搜索
public class SouSouPresenter implements SouSouContract.Presenter {

    private  SouSouContract.View view;
    private SouSouService souService;
    public SouSouPresenter() {
        souService = RetrofitUtils.getInstance().getSouSouService();
    }
    @Override
    public void attachView(SouSouContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }

    @Override
    public void getSouSouBean() {
        souService.getSouSou().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Hot_sousou>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(Hot_sousou hot_sousou) {
                        view.showSouSou(hot_sousou);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
