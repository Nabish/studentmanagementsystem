<!DOCTYPE html>
<html lang="en">
<head>
  <title>Super Admin Dashboard</title>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

</head>
<style type="text/css">
th,td{
	text-align: center;
}
a{
    text-decoration: none;
}
</style>
<%@include file="supernavbar.jsp" %>
<h1><center>Dashboard</center></h1>
<div class="container">
<div class="table-responsive">  
<table class="table table-bordered table-hover">
	<tr>
		<th>Unique School ID</th>
		<th>School Name</th>
		<th>Address</th>
		<th>Email ID</th>
		<th>Phone No.</th>
		<th>Expiry Date</th>
		<th>Action</th>
	</tr>
        <c:forEach items="${adminlist}" var="admins">
        <tr>
            <td>${admins.adminid}</td>
            <td>${admins.schoolName}</td>
            <td>${admins.schoolAddress}</td>
            <td>${admins.schoolEmail}</td>
            <td>${admins.schoolPhoneNumber}</td>
            <td>${admins.expirydate}</td>
            <td><button class="btn btn-success"><a href="editadmininfo?adminid=${admins.adminid}">Edit</a></button></td>
	</tr> 
        </c:forEach>
    
	
</table>
</div>
</div>
</body>
</html>