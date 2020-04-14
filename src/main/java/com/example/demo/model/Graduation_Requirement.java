package com.example.demo.model;

public class Graduation_Requirement {

    private int requirementId;
    private String enrollment_year;
    private String major;
    private String system;
    private String accum_credit;
    private String average_score;
    private String relearn_time;
    private String punishment_time;
    private String update_time;

    public Graduation_Requirement (){

    }

    public Graduation_Requirement(int requirementId, String enrollment_year,
                                  String major, String system,
                                  String accum_credit, String average_score,
                                  String relearn_time, String punishment_time,
                                  String update_time) {
        this.requirementId = requirementId;
        this.enrollment_year = enrollment_year;
        this.major = major;
        this.system = system;
        this.accum_credit = accum_credit;
        this.average_score = average_score;
        this.relearn_time = relearn_time;
        this.punishment_time = punishment_time;
        this.update_time = update_time;
    }

    public int getRequirementId() {
        return requirementId;
    }

    public void setRequirementId(int requirementId) {
        this.requirementId = requirementId;
    }

    public String getEnrollment_year() {
        return enrollment_year;
    }

    public void setEnrollment_year(String enrollment_year) {
        this.enrollment_year = enrollment_year;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    public String getAccum_credit() {
        return accum_credit;
    }

    public void setAccum_credit(String accum_credit) {
        this.accum_credit = accum_credit;
    }

    public String getAverage_score() {
        return average_score;
    }

    public void setAverage_score(String average_score) {
        this.average_score = average_score;
    }

    public String getRelearn_time() {
        return relearn_time;
    }

    public void setRelearn_time(String relearn_time) {
        this.relearn_time = relearn_time;
    }

    public String getPunishment_time() {
        return punishment_time;
    }

    public void setPunishment_time(String punishment_time) {
        this.punishment_time = punishment_time;
    }

    public String getUpdate_time() {
        return update_time;
    }

    public void setUpdate_time(String update_time) {
        this.update_time = update_time;
    }

    @Override
    public String toString() {
        return "Graduation_Requirement{" +
                "requirementId=" + requirementId +
                ", enrollment_year='" + enrollment_year + '\'' +
                ", major='" + major + '\'' +
                ", system='" + system + '\'' +
                ", accum_credit='" + accum_credit + '\'' +
                ", average_score='" + average_score + '\'' +
                ", relearn_time='" + relearn_time + '\'' +
                ", punishment_time='" + punishment_time + '\'' +
                ", update_time='" + update_time + '\'' +
                '}';
    }
}
