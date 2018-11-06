package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;

/**
 *   TODO 添加银行卡
 */
public class AddBankActivity extends BaseActivity implements View.OnClickListener {
    private Button btn_xiayibu;
    private EditText ed_bankname;
    private EditText ed_banknuber;

    @Override
    protected void initTitle() {
    }
    @Override
    protected int getContentView() {
        return R.layout.activity_add_bank;
    }
    @Override
    protected void initView() {
        //绑定银行卡
        btn_xiayibu = findViewById(R.id.btn_xiayibu);
        btn_xiayibu.setOnClickListener(this);
        ed_bankname = findViewById(R.id.ed_bankname);
        ed_banknuber = findViewById(R.id.ed_banknuber);
    }
    @Override
    protected void initData() {

    }
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_xiayibu:
                String bankname = ed_bankname.getText().toString();
                String banknuber = ed_banknuber.getText().toString();
                Intent intent = new Intent(this, AddTypeActivity.class);
                intent.putExtra("name",bankname);
                intent.putExtra("nuber",banknuber+"");
                startActivity(intent);
                break;
        }
    }

}
