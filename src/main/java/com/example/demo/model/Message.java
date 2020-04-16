package com.example.demo.model;

import java.util.List;

public class Message {

    private int code;
    private String message;
    private String token;
    private List<Object> data;

    public Message(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public Message(int code, String message, String token) {
        this.code = code;
        this.message = message;
        this.token = token;
    }

    public Message(int code, String message, List<Object> data) {
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

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<Object> getData() {
        return data;
    }

    public void setData(List<Object> data) {
        this.data = data;
    }

}
