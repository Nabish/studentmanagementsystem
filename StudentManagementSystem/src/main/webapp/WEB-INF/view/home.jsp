<!DOCTYPE html>
<html>
<head>
	<title>SMS | Login Page</title>
	<link rel="stylesheet" type="text/css" href="../css/loginpage.css">
	<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <meta name="viewport" content="width=device-width, initial-scale=1">

</head> 
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/loginpage.css"/>">

            <style>
        .current a{
             color:#70c1b3;
             
            }
            #succssmessage{
                color: red;
                font-size:20px ; 
                text-transform: uppercase;
            }
            
    </style>

<body>
    <%@include file="home/frontnav.jsp" %>
   
	<div id="head">
<div class="col-md-12" id="succssmessage"><center>${message}</center></div>
	</div>
  <div class="login-wrap">
      <div class="body">
<div class="tabs">
<button class="tablink button" onclick="openPage('Admin', this, '#7d869c')"><i class="fas fa-user"></i> Admin</button>
<button class="tablink button" onclick="openPage('Parents', this, '#7d869c')" id="defaultOpen"><i class="fas fa-user"></i> Parents</button>
</div>

<div id="Admin" class="tabcontent">
<form:form method="POST" class="form-horizontal" action="adminlogin" commandName="adminModel">
<form:input type="text" path="username" placeholder="Username"/><span class="fas fa-user icon-class"></span><br>
<form:input type="password" path="password" placeholder="Password"/><span class="fas fa-unlock icon-class"></span><br><br>
<form:input type="submit" path="" value="Login"/>
</div>
</form:form>
<div id="Parents" class="tabcontent">
<form:form method="POST" class="form-horizontal" action="parentslogin" commandName="studentModel">
 <form:input type="text" path="username" placeholder="Username"/><span class="fas fa-user icon-class"></span><br>
<form:input type="password" path="password" placeholder="Password"/><span class="fas fa-unlock icon-class"></span><br><br>
<input type="submit" path="" value="Login"/>
</div>
</form:form>
</div>   
</div>

    <div id="foot">
        
    </div>

    <script>
function openPage(pageName,elmnt,color) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablink");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].style.backgroundColor = "";
    }
    document.getElementById(pageName).style.display = "block";
    elmnt.style.backgroundColor = color;

}
// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
</body>

  
</html>