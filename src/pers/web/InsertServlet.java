package pers.web;

import com.google.gson.Gson;
import pers.pojo.Instructor;
import pers.pojo.Student;
import pers.service.UniversityService;
import pers.service.impl.UniversityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class InsertServlet extends HttpServlet {
    private UniversityService universityService = new UniversityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String feedBack = "";
        String personType = req.getParameter("personType");
        String ID = req.getParameter("ID");
        String name = req.getParameter("name");
        String deptName = req.getParameter("deptName");
        if (personType.equals("student")){
            if (universityService.existStudentID(ID)){
                feedBack = "student ID already exists";
            }
            if (!universityService.existDeptName(deptName)){
                if(feedBack != ""){
                    feedBack += " and dept_name doesn't exist";
                }else {
                    feedBack += "dept_name doesn't exist";
                }
            }
            if(feedBack == "" || feedBack.length() == 0){
                Integer idx = universityService.insertStudent(new Student(ID, name, deptName, 0));
                feedBack = idx.toString();
            }
        }else if (personType.equals("instructor")){
            if (universityService.existInstructor(ID)){
                feedBack = "instructor ID already exists";
            }
            if (!universityService.existDeptName(deptName)){
                if(feedBack != ""){
                    feedBack += " and dept_name doesn't exist";
                }else {
                    feedBack += "dept_name doesn't exist";
                }
            }
            if(feedBack == "" || feedBack.length() == 0){
                Integer idx = universityService.insertInstructor(new Instructor(ID, name, deptName, 29001));
                feedBack = idx.toString();
            }
        }

        out.write(feedBack);
        out.flush();
        out.close();
    }
}
