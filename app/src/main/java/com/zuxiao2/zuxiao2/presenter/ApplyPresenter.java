package com.zuxiao2.zuxiao2.presenter;

import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.model.ApplyService;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.Map;
//认证
public class ApplyPresenter  implements ApplyContract.Presenter {
    private ApplyContract.View view;
    private ApplyService applyService;
    public ApplyPresenter(){
        applyService = RetrofitUtils.getInstance().getApplyService();
    }
    @Override
    public void getApplyBean(Map<String, String> map) {

    }

    @Override
    public void attachView(ApplyContract.View view) {
            this.view = view;
    }

    @Override
    public void detachView() {

    }
}
