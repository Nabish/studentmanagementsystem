<%-- 
    Document   : viewsubject
    Created on : 29-Aug-2018, 15:13:21
    Author     : nabish
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <title>View Subject</title>
<style type="text/css">
         .icon.one{
          color: #FF715B;
      }
      .v3{
          background-color: #93A8AC;
          color: #484A47;
      }
</style>
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
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
  <div class="container">
<h1><center>View Subject</center></h1>
<a href="subjectForm"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Subject</button></a>
<div class="row">
  <div class="col-md-6">
      <form method="GET" action="viewsubjectlist"> 
        <br><label>Class:</label><br>
         <select style="width:80%" id="classid" name="classid" >
               <c:forEach items="${classes}" var="classes">  
                    <option value="${classes.classUniqueKey}" id="classid">${classes.className}</option>
                </c:forEach>
           </select>
   <div class="row">
<input type="submit" name="" value="View Subject" style="width:150px; margin-left: 15px;"/>
</form>
</div>
</div>
    
    <c:if test="${not empty subjectlists}">
<div class="col-md-6" > 
  <h1><center>Subject List of Class ${classname}</center></h1>

 <section>
  <div class="table-responsive">          
    <table class="table">
        <tr>
            <th><b>Subject Name</b></th>
            <th colspan="2">Option</th>
            
          </tr>
      <tbody>
        <c:forEach items="${subjectlists}" var="subject">
            <tr align="center">
              <td>${subject.subjectName}</td>
              <td class='clickable-row' data-href='subjectedit?id=${subject.subjectId}'><button type="button" class="btn btn-success"><i class="fas fa-edit"></i> Edit</button></td> 
              <td class='clickable-row'><a href="subjectdelete?id=${subject.subjectId}&classId=${subject.classes.classUniqueKey}" onclick="return confirm('Are you sure you want to delete information?')"><button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</button></a></td>
              </tr>
        </c:forEach>
      </tbody>
    </table>
  </div>
</section>
</div>

</div>
</div>
    </div>
    </c:if>
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