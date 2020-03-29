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
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>

<%List<Matchpubg> equipos = (List) request.getAttribute("lista");%>


<div class="dropdown" style="display:inline-block;">
  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
  	Season  
   </button>
  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS6&name=xNegis">Season 6</a>
    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS5&name=xNegis">Season 5</a>
    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS4&name=xNegis">Season 4</a>
    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS3&name=xNegis">Season 3</a>
    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS2&name=xNegis">Season 2</a>
    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS1&name=xNegis">Season 1</a>
</div>
  <%if(request.getAttribute("modoJSP").equals("tpp")) {%>
  <a href="/pubg?modo=fpp&season='${seasonJSP}'&name=xNegis">FPP</a>
  <%}else{ %>
    <a href="/pubg?modo=tpp&season='${seasonJSP}'&name=xNegis">TPP</a>
  <%}%>
  
<div>
<%if(request.getAttribute("modoJSP").equals("tpp")){%>
<div ><%if(request.getAttribute("kds").toString().equals("NaN")){%>No hay partidas en solo en la temporada<%}else{ %>Solo KD ${kds}<%} %></div>
<div ><%if(request.getAttribute("kdd").toString().equals("NaN")){%>No hay partidas en solo en la temporada<%}else{ %>Duo KD ${kdd}<%} %></div>
<div ><%if(request.getAttribute("kdsq").toString().equals("NaN")){%>No hay partidas en solo en la temporada<%}else{ %>Squad KD ${kdsq}<%} %></div>
<%}else{ %>
<div ><%if(request.getAttribute("kds").toString().equals("NaN")){%>No hay partidas en solo en la temporada<%}else{ %>Solo KD ${kdsf}<%} %></div>
<div ><%if(request.getAttribute("kdd").toString().equals("NaN")){%>No hay partidas en solo en la temporada<%}else{ %>Duo KD ${kddf}<%} %></div>
<div ><%if(request.getAttribute("kdsq").toString().equals("NaN")){%>No hay partidas en solo en la temporada<%}else{ %>Squad KD ${kdsqf}<%} %></div>
<%} %>
</div>
  
</div>






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