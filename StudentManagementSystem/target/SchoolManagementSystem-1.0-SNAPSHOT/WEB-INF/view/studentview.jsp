<!DOCTYPE html>
<html lang="en">
<head>
  <title>View Student</title>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <script src="https://code.jquery.com/jquery-1.11.2.min.js"></script>
<script src="https://code.jquery.com/ui/1.11.3/jquery-ui.min.js"></script>
<style type="text/css">
#save {
    visibility: hidden;
}

      .icon.one{
          color: #FF715B;
      }
      .v4{
          background-color: #93A8AC;
          color: #484A47;
      }
      td{
          text-align: center;
      }
      
@media (max-width: 1041px) {
          td button{
              width: 50px;
          }
          span{
              display: none;
          }
          i{
              font-size: 20px;
          }
      } @media (max-width: 829px) {
          td button{
              width: 40px;
              height:35px;
          }
          span{
              display: none;
          }
          i{
              font-size: 16px;
          }
      }
            .sidenav{
          height: auto;
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
<h1><center>View Student</center></h1>
<a href="addstudentform"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Student</button></a>
<div class="row">
    <div class="col-md-6">
  <form method="GET" action="viewstudentlist"> 
    
<br>           
<label>Class:</label><br>
 <select style="width:80%" id="idclasses" name="classid">
     <option value='1'>Select Class</option>
       <c:forEach items="${classes}" var="classes">  
            <option value="${classes.classUniqueKey}">${classes.className}</option>
        </c:forEach>
   </select>
    </div>
<div class="col-md-6">
<label>Section:</label><br>
<select style="width:80%" id="section" name="sectionsid">
    <option value='1'>Select Section</option>
       <c:forEach items="${sections}" var="sections">  
            <option value="${sections.sectionUniqueKey}">${sections.section}</option>
        </c:forEach>
   </select>
</div>
      <input type="submit" value="Search" onclick="showDiv()" style="width:150px; margin-left: 15px;"/>
  </form>
</div> 
        <c:if test="${not empty studentlist}">
    <br>            
<div class="container">
    <br>
    <div class="row">
    <div class="col-md-6">
  <h3>Class:one</h3>
    </div>
    <div class="col-md-6">
  <h3>Section:a</h3>
    </div>
    </div>
<section>
  <div class="table-responsive">          
    <table class="table table-bordered">
      
        <tr>
            <th><b>Photo</b></th>
            <th><b>Student Name</b></th>
            <th><b>Class</b></th>
            <th><b>Section</b></th>
            <th><b>Options</b></th>
          </tr>
      
      <tbody>
        <c:forEach items="${studentlist}" var="student">
            <c:if test="${student.studentAvailable==1}">
            <tr>
                <td class='clickable-row' data-href='studentdetail?id=${student.studentId}'> <img class="imgg" alt="" src="<c:url value="/image/images/${student.studentPhoto}"/>"> </td>
                <td class='clickable-row' data-href='studentdetail?id=${student.studentId}'>${student.studentFirstname}</td>
                <td class='clickable-row' data-href='studentdetail?id=${student.studentId}'>${student.classes.className}</td>
                <td class='clickable-row' data-href='studentdetail?id=${student.studentId}'>${student.section.section}</td>
                <td>
                    <a href="viewmarksheetfromstudent?sid=${student.studentId}"><button type="button" class="btn btn-primary"><i class="fas fa-clipboard-list"></i> <span>Marksheet</span></button></a> 
                    <a href="studentedit?id=${student.studentId}"><button type="button" class="btn btn-success" ><i class="fas fa-edit"></i> <span>Edit</span></button></a>
                    <a href="studentdelete?id=${student.studentId}&classId=${student.classes.classUniqueKey}&sectionId=${student.section.sectionUniqueKey}" onclick="return confirm('Are you sure you want to delete information?')"><button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> <span>Delete</span></button></a></td>

            </tr>
            </c:if>
        </c:forEach>
        </tbody>
        </table>
        
  </div>
</section>
</div>
</div>
</div>
    </c:if>
<script src="jquery-1.12.4.min.js"></script>
  <script>
	jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
</script>
<script>
        $(document).ready(function() {
      $("#idclasses").change(function() {
        var classuniquekey=$(this).val();
        console.log(classuniquekey);
        $.getJSON("http://localhost:8080/StudentManagementSystem/getclasssection?classuniquekey="+classuniquekey,function(data, status){
        console.log(data);
        console.log(status);
        var catOptions = "";
         for (obj in data) {
                catOptions += "<option value="+ data[obj][0] +">" + data[obj][1] + "</option>";
            }
            document.getElementById("section").innerHTML = catOptions;
        });
        
        });
    });
</script>
</body>
</html>