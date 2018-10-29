package com.zuxiao2.zuxiao2.bean;

public class Password {


    /**
     * code : 0
     * msg : ok 登录成功
     * data : {"key":"dd4ec040098e4abd9445a1cb7c6dcc9d","userId":8,"merchantId":null,"roleId":null,"nickname":"123","gender":null,"photoUrl":"","phoneNumber":"18813098218","email":null}
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
         * key : dd4ec040098e4abd9445a1cb7c6dcc9d
         * userId : 8
         * merchantId : null
         * roleId : null
         * nickname : 123
         * gender : null
         * photoUrl :
         * phoneNumber : 18813098218
         * email : null
         */

        private String key;
        private int userId;
        private Object merchantId;
        private Object roleId;
        private String nickname;
        private Object gender;
        private String photoUrl;
        private String phoneNumber;
        private Object email;

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            this.key = key;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public Object getMerchantId() {
            return merchantId;
        }

        public void setMerchantId(Object merchantId) {
            this.merchantId = merchantId;
        }

        public Object getRoleId() {
            return roleId;
        }

        public void setRoleId(Object roleId) {
            this.roleId = roleId;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public Object getGender() {
            return gender;
        }

        public void setGender(Object gender) {
            this.gender = gender;
        }

        public String getPhotoUrl() {
            return photoUrl;
        }

        public void setPhotoUrl(String photoUrl) {
            this.photoUrl = photoUrl;
        }

        public String getPhoneNumber() {
            return phoneNumber;
        }

        public void setPhoneNumber(String phoneNumber) {
            this.phoneNumber = phoneNumber;
        }

        public Object getEmail() {
            return email;
        }

        public void setEmail(Object email) {
            this.email = email;
        }
    }
}
