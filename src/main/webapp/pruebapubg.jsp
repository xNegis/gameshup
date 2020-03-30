<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="aiss.Matchpubg" %>
<%@ page import="aiss.MatchpubgSeason" %>
<%@ page import="aiss.MatchPubgLifeStats" %>
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
function dividir(dmg){
	return dmg/100;
}
}
</script>
<%List<Matchpubg> equipos = (List) request.getAttribute("lista");%>
<%List<List<Matchpubg>> compis = (List) request.getAttribute("lista");%>
<div style="width:100%;">


<div style="float:left;width:35%;margin-left:10%;margin-top:3%;">
<div style="margin-bottom:6%;"><h2 class="display-5">LIFETIME STATS</h2></div>

<div style="width:90%;margin-top:5%;">
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/kill.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.killsLS}</div>
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/longestkill.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.longestKillLS}</div>
</div>

<div style="width:90%;margin-top:5%;">
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/roadkill.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.roadKillsLS}</div>
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/armas.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.armasLS}</div>
</div>

<div style="width:90%;margin-top:5%;">
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/tiempo.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;"><script> document.write(format(${jugadorLS.timeSurvivedLS}))</script></div>
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/damage.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.dmgDealtLS}</div>
</div>

<div style="width:90%;margin-top:5%;">
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/vehicledestroy.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.vehiculosDestruidosLS}</div>
<div style="display:inline-block;margin-left:2%;width:47%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/suicide.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.suicidiosLS}</div>
</div>

</div>


<div  style="float:right;width:45%;margin-top:3%;padding-left:6%;margin-right:10%;">
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
</div>
</body>
</html>