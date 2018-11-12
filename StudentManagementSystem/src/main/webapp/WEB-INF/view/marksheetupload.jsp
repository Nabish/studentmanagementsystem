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
      .th{
         border:none;
         text-align: left;
      }
      input{
    width:80px;
}
.t td{
    text-align: center;
}
</style>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
    <div class="mainmarksheet">
        <div class="sidenavv">
    <h2><center>List of Students</center></h2>
    <div class="table-responsive">
    <table class="table" border="1" align="center">
        <tr>
            <th>
                Reg. Number
            </th>
            <th>
                 Name
            </th>
        </tr>
    <c:forEach items="${students}" var="std">
        <tr>
            <td>${std.studentRegistrationNumber}</td>
            <td><a style="color: black; text-decoration: none;" href="marksheetupload?studentId=${std.studentId}&classId=${std.classes.classUniqueKey}&sectionId=${std.section.sectionUniqueKey}">${std.studentFirstname}</a></td>
    </tr>
    </c:forEach>
    </table>
    </div>
</div>

<div class="mains">
  	 <img src="<c:url value="/image/images/${studentinfo.studentPhoto}"/>" style="float: right; max-width: 100px; max-height: 100px;">
         <table>
            <tr>
                <th class="th">Name:</th>
                <td>${studentinfo.studentFirstname}</td>
            </tr>
            <tr>
                <th class="th">Class:</th>
                <td>${studentinfo.classes.className}</td>
            </tr>
            <tr>
                <th class="th">Section:</th>
                <td>${studentinfo.section.section}</td>
            </tr>
  	</table>
        <br>
        
        <form:form method="post" action="addstudentmarksheet" commandName="markSheet">
            <div class="table-responsive">
            <table class="table t" border="1" align="center">
                <tr>
                    <th rowspan="2">Subjects</th>
                    <th colspan="3">Theory</th>
                    <th colspan="3">Practical</th>
                </tr>
                <tr>
                    <th>Marks Obtained</th>
                    <th>FM</th>
                    <th>PM</th>
                    <th>Marks Obtained</th>
                    <th>FM</th>
                    <th>PM</th>
                </tr>
            <c:forEach items="${subjects}" var="sub">
            <form:input path="studentRegistrationNumber" value="${studentinfo.studentId}" hidden="true"/>
            <tr>
                <td>
            ${sub.subjectName}<form:input path="subjectName" class="subname" value="${sub.subjectName}" readonly="true" hidden="true"/>
                </td>
                <td>
            <form:input path="marksObtained" />
                </td>
                <td>
            ${sub.theoryFullMark}<form:input path="theoryFullMark" class="subname" value="${sub.theoryFullMark}" readonly="true" hidden="true"/>
                </td>
                <td>
            ${sub.theoryPassMark}<form:input path="theoryPassMark" class="subname" value="${sub.theoryPassMark}" readonly="true" hidden="true"/>
                </td>
            <c:choose>
            <c:when test="${sub.subjectFlag=='1'}">
                <td>
                <form:input path="marksObtainedPratical"/>
                </td>
                <td>
            ${sub.practicalFullMark}<form:input path="practicalFullMark" class="subname" value="${sub.practicalFullMark}" readonly="true" hidden="true"/>
                </td>
                <td>
            ${sub.practicalPassMark}<form:input path="practicalPassMark" class="subname" value="${sub.practicalPassMark}" readonly="true" hidden="true"/><br>
                </td>
                </c:when>
            <c:otherwise>
                <td>
                <form:input path="marksObtainedPratical" placeholder="Pratical" value="0" hidden="true"/><br>
                </td>
                <td>
                <form:input path="practicalFullMark" class="subname" value="0" hidden="true"/>
                </td>
                <td>
                <form:input path="practicalPassMark" class="subname" value="0" hidden="true"/>
                </td>
            </c:otherwise>
            </c:choose>
            
            </c:forEach>
            </tr>
            </table>
            </div>
  	<input type="submit" value="Submit">
        </form:form>
  
</div>
    </div>
     
</body>
</html>