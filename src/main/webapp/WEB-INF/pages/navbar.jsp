<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE nav PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
#lblCartCount{
    font-size: 8px;
    background: white;
    color: black;
    padding: 0 5px;
    vertical-align: top;
}
</style>
</head>
</html>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">My eLibrary</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/Elibrary">Home</a></li>
      <li><c:if test="${session != null}">
      <a href="<%=request.getContextPath()%>/loadBooks/myBooks">My Books</a>
      </c:if>
      </li>
      <li>
      <a href="<%=request.getContextPath()%>/loadBooks/1">Browse</a></li>
      <c:if test="${session == null}">
      <li><a href="<%=request.getContextPath()%>/loginForm">Sign In</a></li>
      <li><a href="<%=request.getContextPath()%>/registerUser">Sign Up</a></li>
      </c:if>
    </ul>
    <form class="navbar-form navbar-left" action="/action_page.php">
      <div class="input-group">
        <input type="text" class="form-control" placeholder="Search" name="search">
        <div class="input-group-btn">
          <button class="btn btn-default" type="submit">
            <i class="glyphicon glyphicon-search"></i>
          </button>
        </div>
      </div>
    </form>
     <div class="navbar-header">
     <c:if test="${session != null}">
      <a class="navbar-brand" href="<%=request.getContextPath()%>/gotoCart"><span class="glyphicon glyphicon-shopping-cart"></span><asp:Label ID="lblCartCount" runat="server" CssClass="badge badge-warning"  ForeColor="White"/>${bookList.size()}</a>
     <a class="navbar-brand" href="<%=request.getContextPath()%>/userProfile"><span class="glyphicon glyphicon-user"></span></a></c:if>
    </div>
     <ul class="nav navbar-nav">
      <li><c:if test="${session != null}">
      <a href="<%=request.getContextPath()%>/logout">Sign Out</a>
      </c:if>
      </li>
     </ul>
  </div>
</nav>