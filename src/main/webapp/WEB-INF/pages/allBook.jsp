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
			<c:forEach begin="1" end="${list.size()}" var="i" step="1">
			<c:set var="collapseId" value="${collapse-i}"/>
				<div class="panel panel-primary" id="accordion">
					<div class="panel-heading">
						<h4 class="panel-title">
							<a data-toggle="collapse"
								href="#${collapseId}" aria-controls="collapseOne">${list.get(i-1).getName()}</a>
						</h4>
					</div>
					<div id="${collapseId}" class="panel-collapse collapse in">
						<div class="panel-body">
							<ul>
								<li><label class="control-label">Category</label> : ${list.get(i-1).getCategory()}</li>
								<li><label class="control-label">Title</label> : ${list.get(i-1).getName()}</li>
								<li><label class="control-label">Author</label> :${list.get(i-1).getAuthor()}</li>
								<li><label class="control-label">Detail</label> : ${list.get(i-1).getDetail()}</li>
								<li><label class="control-label">Price</label> : $${list.get(i-1).getPrice()}</li>
							</ul>
							 <input  class="btn btn-success" id="addToCart" type="button"
							  value="Add To Cart" onclick="addToWishList(${list.get(i-1).getEbid()})" />
							  <input class="btn btn-warning" id="payNow" type="button" value="Buy Now"/>
				
						</div>
					</div>
				</div>
			</c:forEach>
			
			<%-- List of books --%>
			<c:if test="${list.size() <= 0}">
			<div class="panel panel-primary">
			<div class="panel-heading">Book</div>
			<div class="panel-body"  style="padding: 10px;">
			<label class="control-label">There is no Book Added Yet!!</label>
			<form action="addBook" method="get">
					<button class="btn btn-primary" type="submit" name="abook"
						id="abook">Add Book</button>
			</form>
			</div>
			</div>
			</c:if>
		</div>
		<div>
		<c:if test="${listOfAllBook.size() > 2 }">
		<!-- Pagination links in spring mvc. -->    
		<c:forEach begin="1" end="${listOfAllBook.size()%2 == 0 ? listOfAllBook.size()/2 : (listOfAllBook.size()+1)/2}" var="j" step="1">       
              <ul class="pagination pagination-sm">
                <li class="page-item"><a class="page-link" href="<%=request.getContextPath()%>/loadBooks/${j}">${j}</a></li>
                </ul>
        </c:forEach>  
		</c:if>
		</div>
	</div>
</body>
<script type="text/javascript">

function addToWishList(ebid){
	
	$.ajax({
	 type:"get",
	 url : "addBookToWishList",
	 data : "ebid="+ebid,
	 success : function(response) {
		 console.log("response" + response);
		 if(response){
		 alert(response);
		 }else{
		 $("#addToCart").prop("value","Added to Cart");
		 $("#addToCart").prop( "disabled", true );
		 }
		},
	error : function(){
	}
	});
}

</script>
</html>

