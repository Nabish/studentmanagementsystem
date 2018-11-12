<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Staff</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
    
</head>

    <style>
      .icon.one{
          color: #FF715B;
      }
      .v5{
          background-color: #93A8AC;
          color: #484A47;
      }
    </style>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
        <div class="container">
<h1><center>Add Staff</center></h1>
<a href="staffview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Staff</button></a>
<div id="succssmessage"><h3><center>${message}</center></h3></div>
<div class="row">
  <div class="col-md-6">
      <form:form method="POST" class="form-horizontal" action="staffadd" commandName ="staffModel">
          <br><form:input type="text" hidden="true" path="staffId" class="input"/>
          <form:errors class="error" path="staffName"/>
          <form:input type="text" placeholder="Staff Name" path="staffName" class="input"/><br>
          <form:errors class="error" path="staffTemporaryAddress"/>
        <form:input type="text" placeholder="Temporary Address" path="staffTemporaryAddress" class="input"/><br>
        <form:errors class="error" path="staffPermanentAddress"/>
        <form:input type="text" placeholder="Permanent Address" path="staffPermanentAddress" class="input"/><br>
        <form:errors class="error" path="staffQualification"/>
        <form:input type="text" placeholder="Qualification" path="staffQualification" class="input"/><br>
        <form:errors class="error" path="staffSalary"/>
        <form:label path="" >Salary: </form:label><br>
        <form:input type="text" placeholder="Salary" path="staffSalary" class="input"/><br>
</div>
  <div class="col-md-6">
      <form:errors class="error" path="staffPhone"/>
      <form:input type="text" placeholder="Phone No." path="staffPhone" class="input"/><br>
      <form:errors class="error" path="staffMobile"/>
      <form:input type="text" placeholder="Mobile No." path="staffMobile" class="input"/><br>
      <form:errors class="error" path="role"/>
  <form:label path="role" >Role: </form:label><br>
   <form:select path="role">
       <form:option value="Accountant">Accountant</form:option>
       <form:option value="Librarian">Librarian</form:option>
   </form:select> 
    <br><form:errors class="error" path="staffMartialStatus"/>
<div class="switch-field">
      <form:radiobutton path = "staffMartialStatus" value = "Married" id="switch_left"/><form:label for="switch_left" style="color:grey;" path = "staffMartialStatus">Married</form:label>
      <form:radiobutton path = "staffMartialStatus" value = "Single" id="switch_right"/><form:label for="switch_right" style="color:grey;" path = "staffMartialStatus" >Single</form:label>
      
      
    </div>	
</div>
   
</div>
    <div style="margin-left: 1%;">
<input type="submit" value="Add">
</div>
</div>
      </div>
</form:form>
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

