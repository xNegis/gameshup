
<%@include file="includes/header.jsp"%>
<%@page import="model.auxiliary.MatchLoL"%>
<%@page import="model.auxiliary.MatchLoL2"%>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<% String controller = "/googleDriveFileNew"; %>
<%@include file="cabeceradark.html"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="content-type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" type="text/css" href="css/style.css">

        <title>GAMESHUP: TU PARTIDA</title>
    </head>
    <body>
<c:if test="${not empty file}">
    <% controller = "/googleDriveFileUpdate";%>
</c:if>

<div class="container">

    <p class="message">${message}</p>

    <form action="<%= controller%>" method="post">
        <c:if test="${not empty file}">
            <input type="hidden" name="id" value="${file.id}">
        </c:if>
        <label for="title"></label>
        <input type="text" name="title" id="title" value="${title}" disabled/>
        <label for="content"></label>
        
         
 
        <textarea style="margin: 0px; width: 500px; height: 160px;" id="content" name="content" disabled>${content}</textarea>

        <div class="bottom_links">
            <button type="button" onClick="javascript:window.location.href = '/'" class="btn btn-dark">Cancel</button>
        </div>
    </form>
</div>

</body>
</html>