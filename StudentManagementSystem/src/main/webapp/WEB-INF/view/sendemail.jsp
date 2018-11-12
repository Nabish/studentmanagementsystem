<!DOCTYPE html>
<html lang="en">
<head>
  <title>Admin dashboard | Email</title>
      <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
         <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
   <style>
       .icon.three{
          color: #FF715B;
      }   
   </style>
</head>
<body>

  <%@include file="navbar.jsp" %>
<!--  <div class="main">-->
<div class="container" style="padding-top: 30px;">  
    <h1><center>Send Message</center></h1>
    <center>${message}</center>
    
        <form id="sendEmailForm" method="post" action="sendEmail" enctype="multipart/form-data">
            <div class="row">
          <div class="col-md-6">
            <div style="text-align: left;">
                <label>Send To:</label><br>
            <div class="emaill">
                
                <Select id="colorselector" style="width:50%;" name="receiver">
                <option value="all" selected="select">All</option>
                    <option value="class">Class</option>
                
            </Select>
            <div id="none" class="colors" style="display:none"> You Have Selected None</div>
            <div id="class" class="colors" style="display:none"> 
                <p align="left"><label>Please Select The Classes:</label></p>              
                <form style="float: left;">
                    <c:forEach items="${classList}" var="classes">  
                 <label class="containerr" style="padding-left: 40px;"> ${classes.className}
                     <input type="checkbox" name="classuniquekey" value="${classes.classUniqueKey}"/>
                     <span class="checkmark" style="margin-left: 0px;"></span>
                 </label><br><br>
                </c:forEach>
              

            </div>
            <div id="all" class="colors" style="display:none"> You Have Selected All </div><br>
             </div>  
            </div> 
          </div>
        <div class="col-md-6">
            <input type="text" placeholder="subject" name="subject" class="input">
            <div class="talkbubble">
            <textarea placeholder="Type Message Here" name="message"></textarea>
            </div> 
            <input id="mailAttachment" type="file" name="attachFileObj" size="60" class="input" />
            <input style="float: right;" type="submit" name="submit" value="Send"> 
            
        </div>
        
</div>
  </form>
    </div>

<script>

    $(function() {
        $('#colorselector').change(function(){
            $('.colors').hide();
            $('#' + $(this).val()).show();
        });
    });
</script>

</body>
</html>
