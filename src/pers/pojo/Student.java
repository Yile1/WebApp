package pers.pojo;

public class Student {
    private String ID;
    private String name;
    private String deptName;
    private Integer totCred;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Integer getTotCred() {
        return totCred;
    }

    public void setTotCred(Integer totCred) {
        this.totCred = totCred;
    }

    @Override
    public String toString() {
        return "Student{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", totCred='" + totCred + '\'' +
                '}';
    }

    public Student() {
    }

    public Student(String ID, String name, String deptName, Integer totCred) {
        this.ID = ID;
        this.name = name;
        this.deptName = deptName;
        this.totCred = totCred;
    }

}
