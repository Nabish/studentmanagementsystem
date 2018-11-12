<!DOCTYPE html>
<html>
<head>
    <title>View Staffs</title>
 
  <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
    <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/viewstaffcss.css"/>">
    <script src="http://code.jquery.com/jquery-1.11.1.min.js"></script>
<script language="JavaScript" type="text/javascript">
$(document).ready(function(){
    $("a.delete").click(function(e){
        if(!confirm('Are you sure?')){
            e.preventDefault();
            return false;
        }
        return true;
    });
});
</script>
</head>
<style>
    .icon.one{
          color: #FF715B;
      }
      .v5{
          background-color: #93A8AC;
          color: #484A47;
      }
</style>
</head>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
        <div class="main">
            
		
		<ul class="ul">
			<a class="link a linkk" href="viewteachingstaff"><li><i class="fas fa-chalkboard-teacher iconn"></i> Teacher</li></a>
			<a class="link a" href="viewstaff?role=Accountant"><li><i class="fas fa-hand-holding-usd iconn"></i> Accountant</li></a>
			<a class="link a" href="viewstaff?role=Librarian"><li><i class="fas fa-book iconn"></i> Librarian</li></a>
		</ul>
<div class="container">
    <a href="staffForm"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Staff</button></a>
		<h1 align="center">View Staff</h1>

<c:if test="${role eq 'Teacher'}">      
      <div>
			 
    	     <h1><center>Teacher Info</center></h1>
<section>
	<div class="table-responsive">          
            <table class="table">
  		<thead>
                    <tr>
      			<td><b>S.N.</b></td>
      			<td><b>Name</b></td>
                        <td><b>Options</b></td>
                    </tr>
  		</thead>
  		<tbody>
                    <c:forEach items="${staff}" var="staff" varStatus="count">
                       <c:if test="${staff.availability==1}">
                        <tr>                            
                            <td class='clickable-row' data-href='staff?id=${staff.teachingstaffId}'>${count.count}</td>
                            <td class='clickable-row' data-href='staff?id=${staff.teachingstaffId}'>${staff.teacherName}</td>
                            <td class='clickable-row' data-href='teachingstaffedit?id=${staff.teachingstaffId}'><button type="button" class="btn btn-success" ><i class="fas fa-edit"></i> Edit</button></td> 
                            
                            <td><a href="teachingstaffdelete?id=${staff.teachingstaffId}"><button type="button" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete information?')"><i class="fas fa-trash"></i> Delete</button></a></td>>
                            
                        </tr>
                       </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>
</c:if>

<c:if test="${role eq 'Accountant'}">
<div>
    <h1><center>Accountant Info</center></h1>
    <section>
	<div class="table-responsive">          
            <table class="table">
  		<thead>
                    <tr>
      			<td><b>S.N.</b></td>
      			<td><b>Name</b></td>
                        <td><b>Options</b></td>
                    </tr>
  		</thead>
  		<tbody>
                    <c:forEach items="${staff}" var="staff" varStatus="count">
                        <c:if test="${staff.staffAvailable==1}">
                        <tr>                            
                            <td class='clickable-row' data-href='staff?id=${staff.staffId}'>${count.count}</td>
                            <td class='clickable-row' data-href='staff?id=${staff.staffId}'>${staff.staffName}</td>  
                            <td>
                            <a href="staffedit?id=${staff.staffId}"><button type="button" class="btn btn-success" ><i class="fas fa-edit"></i> Edit</button></a>
                            <a href="staffdelete?id=${staff.staffId}"><button type="button" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete information?')"><i class="fas fa-trash"></i> Delete</button></a>
                            </td>
                        </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>
</c:if>

<c:if test="${role eq 'Librarian'}">              
<div>
<h1><center>Librarian Info</center></h1>
    <section>
	<div class="table-responsive">          
            <table class="table">
  		<thead>
                    <tr>
      			<td><b>S.N.</b></td>
      			<td><b>Name</b></td>
                        <td><b>Options</b></td>
                    </tr>
  		</thead>
  		<tbody>
                    <c:forEach items="${staff}" var="staff" varStatus="count">
                        <c:if test="${staff.staffAvailable==1}">
                        <tr>                            
                            <td class='clickable-row' data-href='staff?id=${staff.staffId}'>${count.count}</td>
                            <td class='clickable-row' data-href='staff?id=${staff.staffId}'>${staff.staffName}</td>
                            <td><button type="button" class="btn btn-success" data-href='staffedit?id=${staff.staffId}'><i class="fas fa-edit"></i> Edit</button>
                                <a href="staffdelete?id=${staff.staffId}"><button type="button" class="btn btn-danger" onclick="return confirm('Are you sure you want to delete information?')"><i class="fas fa-trash"></i> Delete</button></a>
                            </tr>
                        </c:if>
                    </c:forEach>
                </tbody>
            </table>
        </div>
    </section>
</div>
</div>
                </div>
</c:if> 
    <script src="jquery-3.3.1.min.js"></script>
<script>
    

  jQuery(document).ready(function($) {
    $(".clickable-row").click(function() {
        window.location = $(this).data("href");
    });
});
  
</script>

<script type="text/javascript">
$('.textWord_about').hide();

$('.link').click(function() {
    $('.textWord_about').hide();       
    $('.textWord_about[data-link=' + $(this).data('link') + ']').fadeIn({
        width: '200px'
    }, 300);
});
</script>
<script>

$(function() {
   $('a.linkk').click(function() {
       $('a.linkk').removeClass('active');
       $(this).addClass('active');
   });
});
</script>


	<style>
		@media(max-width: 800px){
			.div2{
		float: none;
		width: 100%;
		}
		.div1{
			position: absolute;
			width: 100%;
			float: none;
		}
	}
	</style>
</body>
</html>