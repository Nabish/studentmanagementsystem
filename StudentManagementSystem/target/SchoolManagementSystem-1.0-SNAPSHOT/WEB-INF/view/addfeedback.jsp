<!DOCTYPE html>
<html>
<head>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
           <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
          <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
          <title>Add Feedback</title>
</head>
<style>
    .icon.two{
          color: #FF715B;
      }
</style>
  <!--same in every page-->

<!--same in every page-->
<body>
    <%@include file="parentnav.jsp" %>
    <div id="succssmessage"><h3><center>${message}</center></h3></div>

    <form:form method="POST" action="addfeedback" commandName="feedbackModel">
        <div class="container">
        <div class="form-group">
            Feedback Here:
                    <form:textarea path="feedback" placeholder="Feedback" class="form-control" rows="7"/>
                    <input type="submit" value="Provide Feedback" style="width: 200px;"/>
        </form:form>
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