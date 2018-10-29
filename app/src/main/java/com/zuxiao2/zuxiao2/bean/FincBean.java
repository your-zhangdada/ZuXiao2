package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class FincBean {

    /**
     * code : 0
     * msg : ok
     * data : {"currPage":1,"totalRow":19,"totalPage":19,"list":[{"id":19,"name":"二手【长租】ThinkPad T430 商务办公笔记本电脑租赁","describe":"","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg","bannerList":null,"tag":"","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/79f66cfab7fe4068aa71c1eecafa29a9.txt","provinceId":515,"provinceName":null,"cityId":516,"cityName":null,"insuranceDesc":null,"sellerId":1,"merchantName":null,"merchantIcon":null,"brandId":11,"brandName":null,"userId":1,"showPriceType":1,"showPrice":8888,"postageType":1,"postageMoney":0,"quality":0,"status":1,"stateName":null,"yn":false,"createDate":1539770455000,"modifyDate":1539770455000,"priceDay":0,"priceMonth":0,"orderNums":0,"transportType":null,"canUseNums":25,"operationClassifyId":null,"classifyDate":null,"activityId":null,"activityName":null,"insuranceList":null,"saleNum":4,"classify":null,"specification":null,"skus":null,"boms":null}]}
     */

    private String code;
    private String msg;
    private DataBean data;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * currPage : 1
         * totalRow : 19
         * totalPage : 19
         * list : [{"id":19,"name":"二手【长租】ThinkPad T430 商务办公笔记本电脑租赁","describe":"","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg","bannerList":null,"tag":"","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/79f66cfab7fe4068aa71c1eecafa29a9.txt","provinceId":515,"provinceName":null,"cityId":516,"cityName":null,"insuranceDesc":null,"sellerId":1,"merchantName":null,"merchantIcon":null,"brandId":11,"brandName":null,"userId":1,"showPriceType":1,"showPrice":8888,"postageType":1,"postageMoney":0,"quality":0,"status":1,"stateName":null,"yn":false,"createDate":1539770455000,"modifyDate":1539770455000,"priceDay":0,"priceMonth":0,"orderNums":0,"transportType":null,"canUseNums":25,"operationClassifyId":null,"classifyDate":null,"activityId":null,"activityName":null,"insuranceList":null,"saleNum":4,"classify":null,"specification":null,"skus":null,"boms":null}]
         */

        private int currPage;
        private int totalRow;
        private int totalPage;
        private List<ListBean> list;

        public int getCurrPage() {
            return currPage;
        }

        public void setCurrPage(int currPage) {
            this.currPage = currPage;
        }

        public int getTotalRow() {
            return totalRow;
        }

        public void setTotalRow(int totalRow) {
            this.totalRow = totalRow;
        }

        public int getTotalPage() {
            return totalPage;
        }

        public void setTotalPage(int totalPage) {
            this.totalPage = totalPage;
        }

        public List<ListBean> getList() {
            return list;
        }

        public void setList(List<ListBean> list) {
            this.list = list;
        }

        public static class ListBean {
            /**
             * id : 19
             * name : 二手【长租】ThinkPad T430 商务办公笔记本电脑租赁
             * describe :
             * pic : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/59ab06b676a842abb3c5925dae879db3.jpg
             * bannerList : null
             * tag :
             * contentUrl : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/79f66cfab7fe4068aa71c1eecafa29a9.txt
             * provinceId : 515
             * provinceName : null
             * cityId : 516
             * cityName : null
             * insuranceDesc : null
             * sellerId : 1
             * merchantName : null
             * merchantIcon : null
             * brandId : 11
             * brandName : null
             * userId : 1
             * showPriceType : 1
             * showPrice : 8888
             * postageType : 1
             * postageMoney : 0
             * quality : 0
             * status : 1
             * stateName : null
             * yn : false
             * createDate : 1539770455000
             * modifyDate : 1539770455000
             * priceDay : 0
             * priceMonth : 0
             * orderNums : 0
             * transportType : null
             * canUseNums : 25
             * operationClassifyId : null
             * classifyDate : null
             * activityId : null
             * activityName : null
             * insuranceList : null
             * saleNum : 4
             * classify : null
             * specification : null
             * skus : null
             * boms : null
             */

            private int id;
            private String name;
            private String describe;
            private String pic;
            private Object bannerList;
            private String tag;
            private String contentUrl;
            private int provinceId;
            private Object provinceName;
            private int cityId;
            private Object cityName;
            private Object insuranceDesc;
            private int sellerId;
            private Object merchantName;
            private Object merchantIcon;
            private int brandId;
            private Object brandName;
            private int userId;
            private int showPriceType;
            private double showPrice;
            private int postageType;
            private int postageMoney;
            private int quality;
            private int status;
            private Object stateName;
            private boolean yn;
            private long createDate;
            private long modifyDate;
            private int priceDay;
            private int priceMonth;
            private int orderNums;
            private Object transportType;
            private int canUseNums;
            private Object operationClassifyId;
            private Object classifyDate;
            private Object activityId;
            private Object activityName;
            private Object insuranceList;
            private int saleNum;
            private Object classify;
            private Object specification;
            private Object skus;
            private Object boms;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public String getDescribe() {
                return describe;
            }

            public void setDescribe(String describe) {
                this.describe = describe;
            }

            public String getPic() {
                return pic;
            }

            public void setPic(String pic) {
                this.pic = pic;
            }

            public Object getBannerList() {
                return bannerList;
            }

            public void setBannerList(Object bannerList) {
                this.bannerList = bannerList;
            }

            public String getTag() {
                return tag;
            }

            public void setTag(String tag) {
                this.tag = tag;
            }

            public String getContentUrl() {
                return contentUrl;
            }

            public void setContentUrl(String contentUrl) {
                this.contentUrl = contentUrl;
            }

            public int getProvinceId() {
                return provinceId;
            }

            public void setProvinceId(int provinceId) {
                this.provinceId = provinceId;
            }

            public Object getProvinceName() {
                return provinceName;
            }

            public void setProvinceName(Object provinceName) {
                this.provinceName = provinceName;
            }

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
            }

            public Object getCityName() {
                return cityName;
            }

            public void setCityName(Object cityName) {
                this.cityName = cityName;
            }

            public Object getInsuranceDesc() {
                return insuranceDesc;
            }

            public void setInsuranceDesc(Object insuranceDesc) {
                this.insuranceDesc = insuranceDesc;
            }

            public int getSellerId() {
                return sellerId;
            }

            public void setSellerId(int sellerId) {
                this.sellerId = sellerId;
            }

            public Object getMerchantName() {
                return merchantName;
            }

            public void setMerchantName(Object merchantName) {
                this.merchantName = merchantName;
            }

            public Object getMerchantIcon() {
                return merchantIcon;
            }

            public void setMerchantIcon(Object merchantIcon) {
                this.merchantIcon = merchantIcon;
            }

            public int getBrandId() {
                return brandId;
            }

            public void setBrandId(int brandId) {
                this.brandId = brandId;
            }

            public Object getBrandName() {
                return brandName;
            }

            public void setBrandName(Object brandName) {
                this.brandName = brandName;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public int getShowPriceType() {
                return showPriceType;
            }

            public void setShowPriceType(int showPriceType) {
                this.showPriceType = showPriceType;
            }

            public double getShowPrice() {
                return showPrice;
            }

            public void setShowPrice(double showPrice) {
                this.showPrice = showPrice;
            }

            public int getPostageType() {
                return postageType;
            }

            public void setPostageType(int postageType) {
                this.postageType = postageType;
            }

            public int getPostageMoney() {
                return postageMoney;
            }

            public void setPostageMoney(int postageMoney) {
                this.postageMoney = postageMoney;
            }

            public int getQuality() {
                return quality;
            }

            public void setQuality(int quality) {
                this.quality = quality;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public Object getStateName() {
                return stateName;
            }

            public void setStateName(Object stateName) {
                this.stateName = stateName;
            }

            public boolean isYn() {
                return yn;
            }

            public void setYn(boolean yn) {
                this.yn = yn;
            }

            public long getCreateDate() {
                return createDate;
            }

            public void setCreateDate(long createDate) {
                this.createDate = createDate;
            }

            public long getModifyDate() {
                return modifyDate;
            }

            public void setModifyDate(long modifyDate) {
                this.modifyDate = modifyDate;
            }

            public int getPriceDay() {
                return priceDay;
            }

            public void setPriceDay(int priceDay) {
                this.priceDay = priceDay;
            }

            public int getPriceMonth() {
                return priceMonth;
            }

            public void setPriceMonth(int priceMonth) {
                this.priceMonth = priceMonth;
            }

            public int getOrderNums() {
                return orderNums;
            }

            public void setOrderNums(int orderNums) {
                this.orderNums = orderNums;
            }

            public Object getTransportType() {
                return transportType;
            }

            public void setTransportType(Object transportType) {
                this.transportType = transportType;
            }

            public int getCanUseNums() {
                return canUseNums;
            }

            public void setCanUseNums(int canUseNums) {
                this.canUseNums = canUseNums;
            }

            public Object getOperationClassifyId() {
                return operationClassifyId;
            }

            public void setOperationClassifyId(Object operationClassifyId) {
                this.operationClassifyId = operationClassifyId;
            }

            public Object getClassifyDate() {
                return classifyDate;
            }

            public void setClassifyDate(Object classifyDate) {
                this.classifyDate = classifyDate;
            }

            public Object getActivityId() {
                return activityId;
            }

            public void setActivityId(Object activityId) {
                this.activityId = activityId;
            }

            public Object getActivityName() {
                return activityName;
            }

            public void setActivityName(Object activityName) {
                this.activityName = activityName;
            }

            public Object getInsuranceList() {
                return insuranceList;
            }

            public void setInsuranceList(Object insuranceList) {
                this.insuranceList = insuranceList;
            }

            public int getSaleNum() {
                return saleNum;
            }

            public void setSaleNum(int saleNum) {
                this.saleNum = saleNum;
            }

            public Object getClassify() {
                return classify;
            }

            public void setClassify(Object classify) {
                this.classify = classify;
            }

            public Object getSpecification() {
                return specification;
            }

            public void setSpecification(Object specification) {
                this.specification = specification;
            }

            public Object getSkus() {
                return skus;
            }

            public void setSkus(Object skus) {
                this.skus = skus;
            }

            public Object getBoms() {
                return boms;
            }

            public void setBoms(Object boms) {
                this.boms = boms;
            }
        }
    }
}
