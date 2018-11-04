package com.zuxiao2.zuxiao2.ui.fragment;

import android.view.View;
import android.widget.Toast;

import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.HotListBean;
import com.zuxiao2.zuxiao2.contract.HotListContract;
import com.zuxiao2.zuxiao2.presenter.HotListPresenter;
import com.zuxiao2.zuxiao2.view.WrapLayout;

import java.util.ArrayList;
import java.util.List;

//搜索页面
public class SearchFragment extends BaseFragment<HotListPresenter> implements HotListContract.View {

    private WrapLayout sousou_wrap;
    private WrapLayout remensousou_text;

    @Override
    protected int getCreateView() {
        return R.layout.fragment_search;
    }

    @Override
    protected void initView(View view) {
        sousou_wrap = view.findViewById(R.id.sousou_wrap);//历史搜索
        remensousou_text = view.findViewById(R.id.remensousou_text);//热门搜索
    }

    @Override
    protected void initData(View view) {

        presenter.getHotList();
    }

    @Override
    public void showHotList(HotListBean hotListBean) {
        List<String > list = new ArrayList<>();
        List<HotListBean.DataBean> data = hotListBean.getData();
        for (int i = 0; i < data.size(); i++) {
            list.add(data.get(i).getName());
        }
        sousou_wrap.setData(list,getContext(),10,10,10,10,10,10,10,10,10);
        sousou_wrap.setMarkClickListener(new WrapLayout.MarkClickListener() {
            @Override
            public void clickMark(int position) {
                Toast.makeText(getContext(),position+"", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
