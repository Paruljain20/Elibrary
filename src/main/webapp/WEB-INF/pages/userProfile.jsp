<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ page import="com.app.elib.bean.User"%>
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
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				WELCOME
				<% 
User user=(User)session.getAttribute("user");
out.print(user.getName().toUpperCase());
%>
				<!-- <input class="btn" type="button" value="Sign Out"
					onclick="getlogout()" style="float: right; padding: 2px 12px;" /> -->
			</div>
			<div class="panel-body">
				<form action="addBook" method="get">
					<button class="btn btn-primary" type="submit" name="abook"
						id="abook">Add Book</button>
				</form>
			</div>
			
		</div>
	</div>

</body>
<script type="text/javascript">
$(document).ready(function(){
	window.location.href = "/";
}

function getlogout(){
	$.ajax({
		type:"GET",
		  url: "logout",
		  success: function name() {
			window.location.href = "/Elibrary/";
		}
		});
}

</script>
</html>
