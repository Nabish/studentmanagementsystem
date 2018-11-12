<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Fee</title>
  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>

</head>
   <style type="text/css">
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
                <span><h1><center>Add Fee</center></h1></span>
        <a href="feeview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Fee</button></a>
        <div id="succssmessage"><h3><center>${message}</center></h3></div>
	<div class="row">
	<div class="col-md-4">
	<form:form method="POST" class="form-horizontal" action="feeadd" commandName="feeModel">
	<form:label path = "classes.classUniqueKey"> Class Unique Key: </form:label>
        <form:select path = "classes.classUniqueKey">
        <c:forEach items="${classList}" var="classess">  
            <form:option value="${classess.classUniqueKey}">${classess.className}</form:option>
        </c:forEach>
        </form:select>
	
	<form:input type="text" placeholder="Fee ID" path="feeId" hidden="true"/>
	<form:label path="tutionfee">Tution Fee:</form:label><br>  <form:errors class="error" path="tutionfee"/>
	<form:input type="text" path="tutionfee" placeholder="Tution Fee" class="input"/>
	<form:label path="transportationfee">Transporation Fee:</form:label><br>  <form:errors class="error" path="transportationfee"/>
	<form:input type="text" path="transportationfee" placeholder="Transportation Fee" class="input"/>
        
        </div>
        <div class="col-md-4">
	<form:label path="ecafee">ECA Fee:</form:label><br>  <form:errors class="error" path="ecafee"/>
	<form:input type="text" path="ecafee" placeholder="ECA Fee" class="input"/>
	<form:label path="libraryfee">Library Fee:</form:label><br>  <form:errors class="error" path="libraryfee"/>
	<form:input type="text" path="libraryfee" placeholder="Library Fee" class="input"/>
	<form:label path="computerfee">Computer Fee:</form:label><br>  <form:errors class="error" path="computerfee"/>
	<form:input type="text" path="computerfee" placeholder="Computer Fee" class="input"/>
	<input type="submit" value="Add" style="float: left;">
	</form:form>
</div>
<div class="col-md-4">
        
	<img  style="width: 100%; max-height: 350px; align-content: center; padding-bottom: 120px; object-fit:contain;" src="<c:url value="/resources/image/money.png"/>">
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