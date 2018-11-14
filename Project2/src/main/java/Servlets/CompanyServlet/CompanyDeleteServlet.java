package Servlets.CompanyServlet;


import Service.CompanyService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompanyDeleteServlet  extends HttpServlet {

    private final static String com = "viewCompany/Company.jsp";
    private CompanyService companyService = new CompanyService();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        companyService.removeCompany(id);
        req.getRequestDispatcher(com).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }




}
