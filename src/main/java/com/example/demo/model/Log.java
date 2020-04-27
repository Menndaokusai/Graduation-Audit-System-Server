package com.example.demo.model;

public class Log {

    private int logId;
    private String who;
    private String what;
    private String when;

    public Log(){

    }

    public Log(int logId, String who, String what, String when) {
        this.logId = logId;
        this.who = who;
        this.what = what;
        this.when = when;
    }

    public int getLogId() {
        return logId;
    }

    public void setLogId(int logId) {
        this.logId = logId;
    }

    public String getWho() {
        return who;
    }

    public void setWho(String who) {
        this.who = who;
    }

    public String getWhat() {
        return what;
    }

    public void setWhat(String what) {
        this.what = what;
    }

    public String getWhen() {
        return when;
    }

    public void setWhen(String when) {
        this.when = when;
    }

    @Override
    public String toString() {
        return "Log{" +
                "logId=" + logId +
                ", who='" + who + '\'' +
                ", what='" + what + '\'' +
                ", when='" + when + '\'' +
                '}';
    }
}
