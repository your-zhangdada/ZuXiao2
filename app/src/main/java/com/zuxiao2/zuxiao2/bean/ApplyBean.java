package com.zuxiao2.zuxiao2.bean;

public class ApplyBean {
//认证
    /**
     * code : 0
     * msg : ok
     * data : null
     */

    private String code;
    private String msg;
    private Object data;

    @Override
    public String toString() {
        return "ApplyBean{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
