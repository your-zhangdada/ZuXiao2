package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.contract.IMerchantentryContract;
import com.zuxiao2.zuxiao2.model.MerchantentryService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class MerchantentryPresenter implements IMerchantentryContract.Presenter {

    private final MerchantentryService merchantentryService;

    private IMerchantentryContract.View view;
    public MerchantentryPresenter() {
        merchantentryService = RetrofitUtils.getInstance().getMerchantentryService();
    }

    @Override
    public void getMerchantentryBean(Map<String, String> mMap) {
        merchantentryService.getMerChantentryBean(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MerChantentryBean>() {
                    @Override
                    public void accept(MerChantentryBean merChantentryBean) throws Exception {
                        view.showMerchantentryBean(merChantentryBean);
                    }
                });
    }

    @Override
    public void getCommitImgBean(MultipartBody.Part mMap) {
        merchantentryService.getCommitImgBean(mMap).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Consumer<MerChantentryBean>() {
                    @Override
                    public void accept(MerChantentryBean merChantentryBean) throws Exception {
                        view.showCommitImgBean(merChantentryBean);
                    }
                });
    }

    @Override
    public void attachView(IMerchantentryContract.View view) {

        this.view =view;
    }

    @Override
    public void detachView() {

    }
}
