package com.zuxiao2.zuxiao2.presenter;


import com.zuxiao2.zuxiao2.bean.FincBean;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.PinPaiBean;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.contract.IFLContract;
import com.zuxiao2.zuxiao2.contract.IFincContract;
import com.zuxiao2.zuxiao2.model.FLService;
import com.zuxiao2.zuxiao2.model.FincService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class FincPresenter implements IFincContract.Presenter {
    private IFincContract.View view;
    private FincService fincService;
    public FincPresenter() {
        fincService = RetrofitUtils.getInstance().getFincService();
    }

    @Override
    public void getFincBean(Map<String, String> mMap) {
        fincService.getFincBean(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<FincBean>() {
                    @Override
                    public void accept(FincBean fincBean) throws Exception {
                        view.showFincBean(fincBean);
                    }
                });
    }

    @Override
    public void getPinPaiBean(Map<String, String> mMap) {
        fincService.getPinPaiBean(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<PinPaiBean>() {
                    @Override
                    public void accept(PinPaiBean pinPaiBean) throws Exception {
                        view.showPinPaiBean(pinPaiBean);
                    }
                });
    }

    @Override
    public void getFenLeiCeHuaBean(Map<String, String> mMap) {
        fincService.getFenLeiCeHuaBean(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<Second>() {
                    @Override
                    public void accept(Second second) throws Exception {
                        view.showFenLeiCeHuaBean(second);
                    }
                });
    }

    @Override
    public void attachView(IFincContract.View view) {
        this.view =  view;
    }

    @Override
    public void detachView() {

    }
}
