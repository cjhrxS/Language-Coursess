<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
 <%@include file="bootstrap.min.css" %>
 <%@include file="LogIn.css" %>
</style>
</head>
<body>

<nav class="navbar navbar-expand-lg navbar-dark bg-dark fixed-top">
               <a class="navbar-brand" href="${pageContext.request.contextPath}/usercourse">Home</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                  <span class="navbar-toggler-icon"></span>
                </button>
                <div class="collapse navbar-collapse" id="navbarNav">
                  <ul class="navbar-nav mr-auto mt-2 mt-lg-0" id="superNavbar">
                    <c:if test="${roleId gt 1 }">
					<li class="nav-item">
                      <a class="nav-link" href="${pageContext.request.contextPath}/admin">Admin</a>
                    </li>
				</c:if>
                  </ul>
                  <form class="form-inline" >
                      <a class="nav-link btn btn-outline-danger my-2 my-sm-0" href="${pageContext.request.contextPath}/logout">Log Out</a>
                 </form>
                    </div>
              </nav>
              <br>
              
<div class="container-fluid h-100">
    <div class="row justify-content-center align-items-center h-100">
        <div class="col col-sm-6 col-md-6 col-lg-4 col-xl-3">
            <form action="">
            <h1>Admin Panel</h1>
                 <div class="form-group">
                   <a href="${pageContext.request.contextPath}/adminuser" class="btn btn-info btn-block" role="button">User</a>
                </div>
                 <div class="form-group">
                        <a href="${pageContext.request.contextPath}/adminteacher" class="btn btn-info btn-block" role="button">Teacher</a>
                </div>
                <div class="form-group">
                       <a href="${pageContext.request.contextPath}/admincourse" class="btn btn-info btn-block" role="button">Course</a>
                </div>
            </form>
        </div>
    </div>
</div>
  
</body>
</html>