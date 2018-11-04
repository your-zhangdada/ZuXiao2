package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class OrderTabBean {


    /**
     * code : 0
     * msg : ok
     * data : [{"name":"待支付","id":1},{"name":"待发货","id":2},{"name":"待收货","id":3},{"name":"租赁中","id":4},{"name":"待归还","id":5},{"name":"待商家收货","id":6},{"name":"待商家退押金","id":7},{"name":"已完成","id":8},{"name":"退货售后","id":10}]
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
         * name : 待支付
         * id : 1
         */

        private String name;
        private int id;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }
    }
}
