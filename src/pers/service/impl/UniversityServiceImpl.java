package pers.service.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import pers.dao.UniversityDao;
import pers.dao.impl.UniversityDaoImpl;
import pers.pojo.Course;
import pers.pojo.Instructor;
import pers.pojo.Student;
import pers.service.UniversityService;
import pers.utils.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

public class UniversityServiceImpl implements UniversityService {

    private UniversityDao universityDao = new UniversityDaoImpl();

    @Override
    public Student searchStudentByID(String ID) {
        return universityDao.queryStudentByID(ID);
    }

    @Override
    public List<Course> searchCourseByStudentID(String ID) {
        return universityDao.queryCourseByStudentID(ID);
    }

    @Override
    public List<Course> searchCourseByTitle(String subTitle) {
        return universityDao.queryCourseLikeTitle(subTitle);
    }

    @Override
    public List<Student> findStudentFail(int failCourseNum) {
        return universityDao.queryStudentFail(failCourseNum);
    }

    @Override
    public boolean existStudentID(String ID) {
        if (universityDao.queryStudentByID(ID) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public boolean existDeptName(String deptName) {
        List<String> lists = universityDao.queryDeptName();
        if(lists.contains(deptName)){
            return true;
        }else{
            return false;
        }
    }

    @Override
    public List<String> getAllDeptName() {
        return universityDao.queryDeptName();
    }

    //返回-1则添加失败
    @Override
    public int insertStudent(Student student) {
        return universityDao.saveStudent(student);
    }

    @Override
    public boolean existInstructor(String ID) {
        if (universityDao.queryInstructorByID(ID) == null){
            return false;
        }else{
            return true;
        }
    }

    @Override
    public int insertInstructor(Instructor instructor) {
        return universityDao.saveInstructor(instructor);
    }

    @Override
    public List<Object[]> createDropDown(String sql) {
        return universityDao.queryBySql(sql);
    }
}
