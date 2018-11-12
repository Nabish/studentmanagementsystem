<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Transportation Form</title>
   <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
  
</head>
<style type="text/css">
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
        <h1><center>Add Transportation</center></h1>
        <a href="transportationview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Transport</button></a>
        <div id="succssmessage"><h3><center>${message}</center></h3></div>
	<div class="row">
	<div class="col-md-6">
  <form:form method="POST" class="form-horizontal" action="addtransportation" commandName="transportationModel">
        <form:input type="text" path="transportationId" placeholder="Transportation ID" hidden="true" class="input"/>
        <form:errors class="error" path="busNumber"/>
        <form:input type="text" path="busNumber" placeholder="Bus no." class="input"/>    
        <form:label path="">Bus Capacity:</form:label><br><form:errors class="error" path="busCapacity"/>
        <form:input type="text" path="busCapacity" placeholder="Bus Capacity" class="input"/><br>        
        <form:errors class="error" path="busRoute"/>
        (Example:kalimati-teku-tripureswor....)
        <form:input type="text" path="busRoute" placeholder="Bus Route" class="input"/><br>
        <form:errors  class="error" path="driverName"/>
        <form:input type="text" path="driverName" placeholder="Driver Name" class="input"/><br>
        <form:errors class="error" path="driverPhone"/>
        <form:input type="text" path="driverPhone" placeholder="Driver Phone" class="input"/><br>
        <form:errors class="error" path="driverAddress"/>
        <form:input type="text" path="driverAddress" placeholder="Driver Address" class="input"/><br>
	<input type="submit" value="Add" style="float: left;">
</div>
</form:form>
<div class="col-md-6">
	<img  style="width: 100%; max-height: 500px; align-content: center; padding-bottom: 120px; object-fit:contain; " src="<c:url value="/resources/image/bus.png"/>">
</div>
</div>
            </div>
        </div>
                <script src="jquery-1.12.4.min.js"></script>
        <script>
       
        $( document ).ready(function(){
            $('#succssmessage').fadeIn('slow', function(){
               $('#succssmessage').delay(5000).fadeOut(); 
            });
        });
        </script>
</body>
</html>
