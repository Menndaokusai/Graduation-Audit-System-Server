package com.example.demo.utils;

import java.util.List;

public class PageList {

    private int code;
    private List<Object> items;
    private int total;

    public PageList(int code,List<Object> items) {
        this.code = code;
        this.items = items;
    }

    public PageList(int code, List<Object> items, int total) {
        this.code = code;
        this.items = items;
        this.total = total;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<Object> getItems() {
        return items;
    }

    public void setItems(List<Object> items) {
        this.items = items;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "PageList{" +
                "code=" + code +
                ", items=" + items +
                ", total=" + total +
                '}';
    }
}

