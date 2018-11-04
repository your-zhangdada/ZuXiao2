package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.ApplyListBean;
import com.zuxiao2.zuxiao2.contract.ApplyListContract;
import com.zuxiao2.zuxiao2.model.ApplyListService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
    //认证列表请求
public class ApplyListPresenter implements ApplyListContract.Presenter {
        private ApplyListContract.View view;
        private ApplyListService applyListService;

        public ApplyListPresenter(){
            applyListService = RetrofitUtils.getInstance().getApplyListService();
        }

    @Override
    public void getApplyList(HashMap<String, String> header) {
        applyListService.getUserApplyListBean(header)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyListBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }
                    @Override
                    public void onNext(ApplyListBean applyListBean) {
                        view.showApplyListBean(applyListBean);
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
    public void attachView(ApplyListContract.View view) {
        this.view = view;
    }

    @Override
    public void detachView() {

    }
}
