package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO  学历认证
 */
public class EducationActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private EditText tv_xueli_name, tv_xuejihao, tv_xueli_zy, tv_xueli_dz;
    private ImageView im_xueli;
    private Button bt_upload_immediately,tv_huitui;
    private String xueli_name,xuejihao;
    private String xueli_zy;
    private String xueli_dz;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_education;
    }

    @Override
    protected void initView() {
        tv_huitui = findViewById(R.id.tv_huitui);// 返回键
        tv_huitui.setOnClickListener(this);
        tv_xueli_name = findViewById(R.id.tv_xueli_name);//学校名称
        xueli_name = tv_xueli_name.getText().toString();
        tv_xuejihao = findViewById(R.id.tv_xuejihao);//学籍号码
        xuejihao = tv_xuejihao.getText().toString();
        tv_xueli_zy = findViewById(R.id.tv_xueli_zy);//学历 专业
        xueli_zy = tv_xueli_zy.getText().toString();
        tv_xueli_dz = findViewById(R.id.tv_xueli_dz);//学历地址
        xueli_dz = tv_xueli_dz.getText().toString();
        im_xueli = findViewById(R.id.im_xueli);// 毕业证书照
        im_xueli.setOnClickListener(this);
        bt_upload_immediately = findViewById(R.id.bt_upload_immediately);//提交认证
        bt_upload_immediately.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_huitui://返回
                finish();
                break;
            case R.id.im_xueli: //拍照 毕业证书照
                break;
            case R.id.bt_upload_immediately: // 立即上传
                getEduccationPost();
                break;
        }
    }

    private void getEduccationPost() {
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        // 传递数据
        Map<String,String> map = new HashMap<>();
        map.put("authType",2+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",6+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("schoolName",xueli_name);//学校名称
        map.put("schoolRoll",xuejihao);//学籍号码
        map.put("major",xueli_zy);//所学专业
        map.put("schoolRollAddress",xueli_dz);//学籍地址
        map.put("companyPatent",url);//毕业证书照
        presenter.getEducationApply(map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {
        //返回的参数
        Toast.makeText(this,applyBean.toString(), Toast.LENGTH_SHORT).show();
    }
}
