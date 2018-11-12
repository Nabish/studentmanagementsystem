<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Staff</title>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<style type="text/css">
.icon.one{
          color: #FF715B;
      }
      .v5{
          background-color: #93A8AC;
          color: #484A47;
      }
    .checkmark {
    position: absolute;
    top: 0;
    left: 0;
    height: 25px;
    width: 25px;
    background-color: #ffffff;
    margin-left: 140px;
}
       /* check box ko css The container */
.checkk {
    display: inline-block;
    position: relative;
    margin-bottom: 0px;
    cursor: pointer;
    font-size: 18px;
    -webkit-user-select: none;
    -moz-user-select: none;
    -ms-user-select: none;
    user-select: none;
}
/* Hide the browser's default checkbox */
.checkk input {
    position: absolute;
    opacity: 0;
    cursor: pointer;
}
/* On mouse-over, add a grey background color */
.checkk:hover input ~ .checkmark {
    background-color: #ccc;
}

/* When the checkbox is checked, add a blue background */
.checkk input:checked ~ .checkmark {
    background-color: #2196F3;
}

/* Create the checkmark/indicator (hidden when not checked) */
.checkmark:after {
    content: "";
    position: absolute;
    display: none;
}

/* Show the checkmark when checked */
.checkk input:checked ~ .checkmark:after {
    display: block;
}

/* Style the checkmark/indicator */
.checkk .checkmark:after {
    left: 6px;
    top: 3px;
    width: 5px;
    height: 10px;
    border: solid white;
    border-width: 0 3px 3px 0;
    -webkit-transform: rotate(45deg);
    -ms-transform: rotate(45deg);
    transform: rotate(45deg);
}
</style>

</head>

<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
        <div class="container">
<h1><center>Add Teacher</center></h1>
<a href="staffview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Staff</button></a>
<div id="succssmessage"><h3><center>${message}</center></h3></div>
<form:form method="POST" class="form-horizontal" action="teachingstaffadd" commandName="teachingstaffModel">
<div class="row">
  <div class="col-md-6">
       
  <form:input type="text" path="teachingstaffId" hidden="true"/><br>
        <form:errors class="error" path="teacherUniqueKey"/>
	<form:input type="text" path="teacherUniqueKey" placeholder="Teacher Unique Key" class="input"/><br>
        <form:errors class="error" path="username"/>
	<form:input type="text" path="username" placeholder="Username" class="input"/><br>
        <form:errors class="error" path="password"/>
        <form:input type="text" path="password" placeholder="Password" class="input"/><br>
            <form:errors class="error" path="teacherName"/>
        <form:input type="text" path="teacherName" placeholder="Teacher Name" class="input"/><br>
        <form:errors class="error" path="teacherTemporaryAddress"/>
	<form:input type="text" path="teacherTemporaryAddress" placeholder="Temporary Address" class="input"/><br>
        <form:errors class="error" path="teacherPermanentAddress"/>
        <form:input type="text" path="teacherPermanentAddress" placeholder="Permanent Address" class="input"/>
  </div>
  <div class="col-md-6">
      <form:errors class="*"/>
      <form:errors class="error" path="teacherPhone"/>  
      <br><form:input type="text" path="teacherPhone" placeholder="Phone Number" class="input"/><br>
      <form:errors class="error" path="teacherMobile"/>
	<form:input type="text" path="teacherMobile" placeholder="Mobile Number" class="input"/><br>
        <form:errors class="error" path="teacherPreviousSchool"/>
	<form:input type="text" path="teacherPreviousSchool" placeholder="Previous School" class="input"/><br>
        <form:errors class="error" path="teacherQualification"/>
        <form:input type="text" path="teacherQualification" placeholder="Qualification" class="input"/><br>
        <form:errors class="error" path="teacherMartialStatus"/>
	<form:input type="text" path="teacherMartialStatus" placeholder="Marital Status" class="input"/><br>
        <form:errors class="error" path="teacherSalary"/><br>
        <label>Salary:</label><br><form:input type="text" path="teacherSalary" placeholder="Salary" class="input"/><br>
  </div>
</div>
<h3>Select subjects that teacher teaches:</h3>
  <div class="row">
      
                ${error}
                
         <c:forEach items="${classList}" var="classes">
             <div class="col-md-3">
               
                 <h4>${classes.className}</h4>
                     
         <c:forEach items="${subjects}" var="subject">
             <div class="col-md-2">
             <c:if test="${subject.classes.className eq classes.className}">
                 
         <label class="checkk"> <form:checkbox path="subject" name="subject" value="${subject.subjectId}"/><span class="checkmark"></span>${subject.subjectName}</label>
                     
                     </c:if>
             </div>
         </c:forEach>
                          </div>
         </c:forEach>
         
      
</div>
    <input type="submit" value="Add" style="float: left;"> 
</form:form>
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