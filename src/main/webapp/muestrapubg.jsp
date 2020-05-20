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
		<p><%= equipos.get(i).getDamage()%></p>
		<p><%= equipos.get(i).getWinplace()%></p>
		<%for(int j=0;j<compis.get(i).size();j++){ %>
					<div style="display:inline-block;">
					
		<p><%= compis.get(i).get(j).getNombre()%></p>
		<p><%= compis.get(i).get(j).getKills()%></p>
		<p><%= compis.get(i).get(j).getDamage()%></p>
		<p><%= compis.get(i).get(j).getWinplace()%></p>
		<p><%= compis.get(i).get(j).getHeadshotskill()%></p>
		<p><%= compis.get(i).get(j).getWalkdistance()%></p>
		<p><%= compis.get(i).get(j).getLongestkill()%></p>
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
		<p><c:out value="<%= equipos.get(i+1).getNombre()%>"/></p>
		<p><c:out value="<%= equipos.get(i+1).getKills()%>"/></p>
		<p><c:out value="<%= equipos.get(i+1).getWinplace()%>"/></p>
		<%for(int j=0;j<compis.get(i+1).size();j++){ %>
					<div style="display:inline-block;">
					
		<p><%= compis.get(i+1).get(j).getNombre()%></p>
		<p><%= compis.get(i+1).get(j).getKills()%></p>
		<p><%= compis.get(i+1).get(j).getDamage()%></p>
		<p><%= compis.get(i+1).get(j).getWinplace()%></p>
		<p><%= compis.get(i+1).get(j).getHeadshotskill()%></p>
		<p><%= compis.get(i+1).get(j).getWalkdistance()%></p>
		<p><%= compis.get(i+1).get(j).getLongestkill()%></p>
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
		<p><c:out value="<%= equipos.get(i+2).getNombre()%>"/></p>
		<p><c:out value="<%= equipos.get(i+2).getKills()%>"/></p>
		<p><c:out value="<%= equipos.get(i+2).getWinplace()%>"/></p>
		<%for(int j=0;j<compis.get(i+2).size();j++){ %>
					<div style="display:inline-block;">
					
		<p><%= compis.get(i+2).get(j).getNombre()%></p>
		<p><%= compis.get(i+2).get(j).getKills()%></p>
		<p><%= compis.get(i+2).get(j).getDamage()%></p>
		<p><%= compis.get(i+2).get(j).getWinplace()%></p>
		<p><%= compis.get(i+2).get(j).getHeadshotskill()%></p>
		<p><%= compis.get(i+2).get(j).getWalkdistance()%></p>
		<p><%= compis.get(i+2).get(j).getLongestkill()%></p>
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
<div id="accordion" style="width:1000px;margin: auto;margin-bottom:4%;">
 <div class="card">
    <div class="card-header">
      <a class="card-link" data-toggle="collapse" href="#collapseOne" style="color:#ac4616;font-weight: 300;line-height: 1.2;text-decoration: none;">
SEASONS STATS</a>
    </div>
    <div id="collapseOne" class="collapse" data-parent="#accordion">
      <div class="card-body">
      		<div style="margin-left:2%;display:inline-block;">
			 <div class="dropdown">
			  <button class="btn btn-secondary dropdown-toggle" type="button" id="dropdownMenuButton" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
			  	Season  
			   </button>
			  <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
			    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS6&name=${nombre}&plataformap=${plataformap}">Season 6</a>
			    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS5&name=${nombre}&plataformap=${plataformap}">Season 5</a>
			    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS4&name=${nombre}&plataformap=${plataformap}">Season 4</a>
			    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS3&name=${nombre}&plataformap=${plataformap}">Season 3</a>
			    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS2&name=${nombre}&plataformap=${plataformap}">Season 2</a>
			    <a class="dropdown-item" href="/pubg?modo=tpp&season=SS1&name=${nombre}&plataformap=${plataformap}">Season 1</a>
			  </div>
			 </div>
			 </div>
			 <div style="margin-left:2%;display:inline-block;">
			  <%if(request.getAttribute("modoJSP").equals("tpp")) {%>
			  <a href="/pubg?modo=fpp&season=${seasonJSP}&name=${nombre}&plataformap=${plataformap}" style="color:#ac4616;font-weight: 300;line-height: 1.2;text-decoration: none;">FPP</a>
			  <%}else{ %>
			    <a href="/pubg?modo=tpp&season=${seasonJSP}&name=${nombre}&plataformap=${plataformap}" style="color:#ac4616;font-weight: 300;line-height: 1.2;text-decoration: none;">TPP</a>
			  <%}%>
			  </div>
			
			<div style="width:98%;margin-top:3%;">
			<%
			MatchpubgSeason jugadors = (MatchpubgSeason)request.getAttribute("jugadors");
			MatchpubgSeason jugadord = (MatchpubgSeason)request.getAttribute("jugadord");
			MatchpubgSeason jugadorsq = (MatchpubgSeason)request.getAttribute("jugadorsq");
			MatchpubgSeason jugadorsf = (MatchpubgSeason)request.getAttribute("jugadorsf");
			MatchpubgSeason jugadordf = (MatchpubgSeason)request.getAttribute("jugadordf");
			MatchpubgSeason jugadorsqf = (MatchpubgSeason)request.getAttribute("jugadorsqf");
			%>
			<%if(request.getAttribute("modoJSP").equals("tpp")){%>
			<div style="margin-left:2%;float:left;display:inline-block;width:32%;">
			<p style="color:#ac4616;font-weight: 400;line-height: 1.2;text-decoration: none;">SOLO TPP</p>
			<%if(jugadors.getTime().equals("0")){
			%>
			<div >No hay partidas Solo TPP esta season</div>
			<%}else{ %>			
			<div >KD  ${jugadors.kd}</div>
			<div >Win  <script>document.write(roundToTwo(${jugadors.wins}))</script>%</div>
			<div >Daño medio  ${jugadors.damage}</div>
			<div >Tiempo medio <script> document.write(format(${jugadors.time}))</script></div>
			<div >Headshots  ${jugadors.headshot}%</div>
			<div >TOP 10  ${jugadors.top10}%</div>
			<div >Longest Kill ${jugadors.longestkill} m</div>
			<%} %>
			</div>
			
			<div style="float:center;display:inline-block;width:32%;">
			<p style="color:#ac4616;font-weight: 400;line-height: 1.2;text-decoration: none;">DUO TPP</p>
			<%if(jugadord.getTime().equals("0")){%>
			<div >No hay partidas Duo TPP esta season</div>
			<%}else{ %>
			<div >KD  ${jugadord.kd}</div>
			<div >Win  <script>document.write(roundToTwo(${jugadord.wins}))</script>%</div>
			<div >Daño medio  ${jugadord.damage}</div>
			<div >Tiempo medio <script> document.write(format(${jugadord.time}))</script></div>
			<div >Headshots  ${jugadord.headshot}%</div>
			<div >TOP 10  ${jugadord.top10}%</div>
			<div >Longest Kill ${jugadord.longestkill} m</div>
			<%} %>
			</div>
			
			<div style="float:right;display:inline-block;width:32%;">
			<p style="color:#ac4616;font-weight: 400;line-height: 1.2;text-decoration: none;">SQUAD TPP</p>
			<%if(jugadorsq.getTime().equals("0")){
			%>
			<div >No hay partidas Squad TPP esta season</div>
			<%}else{%>
			<%= jugadors.getTime() %>
			<div >KD  ${jugadorsq.kd}</div>
			<div >Win  <script>document.write(roundToTwo(${jugadorsq.wins}))</script>%</div>
			<div >Daño medio  ${jugadorsq.damage}</div>
			<div >Tiempo medio <script> document.write(format(${jugadorsq.time}))</script></div>
			<div >Headshots  ${jugadorsq.headshot}%</div>
			<div >TOP 10  ${jugadorsq.top10}%</div>
			<div >Longest Kill ${jugadorsq.longestkill} m</div>
			<%} %>
			</div>
			
			<%}else{ %>
			
			<div style="margin-left:2%;float:left;display:inline-block;width:32%;">
			<p style="color:#ac4616;font-weight: 400;line-height: 1.2;text-decoration: none;">SOLO FPP</p>
			<%if(jugadorsf.getTime().equals("0")){
			%>
			<div >No hay partidas Solo TPP esta season</div>
			<%}else{ %>
			<div >KD  ${jugadorsf.kd}</div>
			<div >Win  <script>document.write(roundToTwo(${jugadorsf.wins}))</script>%</div>
			<div >Daño medio  ${jugadorsf.damage}</div>
			<div >Tiempo medio <script> document.write(format(${jugadorsf.time}))</script></div>
			<div >Headshots  ${jugadorsf.headshot}%</div>
			<div >TOP 10  ${jugadorsf.top10}%</div>
			<div >Longest Kill ${jugadorsf.longestkill} m</div>
			<%} %>
			</div>
			
			<div style="float:center;display:inline-block;width:32%;">
			<p style="color:#ac4616;font-weight: 400;line-height: 1.2;text-decoration: none;">DUO FPP</p>
			<%if(jugadordf.getTime().equals("0")){
			%>
			<div >No hay partidas Duo TPP esta season</div>
			<%}else{%>
			<div >KD  ${jugadordf.kd}</div>
			<div >Win  <script>document.write(roundToTwo(${jugadordf.wins}))</script>%</div>
			<div >Daño medio  ${jugadordf.damage}</div>
			<div >Tiempo medio <script> document.write(format(${jugadordf.time}))</script></div>
			<div >Headshots  ${jugadordf.headshot}%</div>
			<div >TOP 10  ${jugadordf.top10}%</div>
			<div >Longest Kill ${jugadordf.longestkill} m</div>
			<%} %>
			</div>
			
			<div style="float:right;display:inline-block;width:32%;">
			<p style="color:#ac4616;font-weight: 400;line-height: 1.2;text-decoration: none;">SQUAD FPP</p>
			<%if(jugadorsqf.getTime().equals("0")){
				
			%>
			
			<div >No hay partidas Squad TPP esta season</div>
			<%}else{%>
			<div >KD  ${jugadorsqf.kd}</div>
			<div >Win  <script>document.write(roundToTwo(${jugadorsqf.wins}))</script>%</div>
			<div >Daño medio  ${jugadorsqf.damage}</div>
			<div >Tiempo Medio <script> document.write(format(${jugadorsqf.time}))</script></div>
			<div >Headshots  ${jugadorsqf.headshot}%</div>
			<div >TOP 10  ${jugadorsqf.top10}%</div>
			<div >Longest Kill ${jugadorsqf.longestkill} m</div>
			<%} %>
			<%} %>
			</div>
			</div>
			  
			
			

      </div>
    </div>
  </div>
  </div>
 
</body>
</html>