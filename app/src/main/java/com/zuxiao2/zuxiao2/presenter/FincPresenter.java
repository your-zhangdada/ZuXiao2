package com.zuxiao2.zuxiao2.presenter;


import com.zuxiao2.zuxiao2.bean.FincBean;
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
    public void attachView(IFincContract.View view) {
        this.view =  view;
    }

    @Override
    public void detachView() {

    }
}
