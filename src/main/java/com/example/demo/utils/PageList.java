package com.example.demo.utils;

import java.util.List;

public class PageList {

    private int code;
    private List<Object> items;

    public PageList(int code,List<Object> items) {
        this.code = code;
        this.items = items;
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

    @Override
    public String toString() {
        return "PageList{" +
                "code=" + code +
                ", items=" + items +
                '}';
    }
}

