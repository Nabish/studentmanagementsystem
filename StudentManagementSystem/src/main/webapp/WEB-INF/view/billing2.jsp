<%-- 
    Document   : billing2
    Created on : Oct 9, 2018, 11:45:01 AM
    Author     : dell
--%>
<!DOCTYPE html>
<html>
<head>
	<title></title>
	<meta charset="utf-8">
        <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  	<meta name="viewport" content="width=device-width, initial-scale=1">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script>
$(document).ready(function(){
    $("#hide").click(function(){
        $("button").hide();
        var x = document.getElementById("hiding");
    if (x.style.display === "none") {
        x.style.display = "block";
    } else {
        x.style.display = "none";
    }
    	window.print();
    });
    
});
</script>
</head>
<style type="text/css">
	h2{
	border-top-style: dotted;
    border-right-style: dotted;
    border-bottom-style: dotted;
    border-left-style: dotted;
	}
        .icon.one{
          color: #FF715B;
      }
      .v13{
          background-color: #93A8AC;
          color: #484A47;
      }
      
   </style>

<body>
    <%@include file="navbar.jsp" %>
    <div id="hiding" class="container"><br>
        <label>Month:</label><input type="text" style="border:none" id="month"><br>
        <table align="center" class="table table-bordered" style="border-color: black;">
            <tr>
                <th>Registration No.</th>
                <th>Student Name</th>
                <th>Due</th>
                <th>Discount</th>
            </tr>
    <c:forEach items="${students}" var="studentlist" varStatus="counter">
        <tr>
            <td>${studentlist.studentRegistrationNumber}</td>
            <td>${studentlist.studentFirstname} ${studentlist.studentMiddlename} ${studentlist.studentLastname}</td>
            <td><input type="text" onchange="duecal(${counter.count})" name="dueamt" value="0"/></td>
            <td><input type="text" onchange="discal(${counter.count})" name="disamt" value="0"/></td>
    </c:forEach>
       </table>
        <button id="hide" class="btn btn-default" value="Calculate" onclick="sum()"><i class="fas fa-calculator"></i> Calculate and Print</button>
         
</div>
    <div class="container">
<c:forEach items="${students}" var="studentinfo" varStatus="counter">
    
		 <h1><center>${sessionScope.adminlogged.schoolName}</center></h1>
                <h6><center>${sessionScope.adminlogged.schoolAddress}</center></h6>
                <h6><center>${sessionScope.adminlogged.schoolPhoneNumber}</center></h6>

		<div class="row">
			<div class="col-md-4">
		<label>Student Name:${studentinfo.studentFirstname} ${studentinfo.studentMiddlename} ${studentinfo.studentLastname}</label><br>
		</div>
		<div class="col-md-8"></div>
		<div class="col-md-3">
		<label>Class:${studentinfo.classes.className}</label>
		</div>
		<div class="col-md-3">
		<label>Section:${studentinfo.section.section}</label>
		</div>
		<div class="col-md-3">
		<label>Registration No:${studentinfo.studentRegistrationNumber}</label>
		</div>
		<div class="col-md-6"></div>
		
	</div>
	<br><br>
	<center><h2 style="width: 300px;">Invoice</h2></center><br><br>
	<label>Month:</label><input type="text" style="border:none" id="month${counter.count}"><br>
	<div class="table-responsive">
            <table class="table table-bordered tb" id="myTable">
		<tr>
			<th>S.N.</th>
			<th>Particulars</th>
			<th>Amount</th>
		</tr>
		<tr>
			<td align="center">1</td>
			<td>Tution Fee</td>
                        <td align="center"><input type="number" style="border:none" value="${fee.tutionfee}" readonly="true" id="txt1"></td>
		</tr>
                <tr>
			<td align="center">2</td>
			<td>Computer Fee</td>
			<td align="center"><input type="number" style="border:none" value="${fee.computerfee}" readonly="true" id="txt2"></td>
		</tr>
                <tr>
			<td align="center">3</td>
			<td>Library Fee</td>
			<td align="center"><input type="number" style="border:none" value="${fee.libraryfee}" readonly="true" id="txt3"></td>
		</tr>
                <tr>
			<td align="center">4</td>
			<td>ECA Fee</td>
			<td align="center"><input type="number" style="border:none" value="${fee.ecafee}" readonly="true" id="txt4"></td>
		</tr>
                <tr>
			<td align="center">5</td>
			<td>Transportation Fee</td>
			<td align="center">
                            <c:if test="${studentinfo.transportationFlag=='1'}">    
                                <input type="number" style="border:none" value="${fee.transportationfee}" readonly="true" id="fiveval${counter.count}">
                            </c:if>
                            <c:if test="${studentinfo.transportationFlag=='0'}">    
                                <input type="number" style="border:none" value="0" readonly="true" id="fiveval${counter.count}">
                            </c:if>
                            
                            </td>
		</tr>
                 <tr>
			<td align="center">6</td>
			<td><input type="text" style="border:none" id="sixpar${counter.count}"></td>
			<td align="center"><input type="number" style="border:none" readonly="true" id="sixval${counter.count}"></td>
		</tr>
                <tr>
			<td align="center">7</td>
                        <td><input type="text" style="border:none" id="sevenpar${counter.count}"></td>
			<td align="center"><input type="number" style="border:none" readonly="true" id="sevenval${counter.count}"></td>
		</tr>
                
                <tr>
			<td align="center">8</td>
                        <td><input type="text" style="border:none" id="eightpar${counter.count}"></td>
			<td align="center"><input type="number" style="border:none" readonly="true" id="eightval${counter.count}"></td>
		</tr>
                
		<tr>
		<th colspan="2">Total</th>
		<th><input type="number" id="result${counter.count}" style="border:none"/></th>
		</tr>
                
                <tr>
		<th colspan="2">Due</th>
		<th><input type="number" id="due${counter.count}" style="border:none"/></th>
		</tr>
                
                <tr>
		<th colspan="2">Discount</th>
		<th><input type="number" id="discount${counter.count}" style="border:none"/></th>
		</tr>
                
                <tr>
		<th colspan="2">Grand Total</th>
		<th><input type="number" id="grandtotal${counter.count}" style="border:none"/></th>
		</tr>
		
	</table>
                
</div>
	
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
                <br>
         
                
                
        </c:forEach>
             </div>   
                
    <script src="//ajax.aspnetcdn.com/ajax/jQuery/jquery-1.6.1.js"></script>
    <script src="jquery-1.12.4.min.js"></script>
        <script>
            $(document).ready(function(){
                $("#sevenpar1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#sevenpar"+ i).val($(this).val());
                    }
                
            });
        });
           $(document).ready(function(){
                $("#sevenval1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#sevenval"+ i).val($(this).val());
                    }
                
            });
        });
        
        $(document).ready(function(){
                $("#sixpar1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#sixpar"+ i).val($(this).val());
                    }
                
            });
        });
           $(document).ready(function(){
                $("#sixval1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#sixval"+ i).val($(this).val());
                    }
                
            });
        });
        
        $(document).ready(function(){
                $("#eightpar1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#eightpar"+ i).val($(this).val());
                    }
                
            });
        });
        $(document).ready(function(){
                $("#eightpar1").keyup(function(){
                var i;
                    for (i = 2; i < 200; i++) { 
                    $("#eightpar"+ i).val($(this).val());
                    }
                
            });
        });
           $(document).ready(function(){
                $("#month").keyup(function(){
                var i;
                    for (i = 1; i < 200; i++) { 
                    $("#month"+ i).val($(this).val());
                    }
                
            });
        });
        
        function duecal() {
            var i=arguments[0];
            var a=i-1;
            var amt = document.getElementsByName('dueamt')[a].value;
            $("#due"+i).val(amt);
            console.log(acc);
        }
                function discal() {
            var i=arguments[0];
            var a=i-1;
            var amt = document.getElementsByName('disamt')[a].value;
            $("#discount"+i).val(amt);
            console.log(acc);
        }
        
        function sum() {
            var i;
             for (i = 1; i < 200; i++) { 
            var txtFirst = document.getElementById('txt1').value;
            var txtSecond = document.getElementById('txt2').value;
            var txtThird= document.getElementById('txt3').value;
            var txtFourth = document.getElementById('txt4').value;
            var txtFifth = $("#fiveval"+ i).val();
            var txtSixth = $("#sixval"+ i).val();
            console.log(txtSixth);
            if(txtSixth===""){
                txtSixth=0;
            }
            
            
            var txtseventh = $("#sevenval"+ i).val();
            if(txtseventh===""){
                txtseventh=0;
            }
            
            
            var txtEighth =$("#eightval"+ i).val();
            if(txtEighth===""){
                txtEighth=0;
            }
            var result = parseInt(txtseventh) +parseInt(txtFirst) + parseInt(txtSecond)+ parseInt(txtThird) + parseInt(txtFourth) + parseInt(txtFifth) + parseInt(txtSixth) + parseInt(txtEighth);
            if (!isNaN(result)) {
            $("#result"+ i).val(result);
      }
      
       var res = $("#result"+ i).val();
            if(res===""){
                res=0;
            }
            
         var due = $("#due"+ i).val();
            if(due===""){
                due=0;
            }
          var dis = $("#discount"+ i).val();
            if(dis===""){
                dis=0;
            }
            
        var grandtotal =parseInt(res) + parseInt(due) - parseInt(dis);
         if (!isNaN(grandtotal)) {
            $("#grandtotal"+ i).val(grandtotal);
      }
}
}
        </script>
        
</body>
</html>