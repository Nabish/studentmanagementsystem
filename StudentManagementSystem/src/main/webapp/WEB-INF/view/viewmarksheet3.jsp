<!DOCTYPE html>
<html>
    <head>
          <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
            <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Mark sheet</title>
    </head>
    <style>
.icon.one{
          color: #FF715B;
      }
      .v11{
          background-color: #93A8AC;
          color: #484A47;
      }
table{
      text-align: center;
}
    </style>
    <body>
        <%@include file="navbar.jsp" %>
        <%@include file="viewsidenav.jsp" %>
                <div class="mainmarksheet">
        
    <div class="sidenavv">
        <h2><center><u>List of Students</u></center></h2><br>
       <table class="table" border="1" align="center">
        <tr href="addMarksheet2.jsp">
            <th>
                Reg. Number
            </th>
            <th>
                Student Name
            </th>
        </tr>
       
    <c:forEach items="${students}" var="std">
         <tr>
        <td>${std.studentRegistrationNumber}</td>
        <td><a  style="color: black; text-decoration: none;" href="adminviewmarksheet?studentId=${std.studentId}&classId=${std.classes.classUniqueKey}&sectionId=${std.section.sectionUniqueKey}">${std.studentFirstname}</a></td>
    </tr>
    </c:forEach>
    </table>
</div>
            <div class="mains">
                <center><h2>${editmessage}</h2></center>
                <label>Name:${studentinfo.studentFirstname} ${studentinfo.studentMiddlename} ${studentinfo.studentLastname}</label><br>
                <label>Class:${studentinfo.classes.className}</label><br>
                <label>Section:${studentinfo.section.section}</label><br><br>
                <div class="table-responsive">        
        <table class="table" border="1" align="center">
            <tr>

                <th rowspan="2">Subject Name</th>
                <th colspan="2">Marks Obtained</th>
                <th rowspan="2">Options</th>
            </tr>
            <tr>
                <th>Theory</th>
                <th>Practical</th>
            </tr>

        <c:forEach items="${markSheet}" var="mark" varStatus="stat">
            <tr>
            <form action="editmarksheetofstudent" method="POST">
                <input type="text" name="marksheetId" value="${mark.markSheetId}" readonly="true" hidden="true">
                <td>${mark.subjectName}</td>
                <td><input type="text" name="markobtained" value="${mark.marksObtained}"></td>
                <td><input type="text" name="markobtainedpratical" value="${mark.marksObtainedPratical}"></td>
                <td><button type="button" class="btn btn-success"><i class="fas fa-edit"></i>  Edit</td>
            </form>
        </tr>
               
                
   
               
        </c:forEach>
            
        </table>
                </div>
        <a href="deletestudentmarksheet?id=${studentinfo.studentId}&classId=${studentinfo.classes.classUniqueKey}&sectionId=${studentinfo.section.sectionUniqueKey}"> <button class="btn btn-danger">Delete MarkSheet</button></a>
        </div>
        </div>
         <script src="jquery-1.12.4.min.js"></script>
        <script>
           
            </script>
        </body>
        
</html>
