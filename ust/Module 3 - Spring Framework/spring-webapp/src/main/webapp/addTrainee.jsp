<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Add Trainee</title>
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
</head>
<body>
    <div class="container mt-4">
        <h2 class="text-center">Add Trainee</h2>
        <form action="/add-trainee" method="post">
            <div class="form-group">
                <input type="text" name="id" class="form-control" placeholder="Enter id" required>
            </div>
            <div class="form-group">
                <input type="text" name="name" class="form-control" placeholder="Enter name" required>
            </div>
            <div class="form-group">
                <input type="text" name="location" class="form-control" placeholder="Enter location" required>
            </div>
            <button type="submit" class="btn btn-primary">Add Trainee</button>
        </form>
    </div>
</body>
</html>
