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
	<div class="container col-md-6" style="float: unset;  padding: 70px;">
		<div class="panel panel-primary">
		<div class="panel-heading">Reset Password</div>
		<c:if test="${message != null}">
			<div>
			<p  style="padding: 50px;">${message}</p>
			</div>
			</c:if>
			<c:if test="${successMsg != null }">
			<div>
			<p  style="padding: 10px;">${successMsg}</p>
			<a href="/Elibrary/loginForm" style="padding-left: 10px;">Now Login From here</a>
			</div>
			</c:if>
			<c:if test="${errorMsg != null }">
			<div>
			<p  style="padding: 10px;">${errorMsg}</p>
			</div>
			</c:if>
		</div>
	</div>

</body>
</html>

