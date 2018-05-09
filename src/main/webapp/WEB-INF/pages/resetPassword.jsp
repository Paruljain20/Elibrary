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

	<div class="container col-md-4" style="float: unset;padding: 70px;">
		<div class="panel panel-primary">
			<div class="panel-heading">Reset Your Password Here</div>
			<div class="panel-body">
			
				<form action="/Elibrary/doResetPassword" method="Post">
					<fieldset class="form-group">
						<span><label class="control-label" for="password">
								New Password</label> <input class="form-control col-sm-4" type="password"
							name="password" id="password" placeholder="Enter New Password" value="" onkeyup="confirmPassword(this.value)" required="required"/> </span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="cpassword">
								Confirm Password</label> <input class="form-control col-sm-4" type="password"
							name="cpassword" id="cpassword" placeholder="Enter Password Again" value="" onkeyup="confirmPassword(this.value)" required="required"/> </span>
					</fieldset>
					<div name="errorMessage">
						<p style="font-style: italic; color: red;"></p>
					</div>
					<input type="text" hidden="true" value="${email}" name="email" id="email">
					<div class="form-group row">
						<div class="col-md-4">
							<button class="btn btn-primary" type="submit" name="resetPassword"
								id="resetPassword">Submit</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
		$(document).ready(function() {
			console.log("email "+'${email}');
			$("p").hide();
		});
function confirmPassword(fieldname) {
			var passowrd = $("#password").val();
			var confirmPassword = $("#cpassword").val();
			if (passowrd == confirmPassword) {
				$("p").hide();
				$("#resetPassword").attr('disabled', false);
				$("#" + fieldname).focus();
			} else {
				$("p").hide();
				$("#resetPassword").attr('disabled', true);
				$("#" + fieldname).focus();
				$("p").text('Invalid Password');
				$("p").show();
			}
}
			</script>
</body>
</html>

