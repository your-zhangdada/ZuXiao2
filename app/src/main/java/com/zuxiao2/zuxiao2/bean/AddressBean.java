package com.zuxiao2.zuxiao2.bean;

import java.util.List;

public class AddressBean {

    private String code;
    private String msg;
    private List<DataBean> data;

    @Override
    public String toString() {
        return "AddressBean{" +
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

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {

        private String label;
        private String value;
        private List<ChildrenBeanX> children;

        @Override
        public String toString() {
            return "DataBean{" +
                    "label='" + label + '\'' +
                    ", value='" + value + '\'' +
                    ", children=" + children +
                    '}';
        }

        public String getLabel() {
            return label;
        }

        public void setLabel(String label) {
            this.label = label;
        }

        public String getValue() {
            return value;
        }

        public void setValue(String value) {
            this.value = value;
        }

        public List<ChildrenBeanX> getChildren() {
            return children;
        }

        public void setChildren(List<ChildrenBeanX> children) {
            this.children = children;
        }

        public static class ChildrenBeanX {

            private String label;
            private String value;
            private List<ChildrenBean> children;

            @Override
            public String toString() {
                return "ChildrenBeanX{" +
                        "label='" + label + '\'' +
                        ", value='" + value + '\'' +
                        ", children=" + children +
                        '}';
            }

            public String getLabel() {
                return label;
            }

            public void setLabel(String label) {
                this.label = label;
            }

            public String getValue() {
                return value;
            }

            public void setValue(String value) {
                this.value = value;
            }

            public List<ChildrenBean> getChildren() {
                return children;
            }

            public void setChildren(List<ChildrenBean> children) {
                this.children = children;
            }

            public static class ChildrenBean {
                @Override
                public String toString() {
                    return "ChildrenBean{" +
                            "label='" + label + '\'' +
                            ", value='" + value + '\'' +
                            '}';
                }

                /**
                 * label : 南京东路
                 * value : 3
                 */

                private String label;
                private String value;

                public String getLabel() {
                    return label;
                }

                public void setLabel(String label) {
                    this.label = label;
                }

                public String getValue() {
                    return value;
                }

                public void setValue(String value) {
                    this.value = value;
                }
            }
        }
    }
}
