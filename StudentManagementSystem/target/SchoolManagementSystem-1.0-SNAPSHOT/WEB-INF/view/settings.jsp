
<!DOCTYPE html>
<html lang="en">
<head>
  <title>Setting</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <script type="text/javascript">
    function Validate() {
        var password = document.getElementById("txtPassword").value;
        var confirmPassword = document.getElementById("txtConfirmPassword").value;
        if (password != confirmPassword) {
            alert("Passwords do not match.");
            return false;
        }
        return true;
    }
</script>
<style>
    .icon.four{
          color: #FF715B;
      }
</style>
</head>

<body>
	<%@include file="navbar.jsp" %>
	<span><h1><center>Manage Setting</center></h1></span>
           
	<div class="container">
	<div class="row">
	<div class="col-md-6">
            <h2><center>Manage Username</center></h2>
        <form:form method="POST" class="form-horizontal" action="manageUsername" commandName = "adminModel">
            <form:input path="adminid" hidden="true"/>
        <form:errors path="username"/>
	<form:input path="username" type="text" placeholder="Username" class="input"/>
	<form:input path="schoolEmail" type="email" placeholder="Email" class="input"/>
        <form:input path="password" hidden="true"/>
	<input type="submit" value="Save Changes" onclick="return Validate()" style="width: 160px;">
        </form:form>
	</div>
        <div class="col-md-6">
            <h2><center>Change Password</center></h2>
        <h4><center>${pmessage}</center></h4>
        <form method="POST" class="form-horizontal" action="changePassword">
	<input type="text" name="old" placeholder="Current Password" class="input"/>
	<input type="password" name="new" placeholder="New Password" id="txtPassword" class="input"/>
	<input type="password" placeholder="Confirm Password" id="txtConfirmPassword" class="input"/>
	<input type="submit" value="Change Password" style="width: 170px;">
        </form>
	</div>
</div>
</div>
</body>
</html>    
            