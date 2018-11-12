<%-- 
    Document   : viewsubject
    Created on : 29-Aug-2018, 15:13:21
    Author     : nabish
--%>
<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <title>Add Gallery</title>
<style type="text/css">
.icon.one{
          color: #FF715B;
      }
      .v8{
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
<h1><center>Add Gallery</center></h1>
<a href="schoolgalleryalbumbs"><button class="btn btn-primary"><i class="far fa-eye"></i> View Gallery</button></a>
<div id="succssmessage"><h3><center>${message}</center></h3></div>
<div class="row">
  <div class="col-md-6">
      
<form:form method="POST" class="form-horizontal" action="galleryadd" commandName="gallerymodel">
    <form:input type="text" path="galleryId" hidden="true" class="input"/><br>
    <form:errors class="error" path="galleryname"/>
    <label>Gallery Name:</label>
    <form:input type="text" path="galleryname" placeholder="gallery Name" class="input"/><br>
    <input type="submit" value="Add">
</form:form>
</div>
<div class="answer_list col-md-6" > 
  <h1><center>List Of Gallery</center></h1>

 <section>
  <div class="table-responsive">          
    <table class="table">
      <thead>
        <tr>
            <td><b>Gallery Name</b></td>
            <td></td>
            
          </tr>
      </thead>
      <tbody>
          <c:forEach items="${galleryname}" var="name">
        <tr>
          <td class='clickable-row'>${name.galleryname}</td>
          <td><a href="addimageform?id=${name.galleryId}"><button type="button" class="btn btn-success" style="width:130px;"><i class="fas fa-plus-circle"></i> Add Image</button></a> 
        </tr>
          </c:forEach>
      </tbody>
    </table>
  </div>
</div>
</div>
  </div>
    </div>
        <script src="jquery-1.12.4.min.js"></script>
        <script>
       
        $( document ).ready(function(){
            $('#succssmessage').fadeIn('slow', function(){
               $('#succssmessage').delay(5000).fadeOut(); 
            });
        });
        </script>
</body>
</html>
