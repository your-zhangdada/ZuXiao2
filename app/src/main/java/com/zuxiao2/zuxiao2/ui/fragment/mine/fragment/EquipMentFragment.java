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
import com.zuxiao2.zuxiao2.contract.MyEquipContract;
import com.zuxiao2.zuxiao2.presenter.MyEquipPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.mine.adapter.MyOrderAdapter;

import java.util.HashMap;
import java.util.List;

//我的设备
public class EquipMentFragment extends BaseFragment<MyEquipPresenter> implements MyEquipContract.View {

    private String type = "1";
    private TextView tishi;
    private RecyclerView recyclerView;
    private List<MyOrederBean.DataBean.ListBean> list;
    private MyOrderAdapter myOrderAdapter;

    private int page = 1;
    @Override
    protected int getCreateView() {
        return R.layout.fragment_equip_ment;
    }

    @Override
    protected void initView(View view) {

        tishi = view.findViewById(R.id.myshebeitishi);
        recyclerView = view.findViewById(R.id.myshebei_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        myOrderAdapter = new MyOrderAdapter(getActivity(),list);
        recyclerView.setAdapter(myOrderAdapter);
        Bundle arguments = getArguments();
        int tabid = arguments.getInt("Tabid");
        if (tabid== 0){
            //租赁中
            type = "1";
        }
        if (tabid== 1){
            //到期提醒
            type = "2";
        }
        if (tabid== 2){
            //待归还
            type ="3";
        }
        if (tabid== 3){
            //已完成
            type ="4";
        }
        HashMap<String, String> parms = new HashMap<>();
        parms.put("type",type);
        parms.put("page",page+"");
        parms.put("pageSize","12");
        presenter.getMyEquipBean(parms);
    }

    @Override
    protected void initData(View view) {

    }

    @Override
    public void showMyEquip(MyOrederBean myOrederBean) {
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
