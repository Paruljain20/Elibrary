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

<jsp:include page="navbar.jsp" />  

	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Sign Up</div>
			<div class="panel-body">
				<form action="saveUser" method="post">
						<fieldset class="form-group">
						<span><input type="checkbox" name="librarian" /> <label
							class="control-label" for="lib">Are You want To Register
								as Librarian</label></span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="name">
								Name</label> <input class="form-control col-md-4" type="text"
							name="name" id="name" placeholder="Enter Name" /> </span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="email">Email
								Address</label> <input class="form-control col-md-4" type="text"
							name="email" id="email" placeholder="Enter Email Address" onkeyup="validateEmail(this.value)"/> </span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="password">Password</label>
							<input class="form-control col-md-4" type="password" name="password"
							id="password" placeholder="Enter Password" onkeyup="confirmPassword('password')"/> </span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="confirmpassword">Confirm
								Password</label> <input class="form-control col-md-4" type="password"
							name="cpassword" id="cpassword" placeholder="Confirm Password" onkeyup="confirmPassword('cpassword')"/>
						</span>
					</fieldset>
					<div name="errorMessage">
					<p></p>
					</div>
					<div class="form-group row">
						<div class="col-md-4">
							<button class="btn btn-primary" type="submit" name="register" id="register">Register</button>
						</div>
					</div>
				</form>
			</div>
		</div>
	</div>
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"
		integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js"
		integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl"
		crossorigin="anonymous"></script>
		<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
		
		<script type="text/javascript">
		$(document).ready(function(){
			$("p").hide();
		});
		
		function confirmPassword(fieldname){
			var passowrd  = $("#password").val();
			var confirmPassword = $("#cpassword").val();
			if(passowrd == confirmPassword){
				$("p").hide();
				console.log("inside if");
				$("#register").attr('disabled', false);
				$("#"+fieldname).focus();
			}
			else{
				$("p").hide();
				$("#register").attr('disabled', true);
				$("#"+fieldname).focus();
				$("p").text('Invalid Password');
				$("p").show();
			}
		}
		
		function validateEmail(currentEmail){
			console.log(currentEmail);
			 $.ajax({
				type:"GET",
				url:"validateEmail",
				data:{email: currentEmail},
				success:function(data1){
					 console.log(data1.result);
					return data1;
				}
     
			});
     
		}
		</script>

</body>
</html>

