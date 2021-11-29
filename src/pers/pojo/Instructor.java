package pers.pojo;

import java.text.DecimalFormat;

public class Instructor {
    private String ID;
    private String name;
    private String deptName;
    private double salary;

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


    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    @Override
    public String toString() {
        return "Instructor{" +
                "ID='" + ID + '\'' +
                ", name='" + name + '\'' +
                ", deptName='" + deptName + '\'' +
                ", salary=" + salary +
                '}';
    }

    public Instructor() {
    }

    public Instructor(String ID, String name, String deptName, double salary) {
        this.ID = ID;
        this.name = name;
        this.deptName = deptName;
        this.salary = salary;
    }
}
