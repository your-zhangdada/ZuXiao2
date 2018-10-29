package com.zuxiao2.zuxiao2.bean;

import java.io.Serializable;
import java.util.List;

public class SHDZ_Bean implements Serializable{

    /**
     * code : 0
     * msg : ok
     * data : [{"id":17,"userId":8,"provinceId":1,"provinceName":"","cityId":1,"cityName":"","countyId":1,"countyName":"河北省","detailAddress":"北京市海淀区","linkPerson":"高高","linkPhone":"18813098218","hasDefault":true,"yn":false,"createDate":1540534198000,"modifyDate":1540534198000},{"id":16,"userId":8,"provinceId":1,"provinceName":"","cityId":1,"cityName":"","countyId":1,"countyName":"河北省","detailAddress":"北京市海淀区","linkPerson":"高高","linkPhone":"18813098218","hasDefault":true,"yn":false,"createDate":1540534178000,"modifyDate":1540534178000}]
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

    public static class DataBean implements Serializable {
        /**
         * id : 17
         * userId : 8
         * provinceId : 1
         * provinceName :
         * cityId : 1
         * cityName :
         * countyId : 1
         * countyName : 河北省
         * detailAddress : 北京市海淀区
         * linkPerson : 高高
         * linkPhone : 18813098218
         * hasDefault : true
         * yn : false
         * createDate : 1540534198000
         * modifyDate : 1540534198000
         */

        private int id;
        private int userId;
        private int provinceId;
        private String provinceName;
        private int cityId;
        private String cityName;
        private int countyId;
        private String countyName;
        private String detailAddress;
        private String linkPerson;
        private String linkPhone;
        private boolean hasDefault;
        private boolean yn;
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

        public int getProvinceId() {
            return provinceId;
        }

        public void setProvinceId(int provinceId) {
            this.provinceId = provinceId;
        }

        public String getProvinceName() {
            return provinceName;
        }

        public void setProvinceName(String provinceName) {
            this.provinceName = provinceName;
        }

        public int getCityId() {
            return cityId;
        }

        public void setCityId(int cityId) {
            this.cityId = cityId;
        }

        public String getCityName() {
            return cityName;
        }

        public void setCityName(String cityName) {
            this.cityName = cityName;
        }

        public int getCountyId() {
            return countyId;
        }

        public void setCountyId(int countyId) {
            this.countyId = countyId;
        }

        public String getCountyName() {
            return countyName;
        }

        public void setCountyName(String countyName) {
            this.countyName = countyName;
        }

        public String getDetailAddress() {
            return detailAddress;
        }

        public void setDetailAddress(String detailAddress) {
            this.detailAddress = detailAddress;
        }

        public String getLinkPerson() {
            return linkPerson;
        }

        public void setLinkPerson(String linkPerson) {
            this.linkPerson = linkPerson;
        }

        public String getLinkPhone() {
            return linkPhone;
        }

        public void setLinkPhone(String linkPhone) {
            this.linkPhone = linkPhone;
        }

        public boolean isHasDefault() {
            return hasDefault;
        }

        public void setHasDefault(boolean hasDefault) {
            this.hasDefault = hasDefault;
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
