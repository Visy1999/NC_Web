package Servlets.CompanyServlet;


import Service.CompanyService;
import model.Company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompanyServlet extends HttpServlet {
    private final static String maincom = "viewCompany/Company.jsp";
    private CompanyService companyService = new CompanyService();

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {


        req.getRequestDispatcher(maincom).forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");


        int id = Integer.parseInt(req.getParameter("id"));
        String name = req.getParameter("name");
        String employee =req.getParameter("employee");


        Company company  = new Company();
        company.setIdcompanys(id);
        company.setName(name);
        company.setEmployee(employee);


        try {

            companyService.addCompany(company);
            req.getRequestDispatcher(maincom).forward(req, resp);
        }
        catch (Exception e)
        {
            System.out.println(e);

        }


    }



}
