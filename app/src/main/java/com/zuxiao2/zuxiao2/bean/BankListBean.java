package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class BankListBean {

    @Override
    public String toString() {
        return "BankListBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * msg : ok
     * data : [{"id":13,"userId":31,"type":null,"typeName":null,"cardNumber":"102033234567897654","hasDefault":true,"status":1,"createDate":1541481952000,"modifyDate":1541481952000,"cardMaster":"高高","merchantId":null}]
     */

    private String code;
    private String msg;
    private List<DataBean> data;

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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * id : 13
         * userId : 31
         * type : null
         * typeName : null
         * cardNumber : 102033234567897654
         * hasDefault : true
         * status : 1
         * createDate : 1541481952000
         * modifyDate : 1541481952000
         * cardMaster : 高高
         * merchantId : null
         */

        private int id;
        private int userId;
        private Object type;
        private Object typeName;
        private String cardNumber;
        private boolean hasDefault;
        private int status;
        private long createDate;
        private long modifyDate;
        private String cardMaster;
        private Object merchantId;

        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", userId=" + userId +
                    ", type=" + type +
                    ", typeName=" + typeName +
                    ", cardNumber='" + cardNumber + '\'' +
                    ", hasDefault=" + hasDefault +
                    ", status=" + status +
                    ", createDate=" + createDate +
                    ", modifyDate=" + modifyDate +
                    ", cardMaster='" + cardMaster + '\'' +
                    ", merchantId=" + merchantId +
                    '}';
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getType() {
            return type;
        }

        public void setType(Object type) {
            this.type = type;
        }

        public Object getTypeName() {
            return typeName;
        }

        public void setTypeName(Object typeName) {
            this.typeName = typeName;
        }

        public String getCardNumber() {
            return cardNumber;
        }

        public void setCardNumber(String cardNumber) {
            this.cardNumber = cardNumber;
        }

        public boolean isHasDefault() {
            return hasDefault;
        }

        public void setHasDefault(boolean hasDefault) {
            this.hasDefault = hasDefault;
        }

        public int getStatus() {
            return status;
        }

        public void setStatus(int status) {
            this.status = status;
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

        public String getCardMaster() {
            return cardMaster;
        }

        public void setCardMaster(String cardMaster) {
            this.cardMaster = cardMaster;
        }

        public Object getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(Object merchantId) {
            this.merchantId = merchantId;
        }
    }
}
