package com.zuxiao2.zuxiao2.presenter;
import com.zuxiao2.zuxiao2.bean.BannerBean;
import com.zuxiao2.zuxiao2.bean.Home_huodong;
import com.zuxiao2.zuxiao2.bean.Home_rezhu;
import com.zuxiao2.zuxiao2.contract.IHomeContract;
import com.zuxiao2.zuxiao2.model.HomeService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class HomePresenter implements IHomeContract.Presenter {
    private IHomeContract.View view;
    private HomeService homeService;

    public HomePresenter() {
        homeService = RetrofitUtils.getInstance().getHomeService();

    }

    @Override
    public void getHomeBean(Map<String, String> mMap) {
        homeService.getLoginCodeBean(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<BannerBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(BannerBean bannerBean) {
                        view.showHomeBean(bannerBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void getHomeRZ(Map<String, String> mMap) {
        homeService.getHomeRZ(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Home_rezhu>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Home_rezhu home_rezhu) {
                        view.showRZ_Bean(home_rezhu);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }

    public void getHomeTab(Map<String, String> map) {
        homeService.getHomeTab(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Home_huodong>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Home_huodong homeBean) {
                    view.showHome_Tab(homeBean);
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
    public void attachView(IHomeContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {
    }
}
