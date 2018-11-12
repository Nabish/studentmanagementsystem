<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Class</title>
  
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

</head>
   <style type="text/css">
    .icon.one{
        color: #FF715B;
    }
    .v1{
        background-color: #93A8AC;
        color: #484A47;
    }
    td{
        text-align: center;
    }
      
   </style>
<body>
     <%@include file="navbar.jsp" %>
     <%@include file="viewsidenav.jsp" %>
     
    <div class="main">
        <div class="container">
    <h1><center>Add Class</center></h1>
    <a href="classview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Class</button></a>
<div id="succssmessage"><h3><center>${message}</center></h3></div>
<div class="row">
  <div class="col-md-6">
	<div class="form-group">
  <form:form method="POST" class="form-horizontal" action="classadd" commandName = "classModel">
      <form:errors class="error" path="classUniqueKey" id="input"/>
      <span id="myspan"></span>
	<br><form:input type="text" path="classUniqueKey" placeholder="Class Unique Key" id="input" class="input"/>
        <br><form:errors class="error" path="className"/>
	<form:input type="text" path="className" placeholder="Class Name" class="input"/>
        <br><form:errors class="error" path="classCapacity"/>
        <form:input type="text" path="classCapacity" placeholder="Class Capacity" class="input" />
	<input type="submit" value="Add" >
  </form:form>
</div>
</div>
<div class="col-md-6">
  <img  style="width: 80%; height:auto; align-content: center;" src="<c:url value="/resources/image/class.png"/>">
  <table class="table success">
      <tr>
          <th>Class Unique Key</th>
          <th>Class Name</th>
          <th>Class Capacity</th>
      </tr>
      <c:forEach items="${classes}" var="classlist">
        <tr>
          <td>${classlist.classUniqueKey}</td>
          <td>${classlist.className}</td>
          <td>${classlist.classCapacity}</td>
      </tr>
      </c:forEach>
  </table>
      
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
        $(document).ready(function() {
    $("#input").keydown(function (e) {
        // Allow: backspace, delete, tab, escape, enter and .
        if ($.inArray(e.keyCode, [46, 8, 9, 27, 13, 110]) !== -1 ||
             // Allow: Ctrl+A
            (e.keyCode == 65 && e.ctrlKey === true) || 
             // Allow: home, end, left, right
            (e.keyCode >= 35 && e.keyCode <= 39)) {
                 // let it happen, don't do anything
                 return;
        }
        // Ensure that it is a number and stop the keypress
        if ((e.shiftKey || (e.keyCode < 48 || e.keyCode > 57)) && (e.keyCode < 96 || e.keyCode > 105)) {
            e.preventDefault();
            document.getElementById("myspan").textContent="Please Enter Number in class unique key field";
        }
    });
});
       

        </script>
</body>
</html>
