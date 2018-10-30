package com.zuxiao2.zuxiao2.ui.hometabftagment.classbase;

import android.content.Intent;
import android.graphics.Paint;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.youth.banner.Banner;
import com.zuxiao2.zuxiao2.R;
import com.zuxiao2.zuxiao2.base.BaseActivity;
import com.zuxiao2.zuxiao2.bean.CommodityBean;
import com.zuxiao2.zuxiao2.contract.IHomeCommContract;
import com.zuxiao2.zuxiao2.presenter.IHomeCommPresenter;
import com.zuxiao2.zuxiao2.ui.activity.Activity_AddDZ;
import com.zuxiao2.zuxiao2.ui.activity.Activity_xz_day;
import com.zuxiao2.zuxiao2.ui.hometabftagment.tabfragment.ChangJianFragment;
import com.zuxiao2.zuxiao2.ui.hometabftagment.tabfragment.ShopMessageFragment;
import com.zuxiao2.zuxiao2.ui.hometabftagment.tabfragment.UserMessageFragment;
import com.zuxiao2.zuxiao2.utils.GlideImageLoader;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CommodityActiivity extends BaseActivity<IHomeCommPresenter> implements IHomeCommContract.View, View.OnClickListener {
    private Banner im_iphoneX_pann;
    private ImageView  im_threee, im_sezhi, im_baoyou, im_kefu, im_dianpu;
    private TextView tv_iphoneX, tv_yuezu, tv_shichangjia, tv_renzheng, tv_baoyou, tv_chengjialiang, tv_fahuodizhi, tv_phoneYP, tv_shengxin, tv_day_fahuo, tv_sezhi, tv_baoy, tv_kefu, tv_dianpu;
    private TabLayout shouye_xq_tablayout;
    private ViewPager shouye_xq_viewpager;
    private Button btn_jiaru_car, btn_mashang_yy;
    private int sid;
    private String id;
    CommodityBean.DataBean data;
    private TextView tv_liji_price;
    private TextView tv_liji_yj;
    private TextView tv_liji_zj;
    private TextView tv_yse1;
    private TextView tv_yse2;
    private TextView tv_yse3;
    private TextView tv_daxiao1;
    private TextView tv_daxiao2;
    //banner 地址
    List<String> mList = new ArrayList<>();
    private TextView tv_jian;
    private TextView tv_taishu;
    private TextView tv_jia;
    private TextView tv_daynumb;
    private TextView tv_myj;
    private List<CommodityBean.DataBean.SkusBean.AttributesJsonBean> attributesJson;
    private String value;
    private String value1;
    private TextView shop;
    private TextView user;
    private TextView cj;
    private LinearLayout shopmessage;
    private LinearLayout usermessage;
    private LinearLayout changjian;
    private TextView tvshop;
    private TextView tvuser;
    private TextView tvchangjian;

    @Override
    protected void initTitle() {
    }
    @Override
    protected int getContentView() {
        return R.layout.commodity_activity;
    }
    @Override
    protected void initView() {
        //接收上个页面传过来的参数
        Intent intent = getIntent();
        id = intent.getStringExtra("id");
        sid = Integer.parseInt(id);
        //Banner
        im_iphoneX_pann = findViewById(R.id.im_iphoneX_bann);
        //图片加载器
        im_iphoneX_pann.setImageLoader(new GlideImageLoader());

        im_threee = findViewById(R.id.im_threee);
        im_sezhi = findViewById(R.id.im_sezhi);
        im_baoyou = findViewById(R.id.im_baoyou);
        im_kefu = findViewById(R.id.im_kefu);
        im_dianpu = findViewById(R.id.im_dianpu);
        //textview
        tv_iphoneX = findViewById(R.id.tv_iphoneX);
        tv_yuezu = findViewById(R.id.tv_yuezu);
        tv_shichangjia = findViewById(R.id.tv_shichangjia);
        tv_renzheng = findViewById(R.id.tv_renzheng);
        tv_baoyou = findViewById(R.id.tv_baoyou);
        tv_chengjialiang = findViewById(R.id.tv_chengjialiang);
        tv_fahuodizhi = findViewById(R.id.tv_fahuodizhi);
        tv_phoneYP = findViewById(R.id.tv_phoneYP);
        tv_shengxin = findViewById(R.id.tv_shengxin);
        tv_day_fahuo = findViewById(R.id.tv_day_fahuo);
        tv_sezhi = findViewById(R.id.tv_sezhi);
        tv_baoy = findViewById(R.id.tv_baoy);
        tv_kefu = findViewById(R.id.tv_kefu);
        tv_dianpu = findViewById(R.id.tv_dianpu);

        //button
        btn_jiaru_car = findViewById(R.id.btn_jiaru_car);
        btn_mashang_yy = findViewById(R.id.btn_mashang_yy);
        btn_mashang_yy.setOnClickListener(this);

        shopmessage = findViewById(R.id.shopmessage_linear);
        shopmessage.setOnClickListener(this);
        usermessage = findViewById(R.id.usermessage_linear);
        usermessage.setOnClickListener(this);
        changjian = findViewById(R.id.changjianwenti_linear);
        changjian.setOnClickListener(this);
        shop = findViewById(R.id.shopmessage);
        user = findViewById(R.id.usermessage);
        cj = findViewById(R.id.changjianwenti);
        tvshop = findViewById(R.id.shopmessage_tv);
        tvuser = findViewById(R.id.usermessage_tv);
        tvchangjian = findViewById(R.id.changjianwenti_tv);
        setContentView(ShopMessageFragment.class,R.id.shopmessageframelayout);
        tvshop.setVisibility(View.VISIBLE);
        tvuser.setVisibility(View.GONE);
        tvchangjian.setVisibility(View.GONE);
    }

    @Override //网络请求
    protected void initData() {
        Map<String,String> mMap = new HashMap<>();
        mMap.put("id",id+"");
        presenter.getHomeCommody(mMap);
    }

    @Override
    public void showHomeCommodt(CommodityBean frist) {
        data = frist.getData();
        List<String> bannerList = data.getBannerList();
        im_iphoneX_pann.setImages(bannerList);
        im_iphoneX_pann.start();

        tv_iphoneX.setText(data.getName());
        tv_fahuodizhi.setText("发货地："+data.getProvinceName());
        tv_yuezu.setText("日租￥"+data.getQuality());
        tv_chengjialiang.setText("成交量："+data.getCanUseNums());
        tv_shichangjia.setText("市场价: ¥ "+data.getShowPrice());
    }
 int content = 1;
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            //商品详情
            case R.id.shopmessage_linear:
                setContentView(ShopMessageFragment.class,R.id.shopmessageframelayout);
                tvshop.setVisibility(View.VISIBLE);
                tvuser.setVisibility(View.GONE);
                tvchangjian.setVisibility(View.GONE);
                break;
                //用户评价
            case R.id.usermessage_linear:
                setContentView(UserMessageFragment.class,R.id.shopmessageframelayout);
                tvshop.setVisibility(View.GONE);
                tvuser.setVisibility(View.VISIBLE);
                tvchangjian.setVisibility(View.GONE);
                break;
                //常见问题
            case R.id.changjianwenti_linear:
                setContentView(ChangJianFragment.class,R.id.shopmessageframelayout);
                tvshop.setVisibility(View.GONE);
                tvuser.setVisibility(View.GONE);
                tvchangjian.setVisibility(View.VISIBLE);
                break;
            case R.id.btn_mashang_yy:
                //立即拥有
                getPOPCommody();
                break;
            case R.id.tv_day_cont:
                //选择天数 pop 里面的
                startActivity(new Intent(this,Activity_xz_day.class));
                break;
                case R.id.tv_jian:
                //选择台数 --
                    content--;
                    tv_taishu.setText(content+"");
                    break;
            case R.id.tv_jia:
                //选择台数 ++
                content++;
                tv_taishu.setText(content+"");
                break;
        }
    }

    private void getPOPCommody() {
        int deposit = 0;
        Toast.makeText(this, "弹窗", Toast.LENGTH_SHORT).show();
        //pop 弹窗
        View inflate = LayoutInflater.from(getApplicationContext()).inflate(R.layout.pop_commody, null, false);
        TextView tv_liji_guanbi = inflate.findViewById(R.id.tv_liji_guanbi);
        ImageView im_liji_iphonex = inflate.findViewById(R.id.im_liji_iphonex);
        tv_liji_price = inflate.findViewById(R.id.tv_liji_price);
        List<CommodityBean.DataBean.SkusBean> skus = data.getSkus();
            CommodityBean.DataBean.SkusBean skusBean = skus.get(0);
            deposit = skusBean.getDeposit();
        List<CommodityBean.DataBean.SkusBean.AttributesJsonBean> attributesJson = skusBean.getAttributesJson();
        Log.e("attributes", String.valueOf(attributesJson.get(0)));
        this.attributesJson = skusBean.getAttributesJson();

            value = this.attributesJson.get(0).getValue();

        tv_liji_yj = inflate.findViewById(R.id.tv_liji_yj);
        tv_liji_zj = inflate.findViewById(R.id.tv_liji_zj);
        tv_yse1 = inflate.findViewById(R.id.tv_yse1);
        tv_yse1.setText(this.value);

        tv_yse2 = inflate.findViewById(R.id.tv_yse2);
        tv_yse3 = inflate.findViewById(R.id.tv_yse3);
        tv_daxiao1 = inflate.findViewById(R.id.tv_daxiao1);
        tv_daxiao1.setText(value1);
        tv_daxiao2 = inflate.findViewById(R.id.tv_daxiao2);
        TextView tv_day = inflate.findViewById(R.id.tv_day);
        tv_daynumb = inflate.findViewById(R.id.tv_daynumb);
        TextView tv_day_cont = inflate.findViewById(R.id.tv_day_cont);
        tv_day_cont.setOnClickListener(this);
        tv_myj = inflate.findViewById(R.id.tv_myj);
        tv_myj.setText("可用免押金额度：￥"+deposit);

        Button btn_queding = inflate.findViewById(R.id.btn_queding);
        tv_jian = findViewById(R.id.tv_jian);
        tv_taishu = findViewById(R.id.tv_taishu);
        tv_jia = findViewById(R.id.tv_jia);
        PopupWindow popupWindow = new PopupWindow(inflate,ViewPager.LayoutParams.WRAP_CONTENT, ViewPager.LayoutParams.WRAP_CONTENT, true);
        // 设置PopupWindow是否能响应外部点击事件
        popupWindow.setOutsideTouchable(true);
        // 设置PopupWindow是否能响应点击事件
        popupWindow.setTouchable(true);
        //点击外部消失
        popupWindow.setOutsideTouchable(true);
        popupWindow.setFocusable(true);
        // 设置好参数之后再show
        // 在底部显示
       //popupWindow.showAsDropDown(inflate);
        popupWindow.showAtLocation(this.getWindow().getDecorView(),Gravity.BOTTOM,0,0);

        Glide.with(getApplicationContext()).load(data.getPic()).into(im_liji_iphonex);

        btn_queding.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String s = tv_liji_price.getText().toString();   //每天租金
                String s1 = tv_liji_yj.getText().toString();   //设备押金
                String s2 = tv_liji_zj.getText().toString(); // 总押金
                String s3 = tv_yse1.getText().toString(); //颜色1
                String s4 = tv_yse2.getText().toString(); //颜色2
                String s5 = tv_yse3.getText().toString(); //颜色3
                String s6 = tv_daxiao1.getText().toString();//容量 1
                String s7 = tv_daxiao2.getText().toString();//容量 1
                String s9 = tv_daynumb.getText().toString(); //天数
                String s8 = tv_taishu.getText().toString();//台数
                String s10 = tv_myj.getText().toString();//可用免押金

                //点击事件
                Intent intent = new Intent(getApplicationContext(),Activity_AddDZ.class);
                intent.putExtra("databena",data);
                startActivity(intent);
            }
        });

    }
}
