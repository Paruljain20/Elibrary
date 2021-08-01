<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
<style type="text/css">
.dollar {
	display: inline-block;
	position: relative;
}

.dollar input {
	padding-left: 15px;
}

.dollar:before {
	position: absolute;
	top: 0;
	content: "$";
	left: 5px;
	top: 2px;
}
}
</style>
</head>
<body>

	<jsp:include page="navbar.jsp" />

	<div class="container">
		<div class="panel panel-primary">
			<div class="panel-heading">Add Book</div>
			<div class="panel-body">
				<form action="saveBook" method="post" enctype="multipart/form-data">
					<fieldset class="form-group">
						<span><label class="control-label" for="name">Book
								Name</label> <input class="form-control col-md-4" type="text"
							name="name" id="name" placeholder="Enter Book Name"
							required="required" /> </span>
					</fieldset>

					<fieldset class="form-group">
						<span><label class="control-label" for="category">Category</label>
						<select class="form-control col-md-4" id="category" name="category">
						<option>Select Category</option>
						<c:forEach items="${catList}" var="bookCatList">
						<option>${bookCatList.getName()}</option>
						</c:forEach>
						</select>
						</span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="author">Author
								Name</label> <input class="form-control col-md-4" type="text"
							name="author" id="author" placeholder="Enter Author Name"
							required="required" /> </span>
					</fieldset>
					<fieldset class="form-group input-group">
						<span><label class="control-label" for="price">Price
						</label></span>
						<div class="input-group">
							<span class="input-group-addon">$</span> <input
								class="form-control col-md-4" type="text" name="price"
								id="price" placeholder="Enter Price Of Book" required="required" />
						</div>

					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="detail">Detail
								Of Book </label> <textarea class="form-control col-md-4" name="detail"
								id="detail" placeholder="Enter Detail Of Book"> </textarea></span>
					</fieldset>
					<fieldset class="form-group">
						<span><label class="control-label" for="detail">Choose
								File </label><input type="file" id="file" name="file" required="required"></span>
					</fieldset>

					<div class="form-group row">
						<div class="col-md-4">
							<button class="btn btn-primary" type="submit" name="book"
								id="book">Submit</button>
								<a class="btn btn-primary" role="button" onclick="goBack()">Back</a> 
						</div>
						
					</div>
				</form>
			</div>
		</div>
	</div>
	<script type="text/javascript">
	function goBack(){
		window.history.back();
	}
</script>
</body>
</html>

