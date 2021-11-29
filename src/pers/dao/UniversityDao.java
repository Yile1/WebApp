package pers.dao;

import pers.pojo.Course;
import pers.pojo.Instructor;
import pers.pojo.Student;

import java.util.List;

public interface UniversityDao {
    public Student queryStudentByID(String ID);
    public List<Student> queryStudentFail(Integer failCnt);
    public Course queryCourseByCourseID(String courseID);
    public List<Course> queryCourseLikeTitle(String subTitle);
    public List<Course> queryCourseByStudentID(String ID);
    public List<String> queryDeptName();
    public int saveStudent(Student student);
    public Instructor queryInstructorByID(String ID);
    public int saveInstructor(Instructor instructor);
    public List<Object[]> queryBySql(String sql);
}
