package com.zuxiao2.zuxiao2.ui.fragment.mine.fragment;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.MyOrederBean;
import com.zuxiao2.zuxiao2.contract.IMyOrderContract;
import com.zuxiao2.zuxiao2.presenter.MyOrderPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.MyOrderAdapter;
import com.zuxiao2.zuxiao2.utils.SpUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import okhttp3.MediaType;
import okhttp3.RequestBody;

//我的订单 里全部订单
public class MyFragment_order extends BaseFragment<MyOrderPresenter> implements IMyOrderContract.View {

    private RecyclerView myorder_recycler;
    private List<MyOrederBean.DataBean.ListBean> list;
    private MyOrderAdapter myOrderAdapter;
    private TextView tishi;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_my_order;
    }

   private String page = "1";
  private  String status = "1,2,3,8,10";
   private String pagesize = "10";
    @Override
    protected void initView(View view) {
        list = new ArrayList<>();
        myorder_recycler = view.findViewById(R.id.myorder_recycler);
        myOrderAdapter = new MyOrderAdapter(getActivity(),list);
        tishi = view.findViewById(R.id.my_order_tishi);
        myorder_recycler.setLayoutManager(new LinearLayoutManager(getActivity()));
        myorder_recycler.setAdapter(myOrderAdapter);
    }

    @Override
    protected void initData(View view) {
        Bundle arguments = getArguments();
        int tabid = arguments.getInt("tabid");
        if (tabid== -1){
            //全部
            status = "1,2,3,8,10";
        }
        if (tabid== 0){
            //待付款
            status = "1";
        }
        if (tabid== 1){
            //待发货
            status = "2";
        }
        if (tabid== 2){
            //待收货
            status ="3";
        }
        if (tabid== 3){
            //售后退款
            status ="10";
        }
        String str = "{\"page\":\""+page+"\",\n" +
                "\"pageSize\":\""+pagesize+"\",\n" +
                "\"status\":\""+status+"\"\n" +
                "}";
        RequestBody fileBody = RequestBody.create(MediaType.parse("application/json"), str);
        HashMap<String, String> header = new HashMap<>();
        header.put("user_login",SpUtils.getUserKey(getActivity()));
        header.put("uuid",SpUtils.getUserId());
        presenter.getMyOrederBean(header,fileBody);
    }

    @Override
    public void showMyOrederBean(MyOrederBean myOrederBean) {
        if (myOrederBean.getCode().equals("0")){
            list.addAll(myOrederBean.getData().getList());
            myOrderAdapter.notifyDataSetChanged();
            if (myOrederBean.getData().getList().size() ==0 ){
                tishi.setVisibility(View.VISIBLE);
            }else {
                tishi.setVisibility(View.GONE);
            }
        }else {

            Toast.makeText(getActivity(), myOrederBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }
}
