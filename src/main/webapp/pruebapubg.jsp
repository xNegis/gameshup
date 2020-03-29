<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="aiss.Matchpubg" %>
<%@ page import="aiss.MatchpubgSeason" %>
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
<script>
function format(time) {   
    // Hours, minutes and seconds
    var hrs = ~~(time / 3600);
    var mins = ~~((time % 3600) / 60);
    var secs = ~~time % 60;

    // Output like "1:01" or "4:03:59" or "123:03:59"
    var ret = "";
    if (hrs > 0) {
        ret += "" + hrs + ":" + (mins < 10 ? "0" : "");
    }
    ret += "" + mins + ":" + (secs < 10 ? "0" : "");
    ret += "" + secs;
    return ret;
}
</script>
<%List<Matchpubg> equipos = (List) request.getAttribute("lista");%>
<%List<List<Matchpubg>> compis = (List) request.getAttribute("lista");%>
<%-- <%for(int i=0;i<compis.size();i++){  --%>
<%--   for(int j=0;j<compis.get(i).size();j++){%> --%>
<%--   <p><%=compis.get(i).get(j).getNombre()%></p> --%>
<%--   <p><%=compis.get(i).get(j).getKills()%></p> --%>
<%-- <%} }%> --%>

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
<%
MatchpubgSeason jugadors = (MatchpubgSeason)request.getAttribute("jugadors");
MatchpubgSeason jugadord = (MatchpubgSeason)request.getAttribute("jugadord");
MatchpubgSeason jugadorsq = (MatchpubgSeason)request.getAttribute("jugadorsq");
MatchpubgSeason jugadorsf = (MatchpubgSeason)request.getAttribute("jugadorsf");
MatchpubgSeason jugadordf = (MatchpubgSeason)request.getAttribute("jugadordf");
MatchpubgSeason jugadorsqf = (MatchpubgSeason)request.getAttribute("jugadorsqf");

%>
<%if(request.getAttribute("modoJSP").equals("tpp")){%>
<p>SOLO TPP</p>
<%if(jugadors.getKd().toString().equals("NaN")){%>
<div >No hay partidas Solo TPP esta season</div>
<%} %>
<div >KD ${jugadors.kd}</div>
<div >Win % ${jugadors.wins}</div>
<div >Daño medio ${jugadors.damage}</div>
<div >Tiempo Medio <script> document.write(format(${jugadors.time}))</script></div>
<div >Headshots % ${jugadors.headshot}</div>
<div >TOP 10 % ${jugadors.top10}</div>
<div >Longest Kill${jugadors.longestkill}</div>
<p>DUO TPP</p>
<%if(jugadord.getKd().toString().equals("NaN")){%>
<div >No hay partidas Duo TPP esta season</div>
<%} %>
<div >KD ${jugadord.kd}</div>
<div >Win % ${jugadord.wins}</div>
<div >Daño medio ${jugadord.damage}</div>
<div >Tiempo Medio <script> document.write(format(${jugadord.time}))</script></div>
<div >Headshots % ${jugadord.headshot}</div>
<div >TOP 10 % ${jugadord.top10}</div>
<div >Longest Kill${jugadord.longestkill}</div>

<p>SQUAD TPP</p>
<%if(jugadorsq.getKd().toString().equals("NaN")){%>
<div >No hay partidas Squad TPP esta season</div>
<%} %>
<div >KD ${jugadorsq.kd}</div>
<div >Win % ${jugadorsq.wins}</div>
<div >Daño medio ${jugadorsq.damage}</div>
<div >Tiempo Medio <script> document.write(format(${jugadorsq.time}))</script></div>
<div >Headshots % ${jugadorsq.headshot}</div>
<div >TOP 10 % ${jugadorsq.top10}</div>
<div >Longest Kill${jugadorsq.longestkill}</div>
<%}else{ %>
<p>SOLO FPP</p>
<%if(jugadorsf.getKd().toString().equals("NaN")){%>
<div >No hay partidas Solo TPP esta season</div>
<%} %>
<div >KD ${jugadorsf.kd}</div>
<div >Win % ${jugadorsf.wins}</div>
<div >Daño medio ${jugadorsf.damage}</div>
<div >Tiempo Medio <script> document.write(format(${jugadorsf.time}))</script></div>
<div >Headshots % ${jugadorsf.headshot}</div>
<div >TOP 10 % ${jugadorsf.top10}</div>
<div >Longest Kill${jugadorsf.longestkill}</div>
<p>DUO FPP</p>
<%if(jugadordf.getKd().toString().equals("NaN")){%>
<div >No hay partidas Duo TPP esta season</div>
<%} %>
<div >KD ${jugadordf.kd}</div>
<div >Win % ${jugadordf.wins}</div>
<div >Daño medio ${jugadordf.damage}</div>
<div >Tiempo Medio <script> document.write(format(${jugadordf.time}))</script></div>
<div >Headshots % ${jugadordf.headshot}</div>
<div >TOP 10 % ${jugadordf.top10}</div>
<div >Longest Kill${jugadordf.longestkill}</div>

<p>SQUAD FPP</p>
<%if(jugadorsqf.getKd().toString().equals("NaN")){%>
<div >No hay partidas Squad TPP esta season</div>
<%} %>
<div >KD ${jugadorsqf.kd}</div>
<div >Win % ${jugadorsqf.wins}</div>
<div >Daño medio ${jugadorsqf.damage}</div>
<div >Tiempo Medio <script> document.write(format(${jugadorsqf.time}))</script></div>
<div >Headshots % ${jugadorsqf.headshot}</div>
<div >TOP 10 % ${jugadorsqf.top10}</div>
<div >Longest Kill${jugadorsqf.longestkill}</div>
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
		<p><%= equipos.get(i).getNombre()%></p>
		<p><%= equipos.get(i).getKills()%></p>
		<p><%= equipos.get(i).getDamage()%></p>
		<p><%= equipos.get(i).getWinplace()%></p>
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