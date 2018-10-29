package com.zuxiao2.zuxiao2;
import android.view.KeyEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.ui.fragment.FicationFragment;
import com.zuxiao2.zuxiao2.ui.fragment.HomeFragment;
import com.zuxiao2.zuxiao2.ui.fragment.MineFragment;
import com.zuxiao2.zuxiao2.ui.fragment.NoticeFragment;
import com.zuxiao2.zuxiao2.ui.fragment.SearchFragment;


public class MainActivity extends BaseActivity implements View.OnClickListener {

    private RelativeLayout fl_home;
    private ImageView iv_home;
    private TextView tv_home;
    private RelativeLayout fl_category;
    private ImageView iv_category;
    private TextView tv_category;
    private RelativeLayout fl_release;
    private ImageView iv_release;
    private TextView tv_release;
    private RelativeLayout fl_event;
    private ImageView iv_event;
    private TextView tv_event;
    private RelativeLayout fl_mine;
    private ImageView iv_mine;
    private TextView tv_mine;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        //首页
        fl_home = findViewById(R.id.fl_home);
        fl_home.setOnClickListener(this);
        iv_home = findViewById(R.id.iv_home);
        tv_home = findViewById(R.id.tv_home);
        //分类
        fl_category = findViewById(R.id.fl_category);
        fl_category.setOnClickListener(this);
        iv_category = findViewById(R.id.iv_category);
        tv_category = findViewById(R.id.tv_category);
        // 搜索
        fl_release = findViewById(R.id.fl_release);
        fl_release.setOnClickListener(this);
        iv_release = findViewById(R.id.iv_release);
        tv_release = findViewById(R.id.tv_release);
        // 通知
        fl_event = findViewById(R.id.fl_event);
        fl_event.setOnClickListener(this);
        iv_event = findViewById(R.id.iv_event);
        tv_event = findViewById(R.id.tv_event);
        //我的
        fl_mine = findViewById(R.id.fl_mine);
        fl_mine.setOnClickListener(this);
        iv_mine = findViewById(R.id.iv_mine);
        tv_mine = findViewById(R.id.tv_mine);


    }
    @Override
    protected void initData() {
        // 首页
        tv_home.setTextColor(getResources().getColor(R.color.app_same));
        iv_home.setImageResource(R.mipmap.home_selected);
        setContentView(HomeFragment.class,R.id.framelayout);
    }
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(true);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.fl_home:
                // 首页
                tv_home.setTextColor(getResources().getColor(R.color.app_same));
                iv_home.setImageResource(R.mipmap.home_selected);
                setContentView(HomeFragment.class,R.id.framelayout);

                //分类
                tv_category.setTextColor(getResources().getColor(R.color.view_bg));
                iv_category.setImageResource(R.mipmap.category_normal);
                // 搜索
                tv_release.setTextColor(getResources().getColor(R.color.view_bg));
                iv_release.setImageResource(R.mipmap.sousuo);
                //通知
                tv_event.setTextColor(getResources().getColor(R.color.view_bg));
                iv_event.setImageResource(R.mipmap.message);
                //我的
                tv_mine.setTextColor(getResources().getColor(R.color.view_bg));
                iv_mine.setImageResource(R.mipmap.mine_normal);
                break;
            case R.id.fl_category:
                //分类
                tv_category.setTextColor(getResources().getColor(R.color.app_same));
                iv_category.setImageResource(R.mipmap.category_selected);
                setContentView(FicationFragment.class,R.id.framelayout);
                break;
            case R.id.fl_release:
                // 搜索
                tv_release.setTextColor(getResources().getColor(R.color.app_same));
                iv_release.setImageResource(R.mipmap.sousuo);
                setContentView(SearchFragment.class,R.id.framelayout);
                break;
            case R.id.fl_event:
                //通知
                tv_event.setTextColor(getResources().getColor(R.color.app_same));
                iv_event.setImageResource(R.mipmap.message);
                setContentView(NoticeFragment.class,R.id.framelayout);
                break;
            case R.id.fl_mine:
                //我的
                tv_mine.setTextColor(getResources().getColor(R.color.app_same));
                iv_mine.setImageResource(R.mipmap.mine_selected);
                setContentView(MineFragment.class,R.id.framelayout);
                break;
        }
    }
}
