package com.example.demo.model;

public class Vote {

    private int voteId;
    private String studentId;
    private int agree;
    private int disagree;
    private String voting_results;
    private String publish_time;
    private String deadline;

    public Vote(){

    }

    public Vote(int voteId, String studentId,
                int agree, int disagree,
                String voting_results, String publish_time,
                String deadline) {
        this.voteId = voteId;
        this.studentId = studentId;
        this.agree = agree;
        this.disagree = disagree;
        this.voting_results = voting_results;
        this.publish_time = publish_time;
        this.deadline = deadline;
    }

    public int getVoteId() {
        return voteId;
    }

    public void setVoteId(int voteId) {
        this.voteId = voteId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public int getAgree() {
        return agree;
    }

    public void setAgree(int agree) {
        this.agree = agree;
    }

    public int getDisagree() {
        return disagree;
    }

    public void setDisagree(int disagree) {
        this.disagree = disagree;
    }

    public String getVoting_results() {
        return voting_results;
    }

    public void setVoting_results(String voting_results) {
        this.voting_results = voting_results;
    }

    public String getPublish_time() {
        return publish_time;
    }

    public void setPublish_time(String publish_time) {
        this.publish_time = publish_time;
    }

    public String getDeadline() {
        return deadline;
    }

    public void setDeadline(String deadline) {
        this.deadline = deadline;
    }

    @Override
    public String toString() {
        return "Vote{" +
                "voteId=" + voteId +
                ", studentId=" + studentId +
                ", agree='" + agree + '\'' +
                ", disagree='" + disagree + '\'' +
                ", voting_results='" + voting_results + '\'' +
                ", publish_time='" + publish_time + '\'' +
                ", deadline='" + deadline + '\'' +
                '}';
    }
}
