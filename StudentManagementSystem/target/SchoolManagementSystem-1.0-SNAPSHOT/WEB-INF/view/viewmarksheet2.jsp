<!DOCTYPE html>
<html>
<head>
    <title>Marksheet</title>
<style>
    
      .icon.one{
          color: #FF715B;
      }
      .v11{
          background-color: #93A8AC;
          color: #484A47;
      }
</style>
</head>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="mainmarksheet">

<div class="sidenavv">
    <h2><center><u>List of Students</u></center></h2><br>
    <div class="table-responsive">
       <table class="table" border="1" align="center">
        <tr href="addMarksheet2.jsp">
            <th>
                Reg. Number
            </th>
            <th>
                Student Name
            </th>
        </tr>
       
    <c:forEach items="${student}" var="std">
         <tr>
             <td><a  style="color: black; text-decoration: none;" href="adminviewmarksheet?studentId=${std.studentId}&classId=${std.classes.classUniqueKey}&sectionId=${std.section.sectionUniqueKey}"">${std.studentRegistrationNumber}</a></td>
        <td><a  style="color: black; text-decoration: none;" href="adminviewmarksheet?studentId=${std.studentId}&classId=${std.classes.classUniqueKey}&sectionId=${std.section.sectionUniqueKey}">${std.studentFirstname}</a></td>
    </tr>
    </c:forEach>
       </table>
    </div>
</div>
    </div>
     
</body>
</html>