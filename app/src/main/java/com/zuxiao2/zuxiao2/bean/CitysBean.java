package com.zuxiao2.zuxiao2.bean;

public class CitysBean {

    private String label;
    private String value;

    public CitysBean(String label, String value) {
        this.label = label;
        this.value = value;
    }

    @Override
    public String toString() {
        return "CitysBean{" +
                "label='" + label + '\'' +
                ", value='" + value + '\'' +
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
}
