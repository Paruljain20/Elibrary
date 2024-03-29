<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page import="com.app.elib.bean.User"%>
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

	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">
				WELCOME
				<% 
User user=(User)session.getAttribute("user");
out.print(user.getName().toUpperCase());
%>
			</div>	
			<div class="panel-body">
			<c:if test="${user.isLibrarian()}">
				<form action="addBook" method="get">
					<button class="btn btn-primary" type="submit" name="abook"
						id="abook">Add Book</button>
				</form>
			</c:if>
		 </div>
		</div>
	</div>

</body>
<script type="text/javascript">
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
