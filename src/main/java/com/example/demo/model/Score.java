package com.example.demo.model;

public class Score {

    private int scoreId;
    private String studentId;
    private String studentName;
    private String enrollment_year;
    private String college;
    private String major;
    private String studentClass;
    private String academic_year;
    private String term;
    private String courseId;
    private String course_name;
    private String course_nature;
    private String credit;
    private String score;
    private String retry_score;
    private String relearn_score;
    private String relearn_mark;

    public Score (){

    }

    public Score(int scoreId, String studentId,
                 String studentName, String enrollment_year,
                 String college, String major,
                 String studentClass, String academic_year,
                 String term, String courseId,
                 String course_name, String course_nature,
                 String credit, String score,
                 String retry_score, String relearn_score, String relearn_mark) {
        this.scoreId = scoreId;
        this.studentId = studentId;
        this.studentName = studentName;
        this.enrollment_year = enrollment_year;
        this.college = college;
        this.major = major;
        this.studentClass = studentClass;
        this.academic_year = academic_year;
        this.term = term;
        this.courseId = courseId;
        this.course_name = course_name;
        this.course_nature = course_nature;
        this.credit = credit;
        this.score = score;
        this.retry_score = retry_score;
        this.relearn_score = relearn_score;
        this.relearn_mark = relearn_mark;
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

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getCourse_nature() {
        return course_nature;
    }

    public void setCourse_nature(String course_nature) {
        this.course_nature = course_nature;
    }

    public String getRelearn_mark() {
        return relearn_mark;
    }

    public void setRelearn_mark(String relearn_mark) {
        this.relearn_mark = relearn_mark;
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

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getRetry_score() {
        return retry_score;
    }

    public void setRetry_score(String retry_score) {
        this.retry_score = retry_score;
    }

    public String getRelearn_score() {
        return relearn_score;
    }

    public void setRelearn_score(String relearn_score) {
        this.relearn_score = relearn_score;
    }

    public String getEnrollment_year() {
        return enrollment_year;
    }

    public void setEnrollment_year(String enrollment_year) {
        this.enrollment_year = enrollment_year;
    }

    @Override
    public String toString() {
        return "Score{" +
                "scoreId=" + scoreId +
                ", studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", enrollment_year='" + enrollment_year + '\'' +
                ", college='" + college + '\'' +
                ", major='" + major + '\'' +
                ", studentClass='" + studentClass + '\'' +
                ", academic_year='" + academic_year + '\'' +
                ", term='" + term + '\'' +
                ", courseId='" + courseId + '\'' +
                ", course_name='" + course_name + '\'' +
                ", course_nature='" + course_nature + '\'' +
                ", credit='" + credit + '\'' +
                ", score='" + score + '\'' +
                ", retry_score='" + retry_score + '\'' +
                ", relearn_score='" + relearn_score + '\'' +
                ", relearn_mark='" + relearn_mark + '\'' +
                '}';
    }
}
