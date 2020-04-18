package com.example.demo.model;

public class Score {

    private int scoreId;
    private String studentId;
    private String studentName;
    private String studentClass;
    private String college;
    private String academic_year;
    private String term;
    private String course_name;
    private Double credit;
    private Double score;
    private Double retry_score;
    private Double relearn_score;

    public Score (){

    }

    public Score(int scoreId, String studentId,
                 String studentName, String studentClass,
                 String college, String academic_year,
                 String term, String course_name,
                 Double credit, Double score,
                 Double retry_score, Double relearn_score) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.college = college;
        this.academic_year = academic_year;
        this.term = term;
        this.course_name = course_name;
        this.credit = credit;
        this.score = score;
        this.retry_score = retry_score;
        this.relearn_score = relearn_score;
    }

    public int getScoreId() {
        return scoreId;
    }

    public void setScoreId(int scoreId) {
        this.scoreId = scoreId;
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

    public String getAcademic_year() {
        return academic_year;
    }

    public void setAcademic_year(String academic_year) {
        this.academic_year = academic_year;
    }

    public String getTerm() {
        return term;
    }

    public void setTerm(String term) {
        this.term = term;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public Double getCredit() {
        return credit;
    }

    public void setCredit(Double credit) {
        this.credit = credit;
    }

    public Double getScore() {
        return score;
    }

    public void setScore(Double score) {
        this.score = score;
    }

    public Double getRetry_score() {
        return retry_score;
    }

    public void setRetry_score(Double retry_score) {
        this.retry_score = retry_score;
    }

    public Double getRelearn_score() {
        return relearn_score;
    }

    public void setRelearn_score(Double relearn_score) {
        this.relearn_score = relearn_score;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", college='" + college + '\'' +
                ", academic_year='" + academic_year + '\'' +
                ", term='" + term + '\'' +
                ", course_name='" + course_name + '\'' +
                ", credit='" + credit + '\'' +
                ", score='" + score + '\'' +
                ", retry_score='" + retry_score + '\'' +
                ", relearn_score='" + relearn_score + '\'' +
                '}';
    }
}
