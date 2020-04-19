package com.example.demo.utils;

import com.example.demo.model.Score;

import java.util.List;

public class Messagee {

    private int code;
    private String message;
    private List<Score> data;

    public Messagee(int code, String message, List<Score> data) {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public List<Score> getData() {
        return data;
    }

    public void setData(List<Score> data) {
        this.data = data;
    }
}
