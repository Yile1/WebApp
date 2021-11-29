package pers.dao.impl;

import pers.dao.UniversityDao;
import pers.pojo.Course;
import pers.pojo.Instructor;
import pers.pojo.Student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class UniversityDaoImpl extends BaseDao implements UniversityDao {
    @Override
    public Student queryStudentByID(String ID) {
        String sql = "select ID, name, dept_name as deptName, tot_cred as totCred from student where ID = ?";
        return queryForOne(Student.class, sql, ID);
    }

    @Override
    public List<Student> queryStudentFail(Integer failCnt) {
        String sql = "with fail_grade(ID, name, deptName, totCred) as " +
                "(select ID, name, student.dept_name, tot_cred " +
                "from student natural join takes " +
                "where grade = 'F' or grade = 'C-') " +
                "select * " +
                "from fail_grade " +
                "group by ID, name, deptName, totCred " +
                "having count(ID) >= ?";
        return queryForList(Student.class, sql, failCnt);
    }

    @Override
    public Course queryCourseByCourseID(String courseID) {
        String sql = "select course_id as courseID, title, dept_name as deptName, credits from course where course_id = ?";
        return queryForOne(Course.class, sql, courseID);
    }

    @Override
    public List<Course> queryCourseLikeTitle(String subTitle) {
        StringBuilder sql = new StringBuilder();
        sql.append("select course_id as courseID, title, dept_name as deptName, credits from course where title like '%");
        sql.append(subTitle + "%'");
        return queryForList(Course.class, sql.toString());
    }

    @Override
    public List<Course> queryCourseByStudentID(String ID) {
        String sql = "select course.course_id as courseID, course.title, course.dept_name as deptName, course.credits, takes.grade from takes, course where takes.ID = ? and takes.course_id = course.course_id";
        return queryForList(Course.class, sql, ID);
    }

    @Override
    public List<String> queryDeptName() {
        String sql = "select distinct(dept_name) from department";
        List<String> resLists = new ArrayList<String>();
        List<Object[]> objLists = queryForArray(sql);
        for(Object[] objList : objLists){
            resLists.add(objList[0].toString());
        }
        return resLists;
    }

    @Override
    public int saveStudent(Student student) {
        String sql = "insert into student (`ID`, `name`, `dept_name`, `tot_cred`) values (?, ?, ?, ?)";
        return update(sql, student.getID(), student.getName(), student.getDeptName(), student.getTotCred());
    }

    @Override
    public Instructor queryInstructorByID(String ID) {
        String sql = "select * from instructor where ID = ?";
        return queryForOne(Instructor.class, sql, ID);
    }

    @Override
    public int saveInstructor(Instructor instructor) {
        String sql = "insert into instructor (`ID`, `name`, `dept_name`, `salary`) values (?, ?, ?, ?)";
        return update(sql, instructor.getID(), instructor.getName(), instructor.getDeptName(), instructor.getSalary());
    }

    @Override
    public List<Object[]> queryBySql(String sql) {
        return queryForArray(sql);
    }
}
