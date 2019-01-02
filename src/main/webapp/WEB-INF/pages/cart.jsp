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

	<jsp:include page="navbar.jsp" />
	<div class="container">
		<div class="panel-group">
			<c:forEach begin="1" end="${bookList.size()}" var="i" step="1">
				<c:set var="collapseId" value="${collapse-i}" />
				<div class="panel panel-primary" id="accordion">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse" href="#${collapseId}"
								aria-controls="collapseOne">${bookList.get(i-1).getName()}</a>
						</h4>
					</div>
					<div id="${collapseId}" class="panel-collapse collapse in">
						<div class="panel-body">
							<ul>
								<li><label class="control-label">Category</label> :
									${bookList.get(i-1).getCategory()}</li>
								<li><label class="control-label">Title</label> :
									${bookList.get(i-1).getName()}</li>
								<li><label class="control-label">Author</label>
									:${bookList.get(i-1).getAuthor()}</li>
								<li><label class="control-label">Detail</label> :
									${bookList.get(i-1).getDetail()}</li>
								<li><label class="control-label">Price</label> :
									$${bookList.get(i-1).getPrice()}</li>
							</ul>
							<input class="btn btn-danger" id="removeToCart" type="button"
								value="Remove From Cart"
								onclick="removeToWishList(${bookList.get(i-1).getEbid()})" />
						</div>
					</div>
				</div>
			</c:forEach>
		</div>
		<c:if test="${bookList.size() > 0}">
		<input class="btn btn-warning" id="payNow" type="button" value="Continue" onclick="paymentPortal()"/>
	    </c:if>
	</div>

</body>
<script type="text/javascript">
function removeToWishList(ebid){
	
	$.ajax({
	 type:"get",
	 url : "removeToWishList",
	 data : "ebid="+ebid,
	 success : function(response) {
		 location.reload();
		},
	error : function(){
	}
	});
}

function paymentPortal(){
	$.ajax({
	     type:"GET",
		 url :"pay",
		 dataType: "json",
		 success : function(data) {
			 console.log("response" + data.redirect_url);
		            window.location = data.redirect_url;
			},
		error : function(response){
			console.log("error");
		}
		});
}
</script>