package pers.test;

import org.junit.Test;
import pers.dao.UniversityDao;
import pers.dao.impl.UniversityDaoImpl;
import pers.pojo.Course;
import pers.pojo.Instructor;
import pers.pojo.Student;

import java.util.List;


public class UniversityDaoImplTest {
    private UniversityDao universityDao = new UniversityDaoImpl();
    @Test
    public void queryStudentByID() {
        String ID = "99977";
        Student student = universityDao.queryStudentByID(ID);
        System.out.print(student.getID() + ' ');
        System.out.print(student.getName() + ' ');
        System.out.print(student.getDeptName() + ' ');
        System.out.println(student.getTotCred());
    }

    @Test
    public void queryStudentFail() {
        int cnt = 1;
        List<Student> lists = universityDao.queryStudentFail(cnt);
        for (Student list : lists){
            System.out.print(list.getID() + ' ');
            System.out.print(list.getName() + ' ');
            System.out.print(list.getDeptName() + ' ');
            System.out.println(list.getTotCred());
        }
    }

    @Test
    public void queryCourseByCourseID() {
        String course_id = "105";
        Course course = universityDao.queryCourseByCourseID(course_id);
        System.out.print(course.getCourseID());
        System.out.print(course.getTitle());
        System.out.print(course.getDeptName());
        System.out.println(course.getCredits());
    }

    @Test
    public void queryCourseLikeTitle() {
        String subTitle = "om";
        List<Course> lists = universityDao.queryCourseLikeTitle(subTitle);
        for (Course list : lists){
            System.out.print(list.getCourseID());
            System.out.print(list.getTitle());
            System.out.print(list.getDeptName());
            System.out.println(list.getCredits());
        }
    }

    @Test
    public void queryCourseByStudentID() {
        String ID = "99977";
        List<Course> lists = universityDao.queryCourseByStudentID(ID);
        for (Course list : lists){
            System.out.print(list.getCourseID() + ' ');
            System.out.print(list.getTitle() + ' ');
            System.out.print(list.getDeptName() + ' ');
            System.out.print(list.getCredits());
            System.out.println(' ' + list.getGrade());
        }
    }

    @Test
    public void saveStudent() {
        Student student = new Student("66666", "yeguang", "Comp. Sci.", 98);
        Integer idx = universityDao.saveStudent(student);
        if(idx == -1){
            System.out.println("保存学生数据失败");
        }else{
            System.out.println("保存成功，受影响的行数为" + idx + "行");
        }
    }

    @Test
    public void saveInstructor() {
        Instructor instructor = new Instructor("88888", "someone", "Comp. Sci.", 50000.85);
        Integer idx = universityDao.saveInstructor(instructor);
        if(idx == -1){
            System.out.println("保存教师数据失败");
        }else{
            System.out.println("保存成功，受影响的行数为" + idx + "行");
        }
    }

    @Test
    public void queryDeptName() {
        List<String> lists = universityDao.queryDeptName();
        for(String list : lists){
            System.out.println(list);
        }
    }
}