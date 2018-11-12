<!DOCTYPE html>
<html>
<head>
    <title>Add Marksheet</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
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
    <h2><center><u>List of Students</u></center></h2>
    <div class="table-responsive">
       <table class="table" border="1">
        <tr>
        <a href="addMarksheet2.jsp"></a>
            <th>
                Reg. Number
            </th>
            <th>
                Name
            </th>
        </tr>
       
    <c:forEach items="${students}" var="std">
         <tr>
             <td><a  style="color: black; text-decoration: none;" href="marksheetupload?studentId=${std.studentId}&classId=${std.classes.classUniqueKey}&sectionId=${std.section.sectionUniqueKey}">${std.studentRegistrationNumber}</a></td>
        <td><a  style="color: black; text-decoration: none;" href="marksheetupload?studentId=${std.studentId}&classId=${std.classes.classUniqueKey}&sectionId=${std.section.sectionUniqueKey}">${std.studentFirstname}</a></td>
    </tr>
    </c:forEach>
       </table>
    </div>
</div>
      <div style="text-transform: uppercase;color: red;text-align: right;padding-right: 150px"><h2>${message}</h2></div>  
    </div>
    
</body>
</html>