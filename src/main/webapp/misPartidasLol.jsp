<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>

<%@page import="aiss.model.google.drive.FileItem"%>
<%@ page import="java.util.List" %>
<%@include file="cabeceradark.html"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>GameShup : MIS PARTIDAS LOL</title>
</head>
<body style="background-color: #ededed;">

<%List<FileItem> files = (List) request.getAttribute("filtradas");%>

<div class="container">
<h1 style="margin-top:20px;">Tus partidas guardadas LoL</h1>
    <p class="message">${message}</p>

    <table class="table" id="files">
    <thead class="thead-dark">
        <tr style="border-radius: 10px;">
            <th scope="col">NAME</th>
            <th scope="col">DATE OF ADDITION</th>
            <th scope="col">DELETE</th>
            <th scope="col">VIEW</th>
        </tr>
         </thead>
		<%
	for(int i=0;i<files.size();i++){ %>
            <tr>
            
                <td><%=files.get(i).getTitle()%></td>
                <td><%=files.get(i).getModifiedDate()%></td>
                <td> 
                <form  method="POST" action="/googleDriveFileDelete?id=<%=files.get(i).getId()%>">
               	<button id="vengoLolP" name="vengoLolP" style="background:none;border:none"><img src="./images/delete.png" width="30px"></button>
                </form>
                </td>
                 <td> 
                    <a href="/googleDriveFileUpdate?id=<%=files.get(i).getId()%>"><img src="./images/edit.png" width="30px"></a>
                </td>
            </tr>
<% } %>
    </table>
    <p>
        <button  class="btn btn-dark" type="button" onClick="javascript:window.location.href = '/'" class="button">BACK</button>
</div>
</body>

