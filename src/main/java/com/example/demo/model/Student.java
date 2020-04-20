package com.example.demo.model;

public class Student {

    private String studentId;
    private String major;
    private String enrollment_year;
    private String system;


    public Student(String studentId, String major, String enrollment_year, String system) {
        this.studentId = studentId;
        this.major = major;
        this.enrollment_year = enrollment_year;
        this.system = system;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getEnrollment_year() {
        return enrollment_year;
    }

    public void setEnrollment_year(String enrollment_year) {
        this.enrollment_year = enrollment_year;
    }

    public String getSystem() {
        return system;
    }

    public void setSystem(String system) {
        this.system = system;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", major='" + major + '\'' +
                ", enrollment_year='" + enrollment_year + '\'' +
                ", system='" + system + '\'' +
                '}';
    }
}
