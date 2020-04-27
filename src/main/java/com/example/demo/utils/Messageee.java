package com.example.demo.utils;

import com.example.demo.model.Student;

import java.util.List;

public class Messageee {

    private int code;
    private String message;
    private List<Student> data;

    public Messageee(int code, String message, List<Student> data) {
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

    public List<Student> getData() {
        return data;
    }

    public void setData(List<Student> data) {
        this.data = data;
    }
}
