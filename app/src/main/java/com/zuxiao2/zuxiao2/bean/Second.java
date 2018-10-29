package com.zuxiao2.zuxiao2.bean;

import java.io.Serializable;
import java.util.List;

/**
 * 作者：wanglong on 18/8/31.
 * 邮箱：wanglong128@aliyun.com
 * 版本：v1.0
 */
public class Second implements Serializable{


    @Override
    public String toString() {
        return "Second{" +
                "code='" + code + '\'' +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    /**
     * code : 0
     * msg : ok
     * data : {"id":100,"name":"手机","sort":1,"icon":"http://guodongqi-social.oss-cn-beijing.aliyuncs.com/4743f72c-c849-11e8-98a1-00163e2eceda.png","items":[{"id":1000000,"name":"手机","sort":1,"specification":[{"id":100000,"name":"屏幕尺寸","values":[{"id":100001,"name":"3.0寸以下"},{"id":100002,"name":"4.5 - 3.1寸"},{"id":100003,"name":"其他寸"}]},{"id":200000,"name":"运行内存","values":[{"id":200001,"name":"2G 以下"},{"id":200002,"name":"2G"},{"id":200003,"name":"3G"}]},{"id":300000,"name":"机身内存","values":[{"id":300001,"name":"8G 以下"},{"id":300002,"name":"16G"},{"id":300003,"name":"32G"}]},{"id":301000,"name":"网络","values":[{"id":301001,"name":"3G"},{"id":301002,"name":"4G"},{"id":301003,"name":"5GG"}]},{"id":302000,"name":"运营商","values":[{"id":302001,"name":"联通"},{"id":302002,"name":"电信"},{"id":302003,"name":"移动"}]}]},{"id":1000001,"name":"旗舰机","sort":2,"specification":[{"id":400000,"name":"屏幕尺寸","values":[{"id":400001,"name":"3.0寸以下"},{"id":400002,"name":"4.5 - 3.1寸"},{"id":400003,"name":"其他寸"}]},{"id":500000,"name":"运行内存","values":[{"id":500001,"name":"2G 以下"},{"id":500002,"name":"2G"},{"id":500003,"name":"3G"}]},{"id":600000,"name":"机身内存","values":[{"id":600001,"name":"8G 以下"},{"id":600002,"name":"16G"},{"id":600003,"name":"32G"}]}]}]}
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

    public static class DataBean implements Serializable{
        @Override
        public String toString() {
            return "DataBean{" +
                    "id=" + id +
                    ", name='" + name + '\'' +
                    ", sort=" + sort +
                    ", icon='" + icon + '\'' +
                    ", items=" + items +
                    '}';
        }

        /**
         * id : 100
         * name : 手机
         * sort : 1
         * icon : http://guodongqi-social.oss-cn-beijing.aliyuncs.com/4743f72c-c849-11e8-98a1-00163e2eceda.png
         * items : [{"id":1000000,"name":"手机","sort":1,"specification":[{"id":100000,"name":"屏幕尺寸","values":[{"id":100001,"name":"3.0寸以下"},{"id":100002,"name":"4.5 - 3.1寸"},{"id":100003,"name":"其他寸"}]},{"id":200000,"name":"运行内存","values":[{"id":200001,"name":"2G 以下"},{"id":200002,"name":"2G"},{"id":200003,"name":"3G"}]},{"id":300000,"name":"机身内存","values":[{"id":300001,"name":"8G 以下"},{"id":300002,"name":"16G"},{"id":300003,"name":"32G"}]},{"id":301000,"name":"网络","values":[{"id":301001,"name":"3G"},{"id":301002,"name":"4G"},{"id":301003,"name":"5GG"}]},{"id":302000,"name":"运营商","values":[{"id":302001,"name":"联通"},{"id":302002,"name":"电信"},{"id":302003,"name":"移动"}]}]},{"id":1000001,"name":"旗舰机","sort":2,"specification":[{"id":400000,"name":"屏幕尺寸","values":[{"id":400001,"name":"3.0寸以下"},{"id":400002,"name":"4.5 - 3.1寸"},{"id":400003,"name":"其他寸"}]},{"id":500000,"name":"运行内存","values":[{"id":500001,"name":"2G 以下"},{"id":500002,"name":"2G"},{"id":500003,"name":"3G"}]},{"id":600000,"name":"机身内存","values":[{"id":600001,"name":"8G 以下"},{"id":600002,"name":"16G"},{"id":600003,"name":"32G"}]}]}]
         */

        private int id;
        private String name;
        private int sort;
        private String icon;
        private List<ItemsBean> items;

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

        public String getIcon() {
            return icon;
        }

        public void setIcon(String icon) {
            this.icon = icon;
        }

        public List<ItemsBean> getItems() {
            return items;
        }

        public void setItems(List<ItemsBean> items) {
            this.items = items;
        }

        public static class ItemsBean  implements Serializable {
            @Override
            public String toString() {
                return "ItemsBean{" +
                        "id=" + id +
                        ", name='" + name + '\'' +
                        ", sort=" + sort +
                        ", specification=" + specification +
                        '}';
            }

            /**
             * id : 1000000
             * name : 手机
             * sort : 1
             * specification : [{"id":100000,"name":"屏幕尺寸","values":[{"id":100001,"name":"3.0寸以下"},{"id":100002,"name":"4.5 - 3.1寸"},{"id":100003,"name":"其他寸"}]},{"id":200000,"name":"运行内存","values":[{"id":200001,"name":"2G 以下"},{"id":200002,"name":"2G"},{"id":200003,"name":"3G"}]},{"id":300000,"name":"机身内存","values":[{"id":300001,"name":"8G 以下"},{"id":300002,"name":"16G"},{"id":300003,"name":"32G"}]},{"id":301000,"name":"网络","values":[{"id":301001,"name":"3G"},{"id":301002,"name":"4G"},{"id":301003,"name":"5GG"}]},{"id":302000,"name":"运营商","values":[{"id":302001,"name":"联通"},{"id":302002,"name":"电信"},{"id":302003,"name":"移动"}]}]
             */

            private int id;
            private String name;
            private int sort;
            private List<SpecificationBean> specification;

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

            public List<SpecificationBean> getSpecification(){
                return specification;
            }

            public void setSpecification(List<SpecificationBean> specification) {
                this.specification = specification;
            }

            public static class SpecificationBean implements Serializable{
                /**
                 * id : 100000
                 * name : 屏幕尺寸
                 * values : [{"id":100001,"name":"3.0寸以下"},{"id":100002,"name":"4.5 - 3.1寸"},{"id":100003,"name":"其他寸"}]
                 */

                private int id;
                private String name;
                private List<ValuesBean> values;

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

                public List<ValuesBean> getValues() {
                    return values;
                }

                public void setValues(List<ValuesBean> values) {
                    this.values = values;
                }

                public static class ValuesBean implements Serializable{
                    /**
                     * id : 100001
                     * name : 3.0寸以下
                     */

                    private int id;
                    private String name;

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
                }
            }
        }
    }
}
