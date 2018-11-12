<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title>Print Marksheet </title>	
        
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
        <script>
$(document).ready(function(){
    $("#hide").click(function(){
        $("button").hide();
    	window.print();
    });
    
});
</script>
</head>
<style>
label,input{
	display: inline-block;
	width: 100px;
}

.icon.one{
          color: #FF715B;
      }
      .v11{
          background-color: #93A8AC;
          color: #484A47;
      }

</style>
<body>
    <%@include file="navbar.jsp" %>
<c:forEach items="${students}" var="studentinfo" varStatus="counter">    
    <h1><center>${sessionScope.adminlogged.schoolName}</center></h1>
    <h6><center>${sessionScope.adminlogged.schoolAddress}</center></h6>
    <h6><center>${sessionScope.adminlogged.schoolPhoneNumber}</center></h6>
<div class="container">
	
<center><h2 class="h2printmark">Progress Report</h2></center><br><br>
<button id="hide" class="btn btn-default" onclick="function()" style="float:right;"><i class="fas fa-print" style="font-size:30px;"></i> Print</button>

<div class="row">
	<div class="col-md-12">
<label>Name:</label>${studentinfo.studentFirstname}<br>
</div>
<div class="col-md-3">
<label>Class:</label>${studentinfo.classes.className}
</div>
<div class="col-md-3">
<label><center>Section:</center></label>${studentinfo.section.section}
</div>
<div class="col-md-3">
<label><center>Roll No:</center></label>${studentinfo.studentRegistrationNumber}
</div>
<div class="col-md-12">
    <lable><b>Term:</b><input type="text" style="border:none" id="term${counter.count}"></lable>
</div>
</div>
<br>
<div style="max-height: 800px; min-height: 800px;">
    <div class="table-responsive">
    <table class="table table-bordered">
		<tr>
			<th rowspan="2">S.N.</th>
			<th rowspan="2">Subjects</th>
			<th colspan="2">Full Marks</th>
			<th colspan="2">Pass Marks</th>
			<th colspan="2">Obtained Marks</th>
			<th rowspan="2">Total Marks</th>
			
			<tr>
                            <th>Th.</th>
				<th>Pr.</th>
                                <th>Th.</th>
				<th>Pr.</th>
				<th>Th.</th>
				<th>Pr.</th>
			</tr>
		</tr>
                <c:forEach items="${studentinfo.marksheet}" var="mark" varStatus="count">
                    <tr style="min-height: 500px;">
				<td>${count.count}</td>
				<td>${mark.subjectName}</td>
				<td>${mark.theoryFullMark}</td>
                                <c:choose>
                                    <c:when test="${mark.practicalFullMark eq 0}" ><td>-</td></c:when>
                                    <c:otherwise><td>${mark.practicalFullMark}</td></c:otherwise>
                                </c:choose>
				<td>${mark.theoryPassMark}</td>
				 <c:choose>
                                    <c:when test="${mark.practicalPassMark eq 0}" ><td>-</td></c:when>
                                    <c:otherwise><td>${mark.practicalPassMark}</td></c:otherwise>
                                </c:choose>
                                <td>${mark.marksObtained}<c:if test="number ${mark.marksObtained < mark.theoryPassMark}">*</c:if></td>
				<c:choose>
                                    <c:when test="${mark.marksObtainedPratical eq '0'}" ><td></td></c:when>
                                    <c:otherwise> <td>${mark.marksObtainedPratical}<c:if test="number ${mark.marksObtainedPratical < mark.practicalPassMark}">*</c:if></td></c:otherwise>
                                </c:choose>
				<td>${mark.total}</td>
				
			</tr>
                     

		</c:forEach>
				<tr>
					<th colspan="2">Grand Total</th>
					<th></th>
					<th></th>
					<th></th>
                                        <th></th>
                                        <th>${studentinfo.grandtotal}</th>
                                        <th></th>
                                        <th></th>
                                        
				</tr>

</table>
</div>
</div>
<br>
<div class="row">
<div class="col-md-4">
    <div class="table-responsive">
	<table class="table table-bordered">
		<th colspan="2"><center>Grading System</center>	</th>
		<tr>
		<th>80% & above:</th><td>Distinction</td>
		</tr>
		<tr>
		<th>60% & above:</th><td>First Division</td>
		</tr>
		<tr>
		<th>50% & above:</th><td>Second Division</td>
		</tr>
		<tr>
		<th>40% & above:</th><td>Third Division</td>
		</tr>
		<tr>
		<th>Below 40%:</th><td>Fail (*)</td>
		</tr>
	</table>
</div>
</div>
<div class="col-md-5">
<br><br><label>Remarks:</label><br>
<textarea class="form-control" rows="5" readonly="true"></textarea>
</div>

<div class="col-md-3" align="right">
    <div class="table-responsive">
	<table class="table table-bordered">
		<tr>
			<td>
				<label>Percentage:</label>
			</td>
                        <td>${studentinfo.percentage}</td>
		</tr>
		<tr>
			<td>
				<label>Division:</label>
			</td>
                        <td>${studentinfo.division}</td>
		</tr>
		<tr>
			<td>
				<label>Position:</label>
			</td>
                        <td>${counter.count}</td>
		</tr>
		<tr>
			<td>
			<label>Result:</label>
			</td>
                        <td>${studentinfo.result}</td>
		</tr>
	</table>
</div>
</div>
</div>
</div>
    </c:forEach>
    <script src="jquery-1.12.4.min.js"></script>
    <script>
            

    $(document).ready(function(){
                $("#term1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#term"+ i).val($(this).val());
                    }
                
            });
        });
        </script>
</body>
</html>