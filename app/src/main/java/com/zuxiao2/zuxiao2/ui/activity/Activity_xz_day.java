package com.zuxiao2.zuxiao2.ui.activity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.text.InputType;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

public class Activity_xz_day extends BaseActivity implements View.OnClickListener {

    private TextView tv_five;
    private TextView tv_shiday;
    private TextView tv_shiwu_dao;
    private TextView tv_threeeday;
    private TextView tv_liuday;
    private TextView tv_shiba_day;
    private TextView tv_qita;
    private ImageView im_fisch;
    private Button btn_day;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_xz_day;
    }

    @Override
    protected void initView() {
        tv_five = findViewById(R.id.tv_five);
        tv_five.setOnClickListener(this);
        tv_shiday = findViewById(R.id.tv_shiday);
        tv_shiday.setOnClickListener(this);
        tv_shiwu_dao = findViewById(R.id.tv_shiwu_dao);
        tv_shiwu_dao.setOnClickListener(this);
        tv_threeeday = findViewById(R.id.tv_threeeday);
        tv_threeeday.setOnClickListener(this);
        tv_liuday = findViewById(R.id.tv_liuday);
        tv_liuday.setOnClickListener(this);
        tv_shiba_day = findViewById(R.id.tv_shiba_day);
        tv_shiba_day.setOnClickListener(this);
        tv_qita = findViewById(R.id.tv_qita);
        tv_qita.setOnClickListener(this);
        im_fisch = findViewById(R.id.im_fisch);
        im_fisch.setOnClickListener(this);
        btn_day = findViewById(R.id.btn_day);
        btn_day.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.tv_five:
                String s = tv_five.getText().toString();
                break;
            case R.id.tv_shiday:
                String s1 = tv_shiday.getText().toString();
                break;
            case R.id.tv_shiwu_dao:
                String s2 = tv_shiwu_dao.getText().toString();
                break;
            case R.id.tv_threeeday:
                String s3 = tv_threeeday.getText().toString();
                break;
            case R.id.tv_liuday:
                String s4 = tv_liuday.getText().toString();
                break;
            case R.id.tv_shiba_day:
                String s5 = tv_shiba_day.getText().toString();
                break;
            case R.id.tv_qita:
                final EditText editText = new EditText(this);
                editText.setInputType(InputType.TYPE_CLASS_NUMBER);
                AlertDialog.Builder  builder =  new AlertDialog.Builder(getApplicationContext());
                builder.setTitle("输入天数")
                        .setView(editText)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                                String s6 = editText.getText().toString();
                            }
                        }).setNegativeButton("取消", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }
                });
                builder.create();
                break;
            case R.id.im_fisch:
                finish();
                break;
            case R.id.btn_day:

                break;
        }
    }
}
