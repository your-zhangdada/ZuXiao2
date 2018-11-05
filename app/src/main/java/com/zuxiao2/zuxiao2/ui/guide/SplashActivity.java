package com.zuxiao2.zuxiao2.ui.guide;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.zuxiao2.zuxiao2.MainActivity;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.utils.SpUtils;


public class SplashActivity extends AppCompatActivity {
    private static Handler handler = new Handler();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

    }

    @Override
    protected void onResume() {
        super.onResume();
        String isFirst = SpUtils.getIsFirst(SplashActivity.this);
        if (isFirst!=null){
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this, MainActivity.class));
                    finish();
                }
            },3000);
        }
    }
}
