<!DOCTYPE html>
<html lang="en">
<head>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
    <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
  <title>Add Event</title>
<style type="text/css">
.icon.one{
          color: #FF715B;
      }
      .v10{
          background-color: #93A8AC;
          color: #484A47;
      }
</style>
</head>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
    <div class="main">
  <div class="container">
      <h1><center>Add Event</center></h1>
      <a href="viewevent"><button class="btn btn-primary"><i class="far fa-eye"></i> View Event</button></a>
      <div id="succssmessage"><h3><center>${message}</center></h3></div>

      <form:form method="POST" class="form-horizontal" action="addEventdata" commandName="eventModel">
  <div class="row">
  <div class="col-md-6">
      <center><label>Event Start:</label></center>

<form:select path="startyear" id="year" name="year">
  <form:option value="">Select Year</form:option>
  <form:option value="2024">2024</form:option>
  <form:option value="2023">2023</form:option>
  <form:option value="2022">2022</form:option>
  <form:option value="2021">2021</form:option>
  <form:option value="2020">2020</form:option>
  <form:option value="2019">2019</form:option>
  <form:option value="2018">2018</form:option>
  <form:option value="2017">2017</form:option>
</form:select><br>

<form:select path="startmonth" id="month" name="month">
  <form:option value="">Select Month</form:option>
  <form:option value="1">January</form:option>
  <form:option value="2">February</form:option>
  <form:option value="3">March</form:option>
  <form:option value="4">April</form:option>
  <form:option value="5">May</form:option>
  <form:option value="6">June</form:option>
  <form:option value="7">July</form:option>
  <form:option value="8">August</form:option>
  <form:option value="9">September</form:option>
  <form:option value="10">October</form:option>
  <form:option value="11">November</form:option>
  <form:option value="12">December</form:option>
</form:select><br>

<form:select path="startday" id="day" name="day">
  <form:option value="">Select Day</form:option>
</form:select>
<br><textarea name="description" placeholder="description" class="form-control" rows="7" style="width:90%;"/></textarea>
  </div>
    <div class="col-md-6">
        <center><label>Event End:</center>
<form:select path="endyear" id="yearr" name="year">
  <form:option value="">Select Year</form:option>
  <form:option value="2024">2024</form:option>
  <form:option value="2023">2023</form:option>
  <form:option value="2022">2022</form:option>
  <form:option value="2021">2021</form:option>
  <form:option value="2020">2020</form:option>
  <form:option value="2019">2019</form:option>
  <form:option value="2018">2018</form:option>
  <form:option value="2017">2017</form:option>
</form:select><br>

<form:select path="endmonth" id="monthh" name="month">
  <form:option value="">Select Month</form:option>
  <form:option value="1">January</form:option>
  <form:option value="2">February</form:option>
  <form:option value="3">March</form:option>
  <form:option value="4">April</form:option>
  <form:option value="5">May</form:option>
  <form:option value="6">June</form:option>
  <form:option value="7">July</form:option>
  <form:option value="8">August</form:option>
  <form:option value="9">September</form:option>
  <form:option value="10">October</form:option>
  <form:option value="11">November</form:option>
  <form:option value="12">December</form:option>
</form:select><br>

<form:select path="endday" id="dayy" name="day">
  <form:option value="">Select Day</form:option>
</form:select>

    </div>
 
<input type="submit" value="Add"/>
</form:form>
</div>

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
<script>
        function daysInMonth(month, year) {
  return new Date(year, month, 0).getDate();
}

$('#year, #month').change(function() {

  if ($('#year').val().length > 0 && $('#month').val().length > 0) {
    $('#day').prop('disabled', false);
    $('#day').find('option').remove();

    var daysInSelectedMonth = daysInMonth($('#month').val(), $('#year').val());

    for (var i = 1; i <= daysInSelectedMonth; i++) {
      $('#day').append($("<option></option>").attr("value", i).text(i));
    }

  } else {
    $('#day').prop('disabled', true);
  }

});
    </script>
    <script>
        function daysInMonth(month, year) {
  return new Date(year, month, 0).getDate();
}

$('#yearr, #monthh').change(function() {

  if ($('#yearr').val().length > 0 && $('#monthh').val().length > 0) {
    $('#dayy').prop('disabled', false);
    $('#dayy').find('option').remove();

    var daysInSelectedMonth = daysInMonth($('#monthh').val(), $('#yearr').val());

    for (var i = 1; i <= daysInSelectedMonth; i++) {
      $('#dayy').append($("<option></option>").attr("value", i).text(i));
    }

  } else {
    $('#dayy').prop('disabled', true);
  }

});
    </script>
</body>
</html>
