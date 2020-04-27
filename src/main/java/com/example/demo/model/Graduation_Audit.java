package com.example.demo.model;

public class Graduation_Audit {

    private String studentId;
    private String studentName;
    private String studentClass;
    private Double accum_credit;
    private Double average_score;
    private Integer relearn_time;
    private Integer punishment_time;
    private String graduation;
    private String degree;
    private String voting_results;

    public Graduation_Audit (){

    }

    public Graduation_Audit(String studentId, String studentName,
                            String studentClass, Double accum_credit,
                            Double average_score, Integer relearn_time,
                            Integer punishment_time, String voting_results) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.accum_credit = accum_credit;
        this.average_score = average_score;
        this.relearn_time = relearn_time;
        this.punishment_time = punishment_time;
        this.voting_results = voting_results;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public void setStudentClass(String studentClass) {
        this.studentClass = studentClass;
    }

    public Double getAccum_credit() {
        return accum_credit;
    }

    public void setAccum_credit(Double accum_credit) {
        this.accum_credit = accum_credit;
    }

    public Double getAverage_score() {
        return average_score;
    }

    public void setAverage_score(Double average_score) {
        this.average_score = average_score;
    }

    public Integer getRelearn_time() {
        return relearn_time;
    }

    public void setRelearn_time(Integer relearn_time) {
        this.relearn_time = relearn_time;
    }

    public Integer getPunishment_time() {
        return punishment_time;
    }

    public void setPunishment_time(Integer punishment_time) {
        this.punishment_time = punishment_time;
    }

    public String getVoting_results() {
        return voting_results;
    }

    public void setVoting_results(String voting_results) {
        this.voting_results = voting_results;
    }

    public String getGraduation() {
        return graduation;
    }

    public void setGraduation(String graduation) {
        this.graduation = graduation;
    }

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    @Override
    public String toString() {
        return "Graduation_Audit{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", accum_credit=" + accum_credit +
                ", average_score=" + average_score +
                ", relearn_time=" + relearn_time +
                ", punishment_time=" + punishment_time +
                ", graduation='" + graduation + '\'' +
                ", degree='" + degree + '\'' +
                ", voting_results='" + voting_results + '\'' +
                '}';
    }
}
