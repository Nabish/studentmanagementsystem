<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
<link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
<script>
$(document).ready(function(){
    $("#hide").click(function(){
        $("button").hide();
      window.print();
    });
    
});
</script>
</head>
<style>

table{
  border: 3px solid black; 
  height: 250px; 
  width:400px;
  
}
td{
  padding-left: 20px;
}
.icon.one{
          color: #FF715B;
      }
</style>
<body>
    <%@include file="navbar.jsp" %>
  <div class="container">
    <button id="hide" class="btn btn-default" onclick="function()" style="float:right;"><i class="fas fa-print" style="font-size:30px;"></i> Print</button>
    <div class="row">

      <c:forEach items="${students}" var="studentinfo" varStatus="counter">
          <div class="col-md-6" style="padding-bottom:36px;">
        <div class="table-responsive">
        <table border="0">
        <tr>
            <th colspan="2"><center><u>${sessionScope.adminlogged.schoolName}</u></center></th>
      </tr>
      <tr>
        <th colspan="2"><center><u>ENTRANCE CARD</u></center>
        </th>
      </tr>
      <tr>
        <td><b>Name:</b></td>
        <td> ${studentinfo.studentFirstname} ${studentinfo.studentMiddlename} ${studentinfo.studentLastname} </td>
      </tr>
      <tr>
        <td><b>Class:</b></td>
        <td> ${studentinfo.classes.className}</td>
      </tr>
      <tr>
        <td><b>Section:</b></td>
        <td>${studentinfo.section.section}</td>
      </tr>
      <tr>
        <td><b>Term:</b></td>
        <td><input type="text" style="border:none" id="term${counter.count}"> </td>
      </tr>
      </table>
      </div>
          </div>
      </c:forEach>
    </div>
  </div>
       <script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.6.1.js"></script>
    <script src="jquery-1.12.4.min.js"></script>
    <script>
                   $(document).ready(function(){
                $("#term1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#term"+ i).val($(this).val());
                    }
                
            });
        });
    </script>
</body>
</html>