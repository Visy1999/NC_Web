

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="model.User" %>
<%@ page import="Service.UserService" %>
<%@ page import="java.io.PrintWriter" %>
<%@ page import="model.Company" %>


<html>
<head>
    <title>User</title>
</head>
<body>

<H1>Users</H1>


        <%
            UserService userService = new UserService();
            PrintWriter printWriter =response.getWriter();



            printWriter.print("<table border='1' width='100%'");
            printWriter.print("<tr>" +
                    "<th>Id</th>" +
                    "<th>Name</th>" +
                    "<th>Company</th>" +
                    "<th>Check</th>" +
                    "<th>Edit</th>" +
                    "<th>Delete</th>" +
                    "</tr>" );
            for(User user : userService.listUser())
            {
                printWriter.print("<tr>" +
                        "<th>" + user.getIdusers() + "</th>"+
                         "<th>"+ user.getName() +"</th>"+
                        "<th>" + user.getIdcompany()+"</th>"+
                        "<th>"+ user.getCheck()+"</th>"+
                        "<th>"+ "<a href='EditUser?id="+user.getIdusers()+"'>edit</a>" + "</th>" +
                        "<th>"+ "<a href='d?id="+user.getIdusers()+"'>delete</a>" + "</th>"+
                        "</tr>");
            }


            printWriter.print("</table>");
        %>


<h3>Add User</h3>

<form method="post" action="User">

       ID :  <input type="text" name="id">
    <br>
    Name    :    <input type="text" name="name">

    <br>
    Company : <input type="text" name="company">

    <br>
    №Check :   <input type="text" name="check">

    <br>

    <input type="submit" value="Go" name="Value">

</form>



</body>
</html>
