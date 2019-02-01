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
              
<h1>UserItems</h1>

 
	<br><br>
	
	<div id="myTable">
	<div id="btnCourse">
	  <a  href="${pageContext.request.contextPath}/usercreate" type="submit" class="btn btn-outline-success btn-lg">Create</a>
	  </div>
	<div class="row">
	<c:set var="currentUsers" value="${userAdminDTO.users}"/>
	<c:if test="${currentUsers ne null && currentUsers.size() gt 0}">
		<table class="table table-dark table-bordered table-striped text-cneter">
		<thead>
            <tr>
             <th scope="col">Id</th>
             <th scope="col">First Name</th>
             <th scope="col">Last Name</th>
             <th scope="col">User Name</th>
             <th scope="col">Password</th>
             <th scope="col">Role</th>
             </tr>
         </thead>
			<c:forEach var="row" items="${currentUsers}">
				<tr>
				    <td>${row.getId()}</td>
					<td>${row.getFirst_name()}</td>
					<td>${row.getLast_name()}</td>
					<td>${row.getUser_name()}</td>
					<td>${row.getPass_word()}</td>
					<td>${row.getRoles_id()}</td> 
					<td><a class="btn btn-outline-light" href="${pageContext.request.contextPath}/useredit?idUser=${row.getId()}">Edit</a></td>
					<td><a class="btn btn-outline-danger" href="#" onclick="checkDeleteItem('${pageContext.request.contextPath}/userdelete?idUserDelete=${row.getId()}')">Delete</a></td>
				</tr>
			</c:forEach>	
		</table>
		</c:if>
		</div>
		</div>
		<br>
		
	
	<br><br>
	<c:set var="currentCourses" value="${userCourseDto.courses}"/>
		<c:if test="${countItems/visibleItems gt 1}">
			<br><br>
			<a href="${hostContext}/useritems?pageNumber=1">1</a>
			&nbsp;...
			&nbsp;<a href="${hostContext}/useritems?pageNumber=1">4</a>
			&nbsp;
			&nbsp;<a href="${hostContext}/useritems?pageNumber=1">6</a>
			&nbsp;...
			&nbsp;<a href="${hostContext}/useritems?pageNumber=1">100</a>
		</c:if>
	<script type="text/javascript">
		function checkDeleteItem(url) {
			if (confirm("Are you sure?")) {
				window.location.href = url;
			}
		}
		function selectVisibleItems(url) {
			var visibleItems = document.getElementById("idVisibleItems");
			window.location.href = url
				+ visibleItems.options[visibleItems.selectedIndex].value;
		}
		
	</script>
</body>
</html>