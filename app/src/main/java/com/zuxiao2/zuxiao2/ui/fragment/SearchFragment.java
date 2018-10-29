package com.zuxiao2.zuxiao2.ui.fragment;

import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.Hot_sousou;
import com.zuxiao2.zuxiao2.contract.SouSouContract;
import com.zuxiao2.zuxiao2.presenter.SouSouPresenter;
import com.zuxiao2.zuxiao2.view.WrapLayout;

import java.util.ArrayList;
import java.util.List;

//搜索页面
public class SearchFragment extends BaseFragment<SouSouPresenter> implements SouSouContract.View, View.OnClickListener {

    private ImageView im_shousuo_fanhui;
    private EditText ed_sousou;
    private TextView tv_sousou;
    private ImageView im_lajitong;
    private WrapLayout sousou_wrap;
    private WrapLayout remensousou_text;
    private String sousou;
    private List<String> mList;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView(View view) {
        //返回
        im_shousuo_fanhui = view.findViewById(R.id.im_shousuo_fanhui);
        im_shousuo_fanhui.setOnClickListener(this);
        // 输入框
        ed_sousou = view.findViewById(R.id.ed_sousou);
        // 点击搜索
        tv_sousou = view.findViewById(R.id.tv_sousou);
        tv_sousou.setOnClickListener(this);
        // 垃圾箱
        im_lajitong = view.findViewById(R.id.im_lajitong );
        im_lajitong.setOnClickListener(this);
        //历史搜索
        sousou_wrap = view.findViewById(R.id.sousou_wrap);
        //热门搜索
        remensousou_text = view.findViewById(R.id.remensousou_text);
    }

    @Override
    protected  void initData(View view) {
            presenter.getSouSouBean();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.im_shousuo_fanhui:

                break;
            case R.id.tv_sousou:
                sousou = ed_sousou.getText().toString();

                break;
            case R.id.im_lajitong:

                break;
        }
    }

    @Override
    public void showSouSou(Hot_sousou hot_sousou) {
        List<Hot_sousou.DataBean> data = hot_sousou.getData();
        mList = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            mList.add(data.get(i).getName());
        }
        //历史搜索
        remensousou_text.setData(mList,getActivity(),10,10,10,10,10,10,10,10,10);
        remensousou_text.setMarkClickListener(new WrapLayout.MarkClickListener() {
            @Override
            public void clickMark(int position) {
                Toast.makeText(getContext(), mList.get(position) , Toast.LENGTH_SHORT).show();
            }
        });
        //热门搜索
        sousou_wrap.setData(mList,getActivity(),10,10,10,10,10,10,10,10,10);
        sousou_wrap.setMarkClickListener(new WrapLayout.MarkClickListener() {
            @Override
            public void clickMark(int position) {
                Toast.makeText(getContext(), mList.get(position) , Toast.LENGTH_SHORT).show();
            }
        });

    }
}
