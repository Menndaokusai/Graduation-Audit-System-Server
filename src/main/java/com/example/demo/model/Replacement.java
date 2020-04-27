package com.example.demo.model;

public class Replacement {

    private int replacementId;
    private String studentId;
    private String original_course;
//    private Double original_course_credit;
    private String replacement_course_a;
//    private Double replacement_course_a_credit;
    private String replacement_course_b;
//    private Double replacement_course_b_credit;
    private String replacement_course_c;
//    private Double replacement_course_c_credit;
    private String report_time;
    private String audit_result;

    public Replacement(){

    }

    public Replacement(int replacementId, String studentId,
                       String original_course,
                       String replacement_course_a,
                       String replacement_course_b,
                       String replacement_course_c,
                       String report_time, String audit_result) {
        this.replacementId = replacementId;
        this.studentId = studentId;
        this.original_course = original_course;
//        this.original_course_credit = original_course_credit;
        this.replacement_course_a = replacement_course_a;
//        this.replacement_course_a_credit = replacement_course_a_credit;
        this.replacement_course_b = replacement_course_b;
//        this.replacement_course_b_credit = replacement_course_b_credit;
        this.replacement_course_c = replacement_course_c;
//        this.replacement_course_c_credit = replacement_course_c_credit;
        this.report_time = report_time;
        this.audit_result = audit_result;
    }

    public int getReplacementId() {
        return replacementId;
    }

    public void setReplacementId(int replacementId) {
        this.replacementId = replacementId;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOriginal_course() {
        return original_course;
    }

    public void setOriginal_course(String original_course) {
        this.original_course = original_course;
    }

//    public Double getOriginal_course_credit() {
//        return original_course_credit;
//    }
//
//    public void setOriginal_course_credit(Double original_course_credit) {
//        this.original_course_credit = original_course_credit;
//    }

    public String getReplacement_course_a() {
        return replacement_course_a;
    }

    public void setReplacement_course_a(String replacement_course_a) {
        this.replacement_course_a = replacement_course_a;
    }

//    public Double getReplacement_course_a_credit() {
//        return replacement_course_a_credit;
//    }

//    public void setReplacement_course_a_credit(Double replacement_course_a_credit) {
//        this.replacement_course_a_credit = replacement_course_a_credit;
//    }

    public String getReplacement_course_b() {
        return replacement_course_b;
    }

    public void setReplacement_course_b(String replacement_course_b) {
        this.replacement_course_b = replacement_course_b;
    }

//    public Double getReplacement_course_b_credit() {
//        return replacement_course_b_credit;
//    }
//
//    public void setReplacement_course_b_credit(Double replacement_course_b_credit) {
//        this.replacement_course_b_credit = replacement_course_b_credit;
//    }

    public String getReplacement_course_c() {
        return replacement_course_c;
    }

    public void setReplacement_course_c(String replacement_course_c) {
        this.replacement_course_c = replacement_course_c;
    }

//    public Double getReplacement_course_c_credit() {
//        return replacement_course_c_credit;
//    }
//
//    public void setReplacement_course_c_credit(Double replacement_course_c_credit) {
//        this.replacement_course_c_credit = replacement_course_c_credit;
//    }

    public String getReport_time() {
        return report_time;
    }

    public void setReport_time(String report_time) {
        this.report_time = report_time;
    }

    public String getAudit_result() {
        return audit_result;
    }

    public void setAudit_result(String audit_result) {
        this.audit_result = audit_result;
    }

    @Override
    public String toString() {
        return "Replacement{" +
                "replacementId=" + replacementId +
                ", studentId=" + studentId +
                ", original_course='" + original_course + '\'' +
//                ", original_course_credit='" + original_course_credit + '\'' +
                ", replacement_course_a='" + replacement_course_a + '\'' +
//                ", replacement_course_a_credit='" + replacement_course_a_credit + '\'' +
                ", replacement_course_b='" + replacement_course_b + '\'' +
//                ", replacement_course_b_credit='" + replacement_course_b_credit + '\'' +
                ", replacement_course_c='" + replacement_course_c + '\'' +
//                ", replacement_course_c_credit='" + replacement_course_c_credit + '\'' +
                ", report_time='" + report_time + '\'' +
                ", audit_result='" + audit_result + '\'' +
                '}';
    }
}
