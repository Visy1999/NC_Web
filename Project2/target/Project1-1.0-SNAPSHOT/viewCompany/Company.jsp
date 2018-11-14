<%@ page import="java.io.PrintWriter" %>
<%@ page import="Service.CompanyService" %>
<%@ page import="model.Company" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Company</title>
</head>
<body>

<H1>Company</H1>


<%
    CompanyService companyService = new CompanyService();
    PrintWriter printWriter =response.getWriter();


    printWriter.print("<table border='1' width='100%'");
    printWriter.print("<tr>" +
            "<th>Id</th>" +
            "<th>Name</th>" +
            "<th>Employee</th>" +
            "<th>Delete</th>" +
            "<th>Edit</th>" +
            "</tr>" );
    for(Company company : companyService.listCompany())
    {
        printWriter.print("<tr>" +
                "<th>" + company.getIdcompanys() + "</th>"+
                "<th>"+ company.getName() +"</th>"+
                "<th>" + company.getEmployee()+"</th>"+
                "<th>"+ "<a href='cd?id="+company.getIdcompanys()+"'>delete</a>" + "</th>" +
                "<th>"+ "<a href='CompanyEdit?id="+company.getIdcompanys()+"'>edit</a>" + "</th>"+
                "</tr>");
    }


    printWriter.print("</table>");
%>


<h3>Add Company</h3>

<form method="post" action="Company">

    ID :  <input type="text" name="id">
    <br>
    Name Company  :   <input type="text" name="name">

    <br>
    Employee : <input type="text" name="employee">

    <br>

    <input type="submit" value="Go" name="Value">

</form>



</body>
</html>
