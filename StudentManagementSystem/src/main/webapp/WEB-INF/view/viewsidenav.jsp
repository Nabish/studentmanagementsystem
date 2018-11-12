<html>
    <head>
<script src="https://code.jquery.com/jquery-3.3.1.min.js" integrity="sha256-FgpCb/KJQlLNfOu91ta32o/NMZxltwRo8QtmkMRdAu8="crossorigin="anonymous"></script>
<script data-require="bootstrap@*" data-semver="3.2.0" src="https://maxcdn.bootstrapcdn.com/bootstrap/3.2.0/js/bootstrap.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
 
 <style type="text/css">
@font-face {
  font-family: 'Lekton-Regular';
  src: url('Lekton-Regular.eot');
  src: url('Lekton-Regular.eot?#iefix') format('embedded-opentype'),
       url('Lekton-Regular.woff') format('woff'),
       url('Lekton-Regular.ttf') format('truetype'),
       url('Lekton-Regular.svg#Lekton-Regular') format('svg');
  
}

.section_header
{
  padding: 15px;
  max-width: 200px;
  color: #eee;
  font-size: 15px;
  cursor: pointer;
}
.section_header:hover
{
  background-color: #93A8AC;
}

.section_header::after
{
   content: "+"; 
   font-size: 20px;
    color: #eee;
    float: right;
    margin-left: 5px;
  margin-top: -3px;
}
.section_para{
   background-color: #596467;
}
.section_para a
{ 
  margin-left: 5px;
  padding-bottom: 5px;
  max-width: 200px;
  display:block;
}
.button {
  background-color: #132226;
  border: none;
  color: white;
  padding: 5px;
  text-align: center;
  font-size: 16px;
  opacity: 1;
  width: 150px;
  transition: 0.3s;
  display: inline-block;
  text-decoration: none;
  cursor: pointer;
  font-family: 'Lekton-Regular',sans-serif;
}

.button:hover {opacity: 0.6}

</style> 
        <script type="text/javascript">
            $(document).ready(function(){
  
  var allPanels = $('.section_para').hide();
    
  $('.section_header').click(function() {
      $(this).next().slideToggle();
      allPanels.not($(this).next()).slideUp();
      
  });
});
$(document).ready(function(){
    $('.section_header').click (function(e){
      $('.section_header.active').removeClass('active'); 
      var $parent=$(this).parent();
      $parent.addClass('active');
      e.preventDefault();
    });
});
</script>
    </head>
<body>
<div class="sidenav">
    <div class="section_header pop v1" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=classForm><button class=button> Add Class</button></a><br>
                          <a href=classview><button class=button> View Class</button></a>">
           <i class="fas fa-chalkboard-teacher"> </i> Class </div>
                    <div class="section_para">
                        <a href="classForm"><i class="far fa-plus-square"></i> Add Class</a>
                        <a href="classview"><i class="far fa-eye"></i> View Class</a>
                  </div>
    <div class="section_header pop v2" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=sectionForm><button class=button> Add Section</button></a><br>
                          <a href=sectionview><button class=button> View Section</button></a>">
    <i class="fas fa-chalkboard-teacher"> </i> Section </div>
                    <div class="section_para">
                        <a href="sectionForm"><i class="far fa-plus-square"></i> Add Section</a>
                        <a href="sectionview"><i class="far fa-eye"></i> View Section</a>
                  </div>
  <div class="section_header pop v3" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=subjectForm><button class=button> Add Subject</button></a><br>
                          <a href=subjectview><button class=button> View Subject</button></a>"><i class="fas fa-book"> </i> Subject </div>
                    <div class="section_para">
                        <a href="subjectForm"><i class="far fa-plus-square"></i> Add Subject</a>
                        <a href="subjectview"><i class="far fa-eye"></i> View Subject</a>
                  </div>
  <div class="section_header pop v4" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=addstudentform><button class=button> Add Student</button></a><br>
                          <a href=viewstudent><button class=button> View Student</button></a>"><i class="fas fa-user-graduate"> </i> Student </div>
                    <div class="section_para">
                        <a href="addstudentform"><i class="far fa-plus-square"></i> Add Student</a>
                        <a href="viewstudent"><i class="far fa-eye"></i> View Student</a>
                  </div>
  <c:if test="${sessionScope.adminlogged.staff ==true}">
  <div class="section_header pop v5" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=staffForm><button class=button> Add Staff</button></a><br>
                            <a href=teachingstaffForm><button class=button> Add Teacher</button></a><br>
                          <a href=staffview><button class=button> View Staff</button></a>"><i class="fas fa-user"> </i> Staff </div>
                    <div class="section_para">
                        <a href="staffForm"><i class="far fa-plus-square"></i> Add Staff</a>
                        <a href="teachingstaffForm"><i class="far fa-plus-square"></i> Add Teacher</a>
                        <a href="staffview"><i class="far fa-eye"></i> View Staff</a>
                  </div>
  </c:if>
  <c:if test="${sessionScope.adminlogged.attendance ==true}">
      <div class="v6">
  <a href=""><i class="fas fa-user-check v6"> </i> Attendence</a>
      </div>
  </c:if>
  <c:if test="${sessionScope.adminlogged.transportation ==true}">
  <div class="section_header pop v7" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=addtransportationform><button class=button> Add Transport</button></a><br>
                          <a href=transportationview><button class=button> View Transport</button></a>"><i class="fas fa-bus-alt"> </i> Transportation </div>
                    <div class="section_para">
                        <a href="addtransportationform"><i class="far fa-plus-square"></i> Add Transport</a>
                        <a href="transportationview"><i class="far fa-eye"></i> View Transport</a>
                  </div>
  </c:if>
  <c:if test="${sessionScope.adminlogged.gallery ==true}">
  <div class="section_header pop v8" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=galleryform><button class=button> Add Gallery</button></a><br>
                          <a href=schoolgalleryalbumbs><button class=button> View Gallery</button></a>"><i class="fas fa-images"> </i> Gallery </div>
                    <div class="section_para">
                        <a href="galleryform"><i class="far fa-plus-square"></i> Add Gallery</a>
                        <a href="schoolgalleryalbumbs"><i class="far fa-eye"></i> View Gallery</a>
                  </div>
  </c:if>
  <div class="v9">
  <a href=""><i class="fas fa-file-alt"> </i> Finance Report</a>
  </div>
  <c:if test="${sessionScope.adminlogged.event ==true}">
  <div class="section_header pop v10" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=addevent><button class=button> Add Event</button></a><br>
                          <a href=viewevent><button class=button> View Event</button></a>"><i class="fas fa-calendar-alt"> </i> Event </div>
                    <div class="section_para">
                        <a href="addevent"><i class="far fa-plus-square"></i> Add Event</a>
                        <a href="viewevent"><i class="far fa-eye"></i> View Event</a>
                  </div>
  </c:if>
  <c:if test="${sessionScope.adminlogged.marksheet ==true}">
  <div class="section_header pop v11" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=addmarksheet><button class=button> Add Mark Sheet</button></a><br>
            <a href=viewmarksheet><button class=button> View Mark Sheet</button></a><br>
                          <a href=print><button class=button> Print Mark Sheet</button></a>
                          ">
      <i class="fas fa-clipboard-list"> </i> Mark Sheet </div>
                    <div class="section_para">
                        <a href="addmarksheet"><i class="far fa-plus-square"></i> Add Mark Sheet</a>
                        <a href="viewmarksheet"><i class="far fa-eye"></i> View Mark Sheet</a>
                        <a href="print"><i class="fas fa-print"></i>  </i> Mark Sheet Print</a>
                  </div>
  </c:if>
  <c:if test="${sessionScope.adminlogged.feedBack ==true}">
      <div class="v12">
  <a href="viewfeedback"><i class="fas fa-comments"> </i> Feedback</a>
      </div>
  </c:if>
  <c:if test="${sessionScope.adminlogged.fee ==true}">
  <div class="section_header pop v13" data-container="body" data-toggle="popover" 
            data-placement="right" 
            data-content="<a href=feeForm><button class=button> Add Fee</button></a><br>
            <a href=feeview><button class=button> View Fee</button></a><br>
                          <a href=billing><button class=button> Print Fee</button></a>">
      <i class="fas fa-file-alt"> </i> Fee </div>
                    <div class="section_para">
                        <a href="feeForm"><i class="far fa-plus-square"></i> Add Fee</a>
                        <a href="feeview"><i class="far fa-eye"></i> View Fee</a>
                        <a href="billing"><i class="fas fa-print"></i>  </i> Print Fee</a>
                  </div>
 
  </c:if>
  <div class="v14">
  <a href="admitcard"><i class="fas fa-print"> </i> Admit Card Print</a>
  </div>
    <a></a>
    <a></a>
    <a></a>
    <a></a>
</div>
<script>   
$(".pop").popover({ trigger: "manual" , html: true, animation:false})
    .on("mouseenter", function () {
        var _this = this;
        $(this).popover("show");
        $(".popover").on("mouseleave", function () {
            $(_this).popover('hide');
        });
    }).on("mouseleave", function () {
        var _this = this;
        setTimeout(function () {
            if (!$(".popover:hover").length) {
                $(_this).popover("hide");
            }
        }, 100);
});
</script>
 </body>
 </html>