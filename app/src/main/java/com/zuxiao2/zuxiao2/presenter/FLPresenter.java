package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.contract.IFLContract;
import com.zuxiao2.zuxiao2.model.FLService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class FLPresenter implements IFLContract.Presenter {
    private IFLContract.View view;
    private FLService flService;
    public FLPresenter() {
        flService = RetrofitUtils.getInstance().getFLService();
    }


    @Override
    public void getFLList(Map<String, String> mMap) {

        flService.getFL_list(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Frist>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Frist frist) {
                       view.showFLList(frist);
                    }
                    @Override
                    public void onError(Throwable e) {
                    }
                    @Override
                    public void onComplete() {
                    }
                });
    }
    public void getFLTwo(int id){
        Map<String,String> map = new HashMap<>();
        map.put("id",id+"");
        flService.getFL_Recycler(map).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<Second>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(Second second) {
                        view.showFLRecycler(second);
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
    public void attachView(IFLContract.View view) {
       this.view =  view;
    }

    @Override
    public void detachView() {

    }
}
