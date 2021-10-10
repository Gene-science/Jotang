package servlet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@WebServlet(value = {"/fail"})
public class LoginFailServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("Fail..");
        resp.getWriter().write("It will jump to the login page in 5 seconds");
        //五秒后重定向；
        resp.setHeader("refresh", "5;/webproject2_war_exploded/login.html");


    }
}
