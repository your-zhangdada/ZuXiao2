package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 * TODO 提现明细
 */
public class PutforwardActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_bankhao;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_putforward;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String yue = intent.getStringExtra("yue");

        LinearLayout im_back = findViewById(R.id.im_back);//返回
        im_back.setOnClickListener(this);
        //选着银行卡
        tv_bankhao = findViewById(R.id.tv_bankhao);
        tv_bankhao.setOnClickListener(this);
        TextView tv_many = findViewById(R.id.tv_many);//账户余额
        tv_many.setText(yue+"元");
        TextView tv_tixian = findViewById(R.id.tv_tixian);//全部提现
        tv_tixian.setOnClickListener(this);
        EditText ed_many = findViewById(R.id.ed_many);//输入提现金额
        Button btn_tixian = findViewById(R.id.btn_tixian);//提现
        btn_tixian.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        //请求
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_back://返回
                finish();
                break;
            case R.id.tv_bankhao://选着银行卡
                Intent intent = new Intent(this, MyBankCardActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.tv_tixian://全部提现
                break;
            case R.id.btn_tixian:
                break;
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Intent intent = getIntent();
        String cardNumber1 = intent.getStringExtra("cardNumber1");
        if (cardNumber1 ==null){
            return;
        }else {
            String str = cardNumber1.substring(cardNumber1.length()-4,cardNumber1.length());
            tv_bankhao.setText("**** **** **** *** "+str);
        }

    }
}
