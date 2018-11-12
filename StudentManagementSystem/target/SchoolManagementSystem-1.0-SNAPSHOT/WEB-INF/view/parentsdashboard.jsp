<!DOCTYPE html>
<html lang="en">
<head>
  <title>Parent dashboard</title>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/css/bootstrap.min.css">
  <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
  <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.0/umd/popper.min.js"></script>
  <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.1.0/js/bootstrap.min.js"></script>
  <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.1.1/css/all.css" integrity="sha384-O8whS3fhG2OnA5Kas0Y9l3cfpmYjapjI0E4theH4iuMD+pLhbf6JI0jIMfYcK3yZ" crossorigin="anonymous">
  <link rel="stylesheet" type="text/css" href="./admincss.css">
  <link rel="stylesheet" type="text/css" href="./parent nav.css">
  <link rel="stylesheet" type="text/css" href="./tablecss.css">

  <style>
        .imgg {
    width: 60px;
    height: 60px;
    object-fit: contain;
    background-color: #fff;
}
      </style>
</head>
<body>
  <div class="body"></div>
  <%@include file="parentnav.jsp" %>
 <div class="container" style="padding-top: 30px;">
  <div class="wals">
    <h2>${studentinfo.studentFathername}</h2>
    <h1>Student(s)</h1>

      <div class="table-responsive">          
    <table class="table">
      <thead>
        <tr>
            <td><b>Photo</b></td>
            <td><b>Name</b></td>
            <td><b>Middle Name</b></td>
            <td><b>Last Name</b></td>
            <td><b>Class</b></td>
          </tr>
      </thead>
      <tbody>
        <tr class='clickable-row' data-href=''>
           <td class="photo"><img class="imgg" src="<c:url value="/resources/Studentimage/${studentinfo.studentPhoto}"/>"></td>
          <td>${studentinfo.studentFirstname}</td>         
          <td>${studentinfo.studentMiddlename}</td>
          <td>${studentinfo.studentLastname}</td>
          <td>${studentinfo.classes.classUniqueKey}</td>
        </tr>
      
      </tbody>
      </table>
    </div>
</div></div>

</body>
</html>
