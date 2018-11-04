package com.zuxiao2.zuxiao2.bean;

import com.google.gson.annotations.SerializedName;

public class WXPayBean {

    /**
     * code : 0
     * msg : ok
     * data : {"paySuccess":false,"wxpay":true,"data":{"package":"Sign=WXPay","appid":"wx4c9a02ded1109d75","sign":"6D5652BE5F2B9FCCB130805221ED0103","partnerid":"1513949331","prepayid":"wx0213553613270051388b04ba2579159061","noncestr":"ce898c0c1ee54e63a27aa145c9d13d27","timestamp":"1541138136"},"msg":"ok"}
     */

    private String code;
    private String msg;
    private DataBeanX data;

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

    public DataBeanX getData() {
        return data;
    }

    public void setData(DataBeanX data) {
        this.data = data;
    }

    public static class DataBeanX {
        /**
         * paySuccess : false
         * wxpay : true
         * data : {"package":"Sign=WXPay","appid":"wx4c9a02ded1109d75","sign":"6D5652BE5F2B9FCCB130805221ED0103","partnerid":"1513949331","prepayid":"wx0213553613270051388b04ba2579159061","noncestr":"ce898c0c1ee54e63a27aa145c9d13d27","timestamp":"1541138136"}
         * msg : ok
         */

        private boolean paySuccess;
        private boolean wxpay;
        private DataBean data;
        private String msg;

        public boolean isPaySuccess() {
            return paySuccess;
        }

        public void setPaySuccess(boolean paySuccess) {
            this.paySuccess = paySuccess;
        }

        public boolean isWxpay() {
            return wxpay;
        }

        public void setWxpay(boolean wxpay) {
            this.wxpay = wxpay;
        }

        public DataBean getData() {
            return data;
        }

        public void setData(DataBean data) {
            this.data = data;
        }

        public String getMsg() {
            return msg;
        }

        public void setMsg(String msg) {
            this.msg = msg;
        }

        public static class DataBean {
            /**
             * package : Sign=WXPay
             * appid : wx4c9a02ded1109d75
             * sign : 6D5652BE5F2B9FCCB130805221ED0103
             * partnerid : 1513949331
             * prepayid : wx0213553613270051388b04ba2579159061
             * noncestr : ce898c0c1ee54e63a27aa145c9d13d27
             * timestamp : 1541138136
             */

            @SerializedName("package")
            private String packageX;
            private String appid;
            private String sign;
            private String partnerid;
            private String prepayid;
            private String noncestr;
            private String timestamp;

            public String getPackageX() {
                return packageX;
            }

            public void setPackageX(String packageX) {
                this.packageX = packageX;
            }

            public String getAppid() {
                return appid;
            }

            public void setAppid(String appid) {
                this.appid = appid;
            }

            public String getSign() {
                return sign;
            }

            public void setSign(String sign) {
                this.sign = sign;
            }

            public String getPartnerid() {
                return partnerid;
            }

            public void setPartnerid(String partnerid) {
                this.partnerid = partnerid;
            }

            public String getPrepayid() {
                return prepayid;
            }

            public void setPrepayid(String prepayid) {
                this.prepayid = prepayid;
            }

            public String getNoncestr() {
                return noncestr;
            }

            public void setNoncestr(String noncestr) {
                this.noncestr = noncestr;
            }

            public String getTimestamp() {
                return timestamp;
            }

            public void setTimestamp(String timestamp) {
                this.timestamp = timestamp;
            }
        }
    }
}
