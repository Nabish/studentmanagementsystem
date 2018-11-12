<html>
<head>
	<title>Nav Bar</title>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
                <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta.3/css/bootstrap.min.css" integrity="sha384-Zug+QiDoJOrZ5t4lssLdxGhVrurbmBWopoEl+M6BdEfwnCJZtKxi1KgxUyJq13dy" crossorigin="anonymous">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/nav.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/admincss.css"/>">
<link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/formcss.css"/>">
</head>
<style>
    .form-control{
        width: 50%;
    }
</style>
<body>
<nav class="navbar navbar-expand-md navbar-dark" style="opacity: 1; background-color: #706c61;">
  <a class="navbar-brand" href="#">Welcome Parent</a>
  <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#a">
    <span class="navbar-toggler-icon"></span>
  </button>
  <div class="collapse navbar-collapse" id="a">
    <ul class="navbar-nav">
      <li class="nav-item">
        <a class="nav-link" href="#"><span class="fas fa-tachometer-alt icon"></span> Dashboard</a>
      </li>
      <li class="nav-item">
        <a class="nav-link" href="parentMarksheet"><span class="fas fa-clipboard-list icon"></span> Marksheet</a>
      </li>     
      <li class="nav-item">
        <a class="nav-link" href="schoolgalleryalbumbs"><span class="fas fa-images icon"></span>Gallery</a>
      </li>  
      <li class="nav-item">
        <a class="nav-link" href="viewevent"><span class="fas fa-calendar-alt icon"></span> Calender</a>
      </li>   
      <li class="nav-item">
        <a class="nav-link" href="addFeedback"><span class="fas fa-comments icon"></span> Feedback</a>
      </li>
            <li class="nav-item">
          <a class="nav-link" href="parentslogout"><span class="fas fa-sign-out-alt icon logout"></span> Logout</a>
      </li> 
      </ul>
  </div>  
</nav>
</body>
</html>
