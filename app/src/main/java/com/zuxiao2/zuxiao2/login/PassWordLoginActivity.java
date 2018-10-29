package com.zuxiao2.zuxiao2.login;

import android.content.Intent;
import android.graphics.Paint;
import android.text.InputType;
import android.text.TextUtils;
import android.text.method.HideReturnsTransformationMethod;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.MainActivity;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.PassLoginBean;
import com.zuxiao2.zuxiao2.contract.IPassLoginContract;
import com.zuxiao2.zuxiao2.presenter.PassLoginPresenter;
import com.zuxiao2.zuxiao2.utils.SpUtils;


public class PassWordLoginActivity extends BaseActivity<PassLoginPresenter> implements View.OnClickListener,IPassLoginContract.View {

    private ImageView back;
    private TextView register;
    private EditText phone;
    private ImageView close;
    private EditText password;
    private CheckBox checkeye;
    private TextView wangjipwd;
    private Button login;
    private TextView codeLogin;
    private ImageView wachatlogin;
    private TextView service;

    @Override
    protected void initTitle() {
        //title
    }

    @Override
    protected int getContentView() {
        return R.layout.activity_pass_word_login;
    }

    @Override
    protected void initView() {
        back = findViewById(R.id.passlogin_back);
        back.setOnClickListener(this);
        register = findViewById(R.id.passlogin_register);
        register.setOnClickListener(this);
        phone = findViewById(R.id.ed_passlogin_phone);
        close = findViewById(R.id.passlogin_close);
        close.setOnClickListener(this);
        password = findViewById(R.id.ed_passlogin_password);
        checkeye = findViewById(R.id.passlogin_checkeye);
        wangjipwd = findViewById(R.id.passlogin_wangjipwd);
        wangjipwd.setOnClickListener(this);
        login = findViewById(R.id.passlogin_login);
        login.setOnClickListener(this);
        codeLogin = findViewById(R.id.passlogin_codelogin);
        codeLogin.setOnClickListener(this);
        wachatlogin = findViewById(R.id.passlogin_wachatlogin);
        wachatlogin.setOnClickListener(this);
        service = findViewById(R.id.passlogin_service);
    }

    @Override
    protected void initData() {
        String phones = phone.getText().toString().trim();
        if (phones.length() ==11){
            close.setVisibility(View.VISIBLE);
        }
        if (phones.length()==0 ){
            close.setVisibility(View.GONE);
        }
        checkeye.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
                if (b){
                    password.setTransformationMethod(HideReturnsTransformationMethod
                            .getInstance());
                }else {
                    password.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD | InputType.TYPE_CLASS_TEXT );
                }
            }
        });
        service.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.passlogin_back:
                this.finish();
                break;
            case R.id.passlogin_register:
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.passlogin_wangjipwd:
                startActivity(new Intent(this,WangJiPwdActivity.class));
                this.finish();
                break;
                //立即登录
            case R.id.passlogin_login:
                String ph = phone.getText().toString().trim();
                String pwd = password.getText().toString().trim();
                if (TextUtils.isEmpty(ph)||ph.length() < 1){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                String regex = "^((13[0-9])|(15[0-3, 5-9])|(18[0,2,3,5-9])|(17[0-8])|(147))\\d{8}$";
                if (!ph.matches(regex)){
                    Toast.makeText(this, "手机号格式不正确", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (ph.length() ==11){
                    close.setVisibility(View.VISIBLE);
                }
                if (TextUtils.isEmpty(pwd)||pwd.length() < 1){
                    Toast.makeText(this, "密码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getPassLoginBean(ph,pwd);

                break;
            case R.id.passlogin_codelogin:
                startActivity(new Intent(this,LoginActivity.class));
                this.finish();
                break;
                //三方微信登录
            case R.id.passlogin_wachatlogin:
                break;
            case R.id.passlogin_close:
                phone.setText("");
                break;

        }
    }

    @Override
    public void showPassLoginBean(PassLoginBean passLoginBean) {
        Toast.makeText(this, passLoginBean.getMsg(), Toast.LENGTH_SHORT).show();
        if (passLoginBean.getMsg().equals("ok")){
            String s = phone.getText().toString();
            String s1 = password.getText().toString();
            String userName = SpUtils.getUserName();
            String userPhone = SpUtils.getUserPhone();
            if (s==userName&&s1==userPhone){
                Intent intent = new Intent(PassWordLoginActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
                this.finish();
            }
        }
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}
