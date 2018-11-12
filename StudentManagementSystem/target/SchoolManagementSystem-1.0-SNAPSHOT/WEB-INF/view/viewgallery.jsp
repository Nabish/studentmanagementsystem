<!DOCTYPE html>
<html>
<head>
	<title>View Gallery</title>
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/gallerycss.css"/>">
</head>
<style>
         .icon.one{
          color: #FF715B;
      }
      .v8{
          background-color: #93A8AC;
          color: #484A47;
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
        <div class="container">
<div class="wrap">
    <h1><center>School Gallery Albums</center></h1>
    <a href="galleryform"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Gallery</button></a>
	<div class="content">
		<div class="row">
                    <c:forEach items="${galleryname}" var="galleryname">
                       <a class="set" href="viewgallaryallimages?galleryid=${galleryname.galleryId}">
                            <c:forEach items="${galleryname.images}" var="images">
				<span class="layer one"><img src="<c:url value="/image/images/${images.imagePath}"/>"></span>
                                                                                    
				<span class="layer three">${galleryname.galleryname}</span>
                            </c:forEach>
			</a>
                     </c:forEach>
		</div>
	</div>
</div>
    </div>
    </div>
</body>
</html>