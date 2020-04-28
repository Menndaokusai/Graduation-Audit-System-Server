package com.example.demo.model;

public class Graduation_Requirement {

    private String enrollment_year;
    private String college;
    private String major;
    private String required_course_credit;
    private String elective_course_credit;


    public Graduation_Requirement(String enrollment_year, String college,
                                  String major, String required_course_credit,
                                  String elective_course_credit) {
        this.enrollment_year = enrollment_year;
        this.college = college;
        this.major = major;
        this.required_course_credit = required_course_credit;
        this.elective_course_credit = elective_course_credit;
    }

    public String getEnrollment_year() {
        return enrollment_year;
    }

    public void setEnrollment_year(String enrollment_year) {
        this.enrollment_year = enrollment_year;
    }

    public String getCollege() {
        return college;
    }

    public void setCollege(String college) {
        this.college = college;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getRequired_course_credit() {
        return required_course_credit;
    }

    public void setRequired_course_credit(String required_course_credit) {
        this.required_course_credit = required_course_credit;
    }

    public String getElective_course_credit() {
        return elective_course_credit;
    }

    public void setElective_course_credit(String elective_course_credit) {
        this.elective_course_credit = elective_course_credit;
    }

    @Override
    public String toString() {
        return "Graduation_Requirement{" +
                "enrollment_year='" + enrollment_year + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", required_course_credit='" + required_course_credit + '\'' +
                ", elective_course_credit='" + elective_course_credit + '\'' +
                '}';
    }
}
