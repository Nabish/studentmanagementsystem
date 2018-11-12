<!DOCTYPE html>
<html lang="en">
<head>
  <title>Navbar</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js" integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js" integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js" integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy" crossorigin="anonymous"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>  
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/nav.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admincss.css"/>">
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/formcss.css"/>">
</head>
<style type="text/css">

</style>
<body>
<div class="sticky" style="z-index: 1">
<nav class="navbar navbar-expand-lg navbar-dark" style="opacity: 1; background-color: #484A47;">
    <a class="navbar-brand" href="#">Welcome Admin</a>
    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#collapsingNavbarMd">
        <span class="navbar-toggler-icon"></span>
    </button>
    <div class="navbar-collapse collapse" id="collapsingNavbarMd">
        <ul class="navbar-nav">
            <li class="nav-item">
                <a class="nav-link" href="viewdashboard"><span class="fas fa-tachometer-alt icon one"></span> Dashboard</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="emailpage"><span class="fas fa-envelope icon three"></span> Messages</a>
            </li>
            <li class="nav-item">
                <a class="nav-link" href="setting"><span class="fas fa-cogs icon four"></span> Setting</a>
            </li> 
            <li class="nav-item">
                <a class="nav-link" href="logout"><span class="fas fa-sign-out-alt icon logout"></span> Logout</a>
            </li>      
        </ul>
    </div>
</nav>
</div>
</body>
</html>