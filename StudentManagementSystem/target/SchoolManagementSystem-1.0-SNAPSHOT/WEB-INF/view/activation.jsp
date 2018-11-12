<%-- 
    Document   : activation
    Created on : 12-Oct-2018, 08:48:45
    Author     : nabish
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css" integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO" crossorigin="anonymous">
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>  
  
  
  <link rel="stylesheet" type="text/css" href="<c:url value="/resources/css/formcss.css"/>">
    </head>
    <style>
        .content{
            max-width: 500px;
            margin: auto;
            padding-top: 100px;
        }
    </style>
    <body>
        <div class="container content">
            <table class="table table-bordered">
                <tr>
                    <td>School Name     :</td><td>${admin.schoolName}</td>
                </tr>
                <tr>
                    <td>Address     :</td><td>${admin.schoolAddress}</td>
                </tr>
                <tr>
                    <td>Phone No.       :</td><td>${admin.schoolPhoneNumber}</td>
                </tr>
                <tr>
                    <td>Email       :</td><td>${admin.schoolEmail}</td>
                </tr>
        </table>

        <form method="post" action="adminactivation">
            <div style="border:1px solid; padding-bottom: 15px; padding-left:35px;" class="container" >
            <label>Activation:</label><br>
            <input type="text" value="${admin.adminid}" readonly="true" name="adminid" class="input"><br>
            <input type="text" placeholder="Activation Code" name="productkey" class="input"><br>
            <input type="submit" value="Activate">
            </div>
            </form>
        </div>
    </body>
</html>
 