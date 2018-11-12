<!DOCTYPE html>
<html>
<head>
	<title>View Transport</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
$(document).ready(function(){
    $("a.delete").click(function(e){
        if(!confirm('Are you sure?')){
            e.preventDefault();
            return false;
        }
        return true;
    });
});
</script>
</head>
<style>
         .icon.one{
          color: #FF715B;
      }
      .v7{
          background-color: #93A8AC;
          color: #484A47;
      }
</style>

<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
	<div class="container">
	<h1><center>Transportation Info</center></h1>
        <a href="addtransportationform"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Transport</button></a>
<section>
	<div class="table-responsive">          
  	<table class="table">
  		<thead>
  			<tr>
      			<td><b>Transportation ID</b></td>
      			<td><b>Bus Number</b></td>
      			<td><b>Bus Capacity</b></td>
      			<td><b>Bus Route</b></td>
                        <td><b>Driver Name</b></td>
                        <td><b>Phone Number</b></td>
            <td></td>
      		</tr>
  		</thead>
  		<tbody>
                    <c:forEach items="${bus}" var="transport">
                        <tr>
                          <td>${transport.transportationId}</td>
                          <td>${transport.busNumber}</td>
                          <td>${transport.busCapacity}</td>
                          <td>${transport.busRoute}</td>
                          <td>${transport.driverName}</td>
                          <td>${transport.driverPhone}</td>
                          <td><a href="transportationedit?id=${transport.transportationId}" name="edit"><button type="button" class="btn btn-success"><i class="fas fa-edit"></i> Edit</button> </a>
                              <a href="transportationdelete?id=${transport.transportationId}" name="delete" onclick="return confirm('Are you sure you want to delete information?')"><button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</button></a></td>
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