package com.zuxiao2.zuxiao2.bean;

import java.util.List;

/**
 * 作者：wanglong on 18/10/17.
 * 邮箱：wanglong128@aliyun.com
 * 版本：v1.0
 */
public class BannerBean {

    /**
     * code : 0
     * msg : ok
     * data : [{"id":14,"title":"耳机","picUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/c2905beb45b4436c83272bbf28bfd6ea.png","href":"www.zux2.com","type":"app","yn":false,"createDate":1539768026000,"modifyDate":1539768026000},{"id":13,"title":"手机","picUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/94b1e579f29c4f21ba9e85f32225c8c0.png","href":"www.zux2.com","type":"app","yn":false,"createDate":1539768009000,"modifyDate":1539768009000},{"id":12,"title":"电脑","picUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/f18b771dc91a48888575d323b4f97f29.png","href":"www.zux2.com","type":"app","yn":false,"createDate":1539767999000,"modifyDate":1539767999000},{"id":11,"title":"耳机","picUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/0d220578dec54519a08361e470d815b1.png","href":"www.zux2.com","type":"app","yn":false,"createDate":1539767977000,"modifyDate":1539767977000},{"id":10,"title":"小米笔记本","picUrl":"https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/80add80d187a4f28b097698bd09b1327.png","href":"www.zux2.com","type":"app","yn":false,"createDate":1539767950000,"modifyDate":1539767950000}]
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
         * id : 14
         * title : 耳机
         * picUrl : https://zux2.oss-cn-beijing.aliyuncs.com/2018/10/17/c2905beb45b4436c83272bbf28bfd6ea.png
         * href : www.zux2.com
         * type : app
         * yn : false
         * createDate : 1539768026000
         * modifyDate : 1539768026000
         */

        private int id;
        private String title;
        private String picUrl;
        private String href;
        private String type;
        private boolean yn;
        private long createDate;
        private long modifyDate;

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getPicUrl() {
            return picUrl;
        }

        public void setPicUrl(String picUrl) {
            this.picUrl = picUrl;
        }

        public String getHref() {
            return href;
        }

        public void setHref(String href) {
            this.href = href;
        }

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
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
}
