package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.ui.fragment.fication.adapter.ScreeRecyclerAdapter;

import java.util.List;

public class FincActivity extends BaseActivity implements View.OnClickListener {

    private TextView tv_comprehensive;
    private TextView tv_salesvolume;
    private TextView tv_price;
    private Second.DataBean.ItemsBean itemsBean;
    private RecyclerView screenRecycler;

    @Override
    protected void initTitle() {

    }

    @Override
    protected int getContentView() {
        return R.layout.fincfragment;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        itemsBean = (Second.DataBean.ItemsBean) intent.getSerializableExtra("sp");
        List<Second.DataBean.ItemsBean.SpecificationBean> specification = itemsBean.getSpecification();
        tv_comprehensive = findViewById(R.id.tv_comprehensive);
        tv_salesvolume = findViewById(R.id.tv_salesvolume);
        tv_price = findViewById(R.id.tv_price);
        tv_comprehensive.setOnClickListener(this);
        tv_salesvolume.setOnClickListener(this);
        tv_price.setOnClickListener(this);
        screenRecycler = findViewById(R.id.screenRecycler);

        ScreeRecyclerAdapter screeRecyclerAdapter = new ScreeRecyclerAdapter(getApplicationContext(),specification);
        screenRecycler.setAdapter(screeRecyclerAdapter);
    }

    @Override
    protected void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.tv_comprehensive:
                //综合排序
                break;
            case R.id.tv_salesvolume:
                //按销量
                break;
            case R.id.tv_price:
                //按价格
                break;
        }
    }
}
