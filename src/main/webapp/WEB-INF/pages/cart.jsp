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
		<div id="smart-button-container">
      <div style="text-align: center;">
        <div id="paypal-button-container"></div>
      </div>
    </div>
	    </c:if>
	</div>

</body>
  <script src="https://www.paypal.com/sdk/js?client-id=sb&enable-funding=venmo&currency=USD" data-sdk-integration-source="button-factory"></script>
  <script>
    function initPayPalButton() {
      paypal.Buttons({
        style: {
          shape: 'rect',
          color: 'gold',
          layout: 'vertical',
          label: 'paypal',
          
        },

        createOrder: function(data, actions) {
          return actions.order.create({
            purchase_units: [{"amount":{"currency_code":"USD","value":1}}]
          });
        },

        onApprove: function(data, actions) {
          return actions.order.capture().then(function(details) {
            alert('Transaction completed by ' + details.payer.name.given_name + '!');
          });
        },

        onError: function(err) {
          console.log(err);
        }
      }).render('#paypal-button-container');
    }
    initPayPalButton();
  </script>