<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Bootstrap Example</title>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<script
	src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container col-md-4" style="float: unset;">
		<c:if test="${message != null || message != ''}">
			<div>
				<label style="font-style: italic; color: red;">${message}</label>
			</div>
		</c:if>
		<div class="panel panel-primary">
			<div class="panel-heading">Log In Here</div>
			<div class="panel-body">
				<form action="loginUser" method="post">
					<fieldset class="form-group">
						<span><label class="control-label" for="email">
								Email</label> <input class="form-control col-sm-4" type="text"
							name="email" id="email" placeholder="Enter Email" value="" /> </span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="password">
								Password</label> <input class="form-control col-sm-4" type="password"
							name="password" id="password" placeholder="Enter Password"
							value="" /> </span>
					</fieldset>
					<div class="form-group row">
						<div class="col-md-4">
							<button class="btn btn-primary" type="submit" name="login"
								id="login">Login</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>

