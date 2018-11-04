package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class HotListBean {

    /**
     * code : 0
     * msg : ok
     * data : [{"id":1,"name":"iphoneXs","sort":1},{"id":2,"name":"无限蓝牙耳机","sort":2},{"id":3,"name":"电话手表","sort":3},{"id":4,"name":"小天才电话手表Z5智能","sort":4},{"id":5,"name":"小天才电话手表Z5","sort":5}]
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
         * id : 1
         * name : iphoneXs
         * sort : 1
         */

        private int id;
        private String name;
        private int sort;

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

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
        }
    }
}
