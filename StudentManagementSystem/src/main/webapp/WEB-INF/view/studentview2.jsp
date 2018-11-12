<html>
    <head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
        <title>Student Detailed Information</title>
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
     .ta th{
          text-align: left;
      }
</style>
    </head>
    <body>
        <%@include file="navbar.jsp" %>
        <%@include file="viewsidenav.jsp" %>
         <div class="main">
        <div class="container">
            <h1><center>Student Info</center></h1>
          
        
        
        <!-- Modal body -->
        <div>
          <div class="photos">
              <img class="imgg" alt="" src="<c:url value="/image/images/${studentDetail.studentPhoto}"/>">
          </div>

          <section>
            <div class="table-responsive">          
  <table class="table ta">
    <tr>
      <th>Reg No.</th>
      <td class="td">${studentDetail.studentRegistrationNumber}</td>
    </tr>
  <tr>
    <th>First Name</th>
    <td class="td">${studentDetail.studentFirstname}</td>
  </tr>
  <tr>
    <th>Middle Name</th>
    <td class="td">${studentDetail.studentMiddlename}</td>
  </tr>
  <tr>
    <th>Last Name</th>
    <td class="td">${studentDetail.studentLastname}</td>
  </tr>
  <tr>
    <th>Father's Name </th>
    <td class="td">${studentDetail.studentFathername}</td>
  </tr>
  <tr>
    <th>Mother's Name</th>
    <td class="td">${studentDetail.studentMothername}</td>
  </tr>
  <tr>
    <th>Date of Birth</th>
    <td class="td">${studentDetail.studentDateofbirth}</td>
  </tr>
  <tr>
    <th>Temporary Address</th>
    <td class="td">${studentDetail.studentTemporaryAddress}</td>
  </tr>
  <tr>
    <th>Permanent Address</th>
    <td class="td">${studentDetail.studentPermanentAddress}</td>
  </tr>
  <tr>
    <th>Gender</th>
    <td class="td">${studentDetail.studentSex}</td>
  </tr>
  <tr>
    <th>Father's Occupation</th>
    <td class="td">${studentDetail.studentFatherOccupation}</td>
  </tr>
  <tr>
    <th>Mother's Occupation</th>
    <td class="td">${studentDetail.studentMotherOccupation}</td>
  </tr>
  <tr>
    <th>Phone Number </th>
    <td class="td">${studentDetail.studentPhoneNumber}</td>
  </tr>
  <tr>
    <th>Class</th>
    <td class="td">${studentDetail.classes.className}</td>
  </tr>
  <tr>
    <th>Section</th>
    <td class="td">${studentDetail.section.section}</td>
  </tr>
  </table>
    <a href="studentedit?id=${studentDetail.studentId}"> <button type="button" class="btn btn-success" id="edit"><i class="fas fa-edit"></i> Edit</button></a>
    <a href="studentdelete?id=${studentDetail.studentId}&classId=${studentDetail.classes.classUniqueKey}&sectionId=${studentDetail.section.sectionUniqueKey}""> <button type="button" class="btn btn-danger"><i class="fas fa-trash"></i> Delete</button></a>
          <button type="button" class="btn btn-primary" id="save" onClick = "this.style.visibility= 'hidden';"><i class="fas fa-save"></i> Save</button>
</div>

</section>


</div>
  </div>

        </div>

<script>
    <script type="text/javascript">
    
</script>
<script>
function myFunction() {
    
    window.print();
}
</script>
<script type="text/javascript">
function showDiv() {
   document.getElementById('welcomeDiv').style.display = "block";
}
</script>
<script type="text/javascript">
var edit = document.getElementById("edit");
var save = document.getElementById("save");

edit.onclick = function() {
    save.style.visibility = "visible";
}
</script>
<script>
    
</script>
    </body>
</html>
