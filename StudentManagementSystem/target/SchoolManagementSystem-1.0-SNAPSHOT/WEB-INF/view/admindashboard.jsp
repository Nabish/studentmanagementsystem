<!DOCTYPE html>
<html lang="en">
<head>
  <title>SMS | Admin Dashboard</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  
  <style>
      .icon.one{
          color: #FF715B;
      }
  </style>
</head>
<body>
    
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
    <%@include file="balloon.jsp" %>
    
    <div class="main">     
    
<div class="container" style="padding-top: 30px;">
    <ul class="adminul col-md-12">
        <div class="col-md-3" style="float: left;"><li style="background-color: #011627; opacity:0.7;"><span class="fas fa-user-graduate icon"></span><h2>${totalstudent}</h2>Total Students </span></li></div>
        <div class="col-md-3" style="float: left;"><li style="background-color: #2ec4b6; opacity:0.7;"><span class="fas fa-user icon"></span><h2>${totalteacher}</h2>Total Teachers</li></div>
        <div class="col-md-3" style="float: left;"><li style="background-color: #e71d36; opacity:0.7;"><span class="fas fa-chalkboard icon"></span><h2>${otherstaff}</h2>Total Other staff</li></div>
        <div class="col-md-3" style="float: left;"><li style="background-color: #ff9f1c; opacity:0.7;"><span class="fas fa-envelope icon"></span><h2>${newmessage}</h2>New Messages</li></div>
    </ul><br>
<div class="row">
    <div class="col-md-6 ">
        <%@include file="dashboardcalendar.jsp" %>
    </div>
    <div class="col-md-6">
        <div class="bday">
             <center>
                                     
            <div class="balloon">
                <div>
                </div>
                <div></div>
                
            </div> 
                 <h2>Birthday Today</h2><br>
                 <table class="table table-bordered" >

       
                      
            <thead>
  		<tr>
                    <th>Photo</th>
                    <th>Student Name</th>
                    <th>Class</th>
                    <th>Section</th>
      		</tr>
            </thead>
            <tbody>
                <c:forEach items="${sbirthday}" var="student">
                    <tr>
                        <td><img class="imgg" src="<c:url value="/image/images/${student.studentPhoto}"/>"></td>
                        <td>${student.studentFirstname} ${student.studentMiddlename} ${student.studentLastname}</td>
                        <td>${student.classes.className}</td>
                        <td>${student.section.section}</td>
                       </tr>
                 </c:forEach>
            </tbody>
        </table>
      
              </center>
        </div>
          </div>
      </div>
    
</body>
</html>
