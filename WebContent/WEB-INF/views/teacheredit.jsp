<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<meta charset="ISO-8859-1">
<style type="text/css">
 <%@include file="bootstrap.min.css" %>
 <%@include file="LogIn.css" %>
</style>
<title>Update Teacher</title>
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
              
            
    <div class="row" style="justify-content: center;">
        <div class="col-4">
            <form id="register" action="${pageContext.request.contextPath}/teacheredit" method="post">
               <div class="form-group" style="margin-top: 100px;">
                  <label for="inputFirstname">First name</label> 
                  <input type="text" class="form-control" id="inputFirstName" name="firstname" placeholder="Enter FirstName">
               </div>
                <div class="form-group">
                    <label for="inputLastName">Last name</label>
                    <input type="text" class="form-control" id="inputLastName" name="lastname" placeholder="Enter LastName">
                </div>
                <div class="form-group">
                    <label for="inputExperience">Experience</label>
                    <input type="text" class="form-control" id="inputExperience" name="experience" placeholder="Enter UserName">
                </div>
                <div style="text-align: right">
                    <button type="submit" class="btn btn-success">UPDATE</button>
                </div>
                </form>
        </div>
    </div>



</body>
</html>