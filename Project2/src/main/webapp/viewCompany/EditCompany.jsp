<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.Company" %>
<%@ page import="Service.CompanyService" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditCompany</title>
</head>
<body>

<h3>Edit Company</h3>

<%
    Company company = (Company) request.getAttribute("company");

    CompanyService companyService = new CompanyService();
    PrintWriter printWriter =response.getWriter();


    printWriter.print("<table border='1' width='100%'");
    printWriter.print("<tr>" +
            "<th>Id</th>" +
            "<th>Name Company</th>" +
            "<th>Employee</th>" +
            "</tr>" );

    printWriter.print("<tr>" +
            "<th>" + company.getIdcompanys() + "</th>"+
            "<th>"+ company.getName() +"</th>"+
            "<th>" + company.getEmployee()+"</th>"+
            "</tr>");
    printWriter.print("</table>");




%>



<form method="post" action="CompanyEdit">

    <br>
    Name Company   :    <input type="text" name="name">

    <br>
    Employee : <input type="text" name="employee" >

    <br>

    <input type="submit" value="Go" name="Value">

</form>


</body>
</html>
