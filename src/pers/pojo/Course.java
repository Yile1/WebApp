package pers.pojo;

public class Course {
    private String courseID;
    private String title;
    private String deptName;
    private Integer credits;
    private String grade;

    public String getCourseID() {
        return courseID;
    }

    public void setCourseID(String courseID) {
        this.courseID = courseID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getCredits() {
        return credits;
    }

    public void setCredits(Integer credits) {
        this.credits = credits;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Course{" +
                "courseID='" + courseID + '\'' +
                ", title='" + title + '\'' +
                ", deptName='" + deptName + '\'' +
                ", credits=" + credits +
                ", grade='" + grade + '\'' +
                '}';
    }

    public Course() {
    }

    public Course(String courseID, String title, String deptName, Integer credits, String grade) {
        this.courseID = courseID;
        this.title = title;
        this.deptName = deptName;
        this.credits = credits;
        this.grade = grade;
    }
}
