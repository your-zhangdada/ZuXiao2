package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ApplyBean;
import com.zuxiao2.zuxiao2.contract.ApplyContract;
import com.zuxiao2.zuxiao2.presenter.ApplyPresenter;

import java.util.HashMap;
import java.util.Map;

/**
 * 学生认证
 */
public class StudentActivity extends BaseActivity<ApplyPresenter> implements ApplyContract.View,View.OnClickListener {
    private EditText tv_school_name,tv_school_xuejihao,tv_school_zy,tv_school_dz;
    private ImageView im,student_im;
    private Button bt_upload_immediately;
    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_student;
    }

    @Override
    protected void initView() {
        tv_school_name = findViewById(R.id.tv_school_name);// 学校名称
        tv_school_xuejihao = findViewById(R.id.tv_school_xuejihao);//学籍号
        tv_school_zy = findViewById(R.id.tv_school_zy);// 所学专业
        tv_school_dz = findViewById(R.id.tv_school_dz);//学籍地址
        im = findViewById(R.id.im);// 学生证 正面
        im.setOnClickListener(this);
        student_im = findViewById(R.id.student_im);//学生证 反面
        student_im.setOnClickListener(this);
        bt_upload_immediately = findViewById(R.id.bt_upload_immediately);
        bt_upload_immediately.setOnClickListener(this);//立即上传
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im:// 学生证 正面
                break;
            case R.id.student_im://学生证 反面
                break;
            case R.id.bt_upload_immediately://立即上传
                // 如果上传成功 弹窗 提示用户
                getStudentApply();
                break;
        }
    }

    private void getStudentApply() {
        String url = "https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg";
        Map<String,String> map = new HashMap<>();
        map.put("authType",1+"");//认证大类型 1、学生认证，2、个人认证，3、企业认证
        map.put("authTypeLast",2+"");//认证小类型 1、身份证认证 2、学生证认证 3、运营商认证 4、芝麻信用 5、社保卡认证 6、学历认证 7、公司信息认证 8、固定资产认证、 9法人认证 10、营业执照认证 11、企业信息认证 12、委托人认证 13、委托书认证
        map.put("schoolName",url);//学校名称
        map.put("schoolRoll",url);//学籍号
        map.put("major",url);//所学专业
        map.put("schoolRollAddress",url);//学籍地址
        map.put("stuCardFront",url);//学生证 正面照
        map.put("stuCardBehind",url);//学生证反面照
        presenter.getApplyStu(map);
    }

    @Override
    public void showApplyBean(ApplyBean applyBean) {
        Log.e("学生证认证",applyBean.toString());
    }
}
