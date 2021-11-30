package pers.web;

import com.google.gson.Gson;
import pers.pojo.Course;
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

public class CourseServlet extends HttpServlet {
    private UniversityService universityService = new UniversityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        String solve = req.getParameter("solve");
        if (solve.equals("1")){
            String ID = req.getParameter("ID");
            List<Course> lists = universityService.searchCourseByStudentID(ID);
            String info = gson.toJson(lists);
            System.out.println(info);
            out.write(info);
        }else if(solve.equals("2")){
            String keyWord = req.getParameter("keyWord");
            List<Course> lists = universityService.searchCourseByTitle(keyWord);
            String info = gson.toJson(lists);
            System.out.println(info);
            out.write(info);
        }
        out.flush();
        out.close();
    }
}
