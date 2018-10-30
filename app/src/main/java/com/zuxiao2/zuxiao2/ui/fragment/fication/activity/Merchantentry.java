package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.HomeBean;
import com.zuxiao2.zuxiao2.contract.MerContart;
import com.zuxiao2.zuxiao2.presenter.MyMerchPresenter;

import java.util.HashMap;
import java.util.Map;

public class Merchantentry extends BaseActivity<MyMerchPresenter> implements MerContart.View, View.OnClickListener {
    public static final int TAKE_PHOTO = 111;
    private TextView tv_xieyi;
    private EditText tv_company_name, tv_staff_Number, tv_shibie_Number, tv_management, tv_name, tv_id_number;
    private ImageView im_shengfenzhengoen, im_shengfenzhengtwo, im_addphotooen, im_addphototwo, im_yingyezao1, im_yingyezao2, im_yingyezao3;
    Button btn_sc;

    private Bitmap bitmap;
    private String bitmaoStr;
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_merchantentry;
    }

    @Override
    protected void initView() {
//公司名称
        tv_company_name = findViewById(R.id.tv_company_name);
//员工人数
        tv_staff_Number = findViewById(R.id.tv_staff_Number);
//纳税人识别码
        tv_shibie_Number = findViewById(R.id.tv_shibie_Number);
//经营范围
        tv_management = findViewById(R.id.tv_management);
//法人姓名
        tv_name = findViewById(R.id.tv_name);
//省份证号
        tv_id_number = findViewById(R.id.tv_id_number);

//正面省份证照片 拍照
        im_shengfenzhengoen = findViewById(R.id.im_shengfenzhengoen);
        im_shengfenzhengoen.setOnClickListener(this);
//反面省份证照片 拍照
        im_shengfenzhengtwo = findViewById(R.id.im_shengfenzhengtwo);
        im_shengfenzhengtwo.setOnClickListener(this);
//上传手持省份证 拍照
        im_addphotooen = findViewById(R.id.im_addphotooen);
        im_addphotooen.setOnClickListener(this);
        im_addphototwo = findViewById(R.id.im_addphototwo);
//上传营业执照  相册与拍照
        im_yingyezao1 = findViewById(R.id.im_yingyezao1);
        im_yingyezao2 = findViewById(R.id.im_yingyezao2);
        im_yingyezao3 = findViewById(R.id.im_yingyezao3);
        im_yingyezao3.setOnClickListener(this);
//查看协议
        tv_xieyi = findViewById(R.id.tv_xieyi);
        tv_xieyi.setOnClickListener(this);
//上传
        btn_sc = findViewById(R.id.btn_sc);
        btn_sc.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_shengfenzhengoen://正面省份证照片 拍照

                getPicFromCamera();//调用相机
                im_shengfenzhengoen.setImageBitmap(bitmap);
                break;
            case R.id.im_shengfenzhengtwo://反面省份证照片 拍照
                getPicFromCamera();//调用相机
                im_shengfenzhengtwo.setImageBitmap(bitmap);
                break;
            case R.id.im_addphotooen://上传手持省份证 拍照
                getPicFromCamera();
                im_addphototwo.setImageBitmap(bitmap);
                break;
            case R.id.im_yingyezao3: //上传营业执照  相册与拍照
                getPicFromCamera();
                im_yingyezao1.setImageBitmap(bitmap);
                im_yingyezao2.setImageBitmap(bitmap);
                break;
            case R.id.tv_xieyi://查看协议
                break;
            case R.id.btn_sc:  //上传
                //上传
                 initPostUrl();
                break;
        }
    }
    private void initPostUrl() {
        String url = "http://image.baidu.com/search/detail?ct=503316480&z=0&ipn=d&word=%E5%9B%BE%E7%89%87&hs=0&pn=0&spn=0&di=97226742140&pi=0&rn=1&tn=baiduimagedetail&is=0%2C0&ie=utf-8&oe=utf-8&cl=2&lm=-1&cs=2200166214%2C500725521&os=4285910673%2C81688594&simid=0%2C0&adpicid=0&lpn=0&ln=30&fr=ala&fm=&sme=&cg=&bdtype=0&oriquery=&objurl=http%3A%2F%2Fpic14.nipic.com%2F20110605%2F1369025_165540642000_2.jpg&fromurl=ippr_z2C%24qAzdH3FAzdH3Fooo_z%26e3Bgtrtv_z%26e3Bv54AzdH3Ffi5oAzdH3F8AzdH3F0AzdH3F9m00da9hl9nnjmm8_z%26e3Bip4s&gsm=0&islist=&querylist=";
        String name = tv_company_name.getText().toString();
        String number = tv_staff_Number.getText().toString();
        String s = tv_shibie_Number.getText().toString();
        String tv_manag = tv_management.getText().toString();
        String s1 = tv_name.getText().toString();
        String s2 = tv_id_number.getText().toString();
        Map<String, String> map = new HashMap<>();
        map.put("name", name);
        map.put("workersNumber", number );
        map.put("taxNumber", s);
        map.put("legalPerson", s1);
        map.put("legalPersonIdNo", s2);
        map.put("idCardFront", url);
        map.put("idCardBehind", url);
        map.put("idCardHandFront", url);
        map.put("idCardHandBehind", url);
        map.put("licenseUrl", url);
        map.put("licenseUrlRepeat", url);
        map.put("businessScope", "beijing");

        presenter.getMerchBean(map);

    }
    @Override
    public void showMerchBean(HomeBean homeBean) {
        //商家入住回来数据
    }
    private void getPicFromCamera() {
        //1.调用系统相机,拍照
        Intent captureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(captureIntent, TAKE_PHOTO);

    }
}
