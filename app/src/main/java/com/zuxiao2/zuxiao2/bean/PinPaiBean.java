package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class PinPaiBean {


    /**
     * code : 0
     * msg : ok
     * data : [{"id":12,"name":"iphoneX","logoUrl":"","sort":1,"yn":false,"createDate":1539921714000,"modifyDate":1539921714000,"searchClassifyId":null,"likeName":null},{"id":9,"name":"小米","logoUrl":"","sort":1,"yn":false,"createDate":1539525393000,"modifyDate":1539525393000,"searchClassifyId":null,"likeName":null},{"id":8,"name":"三星","logoUrl":"","sort":1,"yn":false,"createDate":1539525378000,"modifyDate":1539525378000,"searchClassifyId":null,"likeName":null}]
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
         * id : 12
         * name : iphoneX
         * logoUrl :
         * sort : 1
         * yn : false
         * createDate : 1539921714000
         * modifyDate : 1539921714000
         * searchClassifyId : null
         * likeName : null
         */

        private int id;
        private String name;
        private String logoUrl;
        private int sort;
        private boolean yn;
        private long createDate;
        private long modifyDate;
        private Object searchClassifyId;
        private Object likeName;

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

        public String getLogoUrl() {
            return logoUrl;
        }

        public void setLogoUrl(String logoUrl) {
            this.logoUrl = logoUrl;
        }

        public int getSort() {
            return sort;
        }

        public void setSort(int sort) {
            this.sort = sort;
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

        public Object getSearchClassifyId() {
            return searchClassifyId;
        }

        public void setSearchClassifyId(Object searchClassifyId) {
            this.searchClassifyId = searchClassifyId;
        }

        public Object getLikeName() {
            return likeName;
        }

        public void setLikeName(Object likeName) {
            this.likeName = likeName;
        }
    }
}
