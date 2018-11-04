package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.OrderTabBean;
import com.zuxiao2.zuxiao2.contract.IOrderContract;
import com.zuxiao2.zuxiao2.model.OrderTabService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

public class OrderTabPresenter implements IOrderContract.Presenter {

    private final OrderTabService orderTabService;
    private IOrderContract.View view;
    public OrderTabPresenter() {
        orderTabService = RetrofitUtils.getInstance().getOrderTabService();
    }

    @Override
    public void getOrderTabBean() {
        orderTabService.getOrderTabBean().subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<OrderTabBean>() {
                    @Override
                    public void accept(OrderTabBean orderTabBean) throws Exception {
                        view.showOrderTabBean(orderTabBean);
                    }
                });
    }

    @Override
    public void attachView(IOrderContract.View view) {

        this.view =view;
    }

    @Override
    public void detachView() {

    }
}
