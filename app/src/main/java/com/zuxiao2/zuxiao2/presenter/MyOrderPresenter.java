package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.MyOrederBean;
import com.zuxiao2.zuxiao2.contract.IMyOrderContract;
import com.zuxiao2.zuxiao2.model.MyOrderService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.RequestBody;

public class MyOrderPresenter implements IMyOrderContract.Presenter {
    private IMyOrderContract.View view;
    private final MyOrderService myOrderService;

    public MyOrderPresenter() {
        myOrderService = RetrofitUtils.getInstance().getMyOrderService();
    }

    @Override
    public void getMyOrederBean(Map<String, String> headers, RequestBody mMap) {
        myOrderService.getMyOrederBean(headers,mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MyOrederBean>() {
                    @Override
                    public void accept(MyOrederBean myOrederBean) throws Exception {
                        view.showMyOrederBean(myOrederBean);
                    }
                });
    }

    @Override
    public void attachView(IMyOrderContract.View view) {

        this.view =view;
    }

    @Override
    public void detachView() {

    }
}
