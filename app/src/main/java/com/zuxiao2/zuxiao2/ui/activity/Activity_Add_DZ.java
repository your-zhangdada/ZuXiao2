package com.zuxiao2.zuxiao2.ui.activity;

import android.support.v7.widget.RecyclerView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.SHDZ_Bean;
import com.zuxiao2.zuxiao2.model.MyService;
import com.zuxiao2.zuxiao2.ui.adapter.ADD_RecylerAdapter;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.HashMap;
import java.util.List;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;
//收货地址

public class Activity_Add_DZ extends BaseActivity {

    private List<SHDZ_Bean.DataBean> data;
    private ADD_RecylerAdapter add_recylerAdapter;
    private RecyclerView recycler_adddz;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_sh_dz;
    }

    @Override
    protected void initView() {
        recycler_adddz = findViewById(R.id.recycler_adddz);
        add_recylerAdapter = new ADD_RecylerAdapter(getApplicationContext(),data);
    }

    @Override
    protected void initData() {
        MyService myService = RetrofitUtils.getInstance().getMyService();
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(this));
        header.put("uuid",SpUtils.getUserId());
        myService.getHomeAddDZ(header).subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<SHDZ_Bean>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(SHDZ_Bean shdz_bean) {
                        data = shdz_bean.getData();
                        recycler_adddz.setAdapter(add_recylerAdapter);
                        add_recylerAdapter.notifyDataSetChanged();
                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }
}
