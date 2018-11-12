 <!DOCTYPE html>
 <html>
 <head>
 	<title>Print Marksheet</title>
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
        <h1><center>Marksheet</center></h1>
 <form method="POST" action="printclassinfo"> 
     <div class="col-md-6"> 
<label>Class:</label><br>
<select style="width:80%" id="idclasses" name="classid">
     <option value='1'>Select Class</option>
       <c:forEach items="${classes}" var="classes">  
            <option value="${classes.classUniqueKey}">${classes.className}</option>
        </c:forEach>
   </select>
    </div>
      <input type="submit" value="Search" onclick="showDiv()" style="width:150px; margin-left: 15px;"/>
  </form>
        </div>
    </div>
 </body>
 </html>