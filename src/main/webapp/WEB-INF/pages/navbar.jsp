<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<nav class="navbar navbar-inverse">
  <div class="container-fluid">
    <div class="navbar-header">
      <a class="navbar-brand" href="#">My eLibrary</a>
    </div>
    <ul class="nav navbar-nav">
      <li><a href="/Elibrary">Home</a></li>
      <li><c:if test="${session != null}">
      <a href="mybook.jsp">My Books</a>
      </c:if>
      </li>
      <li><a href="loadBooks">Browse</a></li>
      <li><a href="loginForm">Sign In</a></li>
      <li><a href="registerUser">Sign Up</a></li>
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
      <a class="navbar-brand" href="gotoCart"><span class="glyphicon glyphicon-shopping-cart"></span></a>
     <a class="navbar-brand" href="userProfile"><span class="glyphicon glyphicon-user"></span></a></c:if>
    </div>
     <ul class="nav navbar-nav">
      <li><c:if test="${session != null}">
      <a href="logout">Sign Out</a>
      </c:if>
      </li>
     </ul>
  </div>
</nav>