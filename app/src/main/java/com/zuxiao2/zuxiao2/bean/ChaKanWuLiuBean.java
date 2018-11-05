package com.zuxiao2.zuxiao2.bean;

public class ChaKanWuLiuBean {


    private String time;
    private String context;

    public ChaKanWuLiuBean(String time, String context) {
        this.time = time;
        this.context = context;
    }

    @Override
    public String toString() {
        return "ChaKanWuLiuBean{" +
                "time='" + time + '\'' +
                ", context='" + context + '\'' +
                '}';
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }
}
