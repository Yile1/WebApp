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
import java.util.List;

public class StudentServlet extends HttpServlet {
    private UniversityService universityService = new UniversityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String solve = req.getParameter("solve");
        if (solve.equals("1")){
            String ID = req.getParameter("ID");
            Student student = universityService.searchStudentByID(ID);
            String info = gson.toJson(student);
            System.out.println(info);
            out.write(info);
        }else if(solve.equals("3")){
            String parameter = req.getParameter("failNum");
            Integer failNum = Integer.valueOf(parameter);
            List<Student> lists = universityService.findStudentFail(failNum);
            String info = gson.toJson(lists);
            System.out.println(info);
            out.write(info);
        }
        out.flush();
        out.close();
    }
}
