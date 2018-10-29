package com.zuxiao2.zuxiao2.ui.fragment;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.contract.IFLContract;
import com.zuxiao2.zuxiao2.presenter.FLPresenter;
import com.zuxiao2.zuxiao2.ui.adapter.RightRecyclerAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.fication.activity.FincActivity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

//分类 页面
public class FicationFragment extends BaseFragment<FLPresenter> implements IFLContract.View {
    private ListView category_listview;
    private RecyclerView lv_right;
    private List<Frist.DataBean> data = new ArrayList<>();
    private  List<Second.DataBean.ItemsBean> list = new ArrayList<>();
    private CategropListAdapter categropListAdapter;
    private RightRecyclerAdapter rightRecyclerAdapter;
    private LinearLayoutManager linearLayoutManager;
    private int oneid;


    @Override
    protected int getCreateView() {
        return R.layout.fragment_fication;
    }
int type = 0;
    @Override
    protected void initView(View view) {
        //RecyclerView
        lv_right = view.findViewById(R.id.lv_right);
        linearLayoutManager = new LinearLayoutManager(getContext());
        lv_right.setLayoutManager(linearLayoutManager);

        //listview
        category_listview = view.findViewById(R.id.category_listview);
        categropListAdapter = new CategropListAdapter(getActivity(),data);
        category_listview.setAdapter(categropListAdapter);
        category_listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //一级列表id
                oneid = data.get(position).getId();
                list.clear();
                type = position;
                categropListAdapter.notifyDataSetChanged();
                presenter.getFLTwo(data.get(position).getId());
            }
        });
    }

    @Override
    protected void initData(View view) {
        Map<String,String> map = new HashMap<>();
        presenter.getFLList(map);

    }

    @Override
    public void showFLList(Frist frist) {
        data.addAll( frist.getData());
        //二级也面默认展示数据
        oneid = frist.getData().get(0).getId();
        presenter.getFLTwo(frist.getData().get(0).getId());
        categropListAdapter.notifyDataSetChanged();
    }

    @Override
    public void showFLRecycler(Second second) {
        List<Second.DataBean.ItemsBean> items = second.getData().getItems();
        list.addAll(items);
        Log.e("TAG",items.toString());
        rightRecyclerAdapter = new RightRecyclerAdapter(getActivity(),list);
        lv_right.setAdapter(rightRecyclerAdapter);
        rightRecyclerAdapter.notifyDataSetChanged();
        rightRecyclerAdapter.setOnclicklinster(new RightRecyclerAdapter.onclicklinster() {
            @Override
            public void onItemClick(int ppp) {
                Intent intent = new Intent(getActivity(), FincActivity.class);
                Second.DataBean.ItemsBean itemsBean = list.get(ppp);
                intent.putExtra("oneid",oneid+"");
                intent.putExtra("sp",itemsBean);
                startActivity(intent);
            }
        });
    }

    class CategropListAdapter extends BaseAdapter{
        Context  context;
        List<Frist.DataBean> data;
        public CategropListAdapter(Context  context, List<Frist.DataBean> data) {
            this.context = context;
            this.data = data;
        }

        @Override
        public int getCount() {
            return data.size();
        }
        @Override
        public Object getItem(int position) {
            return null;
        }
        @Override
        public long getItemId(int position) {
            return 0;
        }
        @Override
        public View getView(int position, View view, ViewGroup parent) {
            ViewHolder holder;
            if (view == null){
                holder = new ViewHolder();
                view = LayoutInflater.from(context).inflate(R.layout.categorplistview_item,null);
                holder.linear = view.findViewById(R.id.cate_listview_item_linear);
                holder.imageView = view.findViewById(R.id.cate_listview_item_imageview);
                holder.textView = view.findViewById(R.id.cate_listview_item_title);
              view.setTag(holder);
            }else {
                holder = (ViewHolder) view.getTag();
            }
            holder.textView.setText(data.get(position).getName());
            Glide.with(context).load(data.get(position).getIcon()).into(holder.imageView);

            if (position == type){
                holder.linear.setBackgroundResource(R.color.bg_regist_bg);
            }else {
                holder.linear.setBackgroundResource(R.color.bttext_regist_back);
            }
            return view;
        }
    }
    class ViewHolder{
        LinearLayout linear;
        ImageView imageView;
        TextView textView;
    }
}
