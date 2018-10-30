package com.zuxiao2.zuxiao2.login;


import android.content.Intent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.CodeBean;
import com.zuxiao2.zuxiao2.bean.Frogetpass;
import com.zuxiao2.zuxiao2.bean.LoginCodeBean;
import com.zuxiao2.zuxiao2.bean.Password;
import com.zuxiao2.zuxiao2.contract.ILoginContract;
import com.zuxiao2.zuxiao2.presenter.LoginPresenter;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.HashMap;
import java.util.Map;


public class RegisterActivity extends BaseActivity<LoginPresenter> implements ILoginContract.View, View.OnClickListener {


    private EditText ed_phone;
    private EditText ed_code;
    private EditText ed_pass;
    private Button bt_getcode;
    private ImageView im_pass_iv;
    private Button bt_immediately_regist;
    private String phone;
    private String code;
    private String pass;
    private String codes;

    //Title
    @Override
    protected void initTitle() {
        TextView register_title = findViewById(R.id.register_title);
        register_title.setText(R.string.app_regist);
        TextView title_right = findViewById(R.id.title_right);
        ImageView im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_register;
    }

    @Override
    protected void initView() {
        //手机号
        ed_phone = findViewById(R.id.ed_phone);
        phone = ed_phone.getText().toString();
        //验证码
        ed_code = findViewById(R.id.ed_code);
        codes = ed_code.getText().toString();
        // 密码
        ed_pass = findViewById(R.id.ed_pass);
        pass = ed_pass.getText().toString();
        //获取验证码
        bt_getcode = findViewById(R.id.bt_getcode);
        bt_getcode.setOnClickListener(this);
        //查看密码
        im_pass_iv = findViewById(R.id.im_pass_iv);
        // 立即注册
        bt_immediately_regist = findViewById(R.id.bt_immediately_regist);
        bt_immediately_regist.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    //点击事件
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_getcode:
                //获取验证码
                getCode();

                break;
            case R.id.bt_immediately_regist:
                getLongin();
                break;
        }
    }

    private void getLongin() {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        map.put("pwd", pass);
        map.put("code", codes);
        map.put("nickname", "高高");
        map.put("cityId", 1 + "");
        presenter.getRegister(map);
//        if (!phone.isEmpty()&& !pass.isEmpty()){
//            if (ed_code+"" == code+""){
//                SharedPreferencesUtils.setParam(this,phone,pass);
//                Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
//                Intent intent = new Intent(this, LoginActivity.class);
//                startActivity(intent);
//            }
//        }
    }

    //请求验证码
    private void getCode() {
        Map<String, String> map = new HashMap<>();
        map.put("mobile", phone);
        presenter.getCodeBean(map);

    }

    @Override
    public void showCodeBean(CodeBean codeBean) {
        code = codeBean.getCode();
        if (code == "ok") {
            Toast.makeText(this, "获取验证码成功！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoginBean(LoginCodeBean loginCodeBean) {

    }

    @Override
    public void showPegisterBean(Password password) {
        //注册会来的数据
        if (phone.length() == 11 && pass.length() > 6) {
            if (codes == code) {
                Toast.makeText(this, "注册成功！", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(this, PassWordLoginActivity.class);
                startActivity(intent);
            }
        }
    }

    @Override
    public void showCzPwdBean(Frogetpass frogetpass) {

    }
}
