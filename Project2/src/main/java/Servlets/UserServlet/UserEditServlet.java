package Servlets.UserServlet;

import Service.UserService;
import model.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UserEditServlet extends HttpServlet{

    private final static String us = "viewUser/EditUser.jsp";
    private final static String mainus = "viewUser/User.jsp";
    private UserService userService = new UserService();
    private  int idd= 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        User user = userService.getUserId(id);
        req.setAttribute("user",user);
        idd = id;
        req.getRequestDispatcher(us).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        int idcompany =Integer.parseInt(req.getParameter("company")) ;
        int check = Integer.parseInt(req.getParameter("check"));

        User user = new User();
        user.setIdusers(idd);
        user.setName(name);
        user.setIdcompany(idcompany);
        user.setCheck(check);

        try {
            userService.updateUser(user);
            req.getRequestDispatcher(mainus).forward(req, resp);
        }
        catch (Exception e)
        {
            System.out.println(e);
        }



    }
}
