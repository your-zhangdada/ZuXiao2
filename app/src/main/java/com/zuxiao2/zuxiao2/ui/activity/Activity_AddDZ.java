package com.zuxiao2.zuxiao2.ui.activity;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.tencent.mm.opensdk.modelpay.PayReq;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zuxiao2.zuxiao2.MainActivity;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.WXPayBean;
import com.zuxiao2.zuxiao2.contract.IAddDingDanContract;
import com.zuxiao2.zuxiao2.presenter.AddDingDanPresenter;
import com.zuxiao2.zuxiao2.utils.SpUtils;
import com.zuxiao2.zuxiao2.utils.WXPayUtils;


import java.io.IOException;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

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
        // 合并代码
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
                //下单
                String str = "{ \"addressId\": 17, \"day\":7, \"postageType\": 1, \"remark\": \"快点发货哈\", \"activityId\":-1, \"skus\": [ { \"insuranceId\": \"14\", \"num\": 1, \"skuId\": 34 } ] }";
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/json"), str);
                HashMap<String, String> header = new HashMap<>();
                header.put("user_login",SpUtils.getUserKey(this));
                header.put("uuid",SpUtils.getUserId());
                presenter.getMerChantentryBean(header,fileBody);
                break;
        }
    }

    private IWXAPI iwxapi; //微信支付api
    @Override
    public void showMerChantentryBean(MerChantentryBean merChantentryBean) {
        Toast.makeText(this, merChantentryBean.toString(), Toast.LENGTH_SHORT).show();
        if (merChantentryBean.getCode().equals("0")){
            HashMap<String, String> headers = new HashMap<>();
            headers.put("user_login",SpUtils.getUserKey(this));
            headers.put("uuid",SpUtils.getUserId());
            headers.put("User-Agent","Android");
            headers.put("app-version","android-zx2-1.0");
            HashMap<String, String> params = new HashMap<>();
            params.put("id",merChantentryBean.getData());
            params.put("payType","WX");
            presenter.getWXPayBean(headers,params);
        }

    }

    @Override
    public void showWXPayBean(WXPayBean wxPayBean) {

       final WXPayBean.DataBeanX.DataBean data = wxPayBean.getData().getData();
        iwxapi = WXAPIFactory.createWXAPI(this, data.getAppid(),false); //初始化微信api
        iwxapi.registerApp(data.getAppid());
        WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
   /*     builder.setAppId(data.getAppid())
                .setPartnerId(data.getPartnerid())
                .setPrepayId(data.getPrepayid())
                .setPackageValue(data.getPackageX())
                .setNonceStr(data.getNoncestr())
                .setTimeStamp(data.getTimestamp())
                .setSign(data.getSign())
                .build().toWXPayNotSign(Activity_AddDZ.this);*/
       // WXPayUtils.WXPayBuilder builder = new WXPayUtils.WXPayBuilder();
        builder.setAppId(data.getAppid())
                .setPartnerId(data.getPartnerid())
                .setPrepayId(data.getPrepayid())
                .setPackageValue("Sign=WXPay")
                .setNonceStr(data.getNoncestr())
                .setTimeStamp(data.getTimestamp())
                .build()
                .toWXPayAndSign(Activity_AddDZ.this,data.getAppid(),"d7e5dafef5b94a96867e8b21f685c391");

    }


}
