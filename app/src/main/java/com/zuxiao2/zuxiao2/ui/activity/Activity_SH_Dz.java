package com.zuxiao2.zuxiao2.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.lljjcoder.citypickerview.widget.CityPicker;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.AddressBean;
import com.zuxiao2.zuxiao2.bean.SHDZ_Bean;
import com.zuxiao2.zuxiao2.contract.AddressContract;
import com.zuxiao2.zuxiao2.presenter.AddressPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Activity_SH_Dz extends BaseActivity<AddressPresenter> implements AddressContract.View,View.OnClickListener {

    private LinearLayout lin_back;
    private EditText et_sh_name;
    private EditText et_phone;
    private EditText et_xh_address;
    private Button btn_sanchu_dz;
    private String name;
    private String phone;
    private String address;
    private TextView tv_xz_dz;
    private List<AddressBean.DataBean.ChildrenBeanX> children;
    private List<AddressBean.DataBean.ChildrenBeanX.ChildrenBean> children1;

    //省
    List<String> mLabel1 = new ArrayList<>();
    List<String> mLabel2 = new ArrayList<>();
    List<String> mLabel3 = new ArrayList<>();
    private TextView tV_add;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_add_dz;
    }
private  int swihch;
    @Override
    protected void initView() {
        Intent intent = getIntent();
        SHDZ_Bean.DataBean data = (SHDZ_Bean.DataBean) intent.getSerializableExtra("data");
        lin_back = findViewById(R.id.lin_back);
        lin_back.setOnClickListener(this);
        //收货人
//        et_sh_name = findViewById(R.id.et_sh_name);
////        et_sh_name.setText(data.getLinkPerson());
//        //手机号
//        et_phone = findViewById(R.id.et_phone);
//     //   et_phone.setText(data.getLinkPhone());
//        //详细地址
//        et_xh_address = findViewById(R.id.et_xh_address);
    //    et_xh_address.setText(data.getDetailAddress());
        tv_xz_dz = findViewById(R.id.tv_xz_dz);
        tv_xz_dz.setOnClickListener(this);
        Switch sw_mr_address = findViewById(R.id.sw_mr_address);
        sw_mr_address.setOnClickListener(this);
        btn_sanchu_dz = findViewById(R.id.btn_sanchu_dz);
        btn_sanchu_dz.setOnClickListener(this);
        sw_mr_address.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    if (isChecked){
                        swihch = 0;  //是否默认，0否，1是
                   //     Toast.makeText(Activity_SH_Dz.this, swihch, Toast.LENGTH_SHORT).show();
                    }else {
                        swihch = 1; //是否默认，0否，1是
                     //   Toast.makeText(Activity_SH_Dz.this, swihch, Toast.LENGTH_SHORT).show();
                    }
            }
        });
    }

    @Override
    protected void initData() {

        presenter.getAddressBean();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_back:
                finish();
                break;
            case R.id.tv_xz_dz:
                //弹出 三级联动 地址
                addressDz();
                break;
            case R.id.sw_mr_address:
                // 开关

                break;
            case R.id.btn_sanchu_dz:
                if (btn_sanchu_dz.getText().toString().equals("删除地址")){
                    // 删除地址
                    et_sh_name.setText("");
                    et_phone.setText("");
                    et_xh_address.setText("");
                    btn_sanchu_dz.setText("添加地址");
                }
                if (btn_sanchu_dz.getText().toString().equals("添加地址")){
                    name = et_sh_name.getText().toString();
                    phone = et_phone.getText().toString();
                    address = et_xh_address.getText().toString();
                    //添加收货地址
                    addAddressPost(name,phone,address);
                }
                break;
        }
    }

    private void addressDz() {

        CityPicker build = new CityPicker.Builder(this)
                .province("北京市")
                .city("北京市")
                .district("海淀区")
                .build();

        build .show();
        build.setOnCityItemClickListener(new CityPicker.OnCityItemClickListener() {
            @Override
            public void onSelected(String... citySelected) {
                String s1 = citySelected[0];
                String s2 = citySelected[1];
                String s3 = citySelected[2];
                tv_xz_dz.setText(s1.trim()+"--"+s2.trim()+"--"+s3.trim());
            }
        });
    }
    @Override
    public void showAddress(AddressBean addressBean) {

        List<AddressBean.DataBean> data = addressBean.getData();
        for (int i = 0; i < data.size(); i++) {
            mLabel1.add(data.get(i).getLabel());
            children = data.get(i).getChildren();
        }
        for (int i = 0; i < children.size(); i++) {
            mLabel2.add(children.get(i).getLabel());
            children1 = this.children.get(i).getChildren();
        }
        for (int i = 0; i < children1.size(); i++) {
            mLabel3.add(children1.get(i).getLabel());
        }
    }
    private void addAddressPost(String name, String phone, String address) {
        Map<String,String> map = new HashMap<>();
        map.put("linkPhone",phone);//联系电话
        map.put("linkPerson",name);//联系人
        map.put("hasDefault",swihch+"");//是否默认，0否，1是
        map.put("detailAddress",address);//详细地址
//        map.put("provinceId",);//省份ID
//        map.put("cityId");//城市ID
//        map.put("countyId");//区县ID
//        map.put("countyName");//省份
//        map.put("cityName");//城市
//        map.put("provinceName");//区县

    }



}
