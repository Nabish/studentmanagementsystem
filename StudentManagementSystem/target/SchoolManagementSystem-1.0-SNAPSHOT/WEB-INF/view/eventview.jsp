<!DOCtype html>
<html>
<head>
<title>Any Month Calendar</title>
 <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<script type="text/javascript">
    function setToday() {
var now   = new Date();
var day   = now.getDate();
var month = now.getMonth();
var year  = now.getYear();
if (year < 2000)    // Y2K Fix, Isaac Powell
year = year + 1900; // http://onyx.idbsu.edu/~ipowell
this.focusDay = day;
document.calControl.month.selectedIndex = month;
document.calControl.year.value = year;
displayCalendar(month, year);
}
function isFourDigitYear(year) {
if (year.length != 4) {
alert ("Sorry, the year must be four-digits in length.");
document.calControl.year.select();
document.calControl.year.focus();
} else { return true; }
}
function selectDate() {
var year  = document.calControl.year.value;
if (isFourDigitYear(year)) {
var day   = 0;
var month = document.calControl.month.selectedIndex;
displayCalendar(month, year);
    }
}

function setPreviousMonth() {
var year  = document.calControl.year.value;
if (isFourDigitYear(year)) {
var day   = 0;
var month = document.calControl.month.selectedIndex;
if (month == 0) {
month = 11;
if (year > 1000) {
year--;
document.calControl.year.value = year;
}
} else { month--; }
document.calControl.month.selectedIndex = month;
displayCalendar(month, year);
   }
}
function setNextMonth() {
var year  = document.calControl.year.value;
if (isFourDigitYear(year)) {
var day   = 0;
var month = document.calControl.month.selectedIndex;
if (month == 11) {
month = 0;
year++;
document.calControl.year.value = year;
} else { month++; }
document.calControl.month.selectedIndex = month;
displayCalendar(month, year);
   }
}

function displayCalendar(month, year) {       
month = parseInt(month);
year = parseInt(year);
var i = 0;
var days = getDaysInMonth(month+1,year);
var firstOfMonth = new Date (year, month, 1);
var startingPos = firstOfMonth.getDay();
days += startingPos;
document.calButtons.calPage.value  =   " Su     Mo     Tu     We     Th     Fr     Sa";
document.calButtons.calPage.value += "\n _________________________________";
for (i = 0; i < startingPos; i++) {
if ( i%7 == 0 ) document.calButtons.calPage.value += "\n";
document.calButtons.calPage.value += "          ";
}
for (i = startingPos; i < days; i++) {
if ( i%7 == 0 ) document.calButtons.calPage.value += "\n \n";
if (i-startingPos+1 < 10)
document.calButtons.calPage.value += "0";
document.calButtons.calPage.value += i-startingPos+1;
document.calButtons.calPage.value += "      ";
}
for (i=days; i<42; i++)  {
if ( i%7 == 0 ) document.calButtons.calPage.value += "\n \n ";
document.calButtons.calPage.value += "   ";
}
document.calControl.Go.focus();
}
function getDaysInMonth(month,year)  {
var days;
if (month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)  days=31;
else if (month==4 || month==6 || month==9 || month==11) days=30;
else if (month==2)  {
if (isLeapYear(year)) { days=29; }
else { days=28; }
}
return (days);
}
function isLeapYear (Year) {
if (((Year % 4)==0) && ((Year % 100)!=0) || ((Year % 400)==0)) {
return (true);
} else { return (false); }
}
</script>

<script src="//code.jquery.com/jquery-3.3.0.min.js"></script>
<style>
    .month_style {
  width: 120px;
  background-color: whitesmoke;
  font-size: 18px;
  border: 1px solid red;
}

.year_style {
  width: 85px;
  background-color: whitesmoke;
  font-size: 18px;
  border: 1px solid red;
  text-align: center;
}

.build_style {
  background-color: white;
  width: 85px;
  font-size: 18px;
  cursor: pointer;
}

.area_style {
  width: 465px;
  margin-top: 15px;
  font-size: 20px;
  font-family: sans-serif;
  background-color:#DCDCDC;

}
/*just remove the max-height
 and max-width to move the textarea
*/

.btn_nav {
  background-color: buttonface;
  width: 57px;
  font-size: 15px;
  cursor: pointer;
  margin-top: 15px;
  font-weight:bold;
}

.td{
  background-color:#f9f9f9;
  width: 20%;
  box-shadow: 5px 10px #888888;
  border-width: 3px;
} 

th{
  width:10%;
  text-align: center;
  box-shadow: 5px 10px #888888;
  border-width: 2px;
  font-size: 18px;
  background-color: #08605f;
  max-width: 33%
  }
       .icon.one{
          color: #FF715B;
      }
      .v10{
          background-color: #93A8AC;
          color: #484A47;
      }
  
</style>
</head>

<body onLoad="setToday()">
    <c:if test="${(not empty sessionScope.adminlogged)}">
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
    
    </c:if>
        <c:if test="${(not empty sessionScope.studentinfo)}">
    <%@include file="parentnav.jsp" %>
    </c:if>
    <div class="main">
        <div class="container">
        <h1><center>Events</center></h1>
        <a href="addevent"><button class="btn btn-primary"><i class="far fa-plus-square"></i> Add Event</button></a>
    
        <div class="row">
        <div class="col-md-6">
<form name="calControl" action="calender" method="get">
    
<table cellpadding="0" cellspacing="0" border="0">
	<tr>
		<td colspan=7>
			<select style="width: 200px;" id="cal" class="month_style target" name="month" onChange="selectDate()">
				<option >January</option>
				<option>February</option>
				<option>March</option>
				<option>April</option>
				<option>May</option>
				<option>June</option>
				<option>July</option>

				<option>August</option>
				<option>September</option>
				<option>October</option>
				<option>November</option>
				<option>December</option>
			</select>
			<input type=text class="year_style" name="year"  size=4 maxlength=4>
                        
			<!--<input type="button" class="build_style" name="Go" value="Go to!" onClick="selectDate()">-->
		</td>
	</tr>
        </table>
</form>

<form name="calButtons" method="post">
                <tr>
		<td><textarea font="Courier" class="area_style" name="calPage" WRAP=no style="height: 430px; width: 74%;" disabled></textarea></td>
			<tr>
	
                        
	</tr>
        </form>


 </div>
            
                <div class="col-md-6">
                    <div class="table-responsive">
                    <table class="table" style="margin-top: 60px;" border="3";>
                    <div class="row">
                        <div class="col-md-2">
                            <tr>
                                <th>Start Date</th> 
                                <th>End Date</th> 
                                <th>Description</th>
                                
                            </tr>
                        </div>
                    <div class="col-md-4">
                        <tr>
                            <td class="td"><p id="demo"></p></td>
                            <td class="td"><p id="demo2"></p></td>
                        <td class="td"><p id="demo1"></p></td>
                         </tr>
                    </div>
                    </div>
                </div>
             </table>
   </div>
</div>
    </div>
</div>
</div>
<script src="jquery-3.3.1.min.js"></script>
    <script>
         $(document).ready(function() {
      $("#cal").change(function() {
          var month=$(this).val();
          var myJSON="";
          var myJSON1="";
          var myJSON2="";
        $.getJSON("http://localhost:8080/StudentManagementSystem/calender?month="+month,function(data, status){
        console.log(data);
        console.log(status);
       
        for (var i = 0; i < data.length; i++) {
        myJSON1 += (data[i]['startday'])+"<br>";
        myJSON2 += (data[i]['endday'])+"<br>";
        myJSON += (data[i]['description'])+"<br>";
        
        }
        document.getElementById("demo").innerHTML = myJSON1;
         document.getElementById("demo1").innerHTML = myJSON;
         document.getElementById("demo2").innerHTML = myJSON2;
        });
        
        });
        

      });
  $(document).ready(function() {
      $("#cal").val(function() {
          var month=$(this).val();
          var myJSON="";
          var myJSON1="";
          var myJSON2="";
        $.getJSON("http://localhost:8080/StudentManagementSystem/calender?month="+month,function(data, status){
        console.log(data);
        console.log(status);
       
        for (var i = 0; i < data.length; i++) {
        myJSON1 += (data[i]['startday'])+"<br>";
        myJSON2 += (data[i]['endday'])+"<br>";
        myJSON += (data[i]['description'])+"<br>";
        
        }
        document.getElementById("demo").innerHTML = myJSON1;
         document.getElementById("demo1").innerHTML = myJSON;
         document.getElementById("demo2").innerHTML = myJSON2;
        });
        
        });
        

      });
    </script>

</body>
</html>