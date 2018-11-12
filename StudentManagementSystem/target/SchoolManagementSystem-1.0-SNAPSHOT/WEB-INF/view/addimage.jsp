<!DOCTYPE html>
<html>
<head>
    <title>Image Upload | Gallery</title>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
        <%@taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
</head> 
 <style type="text/css">
.icon.one{
          color: #FF715B;
      }
      .v8{
          background-color: #93A8AC;
          color: #484A47;
      }
    </style>
    <link rel="stylesheet" type="text/css" href="">
</head>
<body>
    <%@include file="navbar.jsp" %>
    <%@include file="viewsidenav.jsp" %>
    <div class="main">
        <div class="container">
    <div id="succssmessage"><h3><center>${message}</center></h3></div>
    <div class="grid-x grid-padding-x">
  <div >
      <h1><center>Upload Image</center></h1>
    
    <form:form action="addimages" id="img-upload-form" method="POST" enctype="multipart/form-data" commandName="imagemodel">
        <form:input type="text" path="gallery.galleryId" hidden="true"/>
        <p>
        <form:label path="file" for="upload_imgs" class="button hollow">Select Your Images +</form:label>
        <form:input path="file" type="file" class="show-for-sr" id="upload_imgs" multiple="multiple" hidden="true"/>
      <div class="quote-imgs-thumbs quote-imgs-thumbs--hidden" id="img_preview" aria-live="polite"></div>
      <p>
          <input type="submit" value="Upload Images" style="width:150px;"/>
      </p>
    </form:form>
  </div>
</div>
    </div>
    </div>
<!--
<label for="exampleFileUpload" class="button">Upload File</label>
<input type="file" id="exampleFileUpload" class="show-for-sr">
-->

<script type="text/javascript">
    var imgUpload = document.getElementById('upload_imgs')
  , imgPreview = document.getElementById('img_preview')
  , imgUploadForm = document.getElementById('img-upload-form')
  , totalFiles
  , previewTitle
  , previewTitleText
  , img;

imgUpload.addEventListener('change', previewImgs, false);


function previewImgs(event) {
  totalFiles = imgUpload.files.length;
  
  if(!!totalFiles) {
    imgPreview.classList.remove('quote-imgs-thumbs--hidden');
    previewTitle = document.createElement('p');
    previewTitle.style.fontWeight = 'bold';
    previewTitleText = document.createTextNode(totalFiles + ' Total Images Selected');
    previewTitle.appendChild(previewTitleText);
    imgPreview.appendChild(previewTitle);
  }
  
  for(var i = 0; i < totalFiles; i++) {
    img = document.createElement('img');
    img.src = URL.createObjectURL(event.target.files[i]);
    img.classList.add('img-preview-thumb');
    imgPreview.appendChild(img);
  }
}


</script>
</body>
</html>

   




