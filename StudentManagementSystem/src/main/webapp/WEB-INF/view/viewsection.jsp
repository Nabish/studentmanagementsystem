<%-- 
    Document   : viewsubject
    Created on : 29-Aug-2018, 15:13:21
    Author     : nabish
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
  <title>View Section</title>
<style type="text/css">
         .icon.one{
          color: #FF715B;
      }
      .v2{
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
<h1><center>View Section</center></h1>
<div style="text-transform: uppercase;color: red;"><center><h2>${message}</h2></center></div>
<a href="sectionForm"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Section</button></a>
<div class="row">
  <div class="col-md-6">
      <form method="GET" action="viewsectionlist"> 
        <br><label>Class:</label><br>
         <select style="width:80%" id="classid" name="classid" >
             <option value='1'>Select Class</option>
               <c:forEach items="${classes}" var="classes">  
                    <option value="${classes.classUniqueKey}" id="classid">${classes.className}</option>
                </c:forEach>
           </select>
   <div class="row">
<input type="submit" name="" value="View Section" style="width:150px; margin-left: 15px;"/>
</form>
</div>
</div>
    
    <c:if test="${not empty sectionlists}">
<div class="col-md-6" > 
  <h1><center>Section List of Class ${classname}</center></h1>

 <section>
  <div class="table-responsive">          
    <table class="table">
        <tr>
            <th><b>Section Name</b></th>
            <th colspan="2"><b>Option</b></th>
            
          </tr>
      <tbody>
        <c:forEach items="${sectionlists}" var="sec">
            <tr align="center">
                <td>${sec.section}</td>
              <td><a href="sectiondelete?id=${sec.sectionUniqueKey}&classId=${sec.classes.classUniqueKey}" onclick="return confirm('Are you sure you want to delete information?')"><button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</button></a></td>

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