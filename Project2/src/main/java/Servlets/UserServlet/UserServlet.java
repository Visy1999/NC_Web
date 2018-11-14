package Servlets.UserServlet;


import Service.UserService;
import model.User;

import javax.persistence.Table;
import javax.persistence.criteria.CriteriaBuilder;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;



public class UserServlet extends HttpServlet {
    private final static String us = "viewUser/User.jsp";
    private UserService userService = new UserService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher(us).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        int idcompany =Integer.parseInt(req.getParameter("company")) ;
        int check = Integer.parseInt(req.getParameter("check"));


        User user = new User();
        user.setIdusers(id);
        user.setName(name);
        user.setIdcompany(idcompany);
        user.setCheck(check);


        try {

            userService.addUser(user);
            req.getRequestDispatcher(us).forward(req, resp);
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("cannot");
        }





    }
}
