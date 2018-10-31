package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 * 学生认证
 */
public class StudentActivity extends BaseActivity implements View.OnClickListener {
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
                break;
        }
    }
}
