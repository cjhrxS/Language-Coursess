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
<title>Sign Up</title>
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
            <form id="register" action="${pageContext.request.contextPath}/coursecreate" method="post">
               <div class="form-group" style="margin-top: 100px;">
                  <label for="inputNameCourses">Name</label> 
                  <input type="text" class="form-control" id="inputNameCourses" name="name_courses" placeholder="Enter Name of Course">
               </div>
                <div class="form-group">
                    <label for="inputPrice">Price</label>
                    <input type="text" class="form-control" id="inputPrice" name="price" placeholder="Enter Price">
                </div>
                <div class="form-group">
                    <label for="inputStartDate">Start Date</label>
                    <input type="text" class="form-control" id="inputStartDate" name="start_date" placeholder="Enter Start Date">
                </div>
                 <div class="form-group">
                    <label for="end_date">End Date</label>
                    <input type="text" class="form-control" id="inputEndDate" name="end_date" placeholder="Enter End Date">
                </div>
                 <div class="form-group">
                    <label for="inputTeacher">Teacher</label>
                    <input type="text" class="form-control" id="inputTeacher" name="teacher_id" placeholder="Select Teacher">
                </div>
                <div style="text-align: right">
                    <button type="submit" class="btn btn-success">Create</button>
                </div>
                </form>
        </div>
    </div>



</body>
</html>