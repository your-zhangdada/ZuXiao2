package com.zuxiao2.zuxiao2.ui.hometabftagment;

import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;


import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.Home_FL;
import com.zuxiao2.zuxiao2.contract.IMyContract;
import com.zuxiao2.zuxiao2.presenter.MyPresenter;
import com.zuxiao2.zuxiao2.ui.adapter.Onedollar_adapter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Onedo_Fragment extends BaseFragment<MyPresenter> implements IMyContract.View {
    private RecyclerView recyclerOnedo;
    private String url;
    private Onedollar_adapter onedollar_adapter;
    static List<Home_FL.DataBean.ListBean> list;
    @Override
    protected int getCreateView() {
        return R.layout.fragment_onedo;
    }
    @Override
    protected void initView(View view) {
        Bundle arguments = getArguments();
        url = arguments.getString("url");
        recyclerOnedo = view .findViewById(R.id.recycler_onedo);
        recyclerOnedo.setLayoutManager(new GridLayoutManager(getContext(),2));
    }

    @Override
    protected void initData(View view) {
        Map<String,String> mMap = new HashMap<>();
        mMap.put("classifyId",url);
        mMap.put("activityId","");
        mMap.put("page",1+"");
        mMap.put("pageSize",12+"");
        presenter.getPassLoginBean(mMap);
    }

    @Override
    public void showHomeFL(Home_FL home_fl) {
       list = home_fl.getData().getList();
        Toast.makeText(getContext(),list.toString(),Toast.LENGTH_SHORT);
        onedollar_adapter = new Onedollar_adapter(getContext(), list);
        recyclerOnedo.setAdapter(onedollar_adapter);
    }
}
