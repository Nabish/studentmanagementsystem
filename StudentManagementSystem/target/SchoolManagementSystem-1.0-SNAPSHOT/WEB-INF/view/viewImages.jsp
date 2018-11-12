<%-- 
    Document   : viewall
    Created on : 13-Jul-2018, 13:37:30
    Author     : nabish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title></title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>


    </head>
    <style>
             .icon.one{
          color: #FF715B;
      }
      .v8{
          background-color: #93A8AC;
          color: #484A47;
      }
.contain{
  width: 80%;
  margin: auto;
  overflow: hidden;
}

img{
  width: auto;
  max-width: 150px;
  height: auto;
  max-height: 150px;
  object-fit: contain;
}
</style> 
    <body>
    <c:if test="${(not empty sessionScope.adminlogged)}">
    <%@include file="navbar.jsp" %>
        <%@include file="viewsidenav.jsp" %>
    </c:if>
        <c:if test="${(not empty sessionScope.studentinfo)}">
    <%@include file="parentnav.jsp" %>
    </c:if>
        <div class="main">
	<div class="contain">
 	<div class="row">
    <c:forEach items="${images.images}" var="images">
    <div class="col-lg-3 col-md-4 col-sm-6">
      <div class="thumbnail">
        <a href="imagedetail?id=${products.productId}" target="_blank">
            
            <img src="<c:url value="/image/images/${images.imagePath}"/>">
         </a>   
        </div>
        
      </div>
    
    </c:forEach> 
   </div>
   </div>
        </div>
    </body>
</html>
