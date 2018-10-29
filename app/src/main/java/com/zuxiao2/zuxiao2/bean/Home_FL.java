package com.zuxiao2.zuxiao2.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：wanglong on 18/10/19.
 * 邮箱：wanglong128@aliyun.com
 * 版本：v1.0
 */
public class Home_FL implements Serializable {
    @Override
    public String toString() {
        return "Home_FL{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**  首页商品分类
     * code : 0
     * msg : ok
     * data : {"currPage":1,"totalRow":3,"totalPage":1,"list":[{"id":22,"name":"lzx的产品","describe":"lzx的描述","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/a614fbc7c4d6466fb124a6626d4bb050.jpeg","bannerList":null,"tag":"好玩,好吃,好喝","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/446d542d218e4b63bbae7bb2657be690.txt","provinceId":515,"cityId":516,"sellerId":1,"merchantName":null,"brandId":1,"brandName":null,"userId":1,"showPriceType":1,"showPrice":0.01,"postageType":1,"postageMoney":0,"quality":100,"status":1,"stateName":"上架","yn":false,"createDate":1539914642000,"modifyDate":1539914729000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":60,"operationClassifyId":100,"classifyDate":1539914729000,"saleNum":0,"classify":null,"specification":null,"skus":null},{"id":16,"name":"阿道夫","describe":"水电费","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/52ab7b704c254a8f912813b69031a011.jpg","bannerList":null,"tag":"水电费","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/075873983a5c4d11814acb79d7922b73.txt","provinceId":868,"cityId":902,"sellerId":1,"merchantName":null,"brandId":9,"brandName":null,"userId":1,"showPriceType":1,"showPrice":34,"postageType":1,"postageMoney":0,"quality":100,"status":1,"stateName":"上架","yn":false,"createDate":1539699227000,"modifyDate":1539826839000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":1,"operationClassifyId":100,"classifyDate":1539826839000,"saleNum":0,"classify":null,"specification":null,"skus":null},{"id":15,"name":"sdf","describe":"sdfdsf","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/5432fcdcc91240feb44f5e82f6520252.jpg","bannerList":null,"tag":"sdf","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/2397a38462f7474e84bb520c0987f989.txt","provinceId":515,"cityId":616,"sellerId":1,"merchantName":null,"brandId":3,"brandName":null,"userId":1,"showPriceType":1,"showPrice":25,"postageType":1,"postageMoney":23,"quality":100,"status":1,"stateName":"上架","yn":false,"createDate":1539699041000,"modifyDate":1539826828000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":1,"operationClassifyId":100,"classifyDate":1539826828000,"saleNum":0,"classify":null,"specification":null,"skus":null}]}
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
                    "currPage=" + currPage +
                    ", totalRow=" + totalRow +
                    ", totalPage=" + totalPage +
                    ", list=" + list +
                    '}';
        }

        /**
         * currPage : 1
         * totalRow : 3
         * totalPage : 1
         * list : [{"id":22,"name":"lzx的产品","describe":"lzx的描述","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/a614fbc7c4d6466fb124a6626d4bb050.jpeg","bannerList":null,"tag":"好玩,好吃,好喝","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/446d542d218e4b63bbae7bb2657be690.txt","provinceId":515,"cityId":516,"sellerId":1,"merchantName":null,"brandId":1,"brandName":null,"userId":1,"showPriceType":1,"showPrice":0.01,"postageType":1,"postageMoney":0,"quality":100,"status":1,"stateName":"上架","yn":false,"createDate":1539914642000,"modifyDate":1539914729000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":60,"operationClassifyId":100,"classifyDate":1539914729000,"saleNum":0,"classify":null,"specification":null,"skus":null},{"id":16,"name":"阿道夫","describe":"水电费","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/52ab7b704c254a8f912813b69031a011.jpg","bannerList":null,"tag":"水电费","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/075873983a5c4d11814acb79d7922b73.txt","provinceId":868,"cityId":902,"sellerId":1,"merchantName":null,"brandId":9,"brandName":null,"userId":1,"showPriceType":1,"showPrice":34,"postageType":1,"postageMoney":0,"quality":100,"status":1,"stateName":"上架","yn":false,"createDate":1539699227000,"modifyDate":1539826839000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":1,"operationClassifyId":100,"classifyDate":1539826839000,"saleNum":0,"classify":null,"specification":null,"skus":null},{"id":15,"name":"sdf","describe":"sdfdsf","pic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/5432fcdcc91240feb44f5e82f6520252.jpg","bannerList":null,"tag":"sdf","contentUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/16/2397a38462f7474e84bb520c0987f989.txt","provinceId":515,"cityId":616,"sellerId":1,"merchantName":null,"brandId":3,"brandName":null,"userId":1,"showPriceType":1,"showPrice":25,"postageType":1,"postageMoney":23,"quality":100,"status":1,"stateName":"上架","yn":false,"createDate":1539699041000,"modifyDate":1539826828000,"priceDay":null,"priceMonth":null,"orderNums":null,"transportType":null,"canUseNums":1,"operationClassifyId":100,"classifyDate":1539826828000,"saleNum":0,"classify":null,"specification":null,"skus":null}]
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

        public static class ListBean   implements Serializable{
            @Override
            public String toString() {
                return "ListBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", describe='" + describe + '\'' +
                        ", pic='" + pic + '\'' +
                        ", bannerList=" + bannerList +
                        ", tag='" + tag + '\'' +
                        ", contentUrl='" + contentUrl + '\'' +
                        ", provinceId=" + provinceId +
                        ", provinceName='" + provinceName + '\'' +
                        ", cityId=" + cityId +
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
                        ", stateName='" + stateName + '\'' +
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
                        ", saleNum=" + saleNum +
                        ", classify=" + classify +
                        ", specification=" + specification +
                        ", skus=" + skus +
                        '}';
            }

            /**
             * id : 22
             * name : lzx的产品
             * describe : lzx的描述
             * pic : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/a614fbc7c4d6466fb124a6626d4bb050.jpeg
             * bannerList : null
             * tag : 好玩,好吃,好喝
             * contentUrl : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/446d542d218e4b63bbae7bb2657be690.txt
             * provinceId : 515
             * cityId : 516
             * sellerId : 1
             * merchantName : null
             * brandId : 1
             * brandName : null
             * userId : 1
             * showPriceType : 1
             * showPrice : 0.01
             * postageType : 1
             * postageMoney : 0
             * quality : 100
             * status : 1
             * stateName : 上架
             * yn : false
             * createDate : 1539914642000
             * modifyDate : 1539914729000
             * priceDay : null
             * priceMonth : null
             * orderNums : null
             * transportType : null
             * canUseNums : 60
             * operationClassifyId : 100
             * classifyDate : 1539914729000
             * saleNum : 0
             * classify : null
             * specification : null
             * skus : null
             */

            private int id;
            private String name;
            private String describe;
            private String pic;
            private Object bannerList;
            private String tag;
            private String contentUrl;
            private int provinceId;
            private String provinceName;
            private int cityId;
            private int sellerId;
            private Object merchantName;
            private int brandId;
            private Object brandName;
            private int userId;
            private int showPriceType;
            private double showPrice;
            private int postageType;
            private int postageMoney;
            private int quality;
            private int status;
            private String stateName;
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
            private int saleNum;
            private Object classify;
            private Object specification;
            private Object skus;

            public String getProvinceName(){
                return provinceName;
            }

            public void setProvinceName(String provinceName){
                this.provinceName = provinceName;
            }

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

            public int getCityId() {
                return cityId;
            }

            public void setCityId(int cityId) {
                this.cityId = cityId;
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

            public String getStateName() {
                return stateName;
            }

            public void setStateName(String stateName) {
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
        }
    }
}
