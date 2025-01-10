<%@ page import="com.ust.traineeapp.model.Trainee" isELIgnored = "false"%>
<%@ page import="java.util.List" %>
<html>
    <head>
        <title>View Page</title>
        <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
        <style>
            .table{
                width: 70%;
                margin: auto;
                border: 1px solid grey;
                border-radius: 8px;
            }
        </style>
    </head>
    <body>
        <jsp:include page="header.jsp"/>

        <%
            List<Trainee> trainees = (List<Trainee>) request.getAttribute("trainees");
            out.println("<table class = 'table'><tr><th>ID</th><th>Name</th><th>Location</th><th>Joined Date</th><th>Action</th></tr>");
            for(Trainee trainee: trainees){
                out.println("<tr><td>" + trainee.getId() + "</td><td>" + trainee.getName() + "</td><td>" + trainee.getLocation() + "</td><td>" + trainee.getJoinedDate() + "</td>");
                out.println("<td>");
                out.println("<form action='trainees/delete' method='post'>");
                out.println("<input type='hidden' name='id' value=" + trainee.getId() + ">");
                out.println("<button type='submit'>Delete</button>");
                out.println("</form></td></tr>");
            }
            out.println("</table>");
        %>

    </body>
</html>

