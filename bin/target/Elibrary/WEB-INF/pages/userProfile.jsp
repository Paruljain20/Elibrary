<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Bootstrap Example</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">My eLibrary</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/MavenElibrary/">Home</a></li>
      <li><a href="mybook.jsp">My Books</a></li>
      <li><a href="newBooks">New Books</a></li>
      <li><a href="loginForm">Log In</a></li>
      <li><a href="registerUser">Sign Up</a></li>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
  </div>
</nav>

<div class="container">
  <div class="panel panel-primary">
  <div class="panel-heading">WELCOME ${fn:toUpperCase(userData.name)}</div>
  <div class="panel-body">
  </div>
  </div>
</div>

</body>
</html>