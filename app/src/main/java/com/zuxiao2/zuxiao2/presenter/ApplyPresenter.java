package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.model.ApplyService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//认证
public class ApplyPresenter  implements ApplyContract.Presenter {
    private ApplyContract.View view;
    private ApplyService applyService;

    public ApplyPresenter() {
        applyService = RetrofitUtils.getInstance().getApplyService();
    }

    @Override// 省份证认证
    public void getApplyBean(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override//学生证认证
    public void getApplyStu(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override//运营商认证
    public void getApplyOperate(Map<String, String> map) {
        applyService.getApply(map)
                .observeOn(Schedulers.newThread())
                .subscribeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override// 社保卡
    public void getApplyCard(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override// 固定资产
    public void getApplyAssets(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override//学历认证
    public void getEducationApply(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override//公司信息认证
    public void getComApply(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {
                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {
                    }

                    @Override
                    public void onComplete() {
                    }
                });
    }

    @Override//营业执照 认证
    public void getLicenseApply(Map<String, String> map) {
        applyService.getApply(map)
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ApplyBean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ApplyBean applyBean) {
                        view.showApplyBean(applyBean);
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    @Override//企业信息认证
    public void getEnterpriseApply(Map<String, String> map) {
        applyService.getApply(map);
    }


    @Override
    public void attachView(ApplyContract.View view) {
        this.view = view;
    }


    @Override
    public void detachView() {

    }
}
