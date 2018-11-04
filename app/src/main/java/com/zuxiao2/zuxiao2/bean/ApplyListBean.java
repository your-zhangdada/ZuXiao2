package com.zuxiao2.zuxiao2.bean;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ApplyListBean {

    @Override
    public String toString() {
        return "ApplyListBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**  认证列表
     * code : 0
     * msg : ok
     * data : {"authTypeLast":[{"1":0,"name":"身份证认证","id":44,"typeLast":1,"status":0}],"authType":1}
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
        @Override
        public String toString() {
            return "DataBean{" +
                    "authType=" + authType +
                    ", authTypeLast=" + authTypeLast +
                    '}';
        }

        /**
         * authTypeLast : [{"1":0,"name":"身份证认证","id":44,"typeLast":1,"status":0}]
         * authType : 1
         */

        private int authType;
        private List<AuthTypeLastBean> authTypeLast;

        public int getAuthType() {
            return authType;
        }

        public void setAuthType(int authType) {
            this.authType = authType;
        }

        public List<AuthTypeLastBean> getAuthTypeLast() {
            return authTypeLast;
        }

        public void setAuthTypeLast(List<AuthTypeLastBean> authTypeLast) {
            this.authTypeLast = authTypeLast;
        }

        public static class AuthTypeLastBean {
            @Override
            public String toString() {
                return "AuthTypeLastBean{" +
                        "_$1=" + _$1 +
                        ", name='" + name + '\'' +
                        ", id=" + id +
                        ", typeLast=" + typeLast +
                        ", status=" + status +
                        '}';
            }

            /**
             * 1 : 0
             * name : 身份证认证
             * id : 44
             * typeLast : 1
             * status : 0
             */

            @SerializedName("1")
            private int _$1;
            private String name;
            private int id;
            private int typeLast;
            private int status;

            public int get_$1() {
                return _$1;
            }

            public void set_$1(int _$1) {
                this._$1 = _$1;
            }

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

            public int getTypeLast() {
                return typeLast;
            }

            public void setTypeLast(int typeLast) {
                this.typeLast = typeLast;
            }

            public int getStatus() {
                return status;
            }

            public void setStatus(int status) {
                this.status = status;
            }
        }
    }
}
