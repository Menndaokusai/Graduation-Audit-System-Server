package com.example.demo.model;

public class Replacement {

    private int id;
    private String studentId;
    private String original_courseId;
    private String replace_courseId;

    public Replacement(int id, String studentId, String original_courseId, String replace_courseId) {
        this.id = id;
        this.studentId = studentId;
        this.original_courseId = original_courseId;
        this.replace_courseId = replace_courseId;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getOriginal_courseId() {
        return original_courseId;
    }

    public void setOriginal_courseId(String original_courseId) {
        this.original_courseId = original_courseId;
    }

    public String getReplace_courseId() {
        return replace_courseId;
    }

    public void setReplace_courseId(String replace_courseId) {
        this.replace_courseId = replace_courseId;
    }

    @Override
    public String toString() {
        return "Replacement{" +
                "id=" + id +
                ", studentId='" + studentId + '\'' +
                ", original_courseId='" + original_courseId + '\'' +
                ", replace_courseId='" + replace_courseId + '\'' +
                '}';
    }
}
