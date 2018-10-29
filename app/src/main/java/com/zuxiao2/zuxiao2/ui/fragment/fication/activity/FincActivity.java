package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.FincBean;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.contract.IFincContract;
import com.zuxiao2.zuxiao2.presenter.FincPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.fication.adapter.ScreeRecyclerAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FincActivity extends BaseActivity<FincPresenter> implements View.OnClickListener,IFincContract.View {

    private TextView tv_comprehensive;
    private TextView tv_salesvolume;
    private TextView tv_price;
    private Second.DataBean.ItemsBean itemsBean;
    private RecyclerView screenRecycler;
    private ImageView back;
    private TextView title;
    private SmartRefreshLayout refresh;
    private List<FincBean.DataBean.ListBean> list;
    private ScreeRecyclerAdapter screeRecyclerAdapter;
    private int page =1;
    private String oneid;
    private TextView tishi;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fincfragment;
    }

    @Override
    protected void initView() {
        tv_comprehensive = findViewById(R.id.tv_comprehensive);
        tv_salesvolume = findViewById(R.id.tv_salesvolume);
        tv_price = findViewById(R.id.tv_price);
        tv_comprehensive.setOnClickListener(this);
        tv_salesvolume.setOnClickListener(this);
        tv_price.setOnClickListener(this);
        screenRecycler = findViewById(R.id.screenRecycler);
        tishi = findViewById(R.id.finc_tishi);
        back = findViewById(R.id.finc_back);
        back.setOnClickListener(this);
        title = findViewById(R.id.finc_title);
        TextView shaixuan = findViewById(R.id.finc_shaixuan);
        screenRecycler.setLayoutManager(new LinearLayoutManager(this));
        refresh = findViewById(R.id.refreshLayout);
        list = new ArrayList<>();
        screeRecyclerAdapter = new ScreeRecyclerAdapter(getApplicationContext(),list);
        screenRecycler.setAdapter(screeRecyclerAdapter);
    }

    @SuppressLint("ResourceAsColor")
    @Override
    protected void initData() {
        Intent intent = getIntent();
        itemsBean = (Second.DataBean.ItemsBean) intent.getSerializableExtra("sp");
        oneid = intent.getStringExtra("oneid");
        String name = itemsBean.getName();
        title.setText(name);
        rucan("1");
        tv_comprehensive.setTextColor(Color.parseColor("#51BF85"));
        tv_salesvolume.setTextColor(Color.parseColor("#999999"));
        tv_price.setTextColor(Color.parseColor("#999999"));
        refresh.setOnRefreshListener(new OnRefreshListener() {
            @Override
            public void onRefresh(RefreshLayout refreshlayout) {
                list.clear();
                page =1;
                screeRecyclerAdapter.notifyDataSetChanged();
                rucan("1");
                refreshlayout.finishRefresh(2000/*,false*/);//传入false表示刷新失败
            }
        });
        refresh.setOnLoadmoreListener(new OnLoadmoreListener() {
            @Override
            public void onLoadmore(RefreshLayout refreshlayout) {
                page ++;
                rucan("1");
                refreshlayout.finishLoadmore(2000/*,false*/);//传入false表示加载失败
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_comprehensive:
                list.clear();
                page =1;
                screeRecyclerAdapter.notifyDataSetChanged();
                tv_comprehensive.setTextColor(Color.parseColor("#51BF85"));
                tv_salesvolume.setTextColor(Color.parseColor("#999999"));
                tv_price.setTextColor(Color.parseColor("#999999"));
                //综合排序
                rucan("1");
                break;
            case R.id.tv_salesvolume:
                //按销量
                list.clear();
                page =1;
                tv_comprehensive.setTextColor(Color.parseColor("#999999"));
                tv_salesvolume.setTextColor(Color.parseColor("#51BF85"));
                tv_price.setTextColor(Color.parseColor("#999999"));
                screeRecyclerAdapter.notifyDataSetChanged();
                //综合排序
               rucan("2");
                break;
            case R.id.tv_price:
                //按价格
                list.clear();
                page =1;
                tv_comprehensive.setTextColor(Color.parseColor("#999999"));
                tv_salesvolume.setTextColor(Color.parseColor("#999999"));
                tv_price.setTextColor(Color.parseColor("#51BF85"));
                screeRecyclerAdapter.notifyDataSetChanged();
                //综合排序
                rucan("3");
                break;
            case R.id.finc_back:
                this.finish();
                break;
        }
    }

    @Override
    public void showFincBean(FincBean fincBean) {
        if (fincBean.getCode().equals("0")){
            list.addAll(fincBean.getData().getList());
            screeRecyclerAdapter.notifyDataSetChanged();
            if (fincBean.getData().getList().size() ==0){
                tishi.setVisibility(View.VISIBLE);
            }else {
                tishi.setVisibility(View.GONE);
            }
        }else {
            Toast.makeText(this, fincBean.getMsg(), Toast.LENGTH_SHORT).show();
        }

    }
    private void rucan(String sort){
        HashMap<String, String>  map = new HashMap<>();
        map.put("classifyId",itemsBean.getId()+"");
        map.put("classifyParentId",oneid);
        map.put("brandIds","");
        map.put("specialIds","");
        map.put("minPrice","");
        map.put("maxPrice","");
        map.put("antName","");
        map.put("sort",sort);
        map.put("page",page+"");
        map.put("pageSize","10");
        presenter.getFincBean(map);
    }
}
