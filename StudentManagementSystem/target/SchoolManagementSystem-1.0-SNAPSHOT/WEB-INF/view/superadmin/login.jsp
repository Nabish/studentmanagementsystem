<!DOCTYPE html>
<html>
<head>
	<title>SMS | Super Admin</title>
	<link rel="stylesheet" type="text/css" href="./super.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.3.1/css/all.css" integrity="sha384-mzrmE5qonljUremFsqc01SB46JvROS7bZs3IO2EmfFsd15uHvIt+Y8vEf7N7fWAU" crossorigin="anonymous">
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/supercss.css"/>">
</head>

<body style="background:url(<c:url value="/resources/image/back1.jpg"/>) no-repeat">
	<header>
		<h1>Super Admin</h1>
                <h3>${message}</h3>
	</header>
<div class="login-page">
  <div class="form">
      <form method="POST" class="form-horizontal" action="superadminlogin">
       <h3>${message}</h3>
      <input type="text" name="username" placeholder="Username"/><span class="fas fa-user-tie icon-class"></span>
      <input type="password" name="password" placeholder="Password"/><span class="fas fa-unlock-alt icon-class"></span>
      <input type="submit" path="" value="Login"/>
      </form>
    </form>
  </div>
</div>
</body>
</html>