package pers.service;

import pers.pojo.Course;
import pers.pojo.Instructor;
import pers.pojo.Student;

import java.util.List;

public interface UniversityService {
    public Student searchStudentByID(String ID);
    public List<Course> searchCourseByStudentID(String ID);
    public List<Course> searchCourseByTitle(String subTitle);
    public List<Student> findStudentFail(int failCourseNum);
    public boolean existStudentID(String ID);
    public boolean existDeptName(String deptName);
    public List<String> getAllDeptName();
    public int insertStudent(Student student);
    public boolean existInstructor(String ID);
    public int insertInstructor(Instructor instructor);
    public <T>List<T> createDropDown(String sql);
}
