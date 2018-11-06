package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class MoneyBean {

    /**
     * code : 0
     * msg : ok
     * data : {"currPage":1,"totalRow":1,"totalPage":1,"list":[{"id":105,"userId":31,"type":1,"sourceType":null,"sourceId":334,"money":-8639,"desc":"订单A3120181106154736支付","createDate":1541490472000,"modifyDate":1541490472000}]}
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
         * totalRow : 1
         * totalPage : 1
         * list : [{"id":105,"userId":31,"type":1,"sourceType":null,"sourceId":334,"money":-8639,"desc":"订单A3120181106154736支付","createDate":1541490472000,"modifyDate":1541490472000}]
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
             * id : 105
             * userId : 31
             * type : 1
             * sourceType : null
             * sourceId : 334
             * money : -8639
             * desc : 订单A3120181106154736支付
             * createDate : 1541490472000
             * modifyDate : 1541490472000
             */

            private int id;
            private int userId;
            private int type;
            private Object sourceType;
            private int sourceId;
            private int money;
            private String desc;
            private long createDate;
            private long modifyDate;

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

            public int getType() {
                return type;
            }

            public void setType(int type) {
                this.type = type;
            }

            public Object getSourceType() {
                return sourceType;
            }

            public void setSourceType(Object sourceType) {
                this.sourceType = sourceType;
            }

            public int getSourceId() {
                return sourceId;
            }

            public void setSourceId(int sourceId) {
                this.sourceId = sourceId;
            }

            public int getMoney() {
                return money;
            }

            public void setMoney(int money) {
                this.money = money;
            }

            public String getDesc() {
                return desc;
            }

            public void setDesc(String desc) {
                this.desc = desc;
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
}
