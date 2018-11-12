<!DOCTYPE html>
<html>
<head>
	<title>View Fee Details</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
</head>
<style>
.icon.one{
    color: #FF715B;
}
.v13{
    background-color: #93A8AC;
    color: #484A47;
}
</style>

<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
	<div class="container">
	<h1><center>Fee Details</center></h1>
        <a href="feeForm"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Fee</button></a>
<section>
    <div class="table-responsive">          
  	<table class="table">
            <thead>
  		<tr>
                    <td><b>Class ID</b></td>
                    <td><b>Fee ID</b></td>
                    <td><b>Tution Fee</b></td>
                    <td><b>Transportation Fee</b></td>
                    <td><b>ECA Fee</b></td>
                    <td><b>Library Fee</b></td>
                    <td><b>Computer Fee</b></td>
                    <td><b>Options</b></td>
      		</tr>
            </thead>
            <tbody>
                <c:forEach items="${fee}" var="fee">
                    <tr class='clickable-row' data-href=''>
                        <td>${fee.classes.className}</td>
                        <td>${fee.feeId}</td>
                        <td>${fee.tutionfee}</td>
                        <td>${fee.transportationfee}</td>
                        <td>${fee.ecafee}</td>
                        <td>${fee.libraryfee}</td>
                        <td>${fee.computerfee}</td>
                        <td><a href="feeedit?id=${fee.feeId}" name="edit"><button type="button" class="btn btn-success" ><i class="fas fa-edit"></i> Edit</button></a> 
                            <a href="feedelete?id=${fee.feeId}" name="delete"><button type="button" class="btn btn-danger" ><i class="fas fa-trash"></i> Delete</button></td></a>
                    </tr>
                 </c:forEach>
            </tbody>
        </table>
  </div>
</section>
</div>
    </div>
<script>
	jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
	
</script>
</body>
</html>
