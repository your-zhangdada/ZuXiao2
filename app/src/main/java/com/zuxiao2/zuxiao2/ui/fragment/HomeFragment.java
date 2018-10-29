package com.zuxiao2.zuxiao2.ui.fragment;


import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseFragment;
import com.zuxiao2.zuxiao2.bean.BannerBean;
import com.zuxiao2.zuxiao2.bean.Home_huodong;
import com.zuxiao2.zuxiao2.bean.Home_rezhu;
import com.zuxiao2.zuxiao2.contract.IHomeContract;
import com.zuxiao2.zuxiao2.presenter.HomePresenter;
import com.zuxiao2.zuxiao2.ui.adapter.Oendollar_pageradapter;
import com.zuxiao2.zuxiao2.ui.hometabftagment.Onedo_Fragment;
import com.zuxiao2.zuxiao2.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/** 首页 Fragment
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment<HomePresenter> implements IHomeContract.View,View.OnClickListener {
    private TextView tv_iphone,tv_my,tv_rz,tv_Macbook,tv_xinping,tv_nkoen,tv_nktwo;
    RelativeLayout relativ_rz;
    private LinearLayout lv ,locations;
    private ImageView im_iphone, message,im_xinpingoen, im_xinpingtwo,im_nikang,im_hot_rent_list_more, im_fruit_and_powder, im_hot_national_machine, im_office_selection;
    private TabLayout shouye_tablayout;
    private ViewPager shouye_viewpager;
    private Banner banner;
    //banner 地址
    List<String> mList = new ArrayList<>();
    @Override
    protected int getCreateView() {
        return R.layout.fragment_home;
    }

    @Override
    protected void initView(View view) {
        //热阻图片
        im_iphone = view.findViewById(R.id.im_iphone);
        //位置
        locations = view.findViewById(R.id.locations);
       locations.setOnClickListener(this);
        //我的购物车
        message = view.findViewById(R.id.message);
       message.setOnClickListener(this);
        banner = (Banner) view.findViewById(R.id.banner);
        //图片加载器
        banner.setImageLoader(new GlideImageLoader());
        //iPhone X
        tv_iphone = view.findViewById(R.id.tv_iphone);
        //我在这里等你来
        tv_my = view.findViewById(R.id.tv_my);
        //热阻
        tv_rz = view.findViewById(R.id.tv_rz);
        //Macbook
        tv_Macbook = view.findViewById(R.id.tv_Macbook);
        //新品
        tv_xinping = view.findViewById(R.id.tv_xinping);
        //新品 图片 1
        im_xinpingoen = view.findViewById(R.id.im_xinpingoen);
        //新品 图片 12
        im_xinpingtwo = view.findViewById(R.id.im_xinpingtwo);

        tv_nkoen = view.findViewById(R.id.tv_nkoen);
        tv_nktwo = view.findViewById(R.id.tv_nktwo);
        im_nikang = view.findViewById(R.id.im_nikang);
        // Tablayout
        shouye_tablayout = view.findViewById(R.id.shouye_tablayout);
        shouye_viewpager = view.findViewById(R.id.shouye_viewpager);
    }

    @Override
    protected void initData(View view) {
        Map<String,String> mMap = new HashMap<>();
        mMap.put("location","app");
        mMap.put("size",6+"");
        presenter.getHomeBean(mMap);
        Map<String,String> mMap_rz = new HashMap<>();
        mMap_rz.put("page",1+"");
        mMap_rz.put("pageSize",10+"");
        presenter.getHomeRZ(mMap_rz);
        Map<String ,String > map = new HashMap<>();
        presenter.getHomeTab(map);
    }

    @Override
    public void showHomeBean(BannerBean homeBean) {
        List<BannerBean.DataBean> data = homeBean.getData();
        for (int i = 0; i < data.size(); i++) {
            mList.add(data.get(i).getPicUrl());
        }
        banner.setImages(mList);
        banner.start();
    }

    @Override//热阻
    public void showRZ_Bean(Home_rezhu home_rezhu) {
        List<Home_rezhu.DataBean.ListBean> list = home_rezhu.getData().getList();
        tv_iphone.setText(list.get(0).getName());
        tv_my.setText(list.get(0).getDescribe());
        Glide.with(getActivity()).load(list.get(0).getPic()).into(im_iphone);
        tv_Macbook.setText(list.get(1).getName());
        tv_xinping.setText(list.get(1).getDescribe());
        Glide.with(getActivity()).load(list.get(1).getPic()).into(im_xinpingoen);
        Glide.with(getActivity()).load(list.get(1).getPic()).into(im_xinpingtwo);
        tv_nkoen.setText(list.get(2).getName());
        tv_nktwo.setText(list.get(2).getDescribe());
        Glide.with(getActivity()).load(list.get(2).getPic()).into(im_nikang);
    }

    @Override //首页 tablayout
    public void showHome_Tab(Home_huodong home_huodong) {
        List<Home_huodong.DataBean> data = home_huodong.getData();
        ArrayList<String> mDatalist = new ArrayList<>();
        List<Onedo_Fragment> myFragment = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            mDatalist.add(data.get(i).getName());
            Onedo_Fragment onedo_fragment = new Onedo_Fragment();
            myFragment.add(onedo_fragment);
            String url = data.get(i).getId() + "";
            Bundle bundle = new Bundle();
            bundle.putString("url", url);
            onedo_fragment.setArguments(bundle);
        }
            Oendollar_pageradapter oendollar_pageradapter = new Oendollar_pageradapter(getFragmentManager(),myFragment,mDatalist);
            shouye_viewpager.setAdapter(oendollar_pageradapter);
            shouye_viewpager.setOnTouchListener(new View.OnTouchListener() {
                @Override
                public boolean onTouch(View v, MotionEvent event) {
                    return true;
                }
            });
            shouye_tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);
            shouye_viewpager.setAdapter(oendollar_pageradapter);
            shouye_tablayout.setupWithViewPager(shouye_viewpager);
        }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.locations:
                break;
            case R.id.message:
                break;
        }
    }


}
