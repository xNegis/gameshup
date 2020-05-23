<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@page import="aiss.MatchLoL"%>
<%@page import="aiss.MatchLoL2"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@include file="cabecera.html"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link rel="stylesheet" type="text/css" href="css/muestralol.css" />
 <meta http-equiv="content-type" content="text/html; charset=UTF-8">
</head>
<body >
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

function sumaMinions(minions,neutral){
	return minions + neutral;
}
function sumaDmg(tdmg,mdmg,pdmg){
	return Math.round(tdmg+mdmg+pdmg+1);
}
</script>
<div class="iniciodiv" style="margin-left:35%; widht: 200px;">
<h1 align="left"  ><img src="https://storage.cloud.google.com/gameshup.appspot.com/profileicon/${icono}.png?authuser=1"  alt="..." width="100" height="100"></h1>
</div>
<div class="iniciodiv" style="margin-left:5%;">
<h1 class="font-weight-light" style="color:#000000">${nombre}</h1>
<h1 class="font-weight-light" style="color:#000000">${lvl}</h1>
</div>


<div id="tabla">
<% int contador=0 ;%>
<%List<MatchLoL> paEdit = (List) request.getAttribute("lista");%>
<%List<Boolean> list = (List) request.getAttribute("wins");%>
<%List<Integer> listtk = (List) request.getAttribute("tk");%>
<%List<Integer> listqk = (List) request.getAttribute("qk");%>
<%List<Integer> listpk = (List) request.getAttribute("pk");%>
<%List<String> linea = (List) request.getAttribute("linea");%>
<%List<Boolean> type0 = (List) request.getAttribute("type0");%>
<%List<Boolean> type1 = (List) request.getAttribute("type1");%>
<%List<Boolean> type2 = (List) request.getAttribute("type2");%>
<%List<Boolean> type3 = (List) request.getAttribute("type3");%>
<%List<Boolean> type4 = (List) request.getAttribute("type4");%>
<%List<Boolean> type5 = (List) request.getAttribute("type5");%>
<%List<Boolean> type6 = (List) request.getAttribute("type6");%>
<%List<Integer> killsr = (List) request.getAttribute("killsr");%>
<%List<Integer> killsa = (List) request.getAttribute("killsa");%>
<%List<Integer> tower = (List) request.getAttribute("tower");%>
<%List<Integer> herald = (List) request.getAttribute("herald");%>
<%List<Integer> drake = (List) request.getAttribute("drake");%>
<%List<Integer> baron = (List) request.getAttribute("baron");%>
<%List<Long> tiempo = (List) request.getAttribute("tiempo");%>
<%List<Integer> equipos = (List) request.getAttribute("equipos");%>
<%List<List<MatchLoL2>> a = (List) request.getAttribute("azul");%>
<%List<List<MatchLoL2>> r = (List) request.getAttribute("rojo");%>
<%String nombre = (String) request.getAttribute("nombre");%>
<%List<MatchLoL> liston = (List<MatchLoL>) request.getAttribute("lista"); %>
<c:forEach items="${requestScope.lista}" var="entry">
<%if(list.get(contador)==false){ %>

 <button class="collapsiblelost"><img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} esta partida" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/${entry.champion}.png?authuser=1" class="mr-3" alt="..." width="70" height="70" style="border-radius:150px;">
<img data-toggle="tooltip" data-placement="top" title="Hechizo de invocador 1" class="imghechizos" src="https://storage.cloud.google.com/gameshup.appspot.com/spell/${entry.spell1}.png?authuser=1" class="mr-3" alt="..." width="40" height="40"><img data-toggle="tooltip" data-placement="top" title="Hechizo de invocador 2" class="imghechizos" src="https://storage.cloud.google.com/gameshup.appspot.com/spell/${entry.spell2}.png?authuser=1" class="mr-3" alt="..." width="40" height="40">

<div style="width:45%;display: inline-block;margin-left:7%;">

<div style="width:30%;display: inline-block;">
<div data-toggle="tooltip" data-placement="top" title="Kills de ${nombre} esta partida" class="prueba" ><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/icons/kills.png?authuser=1" class="mr-3" alt="..." width="25" height="25" ></div><c:out value="${entry.kills}" />
</div>

<div style="width:30%;display: inline-block;">
 <div data-toggle="tooltip" data-placement="top" title="Deaths de ${nombre} esta partida" class="prueba" style="margin-right:3%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/icons/muerte.png?authuser=1" class="mr-3" alt="..." width="15" height="15"  ></div><c:out value="${entry.deaths}" />																												
</div>

<div style="width:30%;display: inline-block;">
 <div data-toggle="tooltip" data-placement="top" title="Assists de ${nombre} esta partida" class="prueba" style="margin-right:3%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/icons/asist.png?authuser=1" class="mr-3" alt="..." width="20" height="20" ></div><c:out value="${entry.assists}" />
</div>

</div>
  <div style="width:10%;display: inline-block;">
  
 <%if(listpk.get(contador)>0){%>
    <img data-toggle="tooltip" data-placement="top" title="${nombre} se ha hecho <%=listpk.get(contador)%> PENTAKILL esta partida" class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/killstreak/penta.png?authuser=1" class="mr-3" alt="..." width="80" height="80" style="margin-left:4%; margin-right:10px;" >
  
 <%}else if(listqk.get(contador)>0){ %>
   <img data-toggle="tooltip" data-placement="top" title="${nombre} se ha hecho <%=listqk.get(contador)%> QUADRAKILL esta partida" class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/killstreak/quadra.png?authuser=1" class="mr-3" alt="..." width="80" height="80" style="margin-left:4%; margin-right:10px;" >
 
 <%}else if(listtk.get(contador)>0){ %>
  <img data-toggle="tooltip" data-placement="top" title="${nombre} se ha hecho <%=listtk.get(contador)%> TRIPLEKILL esta partida" class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/killstreak/triple.png?authuser=1" class="mr-3" alt="..." width="80" height="80" style="margin-left:4%; margin-right:10px;" >
 <%} %>
 </div>
	
 </button>
<div class="content">
	<div class="contentdiv">
	<%if(type0.get(contador)==true || type1.get(contador)==true || type2.get(contador)==true || type3.get(contador)==true || type4.get(contador)==true || type5.get(contador)==true ||type6.get(contador)==true){%>
		  <img align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/aramm.png?authuser=1" class="mr-3" alt="..." width="130px" height="130px"style="margin-left:5%;margin-top:3%;">
	
	<%}else{ %>
  <%if(linea.get(contador).equals("BOTTOM")){ %>
	  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la BOTLANE" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/bottom.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	<%}else if(linea.get(contador).equals("JUNGLE")){ %>
		  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la JUNGLA" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/jungla.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	
	<%}else if(linea.get(contador).equals("MIDDLE")){ %>
		  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la MIDLANE" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/mid.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	<%}else if(linea.get(contador).equals("TOP")){ %>
			  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la TOPLANE" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/top.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	
	<%}else{ %>
				  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en POCHINKY" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/map.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	
	<%} 
   }%>
	<p><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item0}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="margin-left:5%;margin-top:2%"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item1}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="margin-top:2%"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item2}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="margin-top:2%"></p>
  <p><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item3}.png?authuser=1" class="mr-3" alt="..." width="40" height="40"style="margin-left:5%"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item4}.png?authuser=1" class="mr-3" alt="..." width="40" height="40"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item5}.png?authuser=1" class="mr-3" alt="..." width="40" height="40">  <img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item6}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="align-content: center;"></p>
<form method="POST" action="/googleDriveFileNew">
    <%
    session.setAttribute("nombre", request.getAttribute("nombre"));
    session.setAttribute("region", request.getAttribute("region"));
   	session.setAttribute("tks"+contador, listtk.get(contador));
   	session.setAttribute("qks"+contador, listqk.get(contador));
   	session.setAttribute("pks"+contador, listpk.get(contador));
   	session.setAttribute("campeon"+contador, request.getAttribute("campeon"+contador));
   	session.setAttribute("muertes"+contador, request.getAttribute("muertes"+contador));
   	session.setAttribute("asistencias"+contador, request.getAttribute("asistencias"+contador));
   	session.setAttribute("asesinatos"+contador, request.getAttribute("asesinatos"+contador));
	session.setAttribute("vengoLol" , true);
    %>
         <input class="botong" id="boton<%=contador%>" name="boton<%=contador%>" type="submit" value="Guardar partida" ></input>
    
	</form>
 
 
  </div>
  <div class="contentdiv">
  <div class="textocont">
  <p>Stats</p>
  <p data-toggle="tooltip" data-placement="top" title="${entry.minions} subditos asesinados + ${entry.neutral} monstruos neutrales"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/minion.png?authuser=1" style="margin-right:3%"><script> document.write(sumaMinions(${entry.minions},${entry.neutral}))</script></p>
  <p data-toggle="tooltip" data-placement="top" title="Oro obtenido"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/gold.png?authuser=1" style="margin-right:3%"><c:out value="${entry.gold}" /></p>
  <p data-toggle="tooltip" data-placement="top" title="Suma resultante de ${entry.tdmg} daño verdadero + ${entry.mdmg} de daño magico + ${entry.pdmg} de daño fisico"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/danioo.png?authuser=1" style="margin-right:3%"><script>document.write(sumaDmg(${entry.tdmg},${entry.mdmg},${entry.pdmg}))</script></p>
 <%if(equipos.get(contador)==100){%>
  <p data-toggle="tooltip" data-placement="top" title="Team Kills"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/aliadoo.png?authuser=1" style="margin-right:3%"><%=killsa.get(contador)%></p>
   <p data-toggle="tooltip" data-placement="top" title="Enemy Team Kills"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/enemigo.png?authuser=1" style="margin-right:3%"><%=killsr.get(contador)%></p>
   <%
  List<MatchLoL2> jugadores = a.get(contador);
  for(int i=0;i<jugadores.size();i++){ 
  %>
  <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName() %>&region=${region}""><%=jugadores.get(i).getName() %></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
  <%} 
  	}else{ %>
   <p data-toggle="tooltip" data-placement="top" title="Team Kills" ><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/aliadoo.png?authuser=1" style="margin-right:3%"><%=killsr.get(contador)%></p>
   <p data-toggle="tooltip" data-placement="top" title="Enemy Team Kills"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/enemigo.png?authuser=1" style="margin-right:3%"><%=killsa.get(contador)%></p>
  	<%
  List<MatchLoL2> jugadores = r.get(contador);
  for(int i=0;i<jugadores.size();i++){ 
  %>
  <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName()%>&region=${region}""><%=jugadores.get(i).getName()%></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
  <%} 
  } %>
  </div>
  </div>
  <div class="contentdiv">
  <div class="textocont">
  <p>Objetivos</p>
  <p data-toggle="tooltip" data-placement="top" title="Número  de torres"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/tower.png?authuser=1" style="margin-left:1%"> <%=tower.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Número de dragones"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/drake.png?authuser=1" style="margin-left:1%"> <%=drake.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Número de heraldos"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/heraldo.png?authuser=1" style="margin-left:1%"> <%=herald.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Numero de barones"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/baron.png?authuser=1" style="margin-left:1%"> <%=baron.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Tiempo de la partida"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/tiempo.png?authuser=1" style="margin-left:1%"> <script> document.write(format(${entry.tiempo}))</script></p>
  <%if(equipos.get(contador)==100){
  List<MatchLoL2> jugadores = r.get(contador);
  for(int i=0;i<jugadores.size();i++){ 
  %>
  <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName()%>&region=${region}"><%=jugadores.get(i).getName() %></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
  <%}
  }else{ 
	  List<MatchLoL2> jugadores = a.get(contador);
	  for(int i=0;i<jugadores.size();i++){ 
	  %>
  <p >	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName()%>&region=${region}"><%=jugadores.get(i).getName() %></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
	  <%}
	  
  }%>
  </div>
  </div>
</div>

<%}else { %>
<button class="collapsiblewin"><img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} esta partida" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/${entry.champion}.png?authuser=1" class="mr-3" alt="..." width="70" height="70" style="border-radius:150px;">
<img data-toggle="tooltip" data-placement="top" title="Hechizo de invocador 1" class="imghechizos" src="https://storage.cloud.google.com/gameshup.appspot.com/spell/${entry.spell1}.png?authuser=1" class="mr-3" alt="..." width="40" height="40"><img data-toggle="tooltip" data-placement="top" title="Hechizo de invocador 2" class="imghechizos" src="https://storage.cloud.google.com/gameshup.appspot.com/spell/${entry.spell2}.png?authuser=1" class="mr-3" alt="..." width="40" height="40">
<div style="width:45%;display: inline-block;margin-left:7%;">

<div style="width:30%;display: inline-block;">
<div data-toggle="tooltip" data-placement="top" title="Kills de ${nombre} esta partida" class="prueba" ><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/icons/kills.png?authuser=1" class="mr-3" alt="..." width="25" height="25" ></div><c:out value="${entry.kills}" />
</div>

<div style="width:30%;display: inline-block;">
 <div data-toggle="tooltip" data-placement="top" title="Deaths de ${nombre} esta partida" class="prueba" style="margin-right:3%;" ><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/icons/muerte.png?authuser=1" class="mr-3" alt="..." width="15" height="15"  ></div><c:out value="${entry.deaths}" />																												
</div>

<div style="width:30%;display: inline-block;">
 <div data-toggle="tooltip" data-placement="top" title="Assists de ${nombre} esta partida" class="prueba" style="margin-right:3%;"><img class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/icons/asist.png?authuser=1" class="mr-3" alt="..." width="20" height="20" ></div><c:out value="${entry.assists}" />
</div>

</div>
  <div style="width:10%;display: inline-block;">
  
 <%if(listpk.get(contador)>0){%>
    <img data-toggle="tooltip" data-placement="top" title="${nombre} se ha hecho <%=listpk.get(contador)%> PENTAKILL esta partida" class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/killstreak/penta.png?authuser=1" class="mr-3" alt="..." width="80" height="80" style="margin-left:4%; margin-right:10px;" >
  
 <%}else if(listqk.get(contador)>0){ %>
   <img data-toggle="tooltip" data-placement="top" title="${nombre} se ha hecho <%=listqk.get(contador)%> QUADRAKILL esta partida" class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/killstreak/quadra.png?authuser=1" class="mr-3" alt="..." width="80" height="80" style="margin-left:4%; margin-right:10px;" >
 
 <%}else if(listtk.get(contador)>0){ %>
  <img data-toggle="tooltip" data-placement="top" title="${nombre} se ha hecho <%=listtk.get(contador)%> TRIPLEKILL esta partida" class="imgicons" src="https://storage.cloud.google.com/gameshup.appspot.com/killstreak/triple.png?authuser=1" class="mr-3" alt="..." width="80" height="80" style="margin-left:4%; margin-right:10px;" >
 <%} %>
 </div>
<!--    <a style="display: inline-block;" href="/googleDriveFileNew">GoDrive</a> -->
</button>

<div class="content">
<div class="contentdiv">
 <%if(type0.get(contador)==true || type1.get(contador)==true || type2.get(contador)==true || type3.get(contador)==true || type4.get(contador)==true || type5.get(contador)==true ||type6.get(contador)==true){%>
		  <img align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/aramm.png?authuser=1" class="mr-3" alt="..." width="130px" height="130px"style="margin-left:5%;margin-top:3%;">
	
	<%}else{ %>
   <%if(linea.get(contador).equals("BOTTOM")){ %>
	  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la BOTLANE" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/bottom.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	<%}else if(linea.get(contador).equals("JUNGLE")){ %>
		  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la JUNGLA" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/jungla.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	
	<%}else if(linea.get(contador).equals("MIDDLE")){ %>
		  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la MIDLANE" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/mid.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	<%}else if(linea.get(contador).equals("TOP")){ %>
			  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en la TOPLANE" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/top.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	
	<%}else{ %>
				  <img data-toggle="tooltip" data-placement="top" title="${nombre} ha invocado a ${entry.champion} en POCHINKY" align="center" class="maps" src="https://storage.cloud.google.com/gameshup.appspot.com/mapas/map.png?authuser=1" class="mr-3" alt="..." width="150px" height="150px"style="margin-left:5%;margin-top:3%;">
	
	<%} 
   }%>
	<p><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item0}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="margin-left:5%;margin-top:2%"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item1}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="margin-top:2%"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item2}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="margin-top:2%"></p>
  	<p><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item3}.png?authuser=1" class="mr-3" alt="..." width="40" height="40"style="margin-left:5%"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item4}.png?authuser=1" class="mr-3" alt="..." width="40" height="40"><img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item5}.png?authuser=1" class="mr-3" alt="..." width="40" height="40">  <img class="imgspell" src="https://storage.cloud.google.com/gameshup.appspot.com/item/${entry.item6}.png?authuser=1" class="mr-3" alt="..." width="40" height="40" style="align-content: center;"></p>
	<form method="POST" action="/googleDriveFileNew">
    <%
    session.setAttribute("nombre", request.getAttribute("nombre"));
    session.setAttribute("region", request.getAttribute("region"));
   	session.setAttribute("tks"+contador, listtk.get(contador));
   	session.setAttribute("qks"+contador, listqk.get(contador));
   	session.setAttribute("pks"+contador, listpk.get(contador));
   	session.setAttribute("campeon"+contador, request.getAttribute("campeon"+contador));
   	session.setAttribute("muertes"+contador, request.getAttribute("muertes"+contador));
   	session.setAttribute("asistencias"+contador, request.getAttribute("asistencias"+contador));
   	session.setAttribute("asesinatos"+contador, request.getAttribute("asesinatos"+contador));
	session.setAttribute("vengoLol" , true);

    %>
         <input class="botong" id="boton<%=contador%>" name="boton<%=contador%>" type="submit" value="Guardar partida" ></input>
    
	</form>
</div>
  <div class="contentdiv">
  <div class="textocont">
  <p>Stats</p>
  <p data-toggle="tooltip" data-placement="top" title="${entry.minions} subditos asesinados + ${entry.neutral} monstruos neutrales"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/minion.png?authuser=1" style="margin-right:3%"><script>document.write(sumaMinions(${entry.minions},${entry.neutral}))</script></p>
  <p data-toggle="tooltip" data-placement="top" title="Oro obtenido"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/gold.png?authuser=1" style="margin-right:3%"><c:out value="${entry.gold}" /></p>
  <p data-toggle="tooltip" data-placement="top" title="Suma resultante de ${entry.tdmg} daño verdadero + ${entry.mdmg} de daño magico + ${entry.pdmg} de daño fisico"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/danioo.png?authuser=1" style="margin-right:3%"><script>document.write(sumaDmg(${entry.tdmg},${entry.mdmg},${entry.pdmg}))</script></p>
  
  <%if(equipos.get(contador)==100){%>
  <p data-toggle="tooltip" data-placement="top" title="Team Kills"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/aliadoo.png?authuser=1"style="margin-right:3%"><%=killsa.get(contador)%></p>
   <p data-toggle="tooltip" data-placement="top" title="Enemy Team Kills"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/enemigo.png?authuser=1" style="margin-right:3%"><%=killsr.get(contador)%></p>
  <%
   
  List<MatchLoL2> jugadores = a.get(contador);
  for(int i=0;i<jugadores.size();i++){ 
  %>
  
  <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName() %>&region=${region}""><%=jugadores.get(i).getName() %></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
    <%} 
  }else{ %>
   <p data-toggle="tooltip" data-placement="top" title="Team Kills" ><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/aliadoo.png?authuser=1" style="margin-right:3%"><%=killsr.get(contador)%></p>
   <p data-toggle="tooltip" data-placement="top" title="Enemy Team Kills"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/enemigo.png?authuser=1" style="margin-right:3%"><%=killsa.get(contador)%></p>
  <%List<MatchLoL2> jugadores = r.get(contador);
	  for(int i=0;i<jugadores.size();i++){ 
	  %>
	    <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName() %>&region=${region}""><%=jugadores.get(i).getName() %></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
	  <%}
 	} %>
  </div>
  </div>
  <div class="contentdiv">
  <div class="textocont">
  <p>Objetivos</p>
  <p data-toggle="tooltip" data-placement="top" title="Número de torres"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/tower.png?authuser=1" style="margin-left:1%"> <%=tower.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Número de dragones"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/drake.png?authuser=1" style="margin-left:1%"> <%=drake.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Número de heraldos"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/heraldo.png?authuser=1" style="margin-left:1%"> <%=herald.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Numero de barones"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/baron.png?authuser=1" style="margin-left:1%"> <%=baron.get(contador)%></p>
  <p data-toggle="tooltip" data-placement="top" title="Tiempo de la partida"><img src="https://storage.cloud.google.com/gameshup.appspot.com/stats/tiempo.png?authuser=1" style="margin-left:1%"> <script> document.write(format(${entry.tiempo}))</script></p>  
  <%if(equipos.get(contador)==100){
  List<MatchLoL2> jugadores = r.get(contador);
  for(int i=0;i<jugadores.size();i++){ 
  %>
  <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName()%>&region=${region}"><%=jugadores.get(i).getName() %></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
  <%}
  }else{ 
	  List<MatchLoL2> jugadores = a.get(contador);
	  for(int i=0;i<jugadores.size();i++){ 
	  %>
  <p>	<img data-toggle="tooltip" data-placement="top" class="imgcha" src="https://storage.cloud.google.com/gameshup.appspot.com/champion/<%=jugadores.get(i).getChampion()%>.png?authuser=1" class="mr-3" alt="..." width="20" height="20" style="border-radius:150px;"><a style="text-decoration:none;color: black" data-toggle="tooltip" data-placement="top" title="Click para ir a la página de <%=jugadores.get(i).getName() %>" href="/lol?name=<%=jugadores.get(i).getName()%>&region=${region}"><%=jugadores.get(i).getName()%></a>	<%=jugadores.get(i).getKills()%>/<%=jugadores.get(i).getDeaths()%>/<%=jugadores.get(i).getAssists()%> </p>
	  <%}
	  
  }%>
  
  </div>
  </div>
</div>
<%} %>


<%contador++ ;%>
</c:forEach>

</div>

 

                



<script>
$(document).ready(function(){
	  $('[data-toggle="tooltip"]').tooltip();   
	});

var coll = document.getElementsByClassName("collapsiblelost");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.maxHeight){
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
    } 
  });
}
</script>
<script>
var coll = document.getElementsByClassName("collapsiblewin");
var i;

for (i = 0; i < coll.length; i++) {
  coll[i].addEventListener("click", function() {
    this.classList.toggle("active");
    var content = this.nextElementSibling;
    if (content.style.maxHeight){
      content.style.maxHeight = null;
    } else {
      content.style.maxHeight = content.scrollHeight + "px";
    } 
  });
}

</script>
</body>
</html>