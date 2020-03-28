<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="aiss.Matchpubg" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="cabecera.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="pruebapubg.css" />
<title>Insert title here</title>
</head>
<body>

<%List<Matchpubg> equipos = (List) request.getAttribute("lista");%>
<div align="right" style="margin-right:5%;margin-top:4%">
<% for(int i=0;i<6;i=i+3)
{
%>

<div style="margin-top:1%;">
<div style="display:inline-block;margin-left:1%;">
<a href="#popup<%=i%>">
  <img src="img/mapas/<%= equipos.get(i).getMapa()%>.jpg" alt="Partido <%= i %>" style="width:180px;height:180px;border:2px;">
</a>
<div id="popup<%=i%>" class="overlay" align="left">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><c:out value="<%= equipos.get(i).getNombre()%>"/></p>
		<p><c:out value="<%= equipos.get(i).getKills()%>"/></p>
		<p><c:out value="<%= equipos.get(i).getWinplace()%>"/></p>
		
	</div>
</div>
</div>
<div style="display:inline-block;margin-left:1%;">
<a href="#popup<%=i+1%>">
  <img src="img/mapas/<%= equipos.get(i+1).getMapa()%>.jpg" alt="Partido <%= i+1 %>" style="width:180px;height:180px;border:2px;">
</a>
<div id="popup<%=i+1%>" class="overlay" align="left">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><c:out value="<%= equipos.get(i+1).getNombre()%>"/></p>
		<p><c:out value="<%= equipos.get(i+1).getKills()%>"/></p>
		<p><c:out value="<%= equipos.get(i+1).getWinplace()%>"/></p>
		
	</div>
</div>
</div>
<div style="display:inline-block;margin-left:1%;">
<a href="#popup<%=i+2%>">
  <img src="img/mapas/<%= equipos.get(i+2).getMapa()%>.jpg" alt="Partido <%= i+2 %>" style="width:180px;height:180px;border:2px;">
</a>
<div id="popup<%=i+2%>" class="overlay" align="left">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><c:out value="<%= equipos.get(i+2).getNombre()%>"/></p>
		<p><c:out value="<%= equipos.get(i+2).getKills()%>"/></p>
		<p><c:out value="<%= equipos.get(i+2).getWinplace()%>"/></p>
		
	</div>
</div>
</div>
</div>
<%} %>
</div>
</body>
</html>