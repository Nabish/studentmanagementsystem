
<html>
    <head>
        <title></title>
    </head>
    <style>
        .current1 a{
             color:#70c1b3;
             
            }
    </style>
<body>
   
<%@include file="frontnav.jsp" %>

<section id="showcase" style="background:url(<c:url value="/resources/image/showcase.jpg"/>) no-repeat">
   
      <div class="container">
        <h1>Affordable Software For Schools</h1>
        <p>School Management System? is a web based application for school which is highly flexible and is well efficient to make easy interactions with the staff, parents and admin</p>
      </div>
    </section>

    <section id="boxes">
      <div class="container">
        <div class="box">
          <img src="<c:url value="/resources/image/admin.png"/>">
          <h3>Admin</h3>
          <p>Control the overall activites of a School</p>
        </div>
        <div class="box">
          <img src="<c:url value="/resources/image/parent.png"/>">
          <h3>Parent</h3>
          <p>View the task and activites of their childrens</p>
        </div>
        <div class="box">
          <img src="<c:url value="/resources/image/staff.png"/>">
          <h3>Staff</h3>
          <p>Convert the paper work into digital work</p>
        </div>
      </div>
    </section>
<%@include file="footer.jsp" %>
</body>
</html>
    
