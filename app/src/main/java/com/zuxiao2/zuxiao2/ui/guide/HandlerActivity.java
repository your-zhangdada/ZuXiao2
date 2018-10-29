package com.zuxiao2.zuxiao2.ui.guide;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.WindowManager;

import com.zuxiao2.zuxiao2.MainActivity;
import com.zuxiao2.zuxiao2.R;


public class HandlerActivity extends AppCompatActivity {
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //隐藏状态栏
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_handler);
        initView();
        handler.sendEmptyMessageDelayed(0, 3000);
    }

    private void initView() {

    }

    Handler handler = new Handler() {

        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            intent = new Intent(HandlerActivity.this, MainActivity.class);
            startActivity(intent);
            //执行一次后销毁本页面
            finish();
        }

    };
}
