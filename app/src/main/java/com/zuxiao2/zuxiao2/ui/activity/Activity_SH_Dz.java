package com.zuxiao2.zuxiao2.ui.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Switch;
import android.widget.TextView;

import com.bigkoo.pickerview.OptionsPickerView;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.AddressBean;
import com.zuxiao2.zuxiao2.bean.CitysBean;
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
    private List<AddressBean.DataBean.ChildrenBeanX> children;
    private List<AddressBean.DataBean.ChildrenBeanX.ChildrenBean> children1;

    //  省份
    ArrayList<String> provinceBeanList = new ArrayList<>();
    ArrayList<CitysBean> provinceBeanList1 = new ArrayList<>();
    //  城市
    ArrayList<String> cities;
    ArrayList<List<String>> cityList = new ArrayList<>();
    ArrayList<CitysBean> cities1;
    ArrayList<List<CitysBean>> cityList1 = new ArrayList<>();
    //  区/县
    ArrayList<String> district;
    ArrayList<List<String>> districts;
    ArrayList<List<List<String>>> districtList = new ArrayList<>();
    ArrayList<CitysBean> district1;
    ArrayList<List<CitysBean>> districts1;
    ArrayList<List<List<CitysBean>>> districtList1 = new ArrayList<>();
    private RelativeLayout add_dizhi;
    private OptionsPickerView pvOptions;
    private TextView tv_sanji_address;
    private Map<String, String> map;

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
        Switch sw_mr_address = findViewById(R.id.sw_mr_address);
        sw_mr_address.setOnClickListener(this);
        btn_sanchu_dz = findViewById(R.id.btn_sanchu_dz);
        btn_sanchu_dz.setOnClickListener(this);
        add_dizhi = findViewById(R.id.add_dizhi_rela);
        add_dizhi.setOnClickListener(this);
        tv_sanji_address = findViewById(R.id.tv_xz_dz);
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
        map = new HashMap<>();
        map.put("linkPhone",phone);//联系电话
        map.put("linkPerson",name);//联系人
        map.put("hasDefault",swihch+"");//是否默认，0否，1是
        map.put("detailAddress",address);//详细地址
        presenter.getAddressBean();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.lin_back:
                finish();
                break;
            case R.id.add_dizhi_rela:
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
        pvOptions = new OptionsPickerView(this);
        pvOptions.setPicker(provinceBeanList, cityList, districtList, true);
        //  设置是否循环滚动
        pvOptions.setCyclic(false, false, false);
        // 设置默认选中的三级项目
        pvOptions.setSelectOptions(0, 0, 0);
        //  监听确定选择按钮
        pvOptions.setOnoptionsSelectListener(new OptionsPickerView.OnOptionsSelectListener() {
            @Override
            public void onOptionsSelect(int options1, int option2, int options3) {
                //返回的分别是三个级别的选中位置
                String city = provinceBeanList.get(options1);
                String address;
                //  如果是直辖市或者特别行政区只设置市和区/县
                if ("北京市".equals(city) || "上海市".equals(city) || "天津市".equals(city) || "重庆市".equals(city) || "澳门".equals(city) || "香港".equals(city)) {
                    address = provinceBeanList.get(options1)
                            + " " + districtList.get(options1).get(option2).get(options3);
                    map.put("provinceId","");//省份ID
                    map.put("cityId",provinceBeanList1.get(options1).getValue());//城市ID
                    map.put("countyId",districtList1.get(options1).get(option2).get(options3).getValue());//区县ID
                    map.put("countyName","");//省份
                    map.put("cityName",provinceBeanList.get(options1));//城市
                    map.put("provinceName",districtList.get(options1).get(option2).get(options3));//区县
                } else {
                    address = provinceBeanList.get(options1)
                            + " " + cityList.get(options1).get(option2)
                            + " " + districtList.get(options1).get(option2).get(options3);
                    map.put("provinceId",provinceBeanList1.get(options1).getValue());//省份ID
                    map.put("cityId",cityList1.get(options1).get(option2).getValue());//城市ID
                    map.put("countyId",districtList1.get(options1).get(option2).get(options3).getValue());//区县ID
                    map.put("countyName",provinceBeanList.get(options1));//省份
                    map.put("cityName",cityList.get(options1).get(option2));//城市
                    map.put("provinceName",districtList.get(options1).get(option2).get(options3));//区县
                }
                tv_sanji_address.setText(address);
            }
        });
        pvOptions.show();
    }
    @Override
    public void showAddress(AddressBean addressBean) {

        List<AddressBean.DataBean> data = addressBean.getData();
        for (int i = 0; i < data.size(); i++) {
            provinceBeanList.add(data.get(i).getLabel());
            provinceBeanList1.add(new CitysBean(data.get(i).getLabel(),data.get(i).getValue()));
            List<AddressBean.DataBean.ChildrenBeanX> children = data.get(i).getChildren();
            cities = new ArrayList<>();//   声明存放城市的集合
            cities1 = new ArrayList<>();
            districts = new ArrayList<>();//声明存放区县集合的集合
            districts1 = new ArrayList<>();
            for (int i1 = 0; i1 < children.size(); i1++) {
                String label = children.get(i1).getLabel();
                cities.add(label);
                cities1.add(new CitysBean(label,children.get(i1).getValue()));
                district = new ArrayList<>();// 声明存放区县的集合
                district1 = new ArrayList<>();
                List<AddressBean.DataBean.ChildrenBeanX.ChildrenBean> children2 = children.get(i1).getChildren();
                for (int j = 0; j < children2.size(); j++) {
                    String label1 = children2.get(j).getLabel();
                    district.add(label1);
                    district1.add(new CitysBean(label1,children2.get(j).getValue()));
                }
                districts.add(district);
                districts1.add(district1);
            }
            //  将存放区县集合的集合放入集合
            districtList.add(districts);
            districtList1.add(districts1);
            //  将存放城市的集合放入集合
            cityList.add(cities);
            cityList1.add(cities1);
        }
    }
    private void addAddressPost(String name, String phone, String address) {


    }



}
