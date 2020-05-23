<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="model.auxiliary.Matchpubg" %>
<%@ page import="model.auxiliary.MatchpubgSeason" %>
<%@ page import="model.auxiliary.MatchPubgLifeStats" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@include file="cabecera.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<link rel="stylesheet" type="text/css" href="css/muestrapubg.css" />
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
</head>
<body>
<script>
function roundToTwo(num) {    
    return +(Math.round(num + "e+2")  + "e-2");
}
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
<%List<List<Matchpubg>> compis = (List) request.getAttribute("compis");%>

<div style="width:100%;overflow:hidden;margin-bottom:4%;">


<div style="float:left;width:30%;margin-left:8%;margin-top:3%;">
<div style="margin-bottom:6%;"><h1 class="display-4">LIFETIME STATS</h1></div>

<div style="width:90%;margin-top:8%;">
<div data-toggle="tooltip" data-placement="top" title="Kills" style="display:inline-block;margin-left:2%;width:52%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/kill.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.killsLS}</div>
<div data-toggle="tooltip" data-placement="top" title="Longest kill" style="display:inline-block;margin-left:2%;width:41%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/longestkill.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.longestKillLS} m</div>
</div>

<div style="width:90%;margin-top:8%;">
<div data-toggle="tooltip" data-placement="top" title="Road kills" style="display:inline-block;margin-left:2%;width:52%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/roadkill.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.roadKillsLS}</div>
<div data-toggle="tooltip" data-placement="top" title="Armas obtenidas" style="display:inline-block;margin-left:2%;width:41%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/armas.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.armasLS}</div>
</div>

<div style="width:90%;margin-top:8%;">
<div data-toggle="tooltip" data-placement="top" title="Tiempo sobrevivido" style="display:inline-block;margin-left:2%;width:52%;"><img  class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/tiempo.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;"><script> document.write(format(${jugadorLS.timeSurvivedLS}))</script></div>
<div data-toggle="tooltip" data-placement="top" title="Daño inflingido" style="display:inline-block;margin-left:2%;width:41%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/damage.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;"><script>document.write(roundToTwo(${jugadorLS.dmgDealtLS}))</script></div>
</div>

<div style="width:90%;margin-top:8%;">
<div data-toggle="tooltip" data-placement="top" title="Vehiculos destruidos" style="display:inline-block;margin-left:2%;width:52%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/vehicledestroy.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.vehiculosDestruidosLS}</div>
<div data-toggle="tooltip" data-placement="top" title="Suicidios" style="display:inline-block;margin-left:2%;width:41%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/pubg/Icons/suicide.png?authuser=1" class="mr-3" alt="..." style="margin-right:2%;">${jugadorLS.suicidiosLS}</div>
</div>

</div>


<div  style="float:right;width:600px;margin-top:4%;padding-left:2%;margin-right:8%;">
<% for(int i=0;i<6;i=i+3)
{
%>

<div style="margin-top:1%;">
<div style="display:inline-block;margin-left:1%;">
<a href="#popup<%=i%>">
  <img src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/<%= equipos.get(i).getMapa()%>.jpg?authuser=1" alt="Partido <%= i %>" style="border-radius: 12px;width:180px;height:180px;border:2px;">
</a>
<div id="popup<%=i%>" class="overlay" align="left">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><%= equipos.get(i).getNombre()%></p>
		<p><%= equipos.get(i).getKills()%></p>
		<p><%= equipos.get(i).getHeadshotskill()%></p>
		<p><%= equipos.get(i).getLongestkill()%></p>
		<p><%= equipos.get(i).getDamage()%></p>
		<p><%= equipos.get(i).getWinplace()%></p>
		<%for(int j=0;j<compis.get(i).size();j++){ %>
					<div style="display:inline-block;">
					
		<p><%= compis.get(i).get(j).getNombre()%></p>
		<p><%= compis.get(i).get(j).getKills()%></p>
		<p><%= compis.get(i).get(j).getHeadshotskill()%></p>
		<p><%= compis.get(i).get(j).getLongestkill()%></p>
		<p><%= compis.get(i).get(j).getDamage()%></p>
		<p><%= compis.get(i).get(j).getWinplace()%></p>
			
		</div>
		<%}%>
		<form method="POST" action="/googleDriveFileNew">

   		<%
   		
   		session.setAttribute("pubgNombre", request.getAttribute("nombre"));
   		session.setAttribute("pubgPlataforma", request.getAttribute("plataformap"));
   		session.setAttribute("nombre"+i, equipos.get(i).getNombre()); 
   		session.setAttribute("kills"+i, equipos.get(i).getKills());
   		session.setAttribute("hKills"+i, equipos.get(i).getHeadshotskill()); 
   		session.setAttribute("damage"+i, equipos.get(i).getDamage()); 
   		session.setAttribute("win"+i, equipos.get(i).getWinplace()); 
   		session.setAttribute("vengoLol",false); 
   		
   		
   		
   		%>
   
   
         <input class="botong" id="boton<%=i%>" name="boton<%=i%>" type="submit" value="Guardar partida" ></input>
    
		</form>
	</div>


</div>
</div>
<div style="display:inline-block;margin-left:1%;">
<a href="#popup<%=i+1%>">
  <img src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/<%= equipos.get(i+1).getMapa()%>.jpg?authuser=1" alt="Partido <%= i+1 %>" style="border-radius: 12px;width:180px;height:180px;border:2px;">
</a>
<div id="popup<%=i+1%>" class="overlay" align="left">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><%= equipos.get(i+1).getNombre()%></p>
		<p><%= equipos.get(i+1).getKills()%></p>
		<p><%= equipos.get(i+1).getHeadshotskill()%></p>
		<p><%= equipos.get(i+1).getLongestkill()%></p>
		<p><%= equipos.get(i+1).getDamage()%></p>
		<p><%= equipos.get(i+1).getWinplace()%></p>
		<%for(int j=0;j<compis.get(i+1).size();j++){ %>
					<div style="display:inline-block;">
					
		<p><%= compis.get(i+1).get(j).getNombre()%></p>
		<p><%= compis.get(i+1).get(j).getKills()%></p>
		<p><%= compis.get(i+1).get(j).getHeadshotskill()%></p>
		<p><%= compis.get(i+1).get(j).getLongestkill()%></p>
		<p><%= compis.get(i+1).get(j).getDamage()%></p>
		<p><%= compis.get(i+1).get(j).getWinplace()%></p>
		</div>
		<%}%>
		<form method="POST" action="/googleDriveFileNew">

   		<%
   		session.setAttribute("pubgNombre", request.getAttribute("nombre"));
   		session.setAttribute("pubgPlataforma", request.getAttribute("plataformap"));
   		session.setAttribute("nombre"+(i+1), equipos.get(i+1).getNombre()); 
   		session.setAttribute("kills"+(i+1), equipos.get(i+1).getKills()); 
   		session.setAttribute("hKills"+(i+1), equipos.get(i+1).getHeadshotskill()); 
   		session.setAttribute("damage"+(i+1), equipos.get(i+1).getDamage()); 
   		session.setAttribute("win"+(i+1), equipos.get(i+1).getWinplace()); 
   		session.setAttribute("vengoLol",false); 

   		
   		
   		%>
         <input class="botong" id="boton<%=(i+1)%>" name="boton<%=(i+1)%>" type="submit" value="Guardar partida" ></input>
    
		</form>
	</div>
</div>
</div>
<div style="display:inline-block;margin-left:1%;">
<a href="#popup<%=i+2%>">
  <img src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/<%= equipos.get(i+2).getMapa()%>.jpg?authuser=1" alt="Partido <%= i+2 %>" style="border-radius: 12px;width:180px;height:180px;border:2px;">
</a>
<div id="popup<%=i+2%>" class="overlay" align="left">
	<div class="popup">
		<a class="close" href="#">&times;</a>
		<p><%= equipos.get(i+2).getNombre()%></p>
		<p><%= equipos.get(i+2).getKills()%></p>
		<p><%= equipos.get(i+2).getHeadshotskill()%></p>
		<p><%= equipos.get(i+2).getLongestkill()%></p>
		<p><%= equipos.get(i+2).getDamage()%></p>
		<p><%= equipos.get(i+2).getWinplace()%></p>
		<%for(int j=0;j<compis.get(i+2).size();j++){ %>
					<div style="display:inline-block;">
					
		<p><%= compis.get(i+2).get(j).getNombre()%></p>
		<p><%= compis.get(i+2).get(j).getKills()%></p>
		<p><%= compis.get(i+2).get(j).getHeadshotskill()%></p>
		<p><%= compis.get(i+2).get(j).getLongestkill()%></p>
		<p><%= compis.get(i+2).get(j).getDamage()%></p>
		<p><%= compis.get(i+2).get(j).getWinplace()%></p>
		</div>
		<%}%>
		<form method="POST" action="/googleDriveFileNew">

   		<%
   		session.setAttribute("pubgNombre", request.getAttribute("nombre"));
   		session.setAttribute("pubgPlataforma", request.getAttribute("plataformap"));
   		session.setAttribute("nombre"+(i+2), equipos.get(i+2).getNombre()); 
   		session.setAttribute("kills"+(i+2), equipos.get(i+2).getKills()); 
   		session.setAttribute("hKills"+(i+2), equipos.get(i+2).getHeadshotskill()); 
   		session.setAttribute("damage"+(i+2), equipos.get(i+2).getDamage()); 
   		session.setAttribute("win"+(i+2), equipos.get(i+2).getWinplace()); 
   		session.setAttribute("vengoLol",false); 

   		
   		
   		%>
         <input class="botong" id="boton<%=(i+2)%>" name="boton<%=(i+2)%>" type="submit" value="Guardar partida" ></input>
    
		</form>
	</div>
</div>
</div>
</div>
<%} %>
</div>
</div>

 
</body>
</html>