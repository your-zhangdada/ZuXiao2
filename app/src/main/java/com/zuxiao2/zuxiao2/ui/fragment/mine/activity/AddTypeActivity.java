package com.zuxiao2.zuxiao2.ui.fragment.mine.activity;

import android.content.Intent;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.CodeBean;
import com.zuxiao2.zuxiao2.contract.AddBankContract;
import com.zuxiao2.zuxiao2.model.LoginService;
import com.zuxiao2.zuxiao2.presenter.AddBankPrerenter;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;
import com.zuxiao2.zuxiao2.utils.SpUtils;
import com.zuxiao2.zuxiao2.view.BankInfo;

import java.util.HashMap;
import java.util.Map;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

//添加银行卡类型  添加成功
public class AddTypeActivity extends BaseActivity<AddBankPrerenter> implements AddBankContract.View, View.OnClickListener {

    private String yuliuphone;
    private EditText ed_phone_yuliu;
    private EditText ed_code;
    private Button bt_getcode;
    private TextView tv_bankleixing;
    private CheckBox cb_box;
    private TextView tv_xieyi;
    private String name;
    private String nuber;
    private String yuliu;
    private String code;
    private EditText ed_bankname;
    private EditText ed_banknuber;
    private Button btn_xiayibu1;
    private LinearLayout linera1;
    private LinearLayout linera2;
    private ImageView im_backs;
    private ImageView im_back;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_add_type;
    }

    @Override
    protected void initView() {
        String userPhoto = SpUtils.getUserPhoto();//获取预留手机号
        linera1 = findViewById(R.id.linera1);
        linera2 = findViewById(R.id.linera2);


        //银行卡类型
        tv_bankleixing = findViewById(R.id.tv_bankleixing);
           //11111
        btn_xiayibu1 = findViewById(R.id.btn_xiayibu1);
        btn_xiayibu1.setOnClickListener(this);
        ed_bankname = findViewById(R.id.ed_bankname);
        ed_banknuber = findViewById(R.id.ed_banknuber);
        ed_banknuber.addTextChangedListener(new TextWatcher() {

            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                int length = ed_banknuber.getText().toString().length();
                if (length >= 6){
                    String huoqucc = ed_banknuber.getText().toString();
                    char[] cardNumber = huoqucc.toCharArray();
                    // 获取银行卡的信息
                    name = BankInfo.getNameOfBank(cardNumber, 0);

                }else {
                    tv_bankleixing.setText(null);
                }

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        ////22222222222
        //银行卡类型
        tv_bankleixing = findViewById(R.id.tv_bankleixing);
        // 预留手机号
        ed_phone_yuliu = findViewById(R.id.ed_phone_yuliu);
        ed_phone_yuliu.setText(userPhoto);
        //验证码
        ed_code = findViewById(R.id.ed_code);
        //获取验证码
        bt_getcode = findViewById(R.id.bt_getcode);
        bt_getcode.setOnClickListener(this);
        //选中框
        cb_box = findViewById(R.id.cb_box);
        //协议
        tv_xieyi = findViewById(R.id.tv_xieyi);
        tv_xieyi.setOnClickListener(this);
        Button btn_xiayibu = findViewById(R.id.btn_xiayibu);//下一步
        btn_xiayibu.setOnClickListener(this);
        im_backs = findViewById(R.id.im_backs);
        im_backs.setOnClickListener(this);
        im_back = findViewById(R.id.im_back);
        im_back.setOnClickListener(this);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void showAddBank(CodeBean codeBean) {
            if (codeBean.getMsg().equals("ok")){
                finish();
            }else {
                Toast.makeText(this, "请重新添加", Toast.LENGTH_SHORT).show();
            }
    }
    private String s;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_backs:
                finish();
                break;
            case R.id.im_back:
                finish();
                break;
            case R.id.tv_xieyi:
                //协议
           startActivity(new Intent(this,BankXieYiActivity.class));
                break;
            case R.id.bt_getcode:
                String yuliuphone = ed_phone_yuliu.getText().toString();
                Map<String,String> map = new HashMap<>();
                map.put("mobile",yuliuphone);
                LoginService loginService = RetrofitUtils.getInstance().getLoginService();
                loginService.getCodeBean(map)
                        .subscribeOn(Schedulers.newThread())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(new Observer<CodeBean>() {



                            @Override
                            public void onSubscribe(Disposable d) {

                            }

                            @Override
                            public void onNext(CodeBean codeBean) {
                                String s = codeBean.toString();
                                if (codeBean.getCode().equals("ok")){
                                    AddTypeActivity.this.s = codeBean.getData().toString();
                                    ed_code.setText(AddTypeActivity.this.s +"");
                                }


                            }

                            @Override
                            public void onError(Throwable e) {

                            }

                            @Override
                            public void onComplete() {

                            }
                        });

                break;
            case R.id.btn_xiayibu:
                String bankleixing = tv_bankleixing.getText().toString();
                yuliu = ed_phone_yuliu.getText().toString();
                code = ed_code.getText().toString();
                if (bankleixing.isEmpty()){
                    Toast.makeText(this, "银行卡不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (yuliu.isEmpty()){
                    Toast.makeText(this, "手机号不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (code.isEmpty()){
                    Toast.makeText(this, "验证码不能为空", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (s == code){ //如果验证码 相等
                    if (cb_box.isChecked()){ // 选着框被选中
                        //请求
                        Map<String,String> maps = new HashMap<>();
                        maps.put("mobile",yuliu);//手机号
                        maps.put("code",code);//手机验证码
                        maps.put("cardNumber",nuber+"");//银行卡号
                        maps.put("cardMaster",name);//持卡人姓名
                        presenter.getAddBanks(maps);
                    }
                }
                break;
            case R.id.btn_xiayibu1:
                linera1.setVisibility(View.GONE);
                linera2.setVisibility(View.VISIBLE);
                tv_bankleixing.setText(name);
                break;
        }
    }
}
