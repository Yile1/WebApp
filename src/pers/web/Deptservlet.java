package pers.web;

import com.google.gson.Gson;
import pers.service.UniversityService;
import pers.service.impl.UniversityServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

public class DeptServlet extends HttpServlet {
    private UniversityService universityService = new UniversityServiceImpl();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        Gson gson = new Gson();
        List<String> lists = universityService.getAllDeptName();
        String info = gson.toJson(lists);
        System.out.println(info);
        out.write(info);
        out.flush();
        out.close();
    }
}
