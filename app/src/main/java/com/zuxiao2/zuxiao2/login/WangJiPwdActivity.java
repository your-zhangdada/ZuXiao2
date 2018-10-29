package com.zuxiao2.zuxiao2.login;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
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

// 重置密码
public class WangJiPwdActivity extends BaseActivity<LoginPresenter> implements ILoginContract.View, View.OnClickListener {

    private String phone;
    private String code;
    private String pass;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_wang_ji_pwd;
    }

    @Override
    protected void initView() {
      EditText ed_phone = findViewById(R.id.ed_phone);
        phone = ed_phone.getText().toString();
        EditText ed_code = findViewById(R.id.ed_code);
        code = ed_code.getText().toString();
        EditText ed_pass = findViewById(R.id.ed_pass);
        pass = ed_pass.getText().toString();
        Button bt_getcode = findViewById(R.id.bt_getcode);
        bt_getcode.setOnClickListener(this);
        Button  bt_immediately_reset = findViewById(R.id.bt_immediately_reset);
        bt_immediately_reset.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_getcode:
                //获取验证码
                getCode();
                break;
            case R.id.bt_immediately_reset:
                // 重置密码
                getCZPwass();
                break;
        }
    }

    private void getCZPwass() {
        HashMap<String, String> map = new HashMap<>();
        map.put("mobile",phone);
        map.put("pwd",pass);
        map.put("code",code);
        presenter.getCZPwd(map);
    }

    private void getCode() {
        Map<String,String> map = new HashMap<>();
        map.put("mobile",phone);
        presenter.getCodeBean(map);
    }

    @Override
    public void showCodeBean(CodeBean codeBean) {
        if (codeBean.getMsg().equals("ok")){
            Toast.makeText(this, "获取验证码成功！", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showLoginBean(LoginCodeBean loginCodeBean) {

    }

    @Override
    public void showPegisterBean(Password password) {

    }

    @Override
    public void showCzPwdBean(Frogetpass frogetpass) {
        //修改密码返回的数据

    }
}
