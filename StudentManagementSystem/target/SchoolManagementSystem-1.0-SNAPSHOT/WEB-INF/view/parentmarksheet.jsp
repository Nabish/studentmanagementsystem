<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
</head>
<style>
	h2{
	border-top-style: dotted;
    border-right-style: solid;
    border-bottom-style: dotted;
    border-left-style: solid;
	}
	input[type='number'] {
    -moz-appearance:textfield;
}

input::-webkit-outer-spin-button,
input::-webkit-inner-spin-button {
    -webkit-appearance: none;
}

label,input{
	display: inline-block;
	width: 100px;
}
img {
    max-width: 100%;
    height: auto;
    border-style: outset;
}
.photo {
    width: 150px;
    min-height: 100px;
    max-height: auto;
    float: right;
    margin: 3px;
    padding: 3px;
}
table, th, td {
    border: 1px solid black;
    text-align: center;
}
tr:hover {background-color: #f5f5f5;}

</style>
<body>
	
<h1><center>English School</center></h1><br>
<div class="container">
		<div class="photo">
		 <img src="<c:url value="/resources/Studentimage/${studentinfo.studentPhoto}"/>">
	</div>
<center><h2 style="width: 300px;">Progress Report</h2></center><br><br>

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
</div>
<br>
<table class="table" border=1>
		<tr>
			<th rowspan="2">S.N.</th>
			<th rowspan="2">Subjects</th>
			<th rowspan="2">Full Marks</th>
			<th rowspan="2">Pass Marks</th>
			<th colspan="2">Obtained Marks</th>
			<th rowspan="2">Total Marks</th>
			<th rowspan="2">Highest Marks</th>
			<tr>
				<th>Th.</th>
				<th>Pr.</th>
			</tr>
		</tr>
                <c:forEach items="${marks}" var="mark">
			
                    <tr>
				<td>1</td>
				<td>${mark.subjectName}</td>
				<td>100</td>
				<td>40</td>
				<td>${mark.marksObtained}</td>
				<td>${mark.marksObtainedPratical}</td>
				<td>${mark.total}</td>
				<td></td>
			</tr>
		</c:forEach>
				<tr>
					<td colspan="2">Grand Total</td>
					<td></td>
					<td></td>
					<td></td>
					<td></td>
					<td>${total}</td>
					<td></td>
				</tr>

</table>
<br>
<div class="row">
<div class="col-md-6">
	<table border=1>
		<th><center>Grading System</center>	</th>
		<tr>
		<td>75% & above	:	Distinction</td>
		</tr>
		<tr>
		<td>60% & above	:	First Division</td>
		</tr>
		<tr>
		<td>45% & above	:	Second Division</td>
		</tr>
		<tr>
		<td>35% & above	:	Third Division</td>
		</tr>
		<tr>
		<td>Below 35%	:	Fail (*)</td>
		</tr>
	</table>
</div>
<div class="col-md-6" align="right">
	<table>
		<tr>
			<td>
                            <label>Percentage:</label><input type="text" readonly="true" value="${percentage}">
			</td>
		</tr>
		<tr>
			<td>
                            <label>Division:</label><input type="text" readonly="true" value="${division}">
			</td>
		</tr>
		<tr>
			<td>
				<label>Position:</label><input type="text" readonly="true">
			</td>
		</tr>
		<tr>
			<td>
                            <label>Result:</label><input type="text" readonly="true" value="${result}">
			</td>
		</tr>
	</table>
</div>
</div>
<br>
<label>Remarks:</label><br>
<textarea class="form-control" rows="1"></textarea>
</div>
</body>
</html>