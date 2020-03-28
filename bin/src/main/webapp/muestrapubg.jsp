<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css" integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
<meta charset="ISO-8859-1">
<title>Gameshup  : PUGB</title>
</head>
<body>
<p>
<div class="col-lg-6">
        	<div class="panel panel-default">
            <div class="panel-heading"><h3>Ultimas partidas de ${nombre} </h3></div>
            <div class="panel-body">
<table class="table table-condensed" style="border-collapse:collapse;">
           <% int cont=0; %>
                  <c:forEach items="${requestScope.respuesta}" var="entry">
                   <%  cont++; %>
    <tbody>
        <tr data-toggle="collapse" data-target="#demo<%=cont%>" class="accordion-toggle">
                  <td><button class="btn btn-default btn-xs"><span class="glyphicon glyphicon-eye-open"></span></button></td>
            <td>Kills : <c:out value="${entry.kills}" /></td>
            <td>Damage : <c:out value="${entry.damage}" /></td>
            <td>Rank : <c:out value="${entry.rank}" /></td>
        </tr>
        <tr>
            <td colspan="12" class="hiddenRow"><div class="accordian-body collapse" id="demo<%=cont%>"> 
            
            
           
              <table class="table table-striped">
                      <thead>
                        <tr><td>Walked : <c:out value="${entry.distancew}" /></td></tr>
                        <tr><td>Longest Kill : <c:out value="${entry.longestkill}" /></td></tr>
                        <tr><td>HeadShots : <c:out value="${entry.headshots}" /></td></tr>
                      </thead>
                      <tbody>
                  <i class="glyphicon glyphicon-cog"></i></a></td></tr>
                      </tbody>
               	</table>
              </div> 
              </td>
        </tr>
        
    </tbody>
                </c:forEach>
    
</table>

            </div>
        
          </div> 
        
      </div>
       
<script src="https://code.jquery.com/jquery-3.4.1.slim.min.js" integrity="sha384-J6qa4849blE2+poT4WnyKhv5vZF5SrPo0iEjwBvKU7imGFAV0wwj1yYfoRSJoZ+n" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/js/bootstrap.min.js" integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>





<%-- <c:forEach items="${requestScope.respuesta}" var="entry"> --%>
<!-- 		====================================================<br>		 -->
<%-- 		Damage: <c:out value="${entry.damage}" /><br> --%>
<%-- 		Kills: <c:out value="${entry.kills}" /><br> --%>
<%-- 		Rank: <c:out value="${entry.rank}" />/50<br> --%>
<%-- 		Longest Kill: <c:out value="${entry.longestkill}" /><br> --%>
<%-- 		Distancia recorrida: <c:out value="${entry.distancew}"  /> metros<br> --%>
<%-- 		Headshots: <c:out value="${entry.headshots}" /><br> --%>
<%-- </c:forEach> --%>
</p>
</body>
</html>