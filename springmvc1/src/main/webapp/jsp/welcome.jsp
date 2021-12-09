<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@page isELIgnored="false" %>
    <%-- <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> --%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>

   <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">


</head>
<body>
<div class="container mt-5">
  	<h3 class="text-center">Product Selection Form</h3>
   <form action="productform" method="post">
   
  	 <div class="form-group">
    <label for="Colour">Colour</label>
    <input type="text" class="form-control" id="formGroupExampleInput" placeholder="Colour" name="Colour">
  </div>
  <div class="form-group">
    <label for="Size">Size</label>
    <input type="text" class="form-control" id="Size" placeholder="Size" name="Size">
  </div>
  
   <div class="form-group">
    <label for="Gender">Gender</label>
    <input type="text" class="form-control" id="Gender" placeholder="Gender" name="Gender">
  </div>
  <div class="form-group">
    <label for="Preference">Output Preference: 1)Price 2)Rating 3)Both price and Rating</label>
    <input type="text" class="form-control" id="Preference" placeholder="Preference" name="Preference">
  </div>
  <button type="submit" class="btn btn-primary">Submit</button>
    </form>
    </div>
    
<%--     <hr>
    
    <h2>the final product is </h2>
<hr>
<c:forEach var="item" items="${product}">
	<h1><c:out value="${item}"></c:out> </h1>

</c:forEach> --%>
    
        <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  

</body>
</html>