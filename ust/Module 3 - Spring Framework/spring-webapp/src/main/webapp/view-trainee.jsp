<%@ page import="com.ust.webapp.model.Trainee" %>
<%@ page import="java.util.List" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>View Trainees</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <style>
        .container{
            width: 100vw;
            display: flex;
            justify-content: space-around;
        }
        .card{
            width: 250px;
        }
    </style>
</head>
<body>
        <h2 class="text-center">View Trainees</h2>
        <div class="container mt-4">
        <%
            List<Trainee> trainees = (List<Trainee>) request.getAttribute("traineeList");

            for (Trainee trainee : trainees) {
                out.println("<div class='card'><div class='card-header text-center'>Trainee Details</div><div class='card-body'>");
                out.println("<h5 class='card-title'>ID: <span>" + trainee.id() + "</span></h5>");
                out.println("<p class='card-text'>Name: <span>" + trainee.name() + "</span></p>");
                out.println("<p class='card-text'>Location: <span>" + trainee.location() + "</span></p></div>");
                out.println("<div class='card-footer text-center'><a href='' class='btn btn-primary'>Edit Trainee</a><a href='' class='btn btn-danger'>Delete Trainee</a></div>");
            }
        %>
        </div>
        <a href="/" class="btn btn-primary">Add Trainee</a>
</body>
</html>
