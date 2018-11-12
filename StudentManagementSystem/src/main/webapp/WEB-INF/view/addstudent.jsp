<!DOCTYPE html>
<html lang="en">
<head>
  <title>Add Student|SMS</title>
  
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
         <style>
      .icon.one{
          color: #FF715B;
      }
      .v4{
          background-color: #93A8AC;
          color: #484A47;
      }
         </style>
</head>
 

<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
     <div class="main">
         <div class="container">
    <span> <h1><center>Add Student</center></h1></span>
    <a href="viewstudent"><button class="btn btn-primary"><i class="far fa-eye"></i> View Student</button></a>
   <div id="succssmessage"><h3><center>${message}</center></h3></div>
        <form:form method="POST" class="form-horizontal" action="addstudent" commandName="studentModel" enctype="multipart/form-data">
       
       <form:input type="text" path="studentId" hidden="true" class="input"/>
        
            <div class="row">     
        <div class="col-md-2">
        <br><form:errors class="error" path="studentRegistrationNumber"/>
        <form:input type="text" path="studentRegistrationNumber" placeholder="Reg No." class="input"/>
        </div><div class="col-md-10"></div>
        <div class="col-md-4">
            <form:errors class="error" path="studentFirstname"/>
            <form:input type="text" path="studentFirstname" placeholder="First Name" class="input"/></div>
        <div class="col-md-4">
            <form:input type="text" path="studentMiddlename" placeholder="Middle Name" class="input"/></div>
            <div class="col-md-4">
                <form:errors class="error" path="studentLastname"/>
	<form:input type="text" path="studentLastname" placeholder="Last Name" class="input"/>
            </div>
            <div class="col-md-4">
                <form:errors class="error" path="studentFathername"/>
	<form:input type="text" path="studentFathername" placeholder="Father's Name" class="input"/></div>
        <div class="col-md-4">
            <form:errors class="error" path="studentMothername"/>
	<form:input type="text" path="studentMothername" placeholder="Mother's Name" class="input"/></div>
        <div class="col-md-4">
            <form:errors class="error" path="studentDOB"/>
	<form:input type="text" path="studentDOB" placeholder="dd/mm/yyyy" class="input"/></div>
        <div class="col-md-6">
            <form:errors class="error" path="studentTemporaryAddress"/>
	<form:input type="text" path="studentTemporaryAddress" placeholder="Temporary Address" class="input"/></div>
	<div class="col-md-6">
            <form:errors class="error" path="studentPermanentAddress"/>
	<form:input type="text" path="studentPermanentAddress" placeholder="Permanent Address" class="input"/></div>
	<div class="col-md-12">
            <form:errors class="error" path="email"/>
	<form:input type="text" path="email" placeholder="Email Address" class="input"/></div>
	
        <div class="col-md-6">
            <form:errors class="error" path="studentFatherOccupation"/>
	<form:input type="text" path="studentFatherOccupation" placeholder="Father's Occupation" class="input"/></div>
        <div class="col-md-6">
            <form:errors class="error" path="studentMotherOccupation"/>
	<form:input type="text" path="studentMotherOccupation" placeholder="Mother's Occupation" class="input"/></div>
        <div class="col-md-4">
            <form:errors class="error" path="studentFatherNumber"/>
	<form:input type="text" path="studentFatherNumber" placeholder="Father Phone Number" class="input"/></div>
        <div class="col-md-4">
            <form:errors class="error" path="studentMotherNumber"/>
        <form:input type="text" path="studentMotherNumber" placeholder="Mother Phone Number" class="input"/></div>
        <div class="col-md-4">
            <form:errors class="error" path="studentPhoneNumber"/>
        <form:input type="text" path="studentPhoneNumber" placeholder="Phone Number" class="input"/></div>
        <div class="col-md-4">
	<form:label path = "classes.classUniqueKey"> Classes: </form:label><br>
        <form:select id="idclasses" path = "classes.classUniqueKey">
            <form:option value='1'>Select Class</form:option>
        <c:forEach items="${classList}" var="classes">  
            <form:option value="${classes.classUniqueKey}">${classes.className}</form:option>
        </c:forEach>
        </form:select>
        </div>
        <div class="col-md-4">
        <form:label path = "section.sectionUniqueKey"> Sections: </form:label><br>
        <form:select path = "section.sectionUniqueKey" id="section">
            <form:option value='1'>Select Section</form:option>
        <c:forEach items="${sectionList}" var="section">  
            <form:option id="section" value="${section.sectionUniqueKey}"></form:option>
        </c:forEach>
        </form:select>
        </div>
           <div class="col-md-4">
               <label>Upload Image:</label>
         <form:input path="file" type="file" class="input"/>
         <form:label path = ""> Check for Transportation:</form:label>
        <form:checkbox path="transportationFlag" value='1' id="checkbox"/>    
        
        <div class="switch-field">
            <form:errors path="studentSex"/>
            <form:radiobutton path = "studentSex" value = "Male" label = "Male"/>
            <form:radiobutton path = "studentSex" value = "Female" label = "Female" />
        </div>
            <c:choose>
                <c:when test="${empty studentModel.studentFirstname}">
        <input type="submit" value="Add"></div>
        </c:when>
                <c:otherwise>
                   <input type="submit" value="Update"> </div>
                </c:otherwise>
            </c:choose>
    </form:form>
	</div>
            </div>
   </div>
            <script src="jquery-1.12.4.min.js"></script>
        <script>
       
        $( document ).ready(function(){
            $('#succssmessage').fadeIn('slow', function(){
               $('#succssmessage').delay(15000).fadeOut(); 
            });
        });

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
