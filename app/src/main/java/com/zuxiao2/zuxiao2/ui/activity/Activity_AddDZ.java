package com.zuxiao2.zuxiao2.ui.activity;

import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.tencent.mm.opensdk.openapi.IWXAPI;
import com.tencent.mm.opensdk.openapi.WXAPIFactory;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.CommodityBean;
import com.zuxiao2.zuxiao2.bean.MerChantentryBean;
import com.zuxiao2.zuxiao2.bean.WXPayBean;
import com.zuxiao2.zuxiao2.contract.IAddDingDanContract;
import com.zuxiao2.zuxiao2.presenter.AddDingDanPresenter;
import com.zuxiao2.zuxiao2.ui.adapter.EquipmentRecyclerViewAdapter;
import com.zuxiao2.zuxiao2.utils.SpUtils;
import com.zuxiao2.zuxiao2.utils.WXPayUtils;

import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;
 //确认订单
public class Activity_AddDZ extends BaseActivity<AddDingDanPresenter> implements View.OnClickListener,IAddDingDanContract.View {

     private TextView tv_s;
     private ImageView imgback;
     private ImageView photo;
     private TextView name;
     private TextView time;
     private TextView money;
     private CommodityBean.DataBean databena;
     private RecyclerView recyclerView;
     private TextView shopmethord;

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
        Intent intent = getIntent();
        databena = (CommodityBean.DataBean) intent.getSerializableExtra("databena");
        Button btn_zf = findViewById(R.id.btn_zf);
        btn_zf.setOnClickListener(this);
        tv_s = findViewById(R.id.tv_s);//添加收货地址
        tv_s.setOnClickListener(this);
        imgback = findViewById(R.id.equipment_imgback);
        imgback.setOnClickListener(this);
        photo = findViewById(R.id.equipment_shopphoto);
        name = findViewById(R.id.equipment_shopname);
        time = findViewById(R.id.equipment_shoptime);
        money = findViewById(R.id.equipment_shopmoney);
        recyclerView = findViewById(R.id.equipment_baoxianrecycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        shopmethord = findViewById(R.id.equipment_shopmethord);
    }

    @Override
    protected void initData() {
         if (databena !=null){
             Glide.with(Activity_AddDZ.this).load(databena.getPic()).into(photo);
             name.setText(databena.getName());
             time.setText("填用户选择的时间");
             money.setText("填用户传过来的价钱");
             List<CommodityBean.DataBean.InsuranceListBean> insuranceList = databena.getInsuranceList();
             EquipmentRecyclerViewAdapter equipmentRecyclerViewAdapter = new EquipmentRecyclerViewAdapter(this,insuranceList);
             recyclerView.setAdapter(equipmentRecyclerViewAdapter);
             if (databena.getPostageType() ==1 ){
                 shopmethord.setText("包邮");
             }else {
                 shopmethord.setText("不包邮");
             }
         }else {
             Toast.makeText(this, "数据错误", Toast.LENGTH_SHORT).show();
         }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_zf:
                //下单
                //addressId 城市id  day 租期   insuranceId 保险公司 id num 商品 数量  skuId 商品id
                String str = "{ \"addressId\": 17, \"day\":7, \"postageType\": 1, \"remark\": \"快点发货哈\", \"activityId\":-1, \"skus\": [ { \"insuranceId\": \"14\", \"num\": 1, \"skuId\": 34 } ] }";
                RequestBody fileBody = RequestBody.create(MediaType.parse("application/json"), str);
                HashMap<String, String> header = new HashMap<>();
                header.put("user_login",SpUtils.getUserKey(this));
                header.put("uuid",SpUtils.getUserId());
                presenter.getMerChantentryBean(header,fileBody);
                break;
            case R.id.tv_s:
                startActivity(new Intent(this,Activity_Add_DZ.class));
                break;

            case R.id.equipment_imgback:
                this.finish();
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
        }else {
            Toast.makeText(this,merChantentryBean.getMsg() , Toast.LENGTH_SHORT).show();
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
