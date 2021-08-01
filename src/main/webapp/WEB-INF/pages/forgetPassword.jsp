<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html lang="en">
<head>
<title>Elibrary</title>
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
	<div class="container col-md-4" style="float: unset;padding: 70px;">
		<div class="panel panel-primary">
			<div class="panel-heading">Enter Email Here</div>
			<div class="panel-body">
			<c:if test="${message != null }">
			<p style="color: red;">${message}</p>
			</c:if>
				<form action="/Elibrary/resetPassword" method="Post">
					<fieldset class="form-group">
						<span><label class="control-label" for="email">
								Email</label> <input class="form-control col-sm-4" type="text"
							name="email" id="email" placeholder="Enter Email" value="" /> </span>
					</fieldset>
					<div class="form-group row">
						<div class="col-md-4">
							<button class="btn btn-primary" type="submit" name="resetPassword"
								id="login">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>

</body>
</html>

