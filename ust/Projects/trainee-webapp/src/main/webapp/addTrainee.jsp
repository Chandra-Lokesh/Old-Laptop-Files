<html>
<head>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-QWTKZyjpPEjISv5WaRU9OFeRpok6YctnYmDr5pNlyT2bRjXh0JMhjY6hW+ALEwIH" crossorigin="anonymous">
</head>
<body>
<jsp:include page="header.jsp"/>
<h2>Hello World!</h2>
<form action="trainees/add" method="post">
    <input type = "number" name = "id" placeholder="Enter id">
    <input type = "text" name = "name" placeholder="Enter name">
    <input type = "text" name = "location" placeholder="Enter location">
    <input type = "date" name = "joindate" placeholder="Enter joindate">
    <button type = "submit">Submit</button>
</form>
</body>
</html>
