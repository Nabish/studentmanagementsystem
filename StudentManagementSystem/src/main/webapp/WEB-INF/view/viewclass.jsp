<html>
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
   <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
$(document).ready(function(){
    $("a.delete").click(function(e){
        if(!confirm('Are you sure?')){
            e.preventDefault();
            return false;
        }
        return true;
    });
});
</script>
</head>
<style type="text/css">
     .icon.one{
          color: #FF715B;
      }
      .v1{
          background-color: #93A8AC;
          color: #484A47;
      }
  </style>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
        <div class="container">
  
	<h1><center>Class List</center></h1>
        <a href="classForm"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Class</button></a>
        <h3><center>${message}</center></h3>
<section>
    <br>
	<div class="table-responsive">          
  	<table class="table">
  		<thead>
  			<tr>
      			<td><b>Class</b></td>
      			<td><b>Class Capacity</b></td>
      			<td><b>Class Fee</b></td>
                        <td><b>Computer Fee</b></td>
      			<td><b>Section available</b></td>
                        <td><b>options</b></td>
      		</tr>
  		</thead>
  		<tbody>
                <c:forEach items="${classes}" var="classes">
    		<tr class='clickable-row'>
                        <td>${classes.className}</td>
                        <td>${classes.classCapacity}</td>
                        <td>${classes.fees.tutionfee}</td>
                        <td>${classes.fees.computerfee}</td>
                        <td><c:forEach items="${classes.sections}" var="section">
                            ${section.section}
                            </c:forEach>
                        </td>
                        <td><a href="classedit?id=${classes.classUniqueKey}"><button type="button" class="btn btn-success" ><i class="fas fa-edit"></i> Edit</button></a>
                        </td>
                        <td><a href="classdelete?id=${classes.classUniqueKey}" onclick="return confirm('Are you sure you want to delete information?')"><button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</button></a></td>

    		</tr>	
                </c:forEach>
                </tbody>
        </table>
        </div>
</section>
        </div>
        </div>
            
	<script src="jquery-1.12.4.min.js"></script>
        <script>
<script type="text/javascript">
function showDiv() {
   document.getElementById('welcomeDiv').style.display = "block";
}

jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
</script>
</body>
</html>
