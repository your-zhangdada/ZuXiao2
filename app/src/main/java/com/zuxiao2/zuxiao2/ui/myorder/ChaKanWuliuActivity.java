package com.zuxiao2.zuxiao2.ui.myorder;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;

import com.amap.api.maps.AMap;
import com.amap.api.maps.MapView;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.ChaKanWuLiuBean;
import com.zuxiao2.zuxiao2.ui.myorder.adapter.ChaKanWuLiuRecyclerViewAdapter;
import com.zuxiao2.zuxiao2.utils.RetrofitUtils;

import java.util.ArrayList;

public class ChaKanWuliuActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView back;
    private MapView mapView;
    private RecyclerView recyclerView;
    private ChaKanWuLiuRecyclerViewAdapter chaKanWuLiuRecyclerViewAdapter;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cha_kan_wuliu);
        initView();
        mapView.onCreate(savedInstanceState);
        initData();
    }

    private void initView() {
        mapView = findViewById(R.id.mymap);
        back = findViewById(R.id.chakanwuliu_imgback);
        back.setOnClickListener(this);
        recyclerView = findViewById(R.id.chakanwuliu_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ArrayList<ChaKanWuLiuBean> list = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            list.add(new ChaKanWuLiuBean("2018-03-02 08:46:40","秦皇岛市|秦皇岛市【秦皇岛市区五部】，八栋西霞超市 已签收"));
        }
        chaKanWuLiuRecyclerViewAdapter = new ChaKanWuLiuRecyclerViewAdapter(ChaKanWuliuActivity.this,list);
        recyclerView.setAdapter(chaKanWuLiuRecyclerViewAdapter);


    }
    AMap aMap;
    private void initData() {

        if (aMap == null) {
            aMap = mapView.getMap();
        }
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.chakanwuliu_imgback:
                this.finish();
                break;
        }
    }

    @Override
    protected void onPause() {
        super.onPause();
        //在activity执行onPause时执行mMapView.onPause ()，暂停地图的绘制
        mapView.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        //在activity执行onResume时执行mMapView.onResume ()，重新绘制加载地图
        mapView.onResume();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mapView.onDestroy();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        mapView.onSaveInstanceState(outState);
    }
    private void  sendHttp(){
    }
}
