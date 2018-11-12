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
        <div class="main">
        <div class="container">
        <h1><center>View Marksheet</center></h1>
        <a href="addmarksheet"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Mark Sheet</button></a>
 <form method="POST" action="dashboardmarksheet"> 
     <div class="col-md-6"> 
<label>Class:</label><br>
 <select style="width:80%" id="idclasses" name="classid">
     <option value='1' >Select Class</option>
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
 </form><br>
        <a href="deleteallmarksheet"><button class="btn btn-danger">Clear all Marksheet</button></a>
        </div>
    
    </div>
    
    <script src="jquery-1.12.4.min.js"></script>
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