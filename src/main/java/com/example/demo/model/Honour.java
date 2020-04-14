package com.example.demo.model;

public class Honour {

    private int honourId;
    private int studentId;
    private String honour;
    private String obtain_time;
    private String record_time;

    public Honour(){

    }

    public Honour(int honourId, int studentId, String honour, String obtain_time, String record_time) {
        this.honourId = honourId;
        this.studentId = studentId;
        this.honour = honour;
        this.obtain_time = obtain_time;
        this.record_time = record_time;
    }

    public int getHonourId() {
        return honourId;
    }

    public void setHonourId(int honourId) {
        this.honourId = honourId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getHonour() {
        return honour;
    }

    public void setHonour(String honour) {
        this.honour = honour;
    }

    public String getObtain_time() {
        return obtain_time;
    }

    public void setObtain_time(String obtain_time) {
        this.obtain_time = obtain_time;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    @Override
    public String toString() {
        return "Honour{" +
                "honourId=" + honourId +
                ", studentId=" + studentId +
                ", honour='" + honour + '\'' +
                ", obtain_time='" + obtain_time + '\'' +
                ", record_time='" + record_time + '\'' +
                '}';
    }
}
