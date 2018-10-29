package com.zuxiao2.zuxiao2.presenter;


import com.zuxiao2.zuxiao2.bean.Home_FL;
import com.zuxiao2.zuxiao2.contract.IMyContract;
import com.zuxiao2.zuxiao2.model.MyService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class MyPresenter  implements IMyContract.Presenter {
    private IMyContract.View view;
    private MyService myService;
    public MyPresenter() {
        myService = RetrofitUtils.getInstance().getMyService();
    }
    @Override
    public void attachView(IMyContract.View view) {
        this.view = view;
    }
    @Override
    public void detachView() {

    }
    @Override
    public void getPassLoginBean(Map<String, String> mMap) {
        myService.getHome_fl(mMap).subscribeOn(Schedulers.newThread())
                    .observeOn(AndroidSchedulers.mainThread())
                    .subscribe(new Observer<Home_FL>() {
                        @Override
                        public void onSubscribe(Disposable d) {
                        }
                        @Override
                        public void onNext(Home_FL home_fl) {
                            view.showHomeFL(home_fl);
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
