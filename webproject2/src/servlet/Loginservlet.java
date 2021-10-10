package servlet;

import seivice.UserService;
import user.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
@WebServlet(value = {"/login"})
public class Loginservlet extends HttpServlet {
        UserService userService =new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String password =req.getParameter("password");

        User user= null;
        try {
            user=userService.select(username);
        } catch (SQLException e) {
            e.printStackTrace();
        }

        if(password.equals(user.getPassword())){
            resp.sendRedirect("/webproject2_war_exploded/success");//重定向实现
        }else{
            req.getRequestDispatcher("/fail").forward(req,resp);//转发实现
        }
    }


}
