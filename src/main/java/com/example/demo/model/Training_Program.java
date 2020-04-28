package com.example.demo.model;

public class Training_Program {

    private int trainingId;
    private String enrollment_year;
    private String college;
    private String major;
    private String courseId;
    private String course_name;
    private String credit;
    private String course_nature;
    private String recommend_term;

    public Training_Program(){

    }

    public Training_Program(int trainingId, String enrollment_year,
                            String college, String major,
                            String courseId, String course_name,
                            String credit, String course_nature, String recommend_term) {
        this.trainingId = trainingId;
        this.enrollment_year = enrollment_year;
        this.college = college;
        this.major = major;
        this.courseId = courseId;
        this.course_name = course_name;
        this.credit = credit;
        this.course_nature = course_nature;
        this.recommend_term = recommend_term;
    }

    public int getTrainingId() {
        return trainingId;
    }

    public void setTrainingId(int trainingId) {
        this.trainingId = trainingId;
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

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_nature() {
        return course_nature;
    }

    public void setCourse_nature(String course_nature) {
        this.course_nature = course_nature;
    }

    public String getRecommend_term() {
        return recommend_term;
    }

    public void setRecommend_term(String recommend_term) {
        this.recommend_term = recommend_term;
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCredit() {
        return credit;
    }

    public void setCredit(String credit) {
        this.credit = credit;
    }

    @Override
    public String toString() {
        return "Training_Program{" +
                "trainingId=" + trainingId +
                ", enrollment_year='" + enrollment_year + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", courseId='" + courseId + '\'' +
                ", course_name='" + course_name + '\'' +
                ", credit='" + credit + '\'' +
                ", course_nature='" + course_nature + '\'' +
                ", recommend_term='" + recommend_term + '\'' +
                '}';
    }
}
