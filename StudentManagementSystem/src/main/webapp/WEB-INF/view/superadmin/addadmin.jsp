<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add by super admin</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <link rel="stylesheet" type="text/css" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/4.1.2/css/bootstrap-grid.min.css">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/formcss.css"/>">
</head>

<body>
	<%@include file="supernavbar.jsp" %>
	<span><h1><center>Add Schools</center></h1></span>
        <span><h1><center>${message}</center></h1></span>
	<div class="container">
	<div class="row">
	<div class="col-md-6">
        <form:form method="POST" class="form-horizontal" action="addschoolinformation" commandName ="adminModel" enctype="multipart/form-data">
        <form:input type="text" path="activated" hidden="true"/>
        <form:input type="text" path="adminid" hidden="true"/>
        <input type="text" value="${adminModel.expirydate}" name="date" hidden="true"/>
        <form:input type="text" path="schoolName" placeholder="School Name" class="input"/>
	<form:input type="text" path="schoolAddress" placeholder="Address" class="input"/>
	<form:input type="text" path="schoolPhoneNumber" placeholder="Phone Number" class="input" />
        <form:input type="text" path="schoolEmail" placeholder="School Email" class="input"/>
        
	</div>
	<div class="col-md-6">
        <form:input type="text" path="username" placeholder="Username" class="input"/>
	<form:input type="password" path="password" placeholder="Password" class="input"/>
        <form:input type="file" path="logo" placeholder="Password" class="input"/><br>
        <form:checkbox path="Staff"/>Staff<br>
        <form:checkbox path="Attendance"/>Attendance<br>
        <form:checkbox path="Transportation"/>Transportation<br>
        <form:checkbox path="Gallery"/>Gallery<br>
        <form:checkbox path="FinanceReport"/>FinanceReport<br>
        <form:checkbox path="Event"/>Event<br>
        <form:checkbox path="Marksheet"/>Marksheet<br>
        <form:checkbox path="FeedBack"/>FeedBack<br>
        <form:checkbox path="Fee"/>Fee<br>

        
	<input type="submit" value="Add" style="width: 80px;">
	</div>
        </form:form>
</div>
</div>
</body>
</html>