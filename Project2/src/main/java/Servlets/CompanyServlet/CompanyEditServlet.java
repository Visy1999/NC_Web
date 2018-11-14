package Servlets.CompanyServlet;


import Service.CompanyService;
import model.Company;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CompanyEditServlet extends HttpServlet {

    private final static String com = "viewCompany/EditCompany.jsp";
    private final static String maincom = "viewCompany/Company.jsp";
    private CompanyService companyService = new CompanyService();
    private  int idd= 0;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        int id = Integer.parseInt(req.getParameter("id"));
        Company company = companyService.getCompanyId(id);
        req.setAttribute("company",company);
        idd = id;
        req.getRequestDispatcher(com).forward(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String name = req.getParameter("name");
        String employee =req.getParameter("employee") ;


        Company company = new Company();
        company.setIdcompanys(idd);
        company.setName(name);
        company.setEmployee(employee);

        try {
            companyService.updatCompany(company);
            req.getRequestDispatcher(maincom).forward(req, resp);
        }
        catch (Exception e)
        {
            System.out.println(e);
            System.out.println("Cannot");
        }

    }

}
