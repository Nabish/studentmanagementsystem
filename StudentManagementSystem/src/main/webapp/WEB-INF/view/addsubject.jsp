<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Subject Form</title>
  
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head> 
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/formcss.css"/>">
        <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/nav.css"/>">

</head>
   <style type="text/css">
   	@media(max-width: 783px){
   		img{
   			display: none;
   		}
   	}
        
             .icon.one{
          color: #FF715B;
      }
      .v3{
          background-color: #93A8AC;
          color: #484A47;
      }
   </style>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
	
        <div class="main">
            <div class="container">
	<span><h1><center>Add Subject</center></h1></span>
        <a href="subjectview"><button class="btn btn-primary"><i class="far fa-eye"></i> View Subject</button></a>
        <div id="succssmessage"><h3><center>${message}</center></h3></div>
	<div class="row">
	<div class="col-md-6">
	<form:form method="POST" class="form-horizontal" action="subjectadd" commandName="subjectModel">
        <br><form:label path = "classes.classUniqueKey"> Class Unique Key: </form:label><br>
        <form:select path = "classes.classUniqueKey">
        <c:forEach items="${classList}" var="classess">  
            <form:option value="${classess.classUniqueKey}">${classess.className}</form:option>
        </c:forEach>
        </form:select>
        <form:errors class="error" path="subjectId"/>
	<form:input type="text" path="subjectId" placeholder="Subject Unique Key" hidden="true" class="input"/>
        <form:errors class="error" path="subjectName"/>
	<form:input type="text" path="subjectName" placeholder="Subject Name" class="input" /><br>
        <form:label path = ""> Practical Subject:</form:label>
        <form:checkbox path="subjectFlag" value='1' id="checkbox"/><br>
        <div class="row">
            <div class="col-md-6">
        <form:input type="text" path="theoryFullMark" placeholder="Theory Full Mark" class="input" />
        <form:input type="text" path="theoryPassMark" placeholder="Theory Pass Mark" class="input" />
            </div>
            <div class="col-md-6">
        <div id="fm">
        <form:input type="text" path="practicalFullMark" placeholder="Practical Full Mark" class="input"/>
        </div>
        <div id="pm">
        <form:input type="text" path="practicalPassMark" placeholder="Practical Pass Mark" class="input"/>
        </div>
            </div>
        </div>
        
	<input type="submit" value="Add" style="float: left;">
	</form:form>
</div>
<div class="col-md-3">
  <img  style="width: 100%; max-height: 350px; align-content: center; padding-bottom: 120px; object-fit:contain;" src="<c:url value="/resources/image/book1.png"/>">
</div>
<div class="col-md-3">
  <img src="<c:url value="/resources/image/subject.png"/>" style="width: 100%; max-height: 350px; align-content: center; padding-bottom: 120px; object-fit:contain;">
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
        
        
        $("#checkbox").change(function() {
            if(this.checked) {
               $("#fm").show();
                $("#pm").show(); 
            }
             else{
               $("#fm").hide();
                $("#pm").hide(); 
            }
        });
        
        window.onload = function(){
            document.getElementById('fm').style.display = 'none';
            document.getElementById('pm').style.display = 'none';
        }
        </script>
</body>
</html>



