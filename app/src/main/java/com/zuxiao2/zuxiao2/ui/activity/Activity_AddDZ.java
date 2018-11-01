package com.zuxiao2.zuxiao2.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.contract.IAddDingDanContract;
import com.zuxiao2.zuxiao2.presenter.AddDingDanPresenter;
import com.zuxiao2.zuxiao2.utils.SpUtils;


import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;

public class Activity_AddDZ extends BaseActivity<AddDingDanPresenter> implements View.OnClickListener,IAddDingDanContract.View {
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_equipment_return;
    }

    @Override
    protected void initView() {

       /* Intent intent = getIntent();
        CommodityBean.DataBean databena = (CommodityBean.DataBean) intent.getSerializableExtra("databena");*/
        Button btn_zf = findViewById(R.id.btn_zf);
        btn_zf.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zf:
                String str = "{ \"addressId\": 17, \"day\":7, \"postageType\": 1, \"remark\": \"快点发货哈\", \"activityId\":-1, \"skus\": [ { \"insuranceId\": \"14\", \"num\": 1, \"skuId\": 23 } ] }";
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/json"), str);
                HashMap<String, String> header = new HashMap<>();
                header.put("user_login",SpUtils.getUserKey(this));
                header.put("uuid",SpUtils.getUserId());
                presenter.getMerChantentryBean(header,fileBody);
                break;
        }
    }

    @Override
    public void showMerChantentryBean(MerChantentryBean merChantentryBean) {
        Toast.makeText(this, merChantentryBean.toString(), Toast.LENGTH_SHORT).show();
    }

}
