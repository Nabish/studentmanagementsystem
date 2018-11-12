<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Section Form</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

</head>
<style type="text/css">
   .icon.one{
          color: #FF715B;
      }
   .v2{
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
	<h1><center>Add Section</center></h1>
        <a href="sectionview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Section</button></a>
        <div id="succssmessage"><h3><center>${message}</center></h3></div>
	<div class="row">
	<div class="col-md-6">
  <form:form method="POST" class="form-horizontal" action="sectionadd" commandName="sectionModel">
	<br><form:label path = "classes.classUniqueKey"> Class Unique Key: </form:label><br>
        <form:select path = "classes.classUniqueKey">
        <c:forEach items="${classList}" var="classes">  
            <form:option value="${classes.classUniqueKey}">${classes.className}</form:option>
        </c:forEach>
        </form:select><br>
        <form:errors class="error" path="section"/>
	<form:input type="text" path="section" placeholder="Section" class="input"/><br>
        <form:errors class="error" path="sectionUniqueKey"/>
        <form:input type="text" path="sectionUniqueKey" placeholder="Section Unique Key" hidden="true" class="input"/>
	<input type="submit" value="Add">
  </form:form>
</div>
<div class="col-md-6">
	<img  style="width: 80%; height:auto; align-content: center;" src="<c:url value="/resources/image/class.png"/>">
        <table class="table">
            <tr>
                <th>Class Name</th>
                <th>Section Available</th>
            </tr>
            <c:forEach items="${classList}" var="classes">
                <tr>
                        <td>${classes.className}</td>
                        <td><c:forEach items="${classes.sections}" var="section">
                            ${section.section}
                            
                            </c:forEach>
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
        </script>
</body>
</html>