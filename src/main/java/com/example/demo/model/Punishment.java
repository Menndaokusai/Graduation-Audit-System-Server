package com.example.demo.model;

public class Punishment {

    private int punishmentId;
    private int studentId;
    private String punishment;
    private String reason;
    private String record_time;

    public Punishment(){

    }

    public Punishment(int punishmentId, int studentId, String punishment, String reason, String record_time) {
        this.punishmentId = punishmentId;
        this.studentId = studentId;
        this.punishment = punishment;
        this.reason = reason;
        this.record_time = record_time;
    }

    public int getPunishmentId() {
        return punishmentId;
    }

    public void setPunishmentId(int punishmentId) {
        this.punishmentId = punishmentId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getPunishment() {
        return punishment;
    }

    public void setPunishment(String punishment) {
        this.punishment = punishment;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getRecord_time() {
        return record_time;
    }

    public void setRecord_time(String record_time) {
        this.record_time = record_time;
    }

    @Override
    public String toString() {
        return "Punishment{" +
                "punishmentId=" + punishmentId +
                ", studentId=" + studentId +
                ", punishment='" + punishment + '\'' +
                ", reason='" + reason + '\'' +
                ", record_time='" + record_time + '\'' +
                '}';
    }
}
