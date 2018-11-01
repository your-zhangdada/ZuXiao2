package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.contract.IAddDingDanContract;
import com.zuxiao2.zuxiao2.model.AddDingDanService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class AddDingDanPresenter implements IAddDingDanContract.Presenter {

    private AddDingDanService addDingDanService;
    private IAddDingDanContract.View view;

    public AddDingDanPresenter() {
        addDingDanService = RetrofitUtils.getInstance().getAddDingDanService();
    }

    @Override
    public void getMerChantentryBean(Map<String,String> headers,RequestBody mMap) {
        addDingDanService.getAddDingDanBean(headers,mMap)  .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MerChantentryBean>() {
                    @Override
                    public void accept(MerChantentryBean merChantentryBean) throws Exception {
                        view.showMerChantentryBean(merChantentryBean);
                    }
                });
    }


    @Override
    public void attachView(IAddDingDanContract.View view) {
        this.view =view;
    }

    @Override
    public void detachView() {

    }
}
