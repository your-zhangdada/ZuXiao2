package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class MyOrederBean {

    /**
     * code : 0
     * msg : ok
     * data : {"currPage":1,"totalRow":76,"totalPage":76,"list":[{"id":265,"orderNumber":"A820181103195301","userId":8,"nickname":"123","userMobile":"18813098218","merchantId":1,"merchantName":"cyy-test","platformFeeRate":0,"allMoney":70,"allPledge":1,"allInsuranceMoney":0,"allPostageMoney":0,"allPayMoney":null,"allDeductionMoney":null,"allDeductionPledge":0,"occupyCash":true,"beginDate":null,"endDate":null,"day":7,"activityId":-1,"postageType":1,"deliveryProvinceId":1,"deliveryProvinceName":"","deliveryCityId":1,"deliveryCityName":"","deliveryCountyId":1,"deliveryCountyName":"河北省","deliveryUsername":"高高","deliveryMobile":"18813098218","deliveryDetailAddress":"北京市海淀区","goExpress":null,"goExpressNumber":null,"goExpressDate":null,"goExpressRemark":null,"goExpressUserId":null,"goExpressNickname":null,"backExpress":null,"backExpressNumber":null,"backExpressDate":null,"backExpressRemark":null,"backExpressAddressId":null,"deductPledge":null,"deductPledgeRemark":null,"hasOverdue":false,"overdueMoney":0,"refundReason":null,"refundDesc":null,"refundDate":null,"refundRemark":null,"refundOperatorId":null,"refundOperatorNickname":null,"refundOperatorDate":null,"remark":"快点发货哈","status":1,"userYn":false,"merchantYn":false,"platformYn":false,"createDate":1541245981000,"modifyDate":1541245981000,"cancelReasonId":null,"cancelReason":null,"items":[{"id":246,"orderMasterId":265,"productId":24,"productName":"lzx的iPhonx19","productPic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/ba7244dc6d6b44f4a5ac208c9cd8533f.jpeg","skuId":34,"skuAttributes":"[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"版本\",\"value\":\"18\"},{\"key\":\"内存\",\"value\":\"50G\"},{\"key\":\"处理器\",\"value\":\"i10\"}]","skuPriceBack":"{7:10,15:9,20:8}","num":1,"money":10,"continueMoney":10,"pledge":1,"insuranceMoney":0,"yn":false,"createDate":1541245981000,"modifyDate":1541245981000,"insurances":null,"inventories":null}],"pays":null,"searchBeginDate":null,"searchEndDate":null,"stateName":"待支付","activity":null,"evaluateYn":null,"billYn":false,"saleRetYn":null,"invoiceId":null}]}
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
         * totalRow : 76
         * totalPage : 76
         * list : [{"id":265,"orderNumber":"A820181103195301","userId":8,"nickname":"123","userMobile":"18813098218","merchantId":1,"merchantName":"cyy-test","platformFeeRate":0,"allMoney":70,"allPledge":1,"allInsuranceMoney":0,"allPostageMoney":0,"allPayMoney":null,"allDeductionMoney":null,"allDeductionPledge":0,"occupyCash":true,"beginDate":null,"endDate":null,"day":7,"activityId":-1,"postageType":1,"deliveryProvinceId":1,"deliveryProvinceName":"","deliveryCityId":1,"deliveryCityName":"","deliveryCountyId":1,"deliveryCountyName":"河北省","deliveryUsername":"高高","deliveryMobile":"18813098218","deliveryDetailAddress":"北京市海淀区","goExpress":null,"goExpressNumber":null,"goExpressDate":null,"goExpressRemark":null,"goExpressUserId":null,"goExpressNickname":null,"backExpress":null,"backExpressNumber":null,"backExpressDate":null,"backExpressRemark":null,"backExpressAddressId":null,"deductPledge":null,"deductPledgeRemark":null,"hasOverdue":false,"overdueMoney":0,"refundReason":null,"refundDesc":null,"refundDate":null,"refundRemark":null,"refundOperatorId":null,"refundOperatorNickname":null,"refundOperatorDate":null,"remark":"快点发货哈","status":1,"userYn":false,"merchantYn":false,"platformYn":false,"createDate":1541245981000,"modifyDate":1541245981000,"cancelReasonId":null,"cancelReason":null,"items":[{"id":246,"orderMasterId":265,"productId":24,"productName":"lzx的iPhonx19","productPic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/ba7244dc6d6b44f4a5ac208c9cd8533f.jpeg","skuId":34,"skuAttributes":"[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"版本\",\"value\":\"18\"},{\"key\":\"内存\",\"value\":\"50G\"},{\"key\":\"处理器\",\"value\":\"i10\"}]","skuPriceBack":"{7:10,15:9,20:8}","num":1,"money":10,"continueMoney":10,"pledge":1,"insuranceMoney":0,"yn":false,"createDate":1541245981000,"modifyDate":1541245981000,"insurances":null,"inventories":null}],"pays":null,"searchBeginDate":null,"searchEndDate":null,"stateName":"待支付","activity":null,"evaluateYn":null,"billYn":false,"saleRetYn":null,"invoiceId":null}]
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
             * id : 265
             * orderNumber : A820181103195301
             * userId : 8
             * nickname : 123
             * userMobile : 18813098218
             * merchantId : 1
             * merchantName : cyy-test
             * platformFeeRate : 0
             * allMoney : 70
             * allPledge : 1
             * allInsuranceMoney : 0
             * allPostageMoney : 0
             * allPayMoney : null
             * allDeductionMoney : null
             * allDeductionPledge : 0
             * occupyCash : true
             * beginDate : null
             * endDate : null
             * day : 7
             * activityId : -1
             * postageType : 1
             * deliveryProvinceId : 1
             * deliveryProvinceName :
             * deliveryCityId : 1
             * deliveryCityName :
             * deliveryCountyId : 1
             * deliveryCountyName : 河北省
             * deliveryUsername : 高高
             * deliveryMobile : 18813098218
             * deliveryDetailAddress : 北京市海淀区
             * goExpress : null
             * goExpressNumber : null
             * goExpressDate : null
             * goExpressRemark : null
             * goExpressUserId : null
             * goExpressNickname : null
             * backExpress : null
             * backExpressNumber : null
             * backExpressDate : null
             * backExpressRemark : null
             * backExpressAddressId : null
             * deductPledge : null
             * deductPledgeRemark : null
             * hasOverdue : false
             * overdueMoney : 0
             * refundReason : null
             * refundDesc : null
             * refundDate : null
             * refundRemark : null
             * refundOperatorId : null
             * refundOperatorNickname : null
             * refundOperatorDate : null
             * remark : 快点发货哈
             * status : 1
             * userYn : false
             * merchantYn : false
             * platformYn : false
             * createDate : 1541245981000
             * modifyDate : 1541245981000
             * cancelReasonId : null
             * cancelReason : null
             * items : [{"id":246,"orderMasterId":265,"productId":24,"productName":"lzx的iPhonx19","productPic":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/ba7244dc6d6b44f4a5ac208c9cd8533f.jpeg","skuId":34,"skuAttributes":"[{\"key\":\"颜色\",\"value\":\"黑色\"},{\"key\":\"版本\",\"value\":\"18\"},{\"key\":\"内存\",\"value\":\"50G\"},{\"key\":\"处理器\",\"value\":\"i10\"}]","skuPriceBack":"{7:10,15:9,20:8}","num":1,"money":10,"continueMoney":10,"pledge":1,"insuranceMoney":0,"yn":false,"createDate":1541245981000,"modifyDate":1541245981000,"insurances":null,"inventories":null}]
             * pays : null
             * searchBeginDate : null
             * searchEndDate : null
             * stateName : 待支付
             * activity : null
             * evaluateYn : null
             * billYn : false
             * saleRetYn : null
             * invoiceId : null
             */

            private int id;
            private String orderNumber;
            private int userId;
            private String nickname;
            private String userMobile;
            private int merchantId;
            private String merchantName;
            private int platformFeeRate;
            private int allMoney;
            private int allPledge;
            private int allInsuranceMoney;
            private int allPostageMoney;
            private Object allPayMoney;
            private Object allDeductionMoney;
            private int allDeductionPledge;
            private boolean occupyCash;
            private Object beginDate;
            private Object endDate;
            private int day;
            private int activityId;
            private int postageType;
            private int deliveryProvinceId;
            private String deliveryProvinceName;
            private int deliveryCityId;
            private String deliveryCityName;
            private int deliveryCountyId;
            private String deliveryCountyName;
            private String deliveryUsername;
            private String deliveryMobile;
            private String deliveryDetailAddress;
            private Object goExpress;
            private Object goExpressNumber;
            private Object goExpressDate;
            private Object goExpressRemark;
            private Object goExpressUserId;
            private Object goExpressNickname;
            private Object backExpress;
            private Object backExpressNumber;
            private Object backExpressDate;
            private Object backExpressRemark;
            private Object backExpressAddressId;
            private Object deductPledge;
            private Object deductPledgeRemark;
            private boolean hasOverdue;
            private int overdueMoney;
            private Object refundReason;
            private Object refundDesc;
            private Object refundDate;
            private Object refundRemark;
            private Object refundOperatorId;
            private Object refundOperatorNickname;
            private Object refundOperatorDate;
            private String remark;
            private int status;
            private boolean userYn;
            private boolean merchantYn;
            private boolean platformYn;
            private long createDate;
            private long modifyDate;
            private Object cancelReasonId;
            private Object cancelReason;
            private Object pays;
            private Object searchBeginDate;
            private Object searchEndDate;
            private String stateName;
            private Object activity;
            private Object evaluateYn;
            private boolean billYn;
            private Object saleRetYn;
            private Object invoiceId;
            private List<ItemsBean> items;

            public int getId() {
                return id;
            }

            public void setId(int id) {
                this.id = id;
            }

            public String getOrderNumber() {
                return orderNumber;
            }

            public void setOrderNumber(String orderNumber) {
                this.orderNumber = orderNumber;
            }

            public int getUserId() {
                return userId;
            }

            public void setUserId(int userId) {
                this.userId = userId;
            }

            public String getNickname() {
                return nickname;
            }

            public void setNickname(String nickname) {
                this.nickname = nickname;
            }

            public String getUserMobile() {
                return userMobile;
            }

            public void setUserMobile(String userMobile) {
                this.userMobile = userMobile;
            }

            public int getMerchantId() {
                return merchantId;
            }

            public void setMerchantId(int merchantId) {
                this.merchantId = merchantId;
            }

            public String getMerchantName() {
                return merchantName;
            }

            public void setMerchantName(String merchantName) {
                this.merchantName = merchantName;
            }

            public int getPlatformFeeRate() {
                return platformFeeRate;
            }

            public void setPlatformFeeRate(int platformFeeRate) {
                this.platformFeeRate = platformFeeRate;
            }

            public int getAllMoney() {
                return allMoney;
            }

            public void setAllMoney(int allMoney) {
                this.allMoney = allMoney;
            }

            public int getAllPledge() {
                return allPledge;
            }

            public void setAllPledge(int allPledge) {
                this.allPledge = allPledge;
            }

            public int getAllInsuranceMoney() {
                return allInsuranceMoney;
            }

            public void setAllInsuranceMoney(int allInsuranceMoney) {
                this.allInsuranceMoney = allInsuranceMoney;
            }

            public int getAllPostageMoney() {
                return allPostageMoney;
            }

            public void setAllPostageMoney(int allPostageMoney) {
                this.allPostageMoney = allPostageMoney;
            }

            public Object getAllPayMoney() {
                return allPayMoney;
            }

            public void setAllPayMoney(Object allPayMoney) {
                this.allPayMoney = allPayMoney;
            }

            public Object getAllDeductionMoney() {
                return allDeductionMoney;
            }

            public void setAllDeductionMoney(Object allDeductionMoney) {
                this.allDeductionMoney = allDeductionMoney;
            }

            public int getAllDeductionPledge() {
                return allDeductionPledge;
            }

            public void setAllDeductionPledge(int allDeductionPledge) {
                this.allDeductionPledge = allDeductionPledge;
            }

            public boolean isOccupyCash() {
                return occupyCash;
            }

            public void setOccupyCash(boolean occupyCash) {
                this.occupyCash = occupyCash;
            }

            public Object getBeginDate() {
                return beginDate;
            }

            public void setBeginDate(Object beginDate) {
                this.beginDate = beginDate;
            }

            public Object getEndDate() {
                return endDate;
            }

            public void setEndDate(Object endDate) {
                this.endDate = endDate;
            }

            public int getDay() {
                return day;
            }

            public void setDay(int day) {
                this.day = day;
            }

            public int getActivityId() {
                return activityId;
            }

            public void setActivityId(int activityId) {
                this.activityId = activityId;
            }

            public int getPostageType() {
                return postageType;
            }

            public void setPostageType(int postageType) {
                this.postageType = postageType;
            }

            public int getDeliveryProvinceId() {
                return deliveryProvinceId;
            }

            public void setDeliveryProvinceId(int deliveryProvinceId) {
                this.deliveryProvinceId = deliveryProvinceId;
            }

            public String getDeliveryProvinceName() {
                return deliveryProvinceName;
            }

            public void setDeliveryProvinceName(String deliveryProvinceName) {
                this.deliveryProvinceName = deliveryProvinceName;
            }

            public int getDeliveryCityId() {
                return deliveryCityId;
            }

            public void setDeliveryCityId(int deliveryCityId) {
                this.deliveryCityId = deliveryCityId;
            }

            public String getDeliveryCityName() {
                return deliveryCityName;
            }

            public void setDeliveryCityName(String deliveryCityName) {
                this.deliveryCityName = deliveryCityName;
            }

            public int getDeliveryCountyId() {
                return deliveryCountyId;
            }

            public void setDeliveryCountyId(int deliveryCountyId) {
                this.deliveryCountyId = deliveryCountyId;
            }

            public String getDeliveryCountyName() {
                return deliveryCountyName;
            }

            public void setDeliveryCountyName(String deliveryCountyName) {
                this.deliveryCountyName = deliveryCountyName;
            }

            public String getDeliveryUsername() {
                return deliveryUsername;
            }

            public void setDeliveryUsername(String deliveryUsername) {
                this.deliveryUsername = deliveryUsername;
            }

            public String getDeliveryMobile() {
                return deliveryMobile;
            }

            public void setDeliveryMobile(String deliveryMobile) {
                this.deliveryMobile = deliveryMobile;
            }

            public String getDeliveryDetailAddress() {
                return deliveryDetailAddress;
            }

            public void setDeliveryDetailAddress(String deliveryDetailAddress) {
                this.deliveryDetailAddress = deliveryDetailAddress;
            }

            public Object getGoExpress() {
                return goExpress;
            }

            public void setGoExpress(Object goExpress) {
                this.goExpress = goExpress;
            }

            public Object getGoExpressNumber() {
                return goExpressNumber;
            }

            public void setGoExpressNumber(Object goExpressNumber) {
                this.goExpressNumber = goExpressNumber;
            }

            public Object getGoExpressDate() {
                return goExpressDate;
            }

            public void setGoExpressDate(Object goExpressDate) {
                this.goExpressDate = goExpressDate;
            }

            public Object getGoExpressRemark() {
                return goExpressRemark;
            }

            public void setGoExpressRemark(Object goExpressRemark) {
                this.goExpressRemark = goExpressRemark;
            }

            public Object getGoExpressUserId() {
                return goExpressUserId;
            }

            public void setGoExpressUserId(Object goExpressUserId) {
                this.goExpressUserId = goExpressUserId;
            }

            public Object getGoExpressNickname() {
                return goExpressNickname;
            }

            public void setGoExpressNickname(Object goExpressNickname) {
                this.goExpressNickname = goExpressNickname;
            }

            public Object getBackExpress() {
                return backExpress;
            }

            public void setBackExpress(Object backExpress) {
                this.backExpress = backExpress;
            }

            public Object getBackExpressNumber() {
                return backExpressNumber;
            }

            public void setBackExpressNumber(Object backExpressNumber) {
                this.backExpressNumber = backExpressNumber;
            }

            public Object getBackExpressDate() {
                return backExpressDate;
            }

            public void setBackExpressDate(Object backExpressDate) {
                this.backExpressDate = backExpressDate;
            }

            public Object getBackExpressRemark() {
                return backExpressRemark;
            }

            public void setBackExpressRemark(Object backExpressRemark) {
                this.backExpressRemark = backExpressRemark;
            }

            public Object getBackExpressAddressId() {
                return backExpressAddressId;
            }

            public void setBackExpressAddressId(Object backExpressAddressId) {
                this.backExpressAddressId = backExpressAddressId;
            }

            public Object getDeductPledge() {
                return deductPledge;
            }

            public void setDeductPledge(Object deductPledge) {
                this.deductPledge = deductPledge;
            }

            public Object getDeductPledgeRemark() {
                return deductPledgeRemark;
            }

            public void setDeductPledgeRemark(Object deductPledgeRemark) {
                this.deductPledgeRemark = deductPledgeRemark;
            }

            public boolean isHasOverdue() {
                return hasOverdue;
            }

            public void setHasOverdue(boolean hasOverdue) {
                this.hasOverdue = hasOverdue;
            }

            public int getOverdueMoney() {
                return overdueMoney;
            }

            public void setOverdueMoney(int overdueMoney) {
                this.overdueMoney = overdueMoney;
            }

            public Object getRefundReason() {
                return refundReason;
            }

            public void setRefundReason(Object refundReason) {
                this.refundReason = refundReason;
            }

            public Object getRefundDesc() {
                return refundDesc;
            }

            public void setRefundDesc(Object refundDesc) {
                this.refundDesc = refundDesc;
            }

            public Object getRefundDate() {
                return refundDate;
            }

            public void setRefundDate(Object refundDate) {
                this.refundDate = refundDate;
            }

            public Object getRefundRemark() {
                return refundRemark;
            }

            public void setRefundRemark(Object refundRemark) {
                this.refundRemark = refundRemark;
            }

            public Object getRefundOperatorId() {
                return refundOperatorId;
            }

            public void setRefundOperatorId(Object refundOperatorId) {
                this.refundOperatorId = refundOperatorId;
            }

            public Object getRefundOperatorNickname() {
                return refundOperatorNickname;
            }

            public void setRefundOperatorNickname(Object refundOperatorNickname) {
                this.refundOperatorNickname = refundOperatorNickname;
            }

            public Object getRefundOperatorDate() {
                return refundOperatorDate;
            }

            public void setRefundOperatorDate(Object refundOperatorDate) {
                this.refundOperatorDate = refundOperatorDate;
            }

            public String getRemark() {
                return remark;
            }

            public void setRemark(String remark) {
                this.remark = remark;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }

            public boolean isUserYn() {
                return userYn;
            }

            public void setUserYn(boolean userYn) {
                this.userYn = userYn;
            }

            public boolean isMerchantYn() {
                return merchantYn;
            }

            public void setMerchantYn(boolean merchantYn) {
                this.merchantYn = merchantYn;
            }

            public boolean isPlatformYn() {
                return platformYn;
            }

            public void setPlatformYn(boolean platformYn) {
                this.platformYn = platformYn;
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

            public Object getCancelReasonId() {
                return cancelReasonId;
            }

            public void setCancelReasonId(Object cancelReasonId) {
                this.cancelReasonId = cancelReasonId;
            }

            public Object getCancelReason() {
                return cancelReason;
            }

            public void setCancelReason(Object cancelReason) {
                this.cancelReason = cancelReason;
            }

            public Object getPays() {
                return pays;
            }

            public void setPays(Object pays) {
                this.pays = pays;
            }

            public Object getSearchBeginDate() {
                return searchBeginDate;
            }

            public void setSearchBeginDate(Object searchBeginDate) {
                this.searchBeginDate = searchBeginDate;
            }

            public Object getSearchEndDate() {
                return searchEndDate;
            }

            public void setSearchEndDate(Object searchEndDate) {
                this.searchEndDate = searchEndDate;
            }

            public String getStateName() {
                return stateName;
            }

            public void setStateName(String stateName) {
                this.stateName = stateName;
            }

            public Object getActivity() {
                return activity;
            }

            public void setActivity(Object activity) {
                this.activity = activity;
            }

            public Object getEvaluateYn() {
                return evaluateYn;
            }

            public void setEvaluateYn(Object evaluateYn) {
                this.evaluateYn = evaluateYn;
            }

            public boolean isBillYn() {
                return billYn;
            }

            public void setBillYn(boolean billYn) {
                this.billYn = billYn;
            }

            public Object getSaleRetYn() {
                return saleRetYn;
            }

            public void setSaleRetYn(Object saleRetYn) {
                this.saleRetYn = saleRetYn;
            }

            public Object getInvoiceId() {
                return invoiceId;
            }

            public void setInvoiceId(Object invoiceId) {
                this.invoiceId = invoiceId;
            }

            public List<ItemsBean> getItems() {
                return items;
            }

            public void setItems(List<ItemsBean> items) {
                this.items = items;
            }

            public static class ItemsBean {
                /**
                 * id : 246
                 * orderMasterId : 265
                 * productId : 24
                 * productName : lzx的iPhonx19
                 * productPic : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/19/ba7244dc6d6b44f4a5ac208c9cd8533f.jpeg
                 * skuId : 34
                 * skuAttributes : [{"key":"颜色","value":"黑色"},{"key":"版本","value":"18"},{"key":"内存","value":"50G"},{"key":"处理器","value":"i10"}]
                 * skuPriceBack : {7:10,15:9,20:8}
                 * num : 1
                 * money : 10
                 * continueMoney : 10
                 * pledge : 1
                 * insuranceMoney : 0
                 * yn : false
                 * createDate : 1541245981000
                 * modifyDate : 1541245981000
                 * insurances : null
                 * inventories : null
                 */

                private int id;
                private int orderMasterId;
                private int productId;
                private String productName;
                private String productPic;
                private int skuId;
                private String skuAttributes;
                private String skuPriceBack;
                private int num;
                private int money;
                private int continueMoney;
                private int pledge;
                private int insuranceMoney;
                private boolean yn;
                private long createDate;
                private long modifyDate;
                private Object insurances;
                private Object inventories;

                public int getId() {
                    return id;
                }

                public void setId(int id) {
                    this.id = id;
                }

                public int getOrderMasterId() {
                    return orderMasterId;
                }

                public void setOrderMasterId(int orderMasterId) {
                    this.orderMasterId = orderMasterId;
                }

                public int getProductId() {
                    return productId;
                }

                public void setProductId(int productId) {
                    this.productId = productId;
                }

                public String getProductName() {
                    return productName;
                }

                public void setProductName(String productName) {
                    this.productName = productName;
                }

                public String getProductPic() {
                    return productPic;
                }

                public void setProductPic(String productPic) {
                    this.productPic = productPic;
                }

                public int getSkuId() {
                    return skuId;
                }

                public void setSkuId(int skuId) {
                    this.skuId = skuId;
                }

                public String getSkuAttributes() {
                    return skuAttributes;
                }

                public void setSkuAttributes(String skuAttributes) {
                    this.skuAttributes = skuAttributes;
                }

                public String getSkuPriceBack() {
                    return skuPriceBack;
                }

                public void setSkuPriceBack(String skuPriceBack) {
                    this.skuPriceBack = skuPriceBack;
                }

                public int getNum() {
                    return num;
                }

                public void setNum(int num) {
                    this.num = num;
                }

                public int getMoney() {
                    return money;
                }

                public void setMoney(int money) {
                    this.money = money;
                }

                public int getContinueMoney() {
                    return continueMoney;
                }

                public void setContinueMoney(int continueMoney) {
                    this.continueMoney = continueMoney;
                }

                public int getPledge() {
                    return pledge;
                }

                public void setPledge(int pledge) {
                    this.pledge = pledge;
                }

                public int getInsuranceMoney() {
                    return insuranceMoney;
                }

                public void setInsuranceMoney(int insuranceMoney) {
                    this.insuranceMoney = insuranceMoney;
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

                public Object getInsurances() {
                    return insurances;
                }

                public void setInsurances(Object insurances) {
                    this.insurances = insurances;
                }

                public Object getInventories() {
                    return inventories;
                }

                public void setInventories(Object inventories) {
                    this.inventories = inventories;
                }
            }
        }
    }
}
