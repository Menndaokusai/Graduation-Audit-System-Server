package com.example.demo.model;

public class Graduation_Audit {

    private String studentId;
    private String studentName;
    private String college;
    private String major;
    private String studentClass;
    private String gained_required_course_credit;
    private String gained_elective_course_credit;
    private String required_course_credit;
    private String elective_course_credit;
    private String failed_credit;

    public Graduation_Audit (){

    }

    public Graduation_Audit(String studentId, String studentName,
                            String college, String major,
                            String studentClass, String gained_required_course_credit,
                            String gained_elective_course_credit, String required_course_credit,
                            String elective_course_credit, String failed_credit) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.college = college;
        this.major = major;
        this.studentClass = studentClass;
        this.gained_required_course_credit = gained_required_course_credit;
        this.gained_elective_course_credit = gained_elective_course_credit;
        this.required_course_credit = required_course_credit;
        this.elective_course_credit = elective_course_credit;
        this.failed_credit = failed_credit;
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

    public String getGained_required_course_credit() {
        return gained_required_course_credit;
    }

    public void setGained_required_course_credit(String gained_required_course_credit) {
        this.gained_required_course_credit = gained_required_course_credit;
    }

    public String getGained_elective_course_credit() {
        return gained_elective_course_credit;
    }

    public void setGained_elective_course_credit(String gained_elective_course_credit) {
        this.gained_elective_course_credit = gained_elective_course_credit;
    }

    public String getFailed_credit() {
        return failed_credit;
    }

    public void setFailed_credit(String failed_credit) {
        this.failed_credit = failed_credit;
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
        return "Graduation_Audit{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", gained_required_course_credit='" + gained_required_course_credit + '\'' +
                ", gained_elective_course_credit='" + gained_elective_course_credit + '\'' +
                ", required_course_credit='" + required_course_credit + '\'' +
                ", elective_course_credit='" + elective_course_credit + '\'' +
                ", failed_credit='" + failed_credit + '\'' +
                '}';
    }
}
