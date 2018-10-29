package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.MyOrderAdapter;

//我的订单 里全部订单
public class MyFragment_order extends BaseFragment {
    @Override
    protected int getCreateView() {
        return R.layout.fragment_my_order;
    }

    @Override
    protected void initView(View view) {

      RecyclerView myorder_recycler = view.findViewById(R.id.myorder_recycler);

        MyOrderAdapter myOrderAdapter = new MyOrderAdapter();
    }

    @Override
    protected void initData(View view) {

    }
}
