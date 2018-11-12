<!DOCTYPE html>
<html>
<head>
    <title>Feed Back</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<style>
.icon.one{
        color: #FF715B;
}
.v12{
    background-color: #93A8AC;
    color: #484A47;
}
.tablinks{
    color:black;
}
</style>
</head>

<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main"> 
        <div class="container">
        <h1><center>Feedbacks</center></h1>
<div class="tab">
  <button class="tablinks" onclick="openTab(event, 'New')" id="defaultOpen">New</button>
    <button class="tablinks" onclick="openTab(event, 'Viewed')" >Viewed</button>
  
</div>

<div id="Viewed" class="tabcontent">
<div class="table-responsive">          
    <table class="table">
      <thead>
        <tr>
            <th>Student Name</th>
            <th>Parent's Name</th>
            <th>Class</th>
            <th>Section</th>
            <th>Feedback</th>
          </tr>
      </thead>
      <tbody>
          <c:forEach items="${feedback}" var="feedback">
              <c:if test="${feedback.viewed == 0}">
          
        <tr>
          <td>${feedback.student.studentFirstname} ${feedback.student.studentMiddlename} ${feedback.student.studentLastname}</td>
          <td>${feedback.student.studentFathername}</td>
          <td>${feedback.student.classes.className}</td>
          <td>${feedback.student.section.section}</td>
          <td>${feedback.feedback}</td>
        </tr>
        </c:if>
        </c:forEach>
      </tbody>
    </table>
  </div>
</div>

<div id="New" class="tabcontent">
<div class="table-responsive">          
    <table class="table">
      <thead>
        <tr>
            <th>Student Name</th>
            <th>Parent's Name</th>
            <th>Class</th>
            <th>Section</th>
            <th>Feedback</th>
            <th>Option</th>
          </tr>
      </thead>
      <tbody>
          <c:forEach items="${feedback}" var="feedback">
              <c:if test="${feedback.viewed == 1}">
        <tr>
          <td>${feedback.student.studentFirstname} ${feedback.student.studentMiddlename} ${feedback.student.studentLastname}</td>
          <td>${feedback.student.studentFathername}</td>
          <td>${feedback.student.classes.className}</td>
          <td>${feedback.student.section.section}</td>
          <td>${feedback.feedback}</td>
          <td><a href="viewedfeedback?feedbackid=${feedback.feedbackId}"><button class="btn js-click" onclick="submitButtonStyle(this)" type="submit" class="stylebutton"><i class="fas fa-eye"></i> Viewed</button></a></td>
        </tr>
              </c:if></c:forEach>
      </tbody>
    </table>
  </div>
</div>
        </div>
    </div>

<script>
function openTab(evt, tabName) {
    var i, tabcontent, tablinks;
    tabcontent = document.getElementsByClassName("tabcontent");
    for (i = 0; i < tabcontent.length; i++) {
        tabcontent[i].style.display = "none";
    }
    tablinks = document.getElementsByClassName("tablinks");
    for (i = 0; i < tablinks.length; i++) {
        tablinks[i].className = tablinks[i].className.replace(" active", "");
    }
    document.getElementById(tabName).style.display = "block";
    evt.currentTarget.className += " active";
}

// Get the element with id="defaultOpen" and click on it
document.getElementById("defaultOpen").click();
</script>
<script type="text/javascript">
function submitButtonStyle(_this) {
  _this.style.backgroundColor = "green";
}
</script>
</body>
</html> 
