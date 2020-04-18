package com.example.demo.model;

import java.util.List;

public class PageList {

    private int code;
    private int total;
    private List<Object> items;
    private String update_time;

    public PageList(int code, int total, List<Object> items) {
        this.code = code;
        this.total = total;
        this.items = items;
    }

    public PageList(int code, int total, List<Object> items, String update_time) {
        this.code = code;
        this.total = total;
        this.items = items;
        this.update_time = update_time;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "code=" + code +
                ", total=" + total +
                ", items=" + items +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}

