package com.zuxiao2.zuxiao2.bean;

import java.util.List;

/**
 * 作者：wanglong on 18/10/18.
 * 邮箱：wanglong128@aliyun.com
 * 版本：v1.0
 */
public class Home_huodong {

    /**
     * code : 0
     * msg : ok
     * data : [{"id":100,"name":"苹果专区","sort":1},{"id":200,"name":"办公设备","sort":2},{"id":300,"name":"智能酷玩","sort":3}]
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
         * id : 100
         * name : 苹果专区
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
