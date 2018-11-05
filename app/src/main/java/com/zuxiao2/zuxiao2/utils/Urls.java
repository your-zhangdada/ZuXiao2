package com.zuxiao2.zuxiao2.utils;

public class Urls {
    public static String SERVICE = "http://47.94.246.179:8080/";
    //首页轮播图
    public final static String BANNER = "banner/list";
    public final static String HOMEURL = "首页地址";
    //注册账号 REGISTER
    public final static String REGISTER = "user/reg";
    //获取验证码
    public final static String CODEURL = "auth/sendMobileCode";
    //手机号验证码登录
    public final static String LOGINCODEURL = "auth/loginByCode";
    //密码登录
    public final static String PASSLOGINURL = "auth/loginByPwd";
    //修改密码
    public final static String CZPWD = "user/updatePwd";
    //首页热租
    public final static String HOME_RZ = "product/findHot";
    //首页商品Title
    public final static String HOME_COMMODITY = "productType/operatorClassifyList";
    //首页下面Fragment 里面 商品
    public final static String HOME_LIST = "product/list";
    //首页 商品详情
    public final static String HOME_COMMODY = "product/detail";
    //分类 一级
    public final static String FL_LIST = "productType/list";
    public final static String FL_TWO = "productType/findById";
    //收货地址
    public final static String HOME_DZ = "address/list";
    //分类列表
    public final static String FINC_URL = "product/findProduct";
    //热门搜索列表
    public final static String HOT_LIST = "hotSearch/list";
    //分类侧滑品牌
    public final static String FINCPINPAI_URL = "brand/find";
    // 认证借口
    public final static String  USER_APPLY="user/applyAuthentication";
    //   0是申请中，1是审核通过，-1审核失败
    public final static String APPLY_LIST = "user/authenticationList";
    //商家入驻
    public final static String MERCHANTENTRY_URL = "merchant/save";
    //上传图片
    public final static String COMMITIMG = "common/fileupload";
    //下单接口
    public final static String ADDDINGDAN_URL = "order/save";
    //下单接口
    public final static String TOWXPAI_URL = "order/applyPay";
    //获取我的订单tab
    public final static String GETORDERTAB_URL = "order/getOrderStatus";
    //我的订单接口
    public final static String GETMYORDER_URL = "order/find";
    //我的设备
    public final static String MY_EQUIP = "order/findMyOrder";
    //全部省市地址
    public final static String ADDRESS ="common/citys";
}
