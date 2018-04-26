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
      <li><a href="index.html">Home</a></li>
      <li><a href="mybook.html">My Books</a></li>
      <li><a href="index.html">Browse</a></li>
      <li><a href="login.html">Log In</a></li>
      <li><a href="register.html">Sign Up</a></li>
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

<div class="container col-md-4" style="float:unset;">
  <div class="panel panel-primary">
    <div class="panel-heading">Log In Here</div>
    <form >
			<div class="panel-body">
				<div class="form-group">
					<label for="usr">Email:</label> <input type="text"
						class="form-control" id="usr" placeholder="Enter Email-id">
				</div>
				<div class="form-group">
					<label for="usr">Password:</label> <input type="text"
						class="form-control col-sm-4" id="usr" placeholder="Enter Password">
				</div>
				</br>
				<div class="form-group">
					<button type="button" class="btn btn-primary">Login</button>
				</div>
			</div>
			</form>
		</div>
</div>

</body>
</html>

