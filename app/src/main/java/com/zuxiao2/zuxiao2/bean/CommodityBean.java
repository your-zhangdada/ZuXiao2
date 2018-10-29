package com.zuxiao2.zuxiao2.bean;

import java.io.Serializable;
import java.util.List;

public class CommodityBean implements Serializable{


    @Override
    public String toString() {
        return "CommodityBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * msg : ok
     * data : {"id":14,"name":"IPhoneX 最新款 4G 全网通手机","describe":"IPhoneX 最新款 4G 全网通手机","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/15/e5848af720e14b8b90d3639da27a5790.jpg","bannerList":["https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/15/519ab3674d174f1fae1e240047de4044.jpg"],"tag":"IPhoneX 最新款 4G 全网通手机","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/15/cfb8e7d5079a47dfbfa51a2e17ec5dce.txt","provinceId":515,"provinceName":"北京市","cityId":516,"cityName":"东城区","insuranceDesc":null,"sellerId":1,"merchantName":null,"brandId":1,"brandName":null,"userId":1,"showPriceType":1,"showPrice":10,"postageType":1,"postageMoney":0,"quality":100,"status":1,"stateName":null,"yn":false,"createDate":1539618870000,"modifyDate":1539699147000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":2,"operationClassifyId":300,"classifyDate":1539699147000,"activityId":-1,"activityName":null,"insuranceList":[{"id":8,"productId":14,"name":"丢失险","money":20,"compensate":null,"desc":"手机丢失","yn":false,"createDate":1539618870000,"modifyDate":1539618870000},{"id":7,"productId":14,"name":"碎屏保险","money":10,"compensate":null,"desc":"碎屏保险","yn":false,"createDate":1539618870000,"modifyDate":1539618870000}],"saleNum":0,"classify":null,"specification":null,"skus":[{"id":19,"productId":14,"attributes":"[{\"key\":\"颜色\",\"value\":\"白色\"},{\"key\":\"版本\",\"value\":\"256G\"}]","deposit":6000,"salePriceDay":"{7:10,15:9,20:8}","salePriceMonth":null,"yn":false,"createDate":1539618870000,"modifyDate":1539618870000,"inventoryNum":null,"attributesJson":[{"key":"颜色","value":"白色"},{"key":"版本","value":"256G"}]},{"id":18,"productId":14,"attributes":"[{\"key\":\"颜色\",\"value\":\"白色\"},{\"key\":\"版本\",\"value\":\"64G\"}]","deposit":6000,"salePriceDay":"{7:10,15:9,20:8}","salePriceMonth":null,"yn":false,"createDate":1539618870000,"modifyDate":1539618870000,"inventoryNum":1,"attributesJson":[{"key":"颜色","value":"白色"},{"key":"版本","value":"64G"}]},{"id":17,"productId":14,"attributes":"[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"版本\",\"value\":\"64G\"}]","deposit":6000,"salePriceDay":"{7:10,15:9,20:8}","salePriceMonth":null,"yn":false,"createDate":1539618870000,"modifyDate":1539618870000,"inventoryNum":1,"attributesJson":[{"key":"颜色","value":"金色"},{"key":"版本","value":"64G"}]}]}
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

    public static class DataBean implements Serializable {
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", describe='" + describe + '\'' +
                    ", pic='" + pic + '\'' +
                    ", tag='" + tag + '\'' +
                    ", contentUrl='" + contentUrl + '\'' +
                    ", provinceId=" + provinceId +
                    ", provinceName='" + provinceName + '\'' +
                    ", cityId=" + cityId +
                    ", cityName='" + cityName + '\'' +
                    ", insuranceDesc=" + insuranceDesc +
                    ", sellerId=" + sellerId +
                    ", merchantName=" + merchantName +
                    ", brandId=" + brandId +
                    ", brandName=" + brandName +
                    ", userId=" + userId +
                    ", showPriceType=" + showPriceType +
                    ", showPrice=" + showPrice +
                    ", postageType=" + postageType +
                    ", postageMoney=" + postageMoney +
                    ", quality=" + quality +
                    ", status=" + status +
                    ", stateName=" + stateName +
                    ", yn=" + yn +
                    ", createDate=" + createDate +
                    ", modifyDate=" + modifyDate +
                    ", priceDay=" + priceDay +
                    ", priceMonth=" + priceMonth +
                    ", orderNums=" + orderNums +
                    ", transportType=" + transportType +
                    ", canUseNums=" + canUseNums +
                    ", operationClassifyId=" + operationClassifyId +
                    ", classifyDate=" + classifyDate +
                    ", activityId=" + activityId +
                    ", activityName=" + activityName +
                    ", saleNum=" + saleNum +
                    ", classify=" + classify +
                    ", specification=" + specification +
                    ", bannerList=" + bannerList +
                    ", insuranceList=" + insuranceList +
                    ", skus=" + skus +
                    '}';
        }

        /**
         * id : 14
         * name : IPhoneX 最新款 4G 全网通手机
         * describe : IPhoneX 最新款 4G 全网通手机
         * pic : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/15/e5848af720e14b8b90d3639da27a5790.jpg
         * bannerList : ["https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/15/519ab3674d174f1fae1e240047de4044.jpg"]
         * tag : IPhoneX 最新款 4G 全网通手机
         * contentUrl : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/15/cfb8e7d5079a47dfbfa51a2e17ec5dce.txt
         * provinceId : 515
         * provinceName : 北京市
         * cityId : 516
         * cityName : 东城区
         * insuranceDesc : null
         * sellerId : 1
         * merchantName : null
         * brandId : 1
         * brandName : null
         * userId : 1
         * showPriceType : 1
         * showPrice : 10
         * postageType : 1
         * postageMoney : 0
         * quality : 100
         * status : 1
         * stateName : null
         * yn : false
         * createDate : 1539618870000
         * modifyDate : 1539699147000
         * priceDay : null
         * priceMonth : null
         * orderNums : null
         * transportType : null
         * canUseNums : 2
         * operationClassifyId : 300
         * classifyDate : 1539699147000
         * activityId : -1
         * activityName : null
         * insuranceList : [{"id":8,"productId":14,"name":"丢失险","money":20,"compensate":null,"desc":"手机丢失","yn":false,"createDate":1539618870000,"modifyDate":1539618870000},{"id":7,"productId":14,"name":"碎屏保险","money":10,"compensate":null,"desc":"碎屏保险","yn":false,"createDate":1539618870000,"modifyDate":1539618870000}]
         * saleNum : 0
         * classify : null
         * specification : null
         * skus : [{"id":19,"productId":14,"attributes":"[{\"key\":\"颜色\",\"value\":\"白色\"},{\"key\":\"版本\",\"value\":\"256G\"}]","deposit":6000,"salePriceDay":"{7:10,15:9,20:8}","salePriceMonth":null,"yn":false,"createDate":1539618870000,"modifyDate":1539618870000,"inventoryNum":null,"attributesJson":[{"key":"颜色","value":"白色"},{"key":"版本","value":"256G"}]},{"id":18,"productId":14,"attributes":"[{\"key\":\"颜色\",\"value\":\"白色\"},{\"key\":\"版本\",\"value\":\"64G\"}]","deposit":6000,"salePriceDay":"{7:10,15:9,20:8}","salePriceMonth":null,"yn":false,"createDate":1539618870000,"modifyDate":1539618870000,"inventoryNum":1,"attributesJson":[{"key":"颜色","value":"白色"},{"key":"版本","value":"64G"}]},{"id":17,"productId":14,"attributes":"[{\"key\":\"颜色\",\"value\":\"金色\"},{\"key\":\"版本\",\"value\":\"64G\"}]","deposit":6000,"salePriceDay":"{7:10,15:9,20:8}","salePriceMonth":null,"yn":false,"createDate":1539618870000,"modifyDate":1539618870000,"inventoryNum":1,"attributesJson":[{"key":"颜色","value":"金色"},{"key":"版本","value":"64G"}]}]
         */

        private int id;
        private String name;
        private String describe;
        private String pic;
        private String tag;
        private String contentUrl;
        private int provinceId;
        private String provinceName;
        private int cityId;
        private String cityName;
        private Object insuranceDesc;
        private int sellerId;
        private Object merchantName;
        private int brandId;
        private Object brandName;
        private int userId;
        private int showPriceType;
        private int showPrice;
        private int postageType;
        private int postageMoney;
        private int quality;
        private int status;
        private Object stateName;
        private boolean yn;
        private long createDate;
        private long modifyDate;
        private Object priceDay;
        private Object priceMonth;
        private Object orderNums;
        private Object transportType;
        private int canUseNums;
        private int operationClassifyId;
        private long classifyDate;
        private int activityId;
        private Object activityName;
        private int saleNum;
        private Object classify;
        private Object specification;
        private List<String> bannerList;
        private List<InsuranceListBean> insuranceList;
        private List<SkusBean> skus;

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

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
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

        public int getShowPrice() {
            return showPrice;
        }

        public void setShowPrice(int showPrice) {
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

        public Object getPriceDay() {
            return priceDay;
        }

        public void setPriceDay(Object priceDay) {
            this.priceDay = priceDay;
        }

        public Object getPriceMonth() {
            return priceMonth;
        }

        public void setPriceMonth(Object priceMonth) {
            this.priceMonth = priceMonth;
        }

        public Object getOrderNums() {
            return orderNums;
        }

        public void setOrderNums(Object orderNums) {
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

        public int getOperationClassifyId() {
            return operationClassifyId;
        }

        public void setOperationClassifyId(int operationClassifyId) {
            this.operationClassifyId = operationClassifyId;
        }

        public long getClassifyDate() {
            return classifyDate;
        }

        public void setClassifyDate(long classifyDate) {
            this.classifyDate = classifyDate;
        }

        public int getActivityId() {
            return activityId;
        }

        public void setActivityId(int activityId) {
            this.activityId = activityId;
        }

        public Object getActivityName() {
            return activityName;
        }

        public void setActivityName(Object activityName) {
            this.activityName = activityName;
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

        public List<String> getBannerList() {
            return bannerList;
        }

        public void setBannerList(List<String> bannerList) {
            this.bannerList = bannerList;
        }

        public List<InsuranceListBean> getInsuranceList() {
            return insuranceList;
        }

        public void setInsuranceList(List<InsuranceListBean> insuranceList) {
            this.insuranceList = insuranceList;
        }

        public List<SkusBean> getSkus() {
            return skus;
        }

        public void setSkus(List<SkusBean> skus) {
            this.skus = skus;
        }

        public static class InsuranceListBean {
            /**
             * id : 8
             * productId : 14
             * name : 丢失险
             * money : 20
             * compensate : null
             * desc : 手机丢失
             * yn : false
             * createDate : 1539618870000
             * modifyDate : 1539618870000
             */

            private int id;
            private int productId;
            private String name;
            private int money;
            private Object compensate;
            private String desc;
            private boolean yn;
            private long createDate;
            private long modifyDate;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getName() {
                return name;
            }

            public void setName(String name) {
                this.name = name;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public Object getCompensate() {
                return compensate;
            }

            public void setCompensate(Object compensate) {
                this.compensate = compensate;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
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
        }

        public static class SkusBean {
            @Override
            public String toString() {
                return "SkusBean{" +
                        "id=" + id +
                        ", productId=" + productId +
                        ", attributes='" + attributes + '\'' +
                        ", deposit=" + deposit +
                        ", salePriceDay='" + salePriceDay + '\'' +
                        ", salePriceMonth=" + salePriceMonth +
                        ", yn=" + yn +
                        ", createDate=" + createDate +
                        ", modifyDate=" + modifyDate +
                        ", inventoryNum=" + inventoryNum +
                        ", attributesJson=" + attributesJson +
                        '}';
            }

            /**
             * id : 19
             * productId : 14
             * attributes : [{"key":"颜色","value":"白色"},{"key":"版本","value":"256G"}]
             * deposit : 6000
             * salePriceDay : {7:10,15:9,20:8}
             * salePriceMonth : null
             * yn : false
             * createDate : 1539618870000
             * modifyDate : 1539618870000
             * inventoryNum : null
             * attributesJson : [{"key":"颜色","value":"白色"},{"key":"版本","value":"256G"}]
             */

            private int id;
            private int productId;
            private String attributes;
            private int deposit;
            private String salePriceDay;
            private Object salePriceMonth;
            private boolean yn;
            private long createDate;
            private long modifyDate;
            private Object inventoryNum;
            private List<AttributesJsonBean> attributesJson;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public int getProductId() {
                return productId;
            }

            public void setProductId(int productId) {
                this.productId = productId;
            }

            public String getAttributes() {
                return attributes;
            }

            public void setAttributes(String attributes) {
                this.attributes = attributes;
            }

            public int getDeposit() {
                return deposit;
            }

            public void setDeposit(int deposit) {
                this.deposit = deposit;
            }

            public String getSalePriceDay() {
                return salePriceDay;
            }

            public void setSalePriceDay(String salePriceDay) {
                this.salePriceDay = salePriceDay;
            }

            public Object getSalePriceMonth() {
                return salePriceMonth;
            }

            public void setSalePriceMonth(Object salePriceMonth) {
                this.salePriceMonth = salePriceMonth;
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

            public Object getInventoryNum() {
                return inventoryNum;
            }

            public void setInventoryNum(Object inventoryNum) {
                this.inventoryNum = inventoryNum;
            }

            public List<AttributesJsonBean> getAttributesJson() {
                return attributesJson;
            }

            public void setAttributesJson(List<AttributesJsonBean> attributesJson) {
                this.attributesJson = attributesJson;
            }

            public static class AttributesJsonBean {
                /**
                 * key : 颜色
                 * value : 白色
                 */

                private String key;
                private String value;

                public String getKey() {
                    return key;
                }

                public void setKey(String key) {
                    this.key = key;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
