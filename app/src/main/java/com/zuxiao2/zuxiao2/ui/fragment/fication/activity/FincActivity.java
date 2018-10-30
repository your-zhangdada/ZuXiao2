package com.zuxiao2.zuxiao2.ui.fragment.fication.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.scwang.smartrefresh.layout.SmartRefreshLayout;
import com.scwang.smartrefresh.layout.api.RefreshLayout;
import com.scwang.smartrefresh.layout.listener.OnLoadmoreListener;
import com.scwang.smartrefresh.layout.listener.OnRefreshListener;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.FincBean;
import com.zuxiao2.zuxiao2.bean.Frist;
import com.zuxiao2.zuxiao2.bean.PinPaiBean;
import com.zuxiao2.zuxiao2.bean.Second;
import com.zuxiao2.zuxiao2.contract.IFincContract;
import com.zuxiao2.zuxiao2.presenter.FincPresenter;
import com.zuxiao2.zuxiao2.ui.fragment.fication.adapter.PinPaiRecyclerViewAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.fication.adapter.SaiXuanRecyclerViewAdapter;
import com.zuxiao2.zuxiao2.ui.fragment.fication.adapter.ScreeRecyclerAdapter;
import com.zuxiao2.zuxiao2.ui.hometabftagment.classbase.CommodityActiivity;

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
    private DrawerLayout drawer;
    private LinearLayout linear;
    private EditText minprice;
    private EditText maxprice;
    private TextView cehuaname;
    private RecyclerView pinpairecycler;
    private RecyclerView saixuanitem;
    private TextView shaixuan;
    private List<PinPaiBean.DataBean> data;
    private PinPaiRecyclerViewAdapter pinPaiRecyclerViewAdapter;
    private ArrayList<Second.DataBean.ItemsBean.SpecificationBean> spec;
    private SaiXuanRecyclerViewAdapter saiXuanRecyclerViewAdapter;

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
        shaixuan = findViewById(R.id.finc_shaixuan);
        shaixuan.setOnClickListener(this);
        screenRecycler.setLayoutManager(new LinearLayoutManager(this));
        refresh = findViewById(R.id.refreshLayout);
        list = new ArrayList<>();
        data = new ArrayList<>();
        spec = new ArrayList<>();
        screeRecyclerAdapter = new ScreeRecyclerAdapter(getApplicationContext(),list);
        screenRecycler.setAdapter(screeRecyclerAdapter);
        drawer = findViewById(R.id.drawerlayout);
        drawer.setScrimColor(Color.TRANSPARENT);
        linear = findViewById(R.id.cehua_linear);
        minprice = findViewById(R.id.min_price);
        maxprice = findViewById(R.id.max_price);
        cehuaname = findViewById(R.id.chehua_select_name);
        pinpairecycler = findViewById(R.id.finc_pinpai_recycler);
        pinpairecycler.setLayoutManager(new GridLayoutManager(this,3));
        pinPaiRecyclerViewAdapter = new PinPaiRecyclerViewAdapter(this ,data);
        saixuanitem = findViewById(R.id.finc_saixuan_item);
        saixuanitem.setLayoutManager(new LinearLayoutManager(this));
        saiXuanRecyclerViewAdapter = new SaiXuanRecyclerViewAdapter(this,spec);
        cehuaname.setText("全部");
        pinPaiRecyclerViewAdapter.getPinPaiData(new PinPaiRecyclerViewAdapter.setPinPaiData() {
            @Override
            public void setPinPaiItemData(View view, int position) {
                cehuaname.setText(data.get(position).getName());
            }
        });
        Button reset = findViewById(R.id.finc_saixuan_reset);
        reset.setOnClickListener(this);
        Button ok = findViewById(R.id.finc_saixuan_ok);
        ok.setOnClickListener(this);
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
        HashMap<String, String> pinpaiMap = new HashMap<>();
        pinpaiMap.put("classifyId",itemsBean.getId()+"");
        pinpaiMap.put("classifyParentId",oneid);
        presenter.getPinPaiBean(pinpaiMap);
        HashMap<String, String> cehuaMap = new HashMap<>();
        cehuaMap.put("id",oneid);
        presenter.getFenLeiCeHuaBean(cehuaMap);
        pinpairecycler.setAdapter(pinPaiRecyclerViewAdapter);
        saixuanitem.setAdapter(saiXuanRecyclerViewAdapter);
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
        screeRecyclerAdapter.getOnClickData(new ScreeRecyclerAdapter.setOnClickData() {
            @Override
            public void setOnClickData(View view, int position) {
                //跳转到商品详情页面
                Intent intent = new Intent(FincActivity.this,CommodityActiivity.class);
                int id = list.get(position).getId();
                intent.putExtra("id",id+"");
                startActivity(intent);
            }
        });
    }

    @SuppressLint("ResourceAsColor")
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.finc_saixuan_reset:
                data.clear();
                spec.clear();
                pinPaiRecyclerViewAdapter.notifyDataSetChanged();
                saiXuanRecyclerViewAdapter.notifyDataSetChanged();
                HashMap<String, String> pinpaiMap = new HashMap<>();
                pinpaiMap.put("classifyId",itemsBean.getId()+"");
                pinpaiMap.put("classifyParentId",oneid);
                presenter.getPinPaiBean(pinpaiMap);
                HashMap<String, String> cehuaMap = new HashMap<>();
                cehuaMap.put("id",oneid);
                presenter.getFenLeiCeHuaBean(cehuaMap);
                break;
            case R.id.finc_saixuan_ok:
                list.clear();
                screeRecyclerAdapter.notifyDataSetChanged();
                rucan("1");
                drawer.closeDrawer(linear);
                break;
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
            case R.id.finc_shaixuan:
                openRightLayout();
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

    @Override
    public void showPinPaiBean(PinPaiBean pinPaiBean) {
        if (pinPaiBean.getCode().equals("0")){
            data.clear();
            data.addAll(pinPaiBean.getData());
            pinPaiRecyclerViewAdapter.notifyDataSetChanged();
        }else {
            Toast.makeText(this, pinPaiBean.getMsg(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void showFenLeiCeHuaBean(Second second) {
        if (second.getCode().equals("0")){
            List<Second.DataBean.ItemsBean> items1 = second.getData().getItems();
            for (Second.DataBean.ItemsBean bean : items1) {
                List<Second.DataBean.ItemsBean.SpecificationBean> specification = bean.getSpecification();
                spec.addAll(specification);
                saiXuanRecyclerViewAdapter.notifyDataSetChanged();
            }
        }else {
            Toast.makeText(this, second.getMsg(), Toast.LENGTH_SHORT).show();
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
    // 右边菜单开关事件
    public void openRightLayout() {
        if (drawer.isDrawerOpen(linear)) {
            drawer.closeDrawer(linear);
        } else {
            drawer.openDrawer(linear);
        }
    }

}
