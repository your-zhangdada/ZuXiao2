package com.zuxiao2.zuxiao2.login;

import android.content.Intent;
import android.graphics.Paint;
import android.os.CountDownTimer;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.MainActivity;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.CodeBean;
import com.zuxiao2.zuxiao2.bean.Frogetpass;
import com.zuxiao2.zuxiao2.bean.LoginCodeBean;
import com.zuxiao2.zuxiao2.bean.Password;
import com.zuxiao2.zuxiao2.contract.ILoginContract;
import com.zuxiao2.zuxiao2.presenter.LoginPresenter;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends BaseActivity<LoginPresenter> implements View.OnClickListener,ILoginContract.View {

    private ImageView back;
    private TextView register;
    private Button getcode;
    private EditText code;
    private EditText phone;
    private TextView pwdlogin;
    private Button login;
    private ImageView wachatlogin;
    private TextView service;
    private ImageView close;
    private TimeCount time;
    private ImageView imph;
    private ImageView imcode;
    private TextView passlogin;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {

        return R.layout.activity_login;
    }

    @Override
    protected void initView() {

        back = findViewById(R.id.im_back);
        back.setOnClickListener(this);
        //注册
        register = findViewById(R.id.title_right);
        register.setOnClickListener(this);
        //手机号
        phone = findViewById(R.id.ed_phone);
        //验证码
        code = findViewById(R.id.ed_code);
        //获取验证码
        getcode = findViewById(R.id.bt_getcode);
        getcode.setOnClickListener(this);
        //密码登录
        pwdlogin = findViewById(R.id.tv_pass_login);
        pwdlogin.setOnClickListener(this);
        passlogin = findViewById(R.id.tv_password_login);
        passlogin.setOnClickListener(this);
        //立即登录
        login = findViewById(R.id.bt_immediately_login);
        login.setOnClickListener(this);
        //三方微信登录
        wachatlogin = findViewById(R.id.im_weixinlogin);
        //服务协议
        service = findViewById(R.id.tv_service);
        close = findViewById(R.id.close);
        close.setOnClickListener(this);
        time = new TimeCount(60000, 1000);
        imph = findViewById(R.id.im_ph);
        imcode = findViewById(R.id.im_code);
    }

    @Override
    protected void initData() {
        service.getPaint().setFlags(Paint.UNDERLINE_TEXT_FLAG);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.im_back:
                this.finish();
                break;
            case R.id.title_right:
                //跳转到注册界面
                Intent intent = new Intent(this, RegisterActivity.class);
                startActivity(intent);
                this.finish();
                break;
            case R.id.bt_getcode:
                String ph = phone.getText().toString().trim();
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
                    imph.setBackgroundResource(R.mipmap.phoneture);
                }
                Map<String,String> map = new HashMap<>();
                map.put("mobile",ph);
                presenter.getCodeBean(map);
                time.start();
                break;
            case R.id.close:
                phone.setText("");
                break;
            case R.id.bt_immediately_login:
               String phones = phone.getText().toString().trim();
               String yzm = code.getText().toString().trim();
                if (phones.isEmpty()) {
                    Toast.makeText(this, "手机号为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (phones.length() ==11){
                    close.setVisibility(View.VISIBLE);
                    imph.setBackgroundResource(R.mipmap.phoneture);
                }
               /* if (yzm.length() == 4){
                    imcode.setBackgroundResource(R.mipmap.yanzhengmature);
                }*/
                if (yzm.isEmpty()) {
                    Toast.makeText(this, "验证码为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                presenter.getLoginBean(phones,yzm);
                break;
            case R.id.tv_pass_login:
                startActivity(new Intent(LoginActivity.this,PassWordLoginActivity.class));
                this.finish();
                break;
            case R.id.tv_password_login:
                startActivity(new Intent(LoginActivity.this,PassWordLoginActivity.class));
                this.finish();
                break;
        }
    }

    @Override
    public void showCodeBean(CodeBean codeBean) {
        if (codeBean.getMsg().equals("ok")){
            Toast.makeText(this, "获取验证码成功", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoginBean(LoginCodeBean loginCodeBean) {
        Toast.makeText(this, loginCodeBean.toString(), Toast.LENGTH_SHORT).show();
        if (loginCodeBean.getMsg().equals("ok")){
            int userId = loginCodeBean.getData().getUserId();
            String id = String.valueOf(userId);
            String user_phone = loginCodeBean.getData().getPhoneNumber();
            String user_name = loginCodeBean.getData().getNickname();
//            SpUtils.setUserId(id);
//            SpUtils.setUserPhone(user_phone);
//            SpUtils.setUserName(user_name);
            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
            startActivity(intent);
            Toast.makeText(this, "登录成功", Toast.LENGTH_SHORT).show();
            this.finish();
        }
    }

    @Override
    public void showPegisterBean(Password password) {

    }

    @Override
    public void showCzPwdBean(Frogetpass frogetpass) {

    }

    public class TimeCount extends CountDownTimer {

        public TimeCount(long millisInFuture, long countDownInterval) {
            super(millisInFuture, countDownInterval);
        }

        @Override
        public void onTick(long millisUntilFinished) {
            getcode.setClickable(false);
            getcode.setText(+millisUntilFinished / 1000 + "s");
        }

        @Override
        public void onFinish() {
            getcode.setText("重新获取");
            getcode.setClickable(true);
        }
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
