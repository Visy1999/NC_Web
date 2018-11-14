<%@ page import="Service.UserService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.User" %>
<%@ page import="model.Company" %><%--
  Created by IntelliJ IDEA.
  User: Vitalik
  Date: 12.11.2018
  Time: 22:31
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>EditUser</title>
</head>
<body>

<h3>Edit User</h3>

<%
    User user = (User) request.getAttribute("user");

    UserService userService = new UserService();
    PrintWriter printWriter =response.getWriter();


    printWriter.print("<table border='1' width='100%'");
    printWriter.print("<tr>" +
            "<th>Id</th>" +
            "<th>Name</th>" +
            "<th>Company</th>" +
            "<th>Check</th>" +
            "</tr>" );

        printWriter.print("<tr>" +
                "<th>" + user.getIdusers() + "</th>"+
                "<th>"+ user.getName() +"</th>"+
                "<th>" + user.getIdcompany()+"</th>"+
                "<th>"+ user.getCheck()+"</th>"+
                "</tr>");
    printWriter.print("</table>");




%>



<form method="post" action="EditUser">

    <br>
    Name    :    <input type="text" name="name">

    <br>
    Company : <input type="text" name="company" >

    <br>
    №Check :   <input type="text" name="check" >

    <br>

    <input type="submit" value="Go" name="Value">

</form>






</body>
</html>
