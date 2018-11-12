<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
          <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
            <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


        <title>JSP Page</title>
    </head>
    <body>
        <%@include file="supernavbar.jsp" %>
        <br><br>
        <div class="container">
        <h1>${message}</h1>
        <div class="row">
            <div class="col-md-6">
         <form:form method="POST" class="form-horizontal" action="addproductinformation" commandName ="productKeyModel">
          <form:input type="text" path="productkey" placeholder="productkey" class="input"/>
          <input type="submit" value="Add" style="width: 80px;">
         </form:form>
            </div>
            <div class="col-md-6">
          <table class="table">
         <c:forEach items="${productkeylist}" var="list">
             <tr>
                 <th>Product Key</th>
                 <th>Availability</th>
             </tr>
             <tr>
             <td>${list.productkey}</td>
             <td>${list.availability}</td>
             </tr>
         </c:forEach>
          </table>
            </div>
          </div>
        </div>
    </body>
</html>
