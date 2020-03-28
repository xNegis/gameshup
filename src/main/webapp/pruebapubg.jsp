<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pruebapubg.css" />
<title>Insert title here</title>
</head>
<body>

<!-- <h1>Popup/Modal Windows without JavaScript</h1> -->
<!-- <div class="box"> -->
<!-- 	<a class="button" href="#popup1">Let me Pop up</a> -->
<!-- </div> -->

<!-- <div id="popup1" class="overlay"> -->
<!-- 	<div class="popup"> -->
<!-- 		<h2>Here i am</h2> -->
<!-- 		<a class="close" href="#">&times;</a> -->
<!-- 		<div class="content"> -->
<!-- 			Thank to pop me out of that button, but now i'm done so you can close this window. -->
<!-- 		</div> -->
<!-- 	</div> -->
<!-- </div> -->


<c:forEach items="${requestScope.lista}" var="entry">
<div style="width:30%;display:inline-block;margin-left:3%;">
<div>
<p><img src="img/mapas/${entry.mapa}.jpg" width="300" height="300"><a class="button" href="#popup1"><c:out value="${entry.winplace}"/></a></p>
</div>
</div>
<div id="popup1" class="overlay">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><c:out value="${entry.mapa}"/></p>
		<p><c:out value="${entry.nombre}"/></p>
		<p><c:out value="${entry.kills}"/></p>
		
	</div>
</div>
</c:forEach>
</body>
</html>